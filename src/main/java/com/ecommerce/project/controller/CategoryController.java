package com.ecommerce.project.controller;

import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired // Fill injection instead of CategoryController(CategoryService categoryService)
    private CategoryService categoryService;  // Create an object of service

   @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "message") String message){
       // public ResponseEntity<String> echoMessage(@RequestParam(name = "message", defaultValue = "Hello world") String message)
        return new ResponseEntity<>("Echo message : " + message, HttpStatus.OK);
    }

    // http://localhost:8080/api/public/categories
    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    // Create category
    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO saveCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(saveCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
           CategoryDTO deleteCategory= categoryService.deleteCategory(categoryId);
           return new ResponseEntity<>(deleteCategory, HttpStatus.OK);

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId) {

            CategoryDTO savedCategoryID = categoryService.updateCategory(categoryDTO, categoryId);
            return new ResponseEntity<>(savedCategoryID, HttpStatus.OK);


    }
}
