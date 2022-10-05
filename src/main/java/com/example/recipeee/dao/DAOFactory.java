package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;
import com.example.recipeee.dao.jpa.ingredient.JpaIngredientDAO;
import com.example.recipeee.dao.jpa.ingredientRecipe.JpaIngredientRecipeDAO;
import com.example.recipeee.dao.jpa.mealType.JpaMealTypeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;
import com.example.recipeee.dao.jpa.step.JpaStepDAO;
import com.example.recipeee.dao.jpa.recipeUser.JpaRecipeUserDAO;

public final class DAOFactory {

    private static JpaUserDAO jpaUserDAO;
    private static JpaMealTypeDAO jpaMealTypeDAO;
    private static JpaStepDAO jpaStepDAO;
    private static JpaIngredientDAO jpaIngredientDAO;
    private static JpaIngredientRecipeDAO jpaIngredientRecipeDAO;

    private DAOFactory() {
    }

    public static RecipeDAO getRecipeDAO() {
        return new JpaRecipeDAO();
    }
    public static RecipeUserDAO getRecipeUserDAO() {
        return new JpaRecipeUserDAO();
    }
    public static UserDAO getUserDAO() {
        if (jpaUserDAO == null) {
            jpaUserDAO = new JpaUserDAO();
        }
        return jpaUserDAO;
    }

    public static JpaMealTypeDAO getMealTypeDAO() {
        if (jpaMealTypeDAO == null) {
            jpaMealTypeDAO = new JpaMealTypeDAO();
        }
        return jpaMealTypeDAO;
    }

    public static JpaStepDAO getStepDAO() {
        if (jpaStepDAO == null) {
            jpaStepDAO = new JpaStepDAO();
        }
        return jpaStepDAO;
    }

    public static JpaIngredientDAO getIngredientDAO() {
        if (jpaIngredientDAO == null) {
            jpaIngredientDAO = new JpaIngredientDAO();
        }
        return jpaIngredientDAO;
    }

    public static JpaIngredientRecipeDAO getIngredientRecipeDAO() {
        if (jpaIngredientRecipeDAO == null) {
            jpaIngredientRecipeDAO = new JpaIngredientRecipeDAO();
        }
        return jpaIngredientRecipeDAO;
    }
}
