package com.example.recipeee.dao;

import com.example.recipeee.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List findAll();

    long create(User user);

    Optional<User> findById(long idParam);

    boolean delete(long id);

    boolean edit(User userToEdit);
}
