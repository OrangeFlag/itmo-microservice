package org.dei.storehouse.domain;

import org.javamoney.moneta.Money;
import javax.validation.constraints.NotNull;

public class Product {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long amount;
    @NotNull
    private Money price;

    public Product(String name, Long amount, Money price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}

