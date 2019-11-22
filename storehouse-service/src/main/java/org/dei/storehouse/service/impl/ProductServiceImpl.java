package org.dei.storehouse.service.impl;

import org.dei.storehouse.model.Product;
import org.dei.storehouse.repository.ProductRepository;
import org.dei.storehouse.service.ProductService;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product get(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(String name, Long amount, Money price) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product add(int id, Long amount) {
        Product product = get(id);
        product.setAmount(product.getAmount() + amount);
        return product;
    }

    @Override
    public Product reserve(int id, Long amount) {
        Product product = get(id);
        if (product.getAmount() < amount) {
            amount = product.getAmount();
        }
        product.setAmount(product.getAmount() - amount);
        return null;
    }

    @Override
    public Product unreserve(int id, Long amount) {
        return add(id, amount);
    }
}
