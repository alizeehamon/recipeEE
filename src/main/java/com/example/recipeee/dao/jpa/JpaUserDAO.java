package com.example.recipeee.dao.jpa;

import com.example.recipeee.dao.UserDAO;
import com.example.recipeee.dao.entity.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class JpaUserDAO implements UserDAO {

    EntityManagerFactory emf = EMFManager.getEMF();
    //@PersistenceContext
    //public EntityManager em;

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
            //em.close();
        }
        return 0;
    }

    @Override
    public Optional<User> findById(long idParam) {
        User user = null;
        EntityManager em = emf.createEntityManager();

        try{
            user = em.find(User.class, idParam);
        }catch(Exception e){
            e.printStackTrace();

        }finally {
            em.close();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean edit(User userToEdit) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.merge(userToEdit);
            et.commit();
            return true;

        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public long validateUser(String email, String password) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            User user = em.createQuery(
                    "select u from User u where u.email = :email and u.password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return user.getId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return 0;
    }
}
