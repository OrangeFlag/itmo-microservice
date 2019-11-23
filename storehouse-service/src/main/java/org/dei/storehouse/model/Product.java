package org.dei.storehouse.model;

import org.javamoney.moneta.Money;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

