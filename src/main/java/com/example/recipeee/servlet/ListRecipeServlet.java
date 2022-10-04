package com.example.recipeee.servlet;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.service.recipe.RecipeService;
import com.example.recipeee.service.ServiceFactory;
import com.example.recipeee.service.typemeal.TypeMealService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/recipes-list")
public class ListRecipeServlet extends HttpServlet {

    TypeMealService typeMealService = ServiceFactory.getTypeMealService();
    RecipeService recipeService = ServiceFactory.getRecipeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Recipe> recipesList = DAOFactory.getRecipeDAO().findAll();
        List<TypeMeal> typesList = typeMealService.findAll();
        request.setAttribute("mealTypes", typesList);
        request.setAttribute("recipes" , recipesList);
        request.getRequestDispatcher("WEB-INF/listRecipes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mealType = request.getParameter("mealType");
        String searchName = request.getParameter("searchName");

        List<Recipe> filterRecipe = recipeService.findByFilter(searchName, mealType==""?null:Long.valueOf(mealType));
        //TODO : voir pour ne pas avoir à refaire cet appel
        List<TypeMeal> typesList = typeMealService.findAll();
        request.setAttribute("mealTypes", typesList);
        request.setAttribute("recipes" , filterRecipe);
        request.getRequestDispatcher("WEB-INF/listRecipes.jsp").forward(request, response);
    }
}
