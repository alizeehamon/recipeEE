package com.example.recipeee.servlet;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.Step;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/recipe/recipe-details")
public class RecipeDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Optional<Recipe> recipe = DAOFactory.getRecipeDAO().findById(Long.parseLong(id));
            List<Step> steps = DAOFactory.getStepDAO().findStepsByIdRecipe(Long.parseLong(id));
            req.setAttribute("recipe", recipe.get());
            req.setAttribute("steps", steps);
        }catch (NumberFormatException | NoSuchElementException e) {
            req.setAttribute("country_not_found", true);
        }

        req.getRequestDispatcher("/WEB-INF/recipe/recipeDetails.jsp").forward(req, resp);
    }
}
