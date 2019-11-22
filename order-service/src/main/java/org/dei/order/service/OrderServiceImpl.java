package org.dei.order.service;

import org.dei.order.clients.StoreHouseClient;
import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.dto.OrderDTO;
import org.dei.order.model.Order;
import org.dei.order.model.Product;
import org.dei.order.model.Status;
import org.dei.order.repository.OrderRepository;
import org.dei.order.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

@Service
@EnableFeignClients(basePackages = "org.dei.order.clients.StoreHouseClient")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final StoreHouseClient storeHouseClient;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, StoreHouseClient storeHouseClient) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.storeHouseClient = storeHouseClient;
    }

    @Override
    public OrderDTO find(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return modelMapper.map(order, OrderDTO.class);
        }
        return null;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findAll();
        Type listType = new TypeToken<List<OrderDTO>>() {
        }.getType();
        return modelMapper.map(orderList, listType);
    }

    @Override
    public OrderDTO addItem(ItemAdditionParametersDTO iAPDTO, Long orderId) {
        Order resultOrder = orderRepository.findById(orderId).map((Order order) -> {
            if (Objects.equals(order.getUsername(), iAPDTO.getUsername())) {
                Product product = productRepository.findById(iAPDTO.getId()).orElse(null);
                if (product != null){
                    List<Product> products = order.getProducts();

                    Product newProduct = new Product();
                    newProduct.setId(product.getId());
                    newProduct.setName(product.getName());
                    newProduct.setAmount(iAPDTO.getAmount()); //TODO send amount to storehouse
                    newProduct.setPrice(product.getPrice());

                    products.add(newProduct);

                    storeHouseClient.reserveItems(iAPDTO.getId(), iAPDTO.getAmount());
                    orderRepository.save(order);
                }
            }
            return order;
        }).get();

        return modelMapper.map(resultOrder, OrderDTO.class);
    }

    @Override
    public OrderDTO setStatus(Status status, Long orderId) {
        Order resultOrder = orderRepository.findById(orderId).map((Order order) -> {
            if (status == Status.CANCELLED || status == Status.FAILED){
                //TODO: add
            }
            order.setStatus(status);
            orderRepository.save(order);
            return order;
        }).get();
        return modelMapper.map(resultOrder, OrderDTO.class);
    }
}
