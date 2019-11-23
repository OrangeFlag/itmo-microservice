package org.dei.payment.controller;

import org.dei.payment.converter.OrderConverter;
import org.dei.payment.converter.UserDetailsConvert;
import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.api.dto.UserDetailsDTO;
import org.dei.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentControllerImpl implements PaymentController {
    private final Logger LOGGER = LoggerFactory.getLogger(PaymentControllerImpl.class);
    private final PaymentService paymentService;
    private final OrderConverter orderConverter;
    private final UserDetailsConvert userDetailsConvert;

    @Autowired
    public PaymentControllerImpl(PaymentService paymentService, OrderConverter orderConverter, UserDetailsConvert userDetailsConvert) {
        this.paymentService = paymentService;
        this.orderConverter = orderConverter;
        this.userDetailsConvert = userDetailsConvert;
    }

    @RequestMapping(path = "/{order_id}", method = RequestMethod.PUT)
    public OrderDTO perform(@PathVariable("order_id") int orderId, @RequestBody UserDetailsDTO userDetailsDTO) {
        LOGGER.info("start performing payement");
        return orderConverter.orderToDTO(paymentService.perform(orderId, userDetailsConvert.DTOtoUserDetails(userDetailsDTO)).getOrder());
    }

}
