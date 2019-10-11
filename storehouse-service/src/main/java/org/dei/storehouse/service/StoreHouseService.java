package org.dei.storehouse.service;

import org.dei.storehouse.domain.Product;
import org.javamoney.moneta.Money;

public interface StoreHouseService {
    Product[] getAll();

    Product get(Long id);

    Product create(String name, Long amount, Money price);

    Product add(Long id, Long amount);

    Product reserve(Long id, Long amount);

    Product unreserve(Long id, Long amount);
}
