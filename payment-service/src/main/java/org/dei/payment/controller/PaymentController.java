package org.dei.payment.controller;

import org.dei.payment.dto.OrderDTO;
import org.dei.payment.dto.UserDetailsDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public interface PaymentController {
    @RequestMapping(path = "/{order_id}", method = RequestMethod.PUT)
    OrderDTO perform(@PathVariable("order_id") int orderId, @RequestBody UserDetailsDTO userDetailsDTO);
}
