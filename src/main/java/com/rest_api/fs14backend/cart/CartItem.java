package com.rest_api.fs14backend.cart;

import com.rest_api.fs14backend.products.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    @UuidGenerator

    private UUID id;
    @ManyToOne
    private Product product;

    private int quantity;

    // Constructors, getters, and setters
}