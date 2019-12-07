package org.dei.order.api.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Long amount;
    private Long price;
}
