package org.dei.payment.service;

import org.dei.order.api.model.Status;
import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.api.model.CardAuthorizationInfo;
import org.dei.payment.client.OrderClient;
import org.dei.payment.model.Order;
import org.dei.payment.model.PaymentDetails;
import org.dei.payment.model.UserDetails;
import org.dei.payment.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDetailsRepository paymentDetailsRepository;
    private final OrderClient orderClient;

    @Autowired
    public PaymentServiceImpl(PaymentDetailsRepository paymentDetailsRepository, OrderClient orderClient) {
        this.paymentDetailsRepository = paymentDetailsRepository;
        this.orderClient = orderClient;
    }

    @Override
    public OrderDTO perform(Long orderId, UserDetails userDetails) {

        if (userDetails.getCardAuthorizationInfo() == CardAuthorizationInfo.AUTHORIZED) {

            try {
                orderClient.change(orderId, Status.PAID);
                PaymentDetails payment = new PaymentDetails();
                payment.setUsername(userDetails.getUsername());
                payment.setOrder(new Order(orderId));
                payment.setCardAuthorizationInfo(userDetails.getCardAuthorizationInfo());
                paymentDetailsRepository.save(payment);
            } catch (RuntimeException e) {
                orderClient.change(orderId, Status.FAILED);
            }
        }


        return new OrderDTO(orderId);
    }
}
