package com.rest_api.fs14backend.Products;

import com.rest_api.fs14backend.Category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO product, Category category) {
        return new Product(product.getTitle(), product.getPrice(), product.getQuantity(), category);
    }
}
