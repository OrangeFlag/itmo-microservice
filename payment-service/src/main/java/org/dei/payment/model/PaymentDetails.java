package org.dei.payment.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotNull
    String username;

    @NotNull
    @OneToOne
    Order order;

    @NotNull
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
