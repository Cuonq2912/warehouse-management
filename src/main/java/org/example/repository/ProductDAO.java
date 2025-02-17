package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.domain.model.ProductModel;

public class ProductDAO extends BaseDAO<ProductModel> {

    public List<ProductModel> findByName(String username) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em.createQuery("SELECT c FROM CustomerModel c WHERE c.name LIKE :username",
                    ProductModel.class);
            query.setParameter("username", "%" + username + "%");
            List<ProductModel> users = query.getResultList();
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

    public List<ProductModel> findById(String Id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em.createQuery(("SELECT c FROM CustomerModel c WHERE c.email LIKE :email"),
                    ProductModel.class);
            query.setParameter("email", "%" + Id + "%");
            List<ProductModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with email: " + Id);
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

    public List<ProductModel> findByPrice(Double price) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em
                    .createQuery("SELECT c FROM CustomerModel c WHERE c.address LIKE :address", ProductModel.class);
            query.setParameter("address", "%" + price + "%");
            List<ProductModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with address: " + price);
            }
            return users;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by address ", e);
        } finally {
            em.close();
        }
    }

    public List<ProductModel> findByDescription(String description) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em.createQuery(("SELECT c FROM CustomerModel c WHERE c.email LIKE :email"),
                    ProductModel.class);
            query.setParameter("email", "%" + description + "%");
            List<ProductModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with email: " + description);
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

}