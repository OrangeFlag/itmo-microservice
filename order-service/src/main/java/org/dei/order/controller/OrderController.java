package org.dei.order.controller;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.dto.OrderDTO;
import org.dei.order.model.Status;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public interface OrderController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<OrderDTO> orders();

    @RequestMapping(path = "/{order_id}", method = RequestMethod.GET)
    OrderDTO order(@PathVariable("order_id") Long orderId);


    @RequestMapping(path = "/{order_id}/item", method = RequestMethod.POST)
    OrderDTO add(@PathVariable("order_id") Long orderId,
                 @RequestBody ItemAdditionParametersDTO itemAdditionParametersDTO);

    @RequestMapping(path = "/{order_id}/status/{status}", method = RequestMethod.PUT)
    OrderDTO change(@PathVariable("order_id") Long orderId, @PathVariable Status status);

}
