package com.rest_api.fs14backend.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ProductDTO {
    private UUID categoryId;
    private String title;
    private BigDecimal price;
    private int quantity;
    private String brand;
    private String description;
    private String thumbnail;
    private List<String> images;
    private boolean isRemoved;

    public boolean getIsRemoved() {
        return isRemoved;
    }
}
