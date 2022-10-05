package com.example.recipeee.servlet.ingredient;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Ingredient;
import com.example.recipeee.dao.entity.IngredientRecipe;
import com.example.recipeee.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/ingredient/add-ingredient")
public class AddIngredientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idRecipe = Long.parseLong(request.getParameter("idRecipe"));
        String ingredientName = request.getParameter("ingredientName");
        String ingredientUrl = request.getParameter("ingredientUrl");
        int qtyIngredient = Integer.parseInt(request.getParameter("qtyIngredient"));
        DAOFactory.getIngredientRecipeDAO().create(idRecipe, ingredientName, ingredientUrl, qtyIngredient);
        response.sendRedirect(request.getContextPath() + "/recipe/recipe-details?id=" + idRecipe);
    }
}
