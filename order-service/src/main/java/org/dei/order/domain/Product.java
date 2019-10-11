package org.dei.order.domain;

import org.javamoney.moneta.Money;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Product {
    @Id
    Long id;

    @NotNull
    String name;

    @NotNull
    Long amount;

    @NotNull
    Money price;
}
