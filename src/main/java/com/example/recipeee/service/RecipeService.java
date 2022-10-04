package com.example.recipeee.service;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.jpa.mealtype.JpaMealTypeDAO;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;
import com.example.recipeee.dao.jpa.recipe.RecipeDAO;

import java.util.List;

public class RecipeService {

    private final RecipeDAO recipeDAO;

    public RecipeService(){
        this.recipeDAO = DAOFactory.getRecipeDAO();
    }

    public List<Recipe> findByFilter(String name, Long typeId){
        if(!name.equals("") && typeId != null) {
            return recipeDAO.findByNameAndType(name, typeId);
        }else if(!name.equals("")){
            return recipeDAO.findByName(name);
        }else if(typeId != null){
            return recipeDAO.findByType(typeId);
        }else{
            return recipeDAO.findAll();
        }
    }
}
