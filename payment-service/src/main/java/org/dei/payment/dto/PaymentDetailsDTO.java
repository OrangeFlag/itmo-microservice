package org.dei.payment.dto;


import org.dei.payment.model.CardAuthorizationInfo;

public class PaymentDetailsDTO {

    int id;


    String username;


    OrderDTO orderDTO;


    CardAuthorizationInfo cardAuthorizationInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CardAuthorizationInfo getCardAuthorizationInfo() {
        return cardAuthorizationInfo;
    }

    public void setCardAuthorizationInfo(CardAuthorizationInfo cardAuthorizationInfo) {
        this.cardAuthorizationInfo = cardAuthorizationInfo;
    }

    public OrderDTO getOrder() {
        return orderDTO;
    }

    public void setOrder(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}
