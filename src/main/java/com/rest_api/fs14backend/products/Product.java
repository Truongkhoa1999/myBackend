package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
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

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String brand;
    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String description;
    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String thumbnail;


    @ElementCollection
    @Column(nullable = false)
    private List<String> images;
    @Column(nullable = false, name = "isRemoved")
    private boolean isRemoved;

//    Other entities
    @ManyToOne(optional = false)
    private Category category;


    public Product(
            String title,
            BigDecimal price,
            int quantity,
            String brand,
            String description,
            String thumbnail,
            List<String> images,
            boolean isRemoved,
            Category category) {
        this.title = title;
        this.price = price;
        this.quantity =quantity;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.thumbnail = thumbnail;
        this.images = images;
        this.isRemoved = isRemoved;
    }


}
