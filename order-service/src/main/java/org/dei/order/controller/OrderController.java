package org.dei.order.controller;

import org.dei.order.domain.ItemAdditionParametersDto;
import org.dei.order.domain.Order;
import org.dei.order.domain.Status;
import org.dei.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Order> orders() {
        List<Order> list = new ArrayList<Order>();
        orderRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @RequestMapping(path = "/{order_id}", method = RequestMethod.GET)
    public Order order(@PathVariable("order_id") Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @RequestMapping(path = "/{order_id}/item", method = RequestMethod.POST)
    public Order add(@PathVariable("order_id") Long orderId,
                     @RequestBody ItemAdditionParametersDto itemAdditionParametersDto) {
        return null; //TODO
    }

    @RequestMapping(path = "/{order_id}/status/{status}", method = RequestMethod.PUT)
    public Order change(@PathVariable("order_id") Long orderId, @PathVariable Status status) {
        return null; //TODO
    }
}
