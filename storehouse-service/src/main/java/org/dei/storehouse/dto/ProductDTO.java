package org.dei.storehouse.dto;

import org.javamoney.moneta.Money;

public class ProductDTO {

    private int id;


    private String name;

    private Long amount;

    private Money price;

    private StoreHouseDTO storeHouseDTO;

    public StoreHouseDTO getStoreHouse() {
        return storeHouseDTO;
    }

    public void setStoreHouse(StoreHouseDTO storeHouseDTO) {
        this.storeHouseDTO = storeHouseDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}