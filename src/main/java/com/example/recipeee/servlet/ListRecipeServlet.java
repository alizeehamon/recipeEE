package com.example.recipeee.servlet;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/recipes-list")
public class ListRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Recipe> recipesList = DAOFactory.getRecipeDAO().findAll();
        request.setAttribute("recipes" , recipesList);
        request.getRequestDispatcher("WEB-INF/listRecipes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
