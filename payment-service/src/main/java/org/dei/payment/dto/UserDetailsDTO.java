package org.dei.payment.dto;

import org.dei.payment.model.CardAuthorizationInfo;


public class UserDetailsDTO {
    String username; // Is it id?

    CardAuthorizationInfo cardAuthorizationInfo;

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
}