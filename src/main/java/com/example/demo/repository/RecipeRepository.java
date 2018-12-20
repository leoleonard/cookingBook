package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipesByCategories(Category category);

    List<Recipe> findRecipesByLikesCountGreaterThanEqual(Long likesCount);

}

//@Repository
//public class RecipeRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    public void save(Recipe recipe) {
//        entityManager.persist(recipe);
//    }
//
//    public List<Recipe> findAll() {
//        String jpql = "select r from Recipe r";
//        TypedQuery<Recipe> query = entityManager.createQuery(jpql, Recipe.class);
//        return query.getResultList();
//    }
//
//    @Transactional
//    public Recipe findById(Long id) {
//        return entityManager.find(Recipe.class, id);
//    }
//
//    @Transactional
//    public String removeRecipe(Recipe recipe) {
//        entityManager.remove(recipe);
//        return "redirect:/";
//    }
//
//    @Transactional
//    public void updateRecipe(Recipe recipe) {
//        entityManager.merge(recipe);
//    }
//
//
//}
//
