package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.statics.Statics;
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
    @Column(nullable = false, columnDefinition = "varchar(MAX)")
    private String title;
    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "int")
    private int quantity;

    @Column(nullable = false, columnDefinition = "varchar(MAX)")
    private String brand;
    @Column(nullable = false, columnDefinition = "varchar(MAX)")
    private String description;
    @Column(nullable = false, columnDefinition = "varchar(MAX)")
    private String thumbnail;


    @ElementCollection
    @Column(nullable = false)
    private List<String> images;
    @Column(nullable = false, name = "isRemoved")
    private boolean isRemoved;

//    Other entities
    @ManyToOne(optional = false)
    private Category category;
    @ManyToOne(optional = true)
    private Statics statics;

    public Product(
            String title,
            BigDecimal price,
            int quantity,
            String brand,
            String description,
            String thumbnail,
            List<String> images,
            boolean isRemoved,
            Category category,Statics statics) {
        this.title = title;
        this.price = price;
        this.quantity =quantity;
        this.category = category;
        this.statics = new Statics();
        this.brand = brand;
        this.description = description;
        this.thumbnail = thumbnail;
        this.images = images;
        this.isRemoved = isRemoved;
    }


}
