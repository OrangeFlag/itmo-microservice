package org.dei.order.service;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.model.Order;
import org.dei.order.model.Status;

import java.util.List;

public interface OrderService {
    Order find(Long id);

    List<Order> findAll();

    Order addItem(ItemAdditionParametersDTO itemAdditionParametersDTO, Long orderId);

    Order setStatus(Status status, Long orderId);
}
