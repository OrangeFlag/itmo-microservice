package org.dei.payment.converter;

import org.dei.payment.api.dto.PaymentDetailsDTO;
import org.dei.payment.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class PaymentDetailsConvert {
    public PaymentDetails DTOtoPaymentDetails(PaymentDetailsDTO paymentDetailsDTO) {
        OrderConverter orderConverter = new OrderConverter();
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setId(paymentDetailsDTO.getId());
        paymentDetails.setUsername(paymentDetailsDTO.getUsername());
        paymentDetails.setCardAuthorizationInfo(paymentDetailsDTO.getCardAuthorizationInfo());
        paymentDetails.setOrder(orderConverter.DTOtoOrder(paymentDetailsDTO.getOrder()));
        return paymentDetails;
    }

    public PaymentDetailsDTO paymentDetailsToDTO(PaymentDetails paymentDetails) {
        OrderConverter orderConverter = new OrderConverter();
        PaymentDetailsDTO paymentDetailsDTO = new PaymentDetailsDTO();
        paymentDetailsDTO.setId(paymentDetails.getId());
        paymentDetailsDTO.setUsername(paymentDetails.getUsername());
        paymentDetailsDTO.setCardAuthorizationInfo(paymentDetails.getCardAuthorizationInfo());
        paymentDetailsDTO.setOrder(orderConverter.orderToDTO(paymentDetails.getOrder()));
        return paymentDetailsDTO;
    }
}
