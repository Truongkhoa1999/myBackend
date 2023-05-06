package com.rest_api.fs14backend.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
    public List<Category> findAllCategories () {
        return categoryRepository.findAll();
    }
}

