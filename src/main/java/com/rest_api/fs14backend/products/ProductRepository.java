package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);
    List<Product> findByCategory(Category category);
    List<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String titleQuery, String descriptionQuery);


}
