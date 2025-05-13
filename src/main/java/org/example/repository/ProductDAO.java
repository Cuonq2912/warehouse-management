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
}