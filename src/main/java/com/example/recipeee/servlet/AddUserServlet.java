package com.example.recipeee.servlet;

import com.example.recipeee.dao.entity.User;
import com.example.recipeee.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/createUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String pictureUrl = req.getParameter("pictureUrl");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        userService.create(new User(firstName, lastName, pictureUrl, email, password));

        resp.sendRedirect(req.getContextPath() + "/");

    }
}
