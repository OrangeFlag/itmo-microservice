package org.dei.order.service;

import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.model.Status;
import org.dei.order.model.Order;

import java.util.List;

public interface OrderService {
    Order find(Long id);

    List<Order> findAll();

    Order addItem(ItemAdditionParametersDTO itemAdditionParametersDTO, Long orderId);

    Order setStatus(Status status, Long orderId);
}
