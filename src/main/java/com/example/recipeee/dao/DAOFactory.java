package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.recipe.DAORecipe;
import com.example.recipeee.dao.jpa.recipe.JPARecipeDAO;

public class DAOFactory {

    private DAOFactory(){};

    public static DAORecipe getRecipeDAO(){
        return new JPARecipeDAO();
    }
}
