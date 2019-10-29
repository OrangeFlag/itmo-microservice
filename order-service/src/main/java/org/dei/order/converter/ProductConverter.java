package org.dei.order.converter;

import org.dei.order.dto.ProductDTO;
import org.dei.order.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product DTOtoUser(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setAmount(productDTO.getAmount());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public ProductDTO userToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setAmount(product.getAmount());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
