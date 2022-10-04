package com.example.recipeee.dao.jpa.recipe;

import com.example.recipeee.dao.jpa.EMFManager;
import com.example.recipeee.dao.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDAO implements RecipeDAO {
    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            recipes = em.createQuery("Select country from Recipe country", Recipe.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("la table est vide ? / ou n'a pas pu etre atteinte");
        } finally {
            em.close();
        }
        return recipes;
    }


    @Override
    public Optional<Recipe> findById(long idParam) {
        Recipe recipe = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            recipe = em.find(Recipe.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(recipe);
    }
}
