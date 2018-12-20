package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeName;
    private String category;
    private String description;
    private Double preparationTime;
    private String describedRecipe;
    private Integer likesCount;

    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes;

    public Category() {
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}