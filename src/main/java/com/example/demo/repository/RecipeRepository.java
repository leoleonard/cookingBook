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




}
