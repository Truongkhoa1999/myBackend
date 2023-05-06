package com.rest_api.fs14backend.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findProducts () {return productRepository.findAll();}
    public Product findProductByTitle (String title) {
        return productRepository.findByTitle(title);
    }
    public Product findProductById (UUID id) { return productRepository.findById(id).orElse(null);}
    public Product createProduct (Product product) {return productRepository.save(product);}
    public void deleteProductById(UUID id) {productRepository.deleteById(id);}
}
