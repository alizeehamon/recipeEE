package com.example.recipeee.service.user;

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

    public User getUserById(long idParam){
        Optional<User> userOptional = userDAO.findById(idParam);
        return userOptional.orElse(null);
    }

    public boolean edit(User userDTO){
        Optional <User> userOptional = userDAO.findById(userDTO.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPictureUrl(userDTO.getPictureUrl());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            return userDAO.edit(user);
        }
        return false;
    }

    public long validateUser(String email, String password) {
        return userDAO.validateUser(email, password);
    }

}
