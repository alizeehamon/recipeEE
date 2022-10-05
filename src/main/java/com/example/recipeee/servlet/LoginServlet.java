package com.example.recipeee.servlet;

import com.example.recipeee.dao.entity.User;
import com.example.recipeee.service.ServiceFactory;
import com.example.recipeee.service.user.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        long id = userService.validateUser(email,password);

        if(id != 0) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            resp.sendRedirect(req.getContextPath() + "/recipes-list");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}