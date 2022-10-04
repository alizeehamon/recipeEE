package com.example.recipeee.dao.jpa;

import com.example.recipeee.dao.UserDAO;
import com.example.recipeee.dao.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaUserDAO implements UserDAO {

    EntityManagerFactory emf = EMFManager.getEMF();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public long create(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(user);
            et.commit();
        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return 0;
    }

    @Override
    public Optional<User> findById(long idParam) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean edit(User userToEdit) {
        return false;
    }
}
