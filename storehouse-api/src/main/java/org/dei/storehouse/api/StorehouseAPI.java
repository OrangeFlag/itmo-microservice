package org.dei.storehouse.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface StorehouseAPI {
    @RequestMapping(path = "/items", method = RequestMethod.GET)
    List<Product> getItems();

    @RequestMapping(path = "/items/{item_id}", method = RequestMethod.GET)
    Product getItemById(@PathVariable(value = "item_id") Long itemID);

    @RequestMapping(path = "/items", method = RequestMethod.POST)
    Product createItem(@RequestBody ProductCreationDTO productCreationDTO);

    @RequestMapping(path = "/items/{id}/addition/{amount}", method = RequestMethod.PUT)
    Product addItems(@PathVariable Long id, @PathVariable Long amount);

    @RequestMapping(path = "/items/{id}/reserve/{amount}", method = RequestMethod.POST)
    Product reserveItems(@PathVariable Long id, @PathVariable Long amount);

    @RequestMapping(path = "/items/{id}/unreserve/{amount}", method = RequestMethod.POST)
    Product unreserveItems(@PathVariable Long id, @PathVariable Long amount);

}
