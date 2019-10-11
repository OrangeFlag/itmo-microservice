package org.dei.storehouse.domain;

import javax.validation.constraints.NotNull;

public class ProductCreationDto {
    @NotNull
    private String name;

    @NotNull
    private Long amount;

    @NotNull
    private Long price;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
