package org.dei.order.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Product {
    private Long id;

    private String name;

    private Long amount;

    private Long price;
}
