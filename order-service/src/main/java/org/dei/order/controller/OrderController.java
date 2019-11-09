package org.dei.order.controller;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.dto.OrderDTO;
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
    public List<OrderDTO> orders() {
        LOGGER.info("start findAll orders");
        return orderService.findAll();
    }

    @RequestMapping(path = "/{order_id}", method = RequestMethod.GET)
    public OrderDTO order(@PathVariable("order_id") Long orderId) {
        LOGGER.info("start search order by id " + orderId);
        return orderService.find(orderId);
    }

    @RequestMapping(path = "/{order_id}/item", method = RequestMethod.POST)
    public OrderDTO add(@PathVariable("order_id") Long orderId,
                        @RequestBody ItemAdditionParametersDTO itemAdditionParametersDTO) {
        LOGGER.info("start add product" + itemAdditionParametersDTO + " in order with id " + orderId);
        return orderService.addItem(itemAdditionParametersDTO, orderId);
    }

    @RequestMapping(path = "/{order_id}/status/{status}", method = RequestMethod.PUT)
    public OrderDTO change(@PathVariable("order_id") Long orderId, @PathVariable Status status) {
        LOGGER.info("start setting status" + status + "for order " + orderId);
        return orderService.setStatus(status, orderId);
    }

}