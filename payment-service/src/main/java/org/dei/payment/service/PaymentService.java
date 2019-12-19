package org.dei.payment.service;


import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.model.UserDetails;

public interface PaymentService {
    OrderDTO perform(Long orderId, UserDetails userDetails);
}
