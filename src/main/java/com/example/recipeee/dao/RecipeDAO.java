package com.example.recipeee.dao;

import com.example.recipeee.dao.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO {

    public List<Recipe> findAll();

    List<Recipe> findByNameAndType(String name, Long typeId);

    List<Recipe> findByName(String name);

    List<Recipe> findByType(Long typeId);

    Optional<Recipe> findById(long idParam);

    public boolean create(Recipe recipe);
}
