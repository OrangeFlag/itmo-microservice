package org.dei.order.domain;

import org.javamoney.moneta.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document
public class Order {
    @Id
    Long id;

    @NotNull
    Status status;

    @NotNull
    Money totalCost;

    @NotNull
    Long totalAmount;

    @NotNull
    String username;

    @NotNull
    List<Product> products;
}
