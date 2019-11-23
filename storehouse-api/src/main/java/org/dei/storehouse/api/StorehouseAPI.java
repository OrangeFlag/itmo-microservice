package org.dei.storehouse.api;


import org.dei.storehouse.api.dto.ProductCreationDTO;
import org.dei.storehouse.api.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface StorehouseAPI {
    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<ProductDTO> getItems();

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    public ProductDTO getItemById(@PathVariable(value = "item_id") Long itemID);

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public ProductDTO createItem(@RequestBody ProductCreationDTO productCreationDTO);

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    public ProductDTO addItems(@PathVariable Long id, @PathVariable Long amount);

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    public ProductDTO reserveItems(@PathVariable Long id, @PathVariable Long amount);


    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    public ProductDTO unreserveItems(@PathVariable Long id, @PathVariable Long amount);

}
