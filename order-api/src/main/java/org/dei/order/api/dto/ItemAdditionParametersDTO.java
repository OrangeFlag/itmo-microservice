package org.dei.order.api.dto;

import lombok.Data;

@Data
public class ItemAdditionParametersDTO {
    private Long item_id;
    private Long amount;
    private String username;
}
