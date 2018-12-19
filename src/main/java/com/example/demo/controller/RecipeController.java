package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
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
        Recipe recipe = recipeRepository.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "singleRecipe";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam Long id) {
        recipeRepository.removeRecipe(recipeRepository.findById(Long.valueOf(id)));
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String showForm(Model model, @RequestParam Long id) {
        Recipe recipe = recipeRepository.findById(Long.valueOf(id));
        model.addAttribute("recipe", recipe);
        recipeRepository.updateRecipe(recipe);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @PostMapping("/likeRecipe/{id}")
    @Transactional
    public String likeRecipe(@PathVariable("id") long id) {
        Recipe recipe = recipeRepository.findById(id);
        recipe.setLikesCount(recipe.getLikesCount() + 1);
        recipeRepository.save(recipe);
        return "redirect:/recipe?recipeId=" + recipe.getId();
    }
}