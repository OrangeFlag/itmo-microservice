package org.dei.payment.converter;

import org.dei.payment.api.dto.OrderDTO;
import org.dei.payment.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public Order DTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        return order;
    }

    public OrderDTO orderToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        return orderDTO;
    }
}
