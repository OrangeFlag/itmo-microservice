package org.dei.order.model;

import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long amount;

    @NotNull
    private Money price;
}
