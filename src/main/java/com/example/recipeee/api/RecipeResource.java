package com.example.recipeee.api;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.jpa.recipe.JpaRecipeDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/recipes")
public class RecipeResource {

    private final JpaRecipeDAO jpaRecipeDAO;

    public RecipeResource() {
        this.jpaRecipeDAO = (JpaRecipeDAO) DAOFactory.getRecipeDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Recipe> recipeList = DAOFactory.getRecipeDAO().findAll();
        return Response.ok(recipeList).build();
    }

    @GET
    @Path("/{recipeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeById(@PathParam("recipeId") long idParam) {
        Optional<Recipe> optionalRecipe = DAOFactory.getRecipeDAO().findById(idParam);

        if (optionalRecipe.isPresent()) {
            return Response.ok(optionalRecipe.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}