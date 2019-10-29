package org.dei.order.service.impl;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.model.Order;
import org.dei.order.model.Product;
import org.dei.order.model.Status;
import org.dei.order.repository.OrderRepository;
import org.dei.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order find(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order addItem(ItemAdditionParametersDTO itemAdditionParametersDTO, Order order) {
        List<Product> products = order.getProducts();
        //Product toAdd = itemAdditionParametersDTO.
        //TODO
        return order;
    }

    @Override
    public Order setStatus(Status status, Order order) {
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
