package com.rest_api.fs14backend.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity(name = "cart")
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID cartId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int price;
    private UUID userId;
    private UUID productId;

    public Cart(int price, int quantity, String title, UUID userId,UUID productId) {
        this.price =price;
        this.quantity =quantity;
        this.title =title;
        this.userId =userId;
        this.productId = productId;
    }

//    public Cart(double price, int quantity, String title, UUID userId) {
//    }
}
