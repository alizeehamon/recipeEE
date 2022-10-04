package com.example.recipeee;


import com.example.recipeee.dao.jpa.EMFManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------------- APP INITIALIZED ---------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------- APP DESTROYED ---------------");
        EMFManager.close();
    }
}
