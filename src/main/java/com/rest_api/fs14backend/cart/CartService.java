package com.rest_api.fs14backend.cart;

import com.rest_api.fs14backend.products.Product;
import com.rest_api.fs14backend.products.ProductRepository;
import com.rest_api.fs14backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }
    public List<Cart> findCartsByUserId(UUID userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public Cart findCartById(UUID id) {
        return cartRepository.findById(id).orElse(null);
    }
    public Cart createOne(Cart cart) {
        return cartRepository.save(cart);
    }
    public void deleteCartById(UUID id) {
        cartRepository.deleteById(id);
    }



}
