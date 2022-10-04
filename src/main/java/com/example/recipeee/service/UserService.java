package com.example.recipeee.service;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.UserDAO;
import com.example.recipeee.dao.entity.User;

import java.util.Optional;

public class UserService {

    private final UserDAO userDAO;

    public UserService(){
        this.userDAO = DAOFactory.getUserDAO();
    }

    public long create(User user){
       return userDAO.create(user);
    }
}
