package com.rest_api.fs14backend.Category;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
@GetMapping("/")
    public List<Category> getCategories (){
        List<Category> categories =categoryService.findAllCategories();
        return categories;
    }
    @PostMapping("/")
    public Category createCategory (@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
