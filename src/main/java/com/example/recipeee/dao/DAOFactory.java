package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;

public final class DAOFactory {

    private DAOFactory() {
    }

    public static UserDAO getUserDAO() {
        return new JpaUserDAO();
    }
}
