package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.ImportProductModel;

import java.util.List;

public class ImportProductDAO extends BaseDAO<ImportProductModel> {

    public List<ImportProductModel> findByName(String productName) {
        EntityManager em = getEntityManager();
        try{
            List<ImportProductModel> products = em.createQuery("SELECT i FROM ImportProductModel i WHERE i.productName LIKE :productName", ImportProductModel.class)
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

    public List<ImportProductModel> findByQuantity(Long minQuantity, Long maxQuantity){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportProductModel> query = em.createQuery("SELECT e FROM ImportProductModel e WHERE e.quantity BETWEEN :minQuantity AND :maxQuantity", ImportProductModel.class);
            List<ImportProductModel> products = query.setParameter("minQuantity", minQuantity)
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

    public List<ImportProductModel> findByPrice(double minPrice, double maxPrice){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportProductModel> query = em.createQuery("SELECT e FROM ImportProductModel e WHERE e.totalPrice BETWEEN :minPrice AND :maxPrice", ImportProductModel.class);
            List<ImportProductModel> products = query.setParameter("minPrice", minPrice)
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

    public List<ImportProductModel> findBySupplier(String supplier){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportProductModel> query = em.createQuery(
                    "SELECT e FROM ImportProductModel e WHERE e.supplierModel.name LIKE :supplier", ImportProductModel.class
            );
            query.setParameter("supplier", "%" + supplier + "%");
            List<ImportProductModel> products = query.getResultList();
            if(products.isEmpty()){
                throw new RuntimeException("Product not found with customer: " + supplier);
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
