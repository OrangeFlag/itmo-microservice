package org.dei.payment.api.dto;


import lombok.Data;
import org.dei.payment.api.model.CardAuthorizationInfo;

@Data
public class PaymentDetailsDTO {

    Long id;

    String username;

    OrderDTO orderDTO;

    CardAuthorizationInfo cardAuthorizationInfo;
}
