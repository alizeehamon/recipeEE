package com.example.recipeee.dao;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.RecipeUser;

import java.util.List;
import java.util.Optional;

public interface RecipeUserDAO {

    public List<RecipeUser> findAll();

    public boolean create(RecipeUser recipeUser);

    public boolean findIfRecipeWasCooked(long id);

    Optional<RecipeUser> findById(long idParam);

    void update(long id, RecipeUser updatedRecipeUser);

    public Long findID (long recipeID);

    public List<Recipe> findAllSixDays();
}
