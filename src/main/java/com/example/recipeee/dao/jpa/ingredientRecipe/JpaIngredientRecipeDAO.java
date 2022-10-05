package com.example.recipeee.dao.jpa.ingredient;

import com.example.recipeee.dao.entity.Ingredient;
import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaIngredientDAO {
    EntityManagerFactory emf = EMFManager.getEMF();

    public Optional<Ingredient> findByName(String name) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            List<Ingredient> ingredients = em.createQuery("Select i from Ingredient i WHERE i.name=:name", Ingredient.class)
                    .setParameter("name", name).getResultList();
            transaction.commit();
            return Optional.of(ingredients.get(0));
        } catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    public boolean create(Ingredient ingredient){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(ingredient);
            transaction.commit();
            return true;
        } catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }finally {
            em.close();
        }
        return false;
    }
}
