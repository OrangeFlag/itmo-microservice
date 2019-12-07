package org.dei.order.client;

import org.dei.storehouse.api.StorehouseAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "storehouse-service", path = "/api/warehouse")
public interface StoreHouseClient extends StorehouseAPI {
}
