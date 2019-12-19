package org.dei.payment.client;

import org.dei.order.api.OrderAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order-service", path = "/api/orders")
public interface OrderClient extends OrderAPI {
}
