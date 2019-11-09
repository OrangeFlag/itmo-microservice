package org.dei.payment.dto;


import lombok.Data;
import org.dei.payment.model.CardAuthorizationInfo;

@Data
public class PaymentDetailsDTO {

    int id;


    String username;


    OrderDTO orderDTO;


    CardAuthorizationInfo cardAuthorizationInfo;
}
