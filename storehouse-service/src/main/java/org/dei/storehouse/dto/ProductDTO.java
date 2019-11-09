package org.dei.storehouse.dto;

import lombok.Data;
import org.javamoney.moneta.Money;

@Data
public class ProductDTO {

    private int id;

    private String name;

    private Long amount;

    private Money price;

    private StoreHouseDTO storeHouseDTO;

}