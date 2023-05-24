package com.rest_api.fs14backend.cart;

import com.rest_api.fs14backend.category.CategoryRepository;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import com.rest_api.fs14backend.products.Product;
import com.rest_api.fs14backend.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carts")
public class CartController  {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    //Read
    @GetMapping("/")
    public List<Cart> getAllProducts() {
        List<Cart> carts = cartService.findAllCarts();
        return carts;
    }
    @GetMapping("/{userId}")
    public List<Cart> getCartByUserId (@PathVariable UUID userId){
        List<Cart> carts = cartService.findCartsByUserId(userId);
        return carts;
    }

    @PostMapping("/")
    public List<Cart> createCarts(@RequestBody List<Cart> carts) {
        List<Cart> savedCarts = new ArrayList<>();
        for (Cart cart : carts) {
            Cart savedCart = cartRepository.save(cart);
            savedCarts.add(savedCart);
            // Update the remaining quantity of the corresponding product
            UUID productId = cart.getProductId();
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                int quantity = cart.getQuantity();
                int remainingQuantity = product.getQuantity() - quantity;
                if (remainingQuantity >= 0) {
                    product.setQuantity(remainingQuantity);
                    productRepository.save(product);
                } else {
                    String errorMessage = "out of stock";
                    throw new NotFoundException(errorMessage);
                }
            }
        }
        return savedCarts;
    }


}
