package com.ecommerce.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "categories") // To map the database
public class Category {
    @Id
    private Long categoryId;
    private String categoryName;

    public Long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(Long categoryId) {

        this.categoryId = categoryId;
    }

    public String getCategoryName() {

        return categoryName;
    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }
}
