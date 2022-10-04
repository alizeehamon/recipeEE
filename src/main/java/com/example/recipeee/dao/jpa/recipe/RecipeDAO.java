package com.example.recipeee.dao.jpa.recipe;

import com.example.recipeee.dao.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO {

    public List<Recipe> findAll();

    Optional<Recipe> findById(long idParam);
}
