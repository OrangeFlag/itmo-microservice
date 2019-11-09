package org.dei.payment.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotNull
    String username;

    @NotNull
    @OneToOne
    @Enumerated(EnumType.STRING)
    Order order;

    @NotNull
    CardAuthorizationInfo cardAuthorizationInfo;
}
