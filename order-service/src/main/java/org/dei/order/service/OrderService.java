package org.dei.order.service;

import org.dei.order.api.dto.ItemAdditionParametersDTO;
import org.dei.order.api.dto.OrderDTO;
import org.dei.order.api.model.Status;

import java.util.List;

public interface OrderService {
    OrderDTO find(Long id);

    List<OrderDTO> findAll();

    OrderDTO addItem(ItemAdditionParametersDTO itemAdditionParametersDTO, Long orderId);

    OrderDTO setStatus(Status status, Long orderId);
}
