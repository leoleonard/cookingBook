package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeName;
    private String category;
    private String description;
    private Integer preparationTime;
    private Double likesCount;

    public Recipe() {
    }

    public Recipe(String recipeName, String category, String description, Integer preparationTime, Double likesCount) {
        this.recipeName = recipeName;
        this.category = category;
        this.description = description;
        this.preparationTime = preparationTime;
        this.likesCount = likesCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Double getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Double likesCount) {
        this.likesCount = likesCount;
    }
}
