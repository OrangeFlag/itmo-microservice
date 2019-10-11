package org.dei.payment.service;

import org.dei.payment.domain.OrderDto;
import org.dei.payment.domain.UserDetailsDto;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public OrderDto perform(Long orderId, UserDetailsDto userDetailsDto) {
        return new OrderDto(orderId); //TODO NotImplemented, should change order status
    }
}
