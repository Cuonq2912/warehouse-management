package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import org.example.constant.ErrorMessage;
import org.example.domain.model.UserModel;
import org.example.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void createUser(UserModel userModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(userModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public UserModel getUserById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserModel.class, id);
        } finally {
            em.close();
        }
    }

    public UserModel getUserByUsername(String username) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery(
                    "SELECT u FROM UserModel u WHERE u.username = :username", UserModel.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public UserModel getUserByEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery(
                    "SELECT u FROM UserModel u WHERE u.email = :email", UserModel.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public List<UserModel> getAllUsers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u", UserModel.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    public void updateUser(UserModel userModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(userModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to update user: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteUser(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            UserModel user = em.find(UserModel.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public boolean existsByEmail(String email) {
        try (EntityManager en = getEntityManager()) {
            Long count = en.createQuery("SELECT COUNT(u) FROM UserModel u WHERE u.email = :email", Long.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            throw new RuntimeException(String.format(ErrorMessage.User.ERR_CHECK_EMAIL, email), e);
        }
    }

    public boolean existsByUsername(String username) {
        try (EntityManager en = getEntityManager()) {
            Long count = en.createQuery("SELECT COUNT(u) FROM UserModel u WHERE u.username = :username", Long.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            throw new RuntimeException(String.format(ErrorMessage.User.ERR_CHECK_USERNAME, username), e);
        }
    }

    public UserModel findByEmail(String email) {
        return getUserByEmail(email);
    }
}
