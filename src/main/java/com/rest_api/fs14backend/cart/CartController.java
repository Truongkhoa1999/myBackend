package com.rest_api.fs14backend.cart;

import com.rest_api.fs14backend.category.CategoryRepository;
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
    //Read
    @CrossOrigin(origins = "*", allowCredentials = "false")
    @GetMapping("/")
    public List<Cart> getAllProducts() {
        List<Cart> carts = cartService.findAllCarts();
        return carts;
    }
    @PostMapping("/")
    public List<Cart> createCarts(@RequestBody List<Cart> carts) {
        List<Cart> savedCarts = new ArrayList<>();
        for (Cart cart : carts) {
            Cart savedCart = cartRepository.save(cart);
            savedCarts.add(savedCart);
        }
        return savedCarts;
    }



}
