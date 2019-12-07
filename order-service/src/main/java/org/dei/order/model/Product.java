package org.dei.order.model;

import lombok.Data;

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
    private Long price;
}
