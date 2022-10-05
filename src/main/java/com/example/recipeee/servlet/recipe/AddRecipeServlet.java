package com.example.recipeee.servlet.recipe;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.dao.entity.User;
import com.example.recipeee.service.typemeal.TypeMealService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/recipe/add-recipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeMeal> typeMeals = DAOFactory.getMealTypeDAO().findAll();
        request.setAttribute("typeMeals", typeMeals);
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
        String cookType = request.getParameter("cookType");
        String nameTypeMeal = request.getParameter("typeMeal");
        TypeMeal typeMeal = new TypeMeal(nameTypeMeal);
        Recipe recipe = new Recipe(recipeName, difficulty, pictureUrl, cookTime, preparation, restTime, expanse, cookType, typeMeal);
        DAOFactory.getRecipeDAO().create(recipe);

        response.sendRedirect(request.getContextPath() + "/");

    }
}
