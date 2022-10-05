package com.example.recipeee.service;

import com.example.recipeee.service.recipe.RecipeService;
import com.example.recipeee.service.typemeal.TypeMealService;
import com.example.recipeee.service.user.UserService;

public class ServiceFactory {

    private static UserService userService;
    private static TypeMealService typeMealService;

    private static RecipeService recipeService;

    private ServiceFactory() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public static TypeMealService getTypeMealService() {
        if (typeMealService == null) {
            typeMealService = new TypeMealService();
        }
        return typeMealService;
    }

    public static RecipeService getRecipeService() {
        if (recipeService == null) {
            recipeService = new RecipeService();
        }
        return recipeService;
    }
}
