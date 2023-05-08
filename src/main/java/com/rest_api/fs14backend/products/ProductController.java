package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        List<Product> products = productService.findProducts();
        return products;
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable UUID id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new NotFoundException("ID not found");
        }
        return product;
    }

    @PutMapping("/id/{id}")
    public Product updateProductQuantityById(@PathVariable UUID id, @RequestParam int quantity){
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new NotFoundException("ID not found");
        }
        product.setQuantity(quantity);
        productService.saveProductQuantity(product);
        return product;
    }


    @GetMapping("/title/{title}")
    public Product getProductByTitle(@PathVariable String title) {
        Product product = productService.findProductByTitle(title);
        if (product == null) {
            throw new NotFoundException("Product title not found");
        }
        return product;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        UUID categoryId = productDTO.getCategoryId();
        Category category = categoryService.findCategoryById(categoryId);
        Product product = productMapper.toProduct(productDTO, category);
        return productService.createProduct(product);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable UUID id) {
        productService.deleteProductById(id);
    }
}

