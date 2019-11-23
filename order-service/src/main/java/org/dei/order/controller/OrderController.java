package org.dei.order.controller;

import org.dei.order.api.OrderAPI;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
interface OrderController extends OrderAPI {
}
