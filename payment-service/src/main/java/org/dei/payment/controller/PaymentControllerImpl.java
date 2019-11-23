package org.dei.payment.controller;

import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.api.dto.UserDetailsDTO;
import org.dei.payment.model.UserDetails;
import org.dei.payment.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentControllerImpl implements PaymentController {
    private final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public PaymentControllerImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(path = "/{order_id}/payment", method = RequestMethod.PUT)
    public OrderDTO perform(@PathVariable("order_id") Long orderId, @RequestBody UserDetailsDTO userDetailsDTO) {
        LOGGER.info("start performing payment");
        UserDetails userDetails = modelMapper.map(userDetailsDTO, UserDetails.class);
        return modelMapper.map(paymentService.perform(orderId, userDetails), OrderDTO.class);
    }
}
