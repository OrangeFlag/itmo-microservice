package org.dei.order.clients;

import org.dei.storehouse.controller.StoreHouseController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "localhost:8888")
public abstract class StoreHouseClient implements StoreHouseController {

}