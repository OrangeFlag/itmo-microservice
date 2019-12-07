package org.dei.storehouse.controller;

import org.dei.storehouse.api.StorehouseAPI;
import org.dei.storehouse.api.dto.ProductCreationDTO;
import org.dei.storehouse.api.dto.ProductDTO;
import org.dei.storehouse.service.ProductService;
import org.javamoney.moneta.Money;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class StoreHouseControllerImpl implements StorehouseAPI {
    private final Logger LOGGER = LoggerFactory.getLogger(StoreHouseControllerImpl.class);
    private final ProductService productService;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Type listProductDTO = new TypeToken<List<ProductDTO>>() {
    }.getType();

    @Autowired
    public StoreHouseControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<ProductDTO> getItems() {
        LOGGER.info("start findAll products");
        return modelMapper.map(productService.getAll(), listProductDTO);
    }

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    public ProductDTO getItemById(@PathVariable(value = "item_id") Long itemID) {
        LOGGER.info("start product order by id");
        return modelMapper.map(productService.get(itemID), ProductDTO.class);
    }

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public ProductDTO createItem(@RequestBody ProductCreationDTO productCreationDTO) {
        LOGGER.info("start creating new product");
        return modelMapper.map(productService.create(
                productCreationDTO.getName(),
                productCreationDTO.getAmount(),
                Money.of(productCreationDTO.getPrice(), "EUR")
        ), ProductDTO.class);
    }

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    public ProductDTO addItems(@PathVariable Long id, @PathVariable Long amount) {
        LOGGER.info("start adding amount to product");
        return modelMapper.map(productService.add(id, amount), ProductDTO.class);
    }

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    public ProductDTO reserveItems(@PathVariable Long id, @PathVariable Long amount) {
        LOGGER.info("start reserving amount of product");
        return modelMapper.map(productService.reserve(id, amount), ProductDTO.class);
    }


    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    public ProductDTO unreserveItems(@PathVariable Long id, @PathVariable Long amount) {
        LOGGER.info("start unreserving amount of product");
        return modelMapper.map(productService.unreserve(id, amount), ProductDTO.class);
    }
}
