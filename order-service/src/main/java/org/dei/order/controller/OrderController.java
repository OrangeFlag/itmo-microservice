package org.dei.order.controller;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.model.Order;
import org.dei.order.model.Status;
import org.dei.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Order> orders() {
        LOGGER.info("start findAll orders");
        return orderService.findAll();
    }

    @RequestMapping(path = "/{order_id}", method = RequestMethod.GET)
    public Order order(@PathVariable("order_id") int orderId) {
        LOGGER.info("start search order by id");
        return orderService.find(orderId);
    }

    @RequestMapping(path = "/{order_id}/item", method = RequestMethod.POST)
    public Order add(@PathVariable("order_id") int orderId,
                     @RequestBody ItemAdditionParametersDTO itemAdditionParametersDTO) {
        return null; //TODO, awaits for messaging realisation
    }

    @RequestMapping(path = "/{order_id}/status/{status}", method = RequestMethod.PUT)
    public Order change(@PathVariable("order_id") int orderId, @PathVariable Status status) {
        LOGGER.info("start setting status for order");
        return orderService.setStatus(status, orderService.find(orderId));
    }

}