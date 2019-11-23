package org.dei.payment.api;

import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.api.dto.UserDetailsDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface PaymentAPI {
    @RequestMapping(path = "/{order_id}", method = RequestMethod.PUT)
    OrderDTO perform(@PathVariable("order_id") Long orderId, @RequestBody UserDetailsDTO userDetailsDTO);
}
