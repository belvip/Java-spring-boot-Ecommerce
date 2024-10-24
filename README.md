# Spring Boot E-commerce Project

This project is an e-commerce application built using Spring Boot. It includes managing product categories, creating controllers, and setting up RESTful endpoints.

## Getting Started

### Project Initialization

The project was initialized using [Spring Initializr](https://start.spring.io/), and the package `com.ecommerce.project` was set as the base package for this application.

## Model: `Category`

The `Category` class is a representation of a product category in the e-commerce system. It includes the following fields and methods:

### Fields:
- `categoryId`: A `Long` that uniquely identifies the category.
- `categoryName`: A `String` that holds the name of the category.

### Methods:
- **Constructor**: Initializes the `categoryId` and `categoryName`.
- **Getters/Setters**: 
  - `getCategoryId()` and `setCategoryId(Long categoryId)`
  - `getCategoryName()` and `setCategoryName(String categoryName)`

- Example:
```java
public class Category {
    private Long categoryId;
    private String categoryName;

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Getter and Setter methods...
}
```

### Add new Categories:
- **Create a method `crezteCategory(@RequestBody Category category)`**
   - Add categories to the List : 
   ```java
   @PostMapping("/api/public/categories")
     public String createCategory(@RequestBody Category category){
          categories.add(category);
          return "Category added successfully";
    }
  ```

### Add service layer
**Create `com.ecommerce.project.service` package**
- Create `CategoryService` interface to promote loose coupling and modularity into the database
- Create `getAllCategories()` method to have all categories
- Create `void createCategory(Category category)` to have the logic in interface service
- Create `CategoryServiceImpl` class to implement `CategoryService` interface 
