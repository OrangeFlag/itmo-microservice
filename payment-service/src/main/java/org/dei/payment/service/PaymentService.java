package org.dei.payment.service;

import org.dei.payment.domain.OrderDto;
import org.dei.payment.domain.UserDetailsDto;

public interface PaymentService {
    OrderDto perform(Long orderId, UserDetailsDto userDetailsDto);
}
