package org.dei.storehouse.service.impl;

import org.dei.storehouse.repository.StoreHouseRepository;
import org.dei.storehouse.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {
    private final StoreHouseRepository storeHouseRepository;

    @Autowired
    public StoreHouseServiceImpl(StoreHouseRepository storeHouseRepository) {
        this.storeHouseRepository = storeHouseRepository;
    }
}
