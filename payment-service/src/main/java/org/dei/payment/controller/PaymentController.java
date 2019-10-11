package org.dei.payment.controller;

import org.dei.payment.domain.OrderDto;
import org.dei.payment.domain.UserDetailsDto;
import org.dei.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(path = "/{order_id}", method = RequestMethod.PUT)
    public OrderDto perform(@PathVariable("order_id") Long orderId, @RequestBody UserDetailsDto userDetailsDto) {
        return paymentService.perform(orderId, userDetailsDto);
    }

}
