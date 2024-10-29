package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired // Fill injection instead of CategoryController(CategoryService categoryService)
    private CategoryService categoryService;  // Create an object of service

    /* public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    */
    // Methode to get all the category
    // http://localhost:8080/api/public/categories
    @GetMapping("/public/categories")
    // @RequestMapping(value="/public/categories", method=RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    // Create category
    @PostMapping("/public/categories")
    // @RequestMapping(value="/public/categories", method=RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        // return "Category added successfully!!";
        return new ResponseEntity<>("Category added successfully!!", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
           String status = categoryService.deleteCategory(categoryId);
           return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,
                                                 @PathVariable Long categoryId) {

            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with category id " + categoryId, HttpStatus.OK);


    }
}
