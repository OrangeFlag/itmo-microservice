package org.dei.storehouse.service;

import org.dei.storehouse.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product get(Long id);

    Product create(String name, Long amount, Long price);

    Product add(Long id, Long amount);

    Product reserve(Long id, Long amount);

    Product unreserve(Long id, Long amount);
}
