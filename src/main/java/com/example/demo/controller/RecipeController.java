package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Recipe> all = recipeRepository.findAll();
        model.addAttribute("recipes", all);
        return "list";
    }
    //zwrocenie listy przepisow

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "addRecipe";
    }
    //formularz dodania nowego przepisu

    @PostMapping("/save")
    public String saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }
    //zapisanie danych z formularza
    //przekierowanie na stronę głowna

    //localhost:8080/recipe?recipeId=2
    @GetMapping("/recipe")
    public String singleRecipe(@RequestParam Long recipeId, Model model) {
        Recipe recipe = recipeRepository.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "singleRecipe";
    }
}
