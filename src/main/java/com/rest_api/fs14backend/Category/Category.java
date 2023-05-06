package com.rest_api.fs14backend.Category;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Data
@NoArgsConstructor
@Entity(name="category")
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID categoryId;
    @Column(nullable = false, columnDefinition = "Varchar(100)", unique = true)
    private String title;

}
