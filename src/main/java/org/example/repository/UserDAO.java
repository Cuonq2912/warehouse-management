package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.UserModel;

import java.util.List;

public class UserDAO extends BaseDAO<UserModel> {

    public List<UserModel> findByUsername(String username) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.username LIKE :username",
                    UserModel.class);
            query.setParameter("username", "%" + username + "%");
            List<UserModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with username: " + username);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by username ", e);
        } finally {
            em.close();
        }
    }

    public UserModel findByUserName(String username) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.username = : username",
                    UserModel.class);
            query.setParameter("username", username);
            UserModel user = query.getSingleResult();
            return user;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erroe finding user to login ", e);
        }
    }

    public List<UserModel> findByEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery(("SELECT u FROM UserModel u WHERE u.email LIKE :email"),
                    UserModel.class);
            query.setParameter("email", "%" + email + "%");
            List<UserModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with email: " + email);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by email ", e);
        } finally {
            em.close();
        }
    }

    public List<UserModel> findByPhone(String phone) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.phoneNumber LIKE :phone",
                    UserModel.class);
            query.setParameter("phone", "%" + phone + "%");
            List<UserModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with phone: " + phone);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by phone ", e);
        } finally {
            em.close();
        }
    }

    public List<UserModel> findByRole(String role) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.role = :role",
                    UserModel.class);
            query.setParameter("role", role);
            List<UserModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with role: " + role);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding users by role ", e);
        } finally {
            em.close();
        }
    }

    public List<UserModel> findByStatus(String status) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UserModel> query = em.createQuery("SELECT u FROM UserModel u WHERE u.status = :status",
                    UserModel.class);
            query.setParameter("status", status);
            List<UserModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with status: " + status);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding users by status ", e);
        } finally {
            em.close();
        }
    }
}
