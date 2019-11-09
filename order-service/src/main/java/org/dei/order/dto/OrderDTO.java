package org.dei.order.dto;

import lombok.Data;
import org.dei.order.model.Status;
import org.javamoney.moneta.Money;

import java.util.List;

@Data
public class OrderDTO {
    private int id;
    private Status status;
    private Money totalCost;
    private Long totalAmount;
    private String username;
    private List<ProductDTO> products;
}