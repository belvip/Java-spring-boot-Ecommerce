# Spring Boot E-commerce Project

This project is an e-commerce application built using Spring Boot. It includes managing product categories, creating controllers, and setting up RESTful endpoints.

### Key Features
- **Spring Data JPA**: Provides a high-level, consistent API for interacting with databases.
- **H2 In-memory Database**: For testing and local development purposes.
- **REST API**: Exposes endpoints to manage e-commerce entities such as categories, products, etc.


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

## Create `@Entity`  to map the paticular class to a table into the data base
- Map `categoryId` as the ` @Id` annotation.
- Customize the table's name like this : `@Entity(name = "categories")`

### Configuring JPA Repositories

In Spring Data JPA, `JPA Repositories` simplify data access by providing a robust, ready-made implementation for CRUD operations and queries. You can create a repository by simply extending `JpaRepository` and defining the entity type and primary key type. In this project, the `com.ecommerce.project.repositories` package contains the repositories, such as `CategoryRepository`.

#### `CategoryRepository` Implementation

The `CategoryRepository` interface provides CRUD operations for the `Category` entity. It extends `JpaRepository<Category, Long>`, where:
- `Category` is the entity type.
- `Long` is the type of the primary key for `Category`.

```java
// CategoryRepository.java
package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // JpaRepository provides methods like save(), findAll(), findById(), deleteById(), etc.
    // Additional custom query methods can be defined here.
}
```

* In Spring Data JPA, `JPA Repositories` simplify data access in applications by providing a consistent, high-level API for interacting with databases.

# Configure JPA in our project by configure `com.ecommerce.project.repositories` package

The `@Autowired` annotation in Java, specifically in the Spring Framework, is used for dependency injection. It enables Spring to automatically "inject" a required bean (class instance) into a dependent object at runtime.