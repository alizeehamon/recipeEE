package com.example.recipeee.dao.jpa.recipe;

import com.example.recipeee.dao.entity.Recipe;

import java.util.List;

public interface RecipeDAO {

    public List<Recipe> findAll();
}
