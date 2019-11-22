package org.dei.order.clients;


import org.dei.storehouse.controller.StoreHouseController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "storehouse", url = "http://localhost:9999")
public interface StoreHouseClient extends StoreHouseController {

}