package org.dei.storehouse.service;

import org.dei.storehouse.model.Product;
import org.javamoney.moneta.Money;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product get(Long id);

    Product create(String name, Long amount, Money price);

    Product add(Long id, Long amount);

    Product reserve(Long id, Long amount);

    Product unreserve(Long id, Long amount);
}
