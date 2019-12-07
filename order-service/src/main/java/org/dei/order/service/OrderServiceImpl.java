package org.dei.order.service;

import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.model.Status;
import org.dei.order.client.StoreHouseClient;
import org.dei.order.model.Order;
import org.dei.order.model.Product;
import org.dei.order.repository.OrderRepository;
import org.dei.storehouse.api.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@EnableFeignClients(basePackages = "org.dei.order.clients.StoreHouseClient")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StoreHouseClient storeHouseClient;
    private final MessageSender messageSender;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, StoreHouseClient storeHouseClient, MessageSender messageSender) {
        this.orderRepository = orderRepository;
        this.storeHouseClient = storeHouseClient;
        this.messageSender = messageSender;
    }

    @Override
    public Order find(Long id) {

        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();

    }

    @Override
    public Order addItem(ItemAdditionParametersDTO iAPDTO, Long orderId) {
        if (orderId == -1) {
            LOGGER.info("OrderID is -1");
            LOGGER.info("Product id: " + iAPDTO.getId().toString());
            Order order = new Order();
            order.setStatus(Status.COLLECTING);
            order.setUsername(iAPDTO.getUsername());
            getProductById(iAPDTO, order);
            orderRepository.save(order);
            return order;
        } else {
            return orderRepository.findById(orderId).map((Order order) -> {
                if (Objects.equals(order.getUsername(), iAPDTO.getUsername())) {
                    order = getProductById(iAPDTO, order);
                    orderRepository.save(order);
                }
                return order;
            }).get();
        }
    }

    private Order getProductById(ItemAdditionParametersDTO iAPDTO, Order order) {
        ProductDTO product = storeHouseClient.getItemById(iAPDTO.getId());
        LOGGER.info("Product is:", product.toString());
        if (product != null) {
            List<Product> products = order.getProducts();
            Product newProduct = new Product();
            newProduct.setId(product.getId());
            newProduct.setName(product.getName());
            newProduct.setAmount(iAPDTO.getAmount());
            newProduct.setPrice(product.getPrice());
            products.add(newProduct);
            order.setTotalCost(order.getTotalCost() + product.getPrice() + product.getAmount());
            order.setTotalAmount(order.getTotalAmount() + product.getAmount());
            storeHouseClient.reserveItems(iAPDTO.getId(), iAPDTO.getAmount());
        }
        return order;
    }

    @Override
    public Order setStatus(Status status, Long orderId) {
        return orderRepository.findById(orderId).map((Order order) -> {
            if (status == Status.CANCELLED || status == Status.FAILED) {
                for (Product i : order.getProducts()) {
                    messageSender.sendMessage(i.getId(), i.getAmount());
                }
            }
            order.setStatus(status);
            orderRepository.save(order);
            return order;
        }).get();
    }
}
