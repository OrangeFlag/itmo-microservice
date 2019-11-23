package org.dei.order.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("storehouse-service")
public interface StoreHouseClient {
}
