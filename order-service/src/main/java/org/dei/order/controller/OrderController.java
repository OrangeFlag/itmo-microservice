package org.dei.order.controller;

import org.dei.order.api.OrderAPI;
import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.dto.OrderDTO;
import org.dei.order.api.model.Status;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
interface OrderController extends OrderAPI {
}
