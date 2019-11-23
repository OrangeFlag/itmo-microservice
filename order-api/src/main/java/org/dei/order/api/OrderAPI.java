package org.dei.order.api;

import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.dto.OrderDTO;
import org.dei.order.api.model.Status;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface OrderAPI {
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