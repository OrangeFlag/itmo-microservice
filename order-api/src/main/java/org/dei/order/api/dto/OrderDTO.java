package org.dei.order.api.dto;

import lombok.Data;
import org.dei.order.api.model.Status;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Status status;
    private Long totalCost;
    private Long totalAmount;
    private String username;
    private List<ProductDTO> products;
}