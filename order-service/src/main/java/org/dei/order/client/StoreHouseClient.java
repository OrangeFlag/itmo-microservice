package org.dei.order.client;

import org.dei.storehouse.api.StorehouseAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("storehouse-service")
public interface StoreHouseClient extends StorehouseAPI {
}
