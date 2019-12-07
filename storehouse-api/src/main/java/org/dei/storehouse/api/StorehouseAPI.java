package org.dei.storehouse.api;


import org.dei.storehouse.api.dto.ProductCreationDTO;
import org.dei.storehouse.api.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StorehouseAPI {
    @RequestMapping(path = "/items", method = RequestMethod.GET)
    @ResponseBody
    List<ProductDTO> getItems();

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    @ResponseBody
    ProductDTO getItemById(@PathVariable("item_id") Long itemID);

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    @ResponseBody
    ProductDTO createItem(@RequestBody ProductCreationDTO productCreationDTO);

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    @ResponseBody
    ProductDTO addItems(@PathVariable("id") Long id, @PathVariable("amount") Long amount);

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    @ResponseBody
    ProductDTO reserveItems(@PathVariable("id") Long id, @PathVariable("amount") Long amount);

    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    @ResponseBody
    ProductDTO unreserveItems(@PathVariable("id") Long id, @PathVariable("amount") Long amount);
}
