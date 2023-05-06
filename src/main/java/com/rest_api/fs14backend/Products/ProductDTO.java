package com.rest_api.fs14backend.Products;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ProductDTO {
    private UUID categoryId;
    private String title;
    private BigDecimal price;
    private int quantity;

}
