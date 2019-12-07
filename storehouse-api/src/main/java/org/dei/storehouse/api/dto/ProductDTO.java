package org.dei.storehouse.api.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private Long amount;

    private Long price;

    private StoreHouseDTO storeHouseDTO;
}