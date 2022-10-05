package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;
import com.example.recipeee.dao.jpa.mealType.JpaMealTypeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;
import com.example.recipeee.dao.jpa.step.JpaStepDAO;

public final class DAOFactory {

    private static JpaUserDAO jpaUserDAO;
    private static JpaMealTypeDAO jpaMealTypeDAO;

    private static JpaStepDAO jpaStepDAO;

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
}
