package com.example.recipeee.servlet;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.entity.RecipeUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/recipe/last-cooked")
public class RecipeLastCookedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String userId = req.getParameter("user-id"); // possiblement sessionScope
        String recipeId = req.getParameter("recipe-id");

        Long userId = 1L;
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String cookDate = sdf.format(dt);

        try {
            /*
             tester si recetteID existe dans table RecipeUser
             si oui -> trouver la row en question findby recipeID
            puis -> update l'objet récuperer Recipe.setCookdate
             si non -> creer la row
             */
            boolean recipeWasCooked = DAOFactory.getRecipeUserDAO().findIfRecipeWasCooked(Long.parseLong(recipeId));

            if (recipeWasCooked) {
                long userRecipeID = DAOFactory.getRecipeUserDAO().findID(Long.parseLong(recipeId));
                try {
                    RecipeUser cookedRecipe = DAOFactory.getRecipeUserDAO().findById(userRecipeID).get();
                    DAOFactory.getRecipeUserDAO().update(cookedRecipe.getId(), cookDate);
                } catch (Exception e) {
                    System.out.println("user not found");
                    e.printStackTrace();
                }
            } else {
                DAOFactory.getRecipeUserDAO().create(new RecipeUser(cookDate, DAOFactory.getUserDAO().findById(userId).get(), DAOFactory.getRecipeDAO().findById(Long.parseLong(recipeId)).get()));
            }

        } catch (Exception e) {
            System.out.println("not found");
            e.printStackTrace();
        }
    }
}
