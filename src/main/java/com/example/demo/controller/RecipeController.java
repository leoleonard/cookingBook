package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    RecipeRepository recipeRepository;
    CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Recipe> all = recipeRepository.findAll();
        model.addAttribute("recipes", all);
        return "list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "addRecipe";
    }

    @PostMapping("/save")
    public String saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    // localhost:8080/recipe?recipeId=2
    @GetMapping("/recipe")
    public String singleRecipe(@RequestParam Long recipeId, Model model) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        model.addAttribute("recipe", recipe);
        return "singleRecipe";
    }

    @GetMapping("/delete")
    @Transactional
    public String deleteById(@RequestParam Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/edit")
    @Transactional
    public String showForm(Model model, @RequestParam Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @PostMapping("/likeRecipe/{id}")
    @Transactional
    public String likeRecipe(@PathVariable("id") long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setLikesCount(recipe.getLikesCount() + 1);
        recipeRepository.save(recipe);
        return "redirect:/recipe?recipeId=" + recipe.getId();
    }
}