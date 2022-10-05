package com.example.recipeee.servlet;

import com.example.recipeee.dao.entity.User;
import com.example.recipeee.service.ServiceFactory;
import com.example.recipeee.service.user.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/edit-user")
public class EditUserServlet extends HttpServlet {

    UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try{
        User user = userService.getUserById(Long.parseLong(idStr));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/editUser.jsp").forward(req, resp);
        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idUser");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String pictureUrl = req.getParameter("pictureUrl");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User user = new User(firstName, lastName, pictureUrl, email, password);
            user.setId(Long.parseLong(idStr));
            userService.edit(user);


        }catch(Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/editUser.jsp").forward(req, resp);
        }

        resp.sendRedirect(req.getContextPath() + "/recipes-list");
    }
}
