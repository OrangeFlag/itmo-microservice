package org.dei.storehouse.controller;

import org.dei.storehouse.domain.Product;
import org.dei.storehouse.domain.ProductTransferObject;
import org.dei.storehouse.service.StoreHouseService;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
public class StoreHouseController {

    @Autowired
    private StoreHouseService storeHouseService;

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public Product[] getItems() {
        return storeHouseService.getAll();
    }

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    public Product getItemById(@PathVariable(value = "item_id") Long itemID) {
        return storeHouseService.get(itemID);
    }

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public Product createItem(@RequestBody ProductTransferObject productTF) {
        return storeHouseService.create(
                productTF.getName(),
                productTF.getAmount(),
                Money.of(productTF.getPrice(), "RUS")
        );
    }

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    public Product addItems(@PathVariable Long id, @PathVariable Long amount) {
        return storeHouseService.add(id, amount);
    }

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    public Product reserveItems(@PathVariable Long id, @PathVariable Long amount) {
        return storeHouseService.reserve(id, amount);
    }


    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    public Product unreserveItems(@PathVariable Long id, @PathVariable Long amount) {
        return storeHouseService.unreserve(id, amount);
    }
}
