package com.example.recipeee.service.typemeal;

import com.example.recipeee.dao.DAOFactory;
import com.example.recipeee.dao.UserDAO;
import com.example.recipeee.dao.entity.TypeMeal;
import com.example.recipeee.dao.jpa.mealtype.JpaMealTypeDAO;

import java.util.List;

public class TypeMealService {

    private final JpaMealTypeDAO mealTypeDAO;

    public TypeMealService(){
        this.mealTypeDAO = DAOFactory.getMealTypeDAO();
    }

    public List<TypeMeal> findAll(){
        return mealTypeDAO.findAll();
    }
}
