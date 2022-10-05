package com.example.recipeee.servlet.recipe;

import com.example.recipeee.service.ServiceFactory;
import com.example.recipeee.service.recipe.RecipeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/delete-recipe")
public class DeleteRecipeServlet extends HttpServlet {

    RecipeService recipeService = ServiceFactory.getRecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipeId = req.getParameter("id");

        try {
            long id = Long.parseLong(recipeId);
            req.setAttribute("recipeId", id);

        } catch (NumberFormatException e) {
            req.setAttribute("error_format_id", true);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/recipe/deleteRecipe.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipeId = req.getParameter("recipeId");
        try {
            long id = Long.parseLong(recipeId);
            recipeService.delete(id);

            resp.sendRedirect(req.getContextPath() + "/recipes-list");

        } catch (NumberFormatException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/recipe/deleteRecipe.jsp");
            req.setAttribute("error_format_id", true);
            rd.forward(req, resp);
        }
    }
}
