package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;
import com.example.recipeee.dao.jpa.mealtype.JpaMealTypeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;
import com.example.recipeee.dao.jpa.recipeUser.JpaRecipeUserDAO;

public final class DAOFactory {

    private static JpaUserDAO jpaUserDAO;
    private static JpaMealTypeDAO jpaMealTypeDAO;

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
}
