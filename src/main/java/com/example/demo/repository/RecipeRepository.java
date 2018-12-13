package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class RecipeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Recipe recipe) {
        entityManager.persist(recipe);
    }
    //przekazanie obiektu do zapisania

    public List<Recipe> findAll() {
        String jpql = "select r from Recipe r";
        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
        return query.getResultList();
    }
    //zwrócenie wszystich rekordów

    public Recipe findById(Long id) {
        return entityManager.find(Recipe.class, id);
    }

    @Transactional
    public void deleteRecipe(Recipe recipe) {
        entityManager.remove(recipe);
    }

//    public List<Recipe> sortByCategory(String category) {
//        String jpql = "select r from Recipe where category= :category";
//        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
//        List<Recipe> recipesByCategory = query.getResultList();
//        return recipesByCategory;
//    }

    @Transactional
    public int likesCount(int likesCount){
        likesCount++;
        return likesCount;
    }

    @Transactional
    public void incrementLikesCount(Long id) {
        Recipe recipe = entityManager.find(Recipe.class, id);
        Integer likesCount = recipe.getLikesCount();
        recipe.setLikesCount(likesCount+1);
    }

}
