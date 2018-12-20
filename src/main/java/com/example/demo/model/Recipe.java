package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeName;
    private String category;
    private String description;
    private Double preparationTime;
    private Integer likesCount;
    private String describedRecipe;

    @ManyToMany(cascade=CascadeType.PERSIST)

    private List<Category> categories;
    

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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Double preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public String getDescribedRecipe() {
        return describedRecipe;
    }

    public void setDescribedRecipe(String describedRecipe) {
        this.describedRecipe = describedRecipe;
    }
}
