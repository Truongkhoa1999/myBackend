package com.rest_api.fs14backend.Products;

import com.rest_api.fs14backend.Category.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String title;
    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "int")
    private int quantity;
    @ManyToOne(optional = false)
    private Category category;

    public Product(String title, BigDecimal price, int quantity, Category category) {
        this.title = title;
        this.price = price;
        this.quantity =quantity;
        this.category = category;
    }

}
