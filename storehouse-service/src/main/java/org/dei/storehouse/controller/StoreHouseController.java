package org.dei.storehouse.controller;

import org.dei.storehouse.dto.ProductCreationDTO;
import org.dei.storehouse.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public interface StoreHouseController {

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    List<Product> getItems();

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    Product getItemById(@PathVariable(value = "item_id") int itemID);

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    Product createItem(@RequestBody ProductCreationDTO productCreationDTO);

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    Product addItems(@PathVariable int id, @PathVariable Long amount);

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    Product reserveItems(@PathVariable int id, @PathVariable Long amount);

    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    Product unreserveItems(@PathVariable int id, @PathVariable Long amount);

}
