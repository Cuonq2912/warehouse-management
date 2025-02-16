package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.ExportProductModel;

import java.util.List;

public class ExportProductDAO extends BaseDAO<ExportProductModel> {

    public List<ExportProductModel> findByProductName(String productName) {
        EntityManager em = getEntityManager();
        try{
            List<ExportProductModel> products = em.createQuery("SELECT e FROM ExportProductModel e WHERE e.productName LIKE :productName", ExportProductModel.class)
                    .setParameter("productName", "%" + productName + "%")
                    .getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with productName: " + productName);
            }
            return products;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by productName ", e);
        } finally {
            em.close();
        }
    }

    public List<ExportProductModel> findByQuantity(Long minQuantity, Long maxQuantity){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ExportProductModel> query = em.createQuery("SELECT e FROM ExportProductModel e WHERE e.quantity BETWEEN :minQuantity AND :maxQuantity", ExportProductModel.class);
            List<ExportProductModel> products = query.setParameter("minQuantity", minQuantity)
                    .setParameter("maxQuantity", maxQuantity)
                    .getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with quantity: " + minQuantity + " - " + maxQuantity);
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

    public List<ExportProductModel> findByPrice(double minPrice, double maxPrice){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ExportProductModel> query = em.createQuery("SELECT e FROM ExportProductModel e WHERE e.totalPrice BETWEEN :minPrice AND :maxPrice", ExportProductModel.class);
            List<ExportProductModel> products = query.setParameter("minPrice", minPrice)
                    .setParameter("maxPrice", maxPrice)
                    .getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with price: " + minPrice + " - " + maxPrice);
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

    public List<ExportProductModel> findByCustomer(String customer){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ExportProductModel> query = em.createQuery(
                    "SELECT e FROM ExportProductModel e WHERE e.customerModel.name LIKE :customer", ExportProductModel.class
            );
            query.setParameter("customer", "%" + customer + "%");
            List<ExportProductModel> products = query.getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with customer: " + customer);
            }
            return products;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding product by customer ", e);
        } finally {
            em.close();
        }
    }

}

