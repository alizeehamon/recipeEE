package com.example.recipeee.servlet.user;

import com.example.recipeee.dao.entity.User;
import com.example.recipeee.service.ServiceFactory;
import com.example.recipeee.service.user.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user/createUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String pictureUrl = req.getParameter("pictureUrl");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        userService.create(new User(firstName, lastName, pictureUrl, email, password));

        resp.sendRedirect(req.getContextPath() + "/login");

    }
}
