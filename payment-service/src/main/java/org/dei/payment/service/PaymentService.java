package org.dei.payment.service;

import org.dei.payment.model.PaymentDetails;
import org.dei.payment.model.UserDetails;

public interface PaymentService {
    PaymentDetails perform(int orderId, UserDetails userDetails);
}
