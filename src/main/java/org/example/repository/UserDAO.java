package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.UserModel;

import java.util.List;

public class UserDAO extends BaseDAO<UserModel> {
    public List<UserModel> findAllUsers() {
        EntityManager em = getEntityManager();
        try{
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u", UserModel.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public UserModel findByUsername(String username){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.username = :username", UserModel.class);
            query.setParameter("username", username);
            List<UserModel> users = query.getResultList();
            if(users.isEmpty()){
                throw new RuntimeException("User not found with username: " + username);
            }
            return users.get(0);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public UserModel findByEmail(String email){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<UserModel> query = em.createQuery(("SELECT u FROM UserModel u WHERE u.email = :email"), UserModel.class);
            query.setParameter("email", email);
            List<UserModel> users = query.getResultList();
            if(users.isEmpty()){
                throw new RuntimeException("User not found with email: " + email);
            }
            return users.get(0);
        } catch (RuntimeException e){
            throw new RuntimeException("Error finding user by email ", e);
        } finally {
            em.close();
        }
    }

}
