package org.dei.storehouse.model;

import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private Long amount;

    @NotNull
    private Money price;

    @NotNull
    @ManyToOne
    private StoreHouse storeHouse;
}

