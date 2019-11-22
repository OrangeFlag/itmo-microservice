package org.dei.storehouse.converter;

import org.dei.storehouse.dto.StoreHouseDTO;
import org.dei.storehouse.model.StoreHouse;
import org.springframework.stereotype.Component;

@Component
public class StoreHouseConverter {
    public StoreHouse DTOtoStoreHouse(StoreHouseDTO storeHouseDTO) {
        StoreHouse storeHouse = new StoreHouse();
        storeHouse.setId(storeHouseDTO.getId());
        storeHouse.setName(storeHouseDTO.getName());
        return storeHouse;
    }

    public StoreHouseDTO StoreHouseToDTO(StoreHouse storeHouse) {
        StoreHouseDTO storeHouseDTO = new StoreHouseDTO();
        storeHouseDTO.setId(storeHouse.getId());
        storeHouseDTO.setName(storeHouse.getName());
        return storeHouseDTO;
    }
}
