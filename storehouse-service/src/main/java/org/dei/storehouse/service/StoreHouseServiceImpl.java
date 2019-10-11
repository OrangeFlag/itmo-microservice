package org.dei.storehouse.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dei.storehouse.domain.Product;
import org.javamoney.moneta.Money;

public class StoreHouseServiceImpl implements StoreHouseService {

    private final Logger log = LogManager.getLogger(getClass());

    @Override
    public Product[] getAll() {
        return new Product[0];
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public Product create(String name, Long amount, Money price) {
        return null;
    }

    @Override
    public Product add(Long id, Long amount) {
        return null;
    }

    @Override
    public Product reserve(Long id, Long amount) {
        return null;
    }

    @Override
    public Product unreserve(Long id, Long amount) {
        return null;
    }
}
