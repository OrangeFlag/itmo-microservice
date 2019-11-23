package org.dei.payment.service;

import org.dei.payment.model.PaymentDetails;
import org.dei.payment.model.UserDetails;
import org.dei.payment.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    public PaymentServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @Override
    public PaymentDetails perform(Long orderId, UserDetails userDetails) {
        PaymentDetails order = paymentDetailsRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setCardAuthorizationInfo(userDetails.getCardAuthorizationInfo());
            paymentDetailsRepository.save(order);
        }
        return order; //TODO NotImplemented, should change order status
    }
}
