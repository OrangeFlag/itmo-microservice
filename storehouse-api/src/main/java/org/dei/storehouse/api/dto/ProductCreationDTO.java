package org.dei.storehouse.api.dto;

import lombok.Data;

@Data
public class ProductCreationDTO {

    private String name;

    private Long amount;

    private Long price;

}
