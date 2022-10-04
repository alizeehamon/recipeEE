package com.example.recipeee.service;

import com.example.recipeee.dao.UserDAO;
import com.example.recipeee.dao.jpa.JpaUserDAO;

public class ServiceFactory {

    private static UserService userService;

    private ServiceFactory() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
