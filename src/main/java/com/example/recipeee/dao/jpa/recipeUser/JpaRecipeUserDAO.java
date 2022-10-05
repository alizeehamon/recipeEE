package com.example.recipeee.dao.jpa.recipeUser;

import com.example.recipeee.dao.RecipeUserDAO;
import com.example.recipeee.dao.entity.RecipeUser;
import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeUserDAO implements RecipeUserDAO {

    @Override
    public List<RecipeUser> findAll() {
        List<RecipeUser> recipeUser = new ArrayList<>();
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            recipeUser = em.createQuery("Select recipeUser from RecipeUser recipeUser", RecipeUser.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("la table est vide ? / ou n'a pas pu etre atteinte");
        } finally {
            em.close();
        }
        return recipeUser;
    }

    @Override
    public boolean create(RecipeUser recipeUser) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(recipeUser);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    /* cherche si la recipe est dans la DB */

    @Override
    public boolean findIfRecipeWasCooked(long idParam) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            RecipeUser query = em.createQuery("SELECT i from RecipeUser i where i.recipeByIdRecipe.id = :idRecipe", RecipeUser.class).setParameter("idRecipe", idParam).getSingleResult();

            if (query != null){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("test");
            e.printStackTrace();
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public Optional<RecipeUser> findById(long idParam) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            RecipeUser recipeUser = em.find(RecipeUser.class, idParam);
            return Optional.ofNullable(recipeUser);
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public void update(long id, RecipeUser updatedRecipeUser) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            RecipeUser recipeUser1 = em.find(RecipeUser.class, id);
            recipeUser1.setCookDate(updatedRecipeUser.getCookDate());
            recipeUser1.setRecipeByIdRecipe(updatedRecipeUser.getRecipeByIdRecipe());
            recipeUser1.setUserByIdUser(updatedRecipeUser.getUserByIdUser());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("la table est vide ? / ou n'a pas pu etre atteinte");
        } finally {
            em.close();
        }
    }

    public Long findID(long recipeID) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        Long id = null;
        try {
            em.getTransaction().begin();
            id = em.find(RecipeUser.class, recipeID).getId();
        } catch (Exception E) {
            System.out.println("id not found");
            E.printStackTrace();
        }
        return id;
    }
}
