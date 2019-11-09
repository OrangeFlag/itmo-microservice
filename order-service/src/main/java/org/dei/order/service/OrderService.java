package org.dei.order.service;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.dto.OrderDTO;
import org.dei.order.model.Status;

import java.util.List;

public interface OrderService {
    OrderDTO find(Long id);

    List<OrderDTO> findAll();

    OrderDTO addItem(ItemAdditionParametersDTO itemAdditionParametersDTO, Long orderId);

    OrderDTO setStatus(Status status, Long orderId);
}
