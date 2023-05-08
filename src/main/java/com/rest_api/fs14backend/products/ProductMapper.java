package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO product, Category category) {
        return new Product(
                product.getTitle(),
                product.getPrice(),
                product.getQuantity(),
                product.getBrand(),
                product.getDescription(),
                product.getThumbnail(),
                product.getImages(),
                product.getIsRemoved(),
                category);
    }
}

