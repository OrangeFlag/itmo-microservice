package org.dei.order.converter;

import org.dei.order.dto.ItemAdditionParametersDTO;
import org.dei.order.model.ItemAdditionParameters;
import org.springframework.stereotype.Component;

@Component
public class ItemAdditionParametersConverter {

    public ItemAdditionParameters DTOtoItemAdditionParameters(ItemAdditionParametersDTO itemAdditionParametersDTO) {
        ItemAdditionParameters itemAdditionParameters = new ItemAdditionParameters();
        itemAdditionParameters.setAmount(itemAdditionParametersDTO.getAmount());
        itemAdditionParameters.setId(itemAdditionParametersDTO.getId());
        itemAdditionParameters.setUsername(itemAdditionParametersDTO.getUsername());
        return itemAdditionParameters;
    }

    public ItemAdditionParametersDTO itemAdditionParametersToDTO(ItemAdditionParameters itemAdditionParameters) {
        ItemAdditionParametersDTO itemAdditionParametersDTO = new ItemAdditionParametersDTO();
        itemAdditionParametersDTO.setAmount(itemAdditionParameters.getAmount());
        itemAdditionParametersDTO.setId(itemAdditionParameters.getId());
        itemAdditionParametersDTO.setUsername(itemAdditionParameters.getUsername());
        return itemAdditionParametersDTO;
    }
}
