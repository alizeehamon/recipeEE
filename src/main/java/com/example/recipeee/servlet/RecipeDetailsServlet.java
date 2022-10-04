package com.example.recipeee.servlet;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/recipe-details")
public class RecipeDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Optional<Recipe> recipe = DAOFactory.getRecipeDAO().findById(Long.parseLong(id));
            req.setAttribute("recipe", recipe.get());
        }catch (NumberFormatException | NoSuchElementException e) {
            req.setAttribute("country_not_found", true);
        }

        req.getRequestDispatcher("/WEB-INF/recipeDetails.jsp").forward(req, resp);
    }
}
