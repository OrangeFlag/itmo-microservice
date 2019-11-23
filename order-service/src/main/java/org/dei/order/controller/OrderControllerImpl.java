package org.dei.order.controller;

import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.dto.OrderDTO;
import org.dei.order.api.model.Status;
import org.dei.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerImpl {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    private final ModelMapper modelMapper = new ModelMapper();
    private final Type listOrderDTO = new TypeToken<List<OrderDTO>>() {
    }.getType();


    @Autowired
    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<OrderDTO> orders() {
        LOGGER.info("start findAll orders");
        return modelMapper.map(orderService.findAll(), listOrderDTO);
    }

    @RequestMapping(path = "/{order_id}", method = RequestMethod.GET)
    public OrderDTO order(@PathVariable("order_id") Long orderId) {
        LOGGER.info("start search order by id " + orderId);

        return modelMapper.map(orderService.find(orderId), OrderDTO.class);
    }

    @RequestMapping(path = "/{order_id}/item", method = RequestMethod.POST)
    public OrderDTO add(@PathVariable("order_id") Long orderId,
                        @RequestBody ItemAdditionParametersDTO itemAdditionParametersDTO) {
        LOGGER.info("start add product" + itemAdditionParametersDTO + " in order with id " + orderId);
        return modelMapper.map(orderService.addItem(itemAdditionParametersDTO, orderId), OrderDTO.class);
    }

    @RequestMapping(path = "/{order_id}/status/{status}", method = RequestMethod.PUT)
    public OrderDTO change(@PathVariable("order_id") Long orderId, @PathVariable Status status) {
        LOGGER.info("start setting status" + status + "for order " + orderId);
        return modelMapper.map(orderService.setStatus(status, orderId), OrderDTO.class);
    }

}