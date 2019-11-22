package org.dei.storehouse.service;

import org.dei.storehouse.model.Product;
import org.javamoney.moneta.Money;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product get(int id);

    Product create(String name, Long amount, Money price);

    Product add(int id, Long amount);

    Product reserve(int id, Long amount);

    Product unreserve(int id, Long amount);
}
