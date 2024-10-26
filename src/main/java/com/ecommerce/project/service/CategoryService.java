package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}

// url=jdbc:h2:mem:1e126fe4-2f81-413d-90f3-aab3099d5035 user=SA

// Access console : '/h2-console'