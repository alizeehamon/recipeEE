package com.example.recipeee.dao;

import com.example.recipeee.dao.jpa.JpaUserDAO;

public final class DAOFactory {

    private static JpaUserDAO jpaUserDAO;

    private DAOFactory() {
    }

    public static UserDAO getUserDAO() {
        if (jpaUserDAO == null) {
            jpaUserDAO = new JpaUserDAO();
        }
        return jpaUserDAO;
    }
}
