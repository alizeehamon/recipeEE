package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;
import com.example.recipeee.dao.jpa.recipe.RecipeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;

public class DAOFactory {

    private DAOFactory(){};

    public static RecipeDAO getRecipeDAO() {
        return new JpaRecipeDAO();
    }
    public static UserDAO getUserDAO() {
        return new JpaUserDAO();
    }
}
