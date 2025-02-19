package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.ProductModel;

import java.util.List;

public class ProductDAO extends BaseDAO<ProductModel> {

    public List<ProductModel> findByName(String name) {
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ProductModel> query = em.createQuery("SELECT u FROM ProductModel u WHERE u.name LIKE :name", ProductModel.class);
            query.setParameter("name", "%" + name + "%");
            List<ProductModel> products = query.getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with name: " + name);
            }
            return products;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by name ", e);
        } finally {
            em.close();
        }
    }

    public List<ProductModel> findByCategory(String categoryName) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em.createQuery(
                    "SELECT p FROM ProductModel p WHERE p.categoryModel.name LIKE :categoryName",
                    ProductModel.class
            );
            query.setParameter("categoryName", "%" + categoryName + "%");
            List<ProductModel> products = query.getResultList();
            if (products.isEmpty()) {
                throw new RuntimeException("Product not found with category: " + categoryName);
            }
            return products;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by category ", e);
        } finally {
            em.close();
        }
    }

    public List<ProductModel> findByPrice(double minPrice, double maxPrice){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ProductModel> query = em.createQuery("SELECT p FROM ProductModel p WHERE p.price BETWEEN :minPrice AND :maxPrice", ProductModel.class);
            query.setParameter("minPrice", minPrice)
                    .setParameter("maxPrice", maxPrice);
            List<ProductModel> products = query.getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with price between: " + minPrice + " and " + maxPrice);
            }
            return products;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by price ", e);
        } finally {
            em.close();
        }
    }

    public List<ProductModel> findByQuantity(Long minQuantity, Long maxQuantity){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ProductModel> query = em.createQuery("SELECT p FROM ProductModel p WHERE p.stockQuantity BETWEEN :minQuantity AND :maxQuantity", ProductModel.class);
            query.setParameter("minQuantity", minQuantity)
                    .setParameter("maxQuantity", maxQuantity);
            List<ProductModel> products = query.getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with quantity between: " + minQuantity + " and " + maxQuantity);
            }
            return products;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by quantity ", e);
        } finally {
            em.close();
        }
    }
    public List<ProductModel> findByCategoryid(String categoryid) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductModel> query = em.createQuery(("SELECT c FROM CustomerModel c WHERE c.email LIKE :email"),
                    ProductModel.class);
            query.setParameter("email", "%" + categoryid + "%");
            List<ProductModel> users = query.getResultList();
            if (users.isEmpty()) {
                throw new RuntimeException("User not found with email: " + categoryid);
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