package com.example.recipeee.dao.jpa.step;

import com.example.recipeee.dao.entity.Step;
import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

public class JpaStepDAO {
    EntityManagerFactory emf = EMFManager.getEMF();

    public List<Step> findStepsByIdRecipe(long idRecipe){
            List<Step> steps = new ArrayList<>();
            EntityManager em = emf.createEntityManager();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                steps = em.createQuery("Select s from Step s WHERE s.recipeByIdRecipe.id=:idRecipe", Step.class).setParameter("idRecipe", idRecipe).getResultList();
                et.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
            }
            return steps;
    }

    public boolean create(Step step){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(step);
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
