package org.dei.payment.model;


import lombok.Data;
import org.dei.payment.api.model.CardAuthorizationInfo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    String username;

    @NotNull
    @OneToOne
    @Enumerated(EnumType.STRING)
    Order order;

    @NotNull
    CardAuthorizationInfo cardAuthorizationInfo;
}
