package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findProductByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public Product findProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findProductsByTitleandDescription(String query) {
        return productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product saveProductQuantity(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void softDeleteProductById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setRemoved(true);
        productRepository.save(product);
    }

    @Transactional
    public void restoreProductById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setRemoved(false);
        productRepository.save(product);
    }
}
