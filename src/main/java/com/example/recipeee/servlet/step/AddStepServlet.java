package com.example.recipeee.servlet.step;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.Recipe;
import com.example.recipeee.dao.entity.Step;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/add-step")
public class AddStepServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idRecipe = Long.parseLong(request.getParameter("idRecipe"));
        String description = request.getParameter("stepDescription");
        Recipe recipe = DAOFactory.getRecipeDAO().findById(idRecipe).get();
        Step step = new Step(description, recipe);
        DAOFactory.getStepDAO().create(step);
        response.sendRedirect(request.getContextPath() + "/auth/recipe-details?id=" + idRecipe);
    }
}
