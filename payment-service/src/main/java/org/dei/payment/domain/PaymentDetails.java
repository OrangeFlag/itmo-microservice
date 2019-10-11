package org.dei.payment.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "payment_details")
public class PaymentDetails {
    @Id
    Long id;

    @NotNull
    String username;

    @NotNull
    CardAuthorizationInfo cardAuthorizationInfo;
}
