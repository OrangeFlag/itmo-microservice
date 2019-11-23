package org.dei.order.api.dto;

import lombok.Data;

@Data
public class ItemAdditionParametersDTO {
    private Long id;
    private Long amount;
    private String username;
}
