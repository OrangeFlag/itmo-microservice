package org.dei.storehouse.converter;

import org.dei.storehouse.dto.ProductDTO;
import org.dei.storehouse.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product DTOtoProduct(ProductDTO productDTO) {
        StoreHouseConverter storeHouseConverter = new StoreHouseConverter();
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        product.setAmount(productDTO.getAmount());
        product.setName(productDTO.getName());
        product.setStoreHouse(storeHouseConverter.DTOtoStoreHouse(productDTO.getStoreHouse()));
        return product;
    }

    public ProductDTO ProductToDTO(Product product) {
        StoreHouseConverter storeHouseConverter = new StoreHouseConverter();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setAmount(product.getAmount());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStoreHouse(storeHouseConverter.StoreHouseToDTO(product.getStoreHouse()));
        return productDTO;
    }
}
