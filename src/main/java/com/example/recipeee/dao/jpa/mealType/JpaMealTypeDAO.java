package com.example.recipeee.dao.jpa.mealType;

import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

public class JpaMealTypeDAO {

    EntityManagerFactory emf = EMFManager.getEMF();

    public List<TypeMeal> findAll(){
            List<TypeMeal> types = new ArrayList<>();
            EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                types = em.createQuery("Select t from TypeMeal t", TypeMeal.class).getResultList();
                et.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
            }
            return types;
    }
}
