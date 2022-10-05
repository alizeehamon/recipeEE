package com.example.recipeee.dao.jpa.recipe;

import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.dao.jpa.EMFManager;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.RecipeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDAO implements RecipeDAO {

    EntityManagerFactory emf = EMFManager.getEMF();
    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
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
    public List<Recipe> findByNameAndType(String name, Long typeId) {
        List<Recipe> recipes = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Recipe> query = em.createQuery(
                    "select r from Recipe r join TypeMeal t on t.id = r.typeMealByIdTypeMeal.id where r.name like concat('%', :name, '%') and t.id = :typeId", Recipe.class);
            recipes = query
                    .setParameter("name", name)
                    .setParameter("typeId", typeId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return recipes;
    }

    @Override
    public List<Recipe> findByName(String name) {
        List<Recipe> recipes = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Recipe> query = em.createQuery(
                    "select r from Recipe r where r.name like concat('%', :name, '%')", Recipe.class);
            recipes = query
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return recipes;
    }

    @Override
    public List<Recipe> findByType(Long typeId) {
        List<Recipe> recipes = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Recipe> query = em.createQuery(
                    "select r from Recipe r join TypeMeal t on t.id = r.typeMealByIdTypeMeal.id where t.id = :typeId", Recipe.class);
            recipes = query
                    .setParameter("typeId", typeId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return recipes;
    }

    @Override
    public Optional<Recipe> findById(long idParam) {
        Recipe recipe = null;
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

    @Override
    public boolean create(Recipe recipe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            String typeMealName = recipe.getTypeMealByIdTypeMeal().getName();
            List<TypeMeal> typeMeals = em.createQuery("SELECT tm FROM TypeMeal tm WHERE tm.name = :name", TypeMeal.class).setParameter("name", typeMealName).getResultList();
            if (typeMeals.size()==1){
                recipe.setTypeMealByIdTypeMeal(typeMeals.get(0));
            }
            em.persist(recipe);
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

    public boolean delete(long id) {
        Recipe recipe;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            recipe = em.find(Recipe.class, id);
                em.remove(recipe);
                et.commit();
                return true;

        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

}
