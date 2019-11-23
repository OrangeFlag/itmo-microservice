package org.dei.storehouse.api.dto;

import lombok.Data;
import org.javamoney.moneta.Money;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private Long amount;

    private Money price;

    private StoreHouseDTO storeHouseDTO;
}