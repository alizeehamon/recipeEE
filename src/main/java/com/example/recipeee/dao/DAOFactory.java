package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;
import com.example.recipeee.dao.jpa.recipe.RecipeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;

public class DAOFactory {

    private static JpaUserDAO jpaUserDAO;

    private DAOFactory() {
    }

    public static RecipeDAO getRecipeDAO() {
        return new JpaRecipeDAO();
    }
    public static UserDAO getUserDAO() {
        if (jpaUserDAO == null) {
            jpaUserDAO = new JpaUserDAO();
        }
        return jpaUserDAO;
    }
}
