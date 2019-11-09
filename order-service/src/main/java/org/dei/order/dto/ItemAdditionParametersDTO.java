package org.dei.order.dto;

import lombok.Data;

@Data
public class ItemAdditionParametersDTO {
    private Long id;
    private Long amount;
    private String username;
}
