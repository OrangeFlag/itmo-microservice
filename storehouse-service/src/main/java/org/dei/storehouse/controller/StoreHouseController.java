package org.dei.storehouse.controller;

import org.dei.storehouse.dto.ProductCreationDTO;
import org.dei.storehouse.model.Product;
import org.dei.storehouse.service.ProductService;
import org.dei.storehouse.service.StoreHouseService;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class StoreHouseController {
    private final Logger LOGGER = LoggerFactory.getLogger(StoreHouseController.class);
    private final StoreHouseService storeHouseService;
    private final ProductService productService;

    @Autowired
    public StoreHouseController(StoreHouseService storeHouseService, ProductService productService) {
        this.storeHouseService = storeHouseService;
        this.productService = productService;
    }


    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<Product> getItems() {
        LOGGER.info("start findAll products");
        return productService.getAll();
    }

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    public Product getItemById(@PathVariable(value = "item_id") int itemID) {
        LOGGER.info("start product order by id");
        return productService.get(itemID);
    }

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public Product createItem(@RequestBody ProductCreationDTO productCreationDTO) {
        LOGGER.info("start creating new product");
        return productService.create(
                productCreationDTO.getName(),
                productCreationDTO.getAmount(),
                Money.of(productCreationDTO.getPrice(), "RUS")
        );
    }

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    public Product addItems(@PathVariable int id, @PathVariable Long amount) {
        LOGGER.info("start adding amount to product");
        return productService.add(id, amount);
    }

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    public Product reserveItems(@PathVariable int id, @PathVariable Long amount) {
        LOGGER.info("start reserving amount of product");
        return productService.reserve(id, amount);
    }


    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    public Product unreserveItems(@PathVariable int id, @PathVariable Long amount) {
        LOGGER.info("start unreserving amount of product");
        return productService.unreserve(id, amount);
    }
}
