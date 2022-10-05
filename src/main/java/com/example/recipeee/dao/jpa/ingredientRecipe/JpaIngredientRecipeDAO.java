package com.example.recipeee.dao.jpa.ingredientRecipe;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Ingredient;
import com.example.recipeee.dao.entity.IngredientRecipe;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class JpaIngredientRecipeDAO {

    public boolean create(long idRecipe,String ingredientName, String ingredientUrl,int qtyIngredient){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            IngredientRecipe ingredientRecipe = new IngredientRecipe();
            ingredientRecipe.setQtyIngredient(qtyIngredient);
            Optional<Recipe> optionalRecipe = Optional.of(em.find(Recipe.class, idRecipe));
            if (optionalRecipe.isPresent()){
                ingredientRecipe.setRecipeByIdRecipe(optionalRecipe.get());
                Optional<Ingredient> optionalIngredient = DAOFactory.getIngredientDAO().findByName(ingredientName);
                if(optionalIngredient.isPresent()){
                    ingredientRecipe.setIngredientByIdIngredient(optionalIngredient.get());
                }else{
                    Ingredient ingredient = new Ingredient(ingredientName, ingredientUrl);
                    ingredientRecipe.setIngredientByIdIngredient(ingredient);
                }
                em.persist(ingredientRecipe);
            }else {
                return false;
            }
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
