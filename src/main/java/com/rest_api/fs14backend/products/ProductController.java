package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
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

    //Read
    @CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "false")
    @GetMapping("/")
    public List<Product> getAllProducts() {
        List<Product> products = productService.findProducts();
        return products;
    }

    @CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "false")
    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable UUID id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new NotFoundException("ID not found");
        }
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

    @CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "false")
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable UUID categoryId) {
        Category category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        List<Product> products = productService.findProductsByCategory(category);
        return products;
    }

    @CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "false")
    @GetMapping("/search")
    public List<Product> getProductsByTitleandCategory(@RequestParam("q") String query) {
        return productService.findProductsByTitleandDescription(query);
    }

    //Update
    @PutMapping("/id/{id}")
    public Product updateProductQuantityById(@PathVariable UUID id, @RequestParam int quantity) {
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new NotFoundException("ID not found");
        }
        product.setQuantity(quantity);
        productService.saveProductQuantity(product);
        return product;
    }

    //Create
    @PostMapping("/add/")
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        UUID categoryId = productDTO.getCategoryId();
        Category category = categoryService.findCategoryById(categoryId);
        Product product = productMapper.toProduct(productDTO, category);
        return productService.createProduct(product);
    }

    //Delete
    @PutMapping("/delete/{id}")
    public void deleteProductById(@PathVariable UUID id) {
        productService.softDeleteProductById(id);
    }

    @PutMapping("/restore/{id}")
    public void restoreProductById(@PathVariable UUID id) {
        productService.restoreProductById(id);
    }

}

