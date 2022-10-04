package com.example.recipeee.servlet.recipe;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/recipe/add-recipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/recipe/createRecipeForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipeName = request.getParameter("recipeName");
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        String pictureUrl = request.getParameter("pictureUrl");
        int cookTime = Integer.parseInt(request.getParameter("cookTime"));
        int preparation = Integer.parseInt(request.getParameter("preparation"));
        int restTime = Integer.parseInt(request.getParameter("restTime"));
        int expanse = Integer.parseInt(request.getParameter("expanse"));
        String mealType = request.getParameter("mealType");

        Recipe recipe = new Recipe(recipeName, difficulty, pictureUrl, cookTime, preparation, restTime, expanse, mealType);
        DAOFactory.getRecipeDAO().create(recipe);

        response.sendRedirect(request.getContextPath() + "/");

    }
}
