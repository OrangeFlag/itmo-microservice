package org.dei.storehouse.service;

import org.dei.storehouse.model.Product;
import org.dei.storehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return productRepository.findAll();
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(String name, Long amount, Long price) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public Product add(Long id, Long amount) {
        Product product = get(id);
        product.setAmount(product.getAmount() + amount);
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public Product reserve(Long id, Long amount) {
        Product product = get(id);
        if (product.getAmount() < amount) {
            amount = product.getAmount();
        }
        product.setAmount(product.getAmount() - amount);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product unreserve(Long id, Long amount) {
        return add(id, amount);
    }
}
