package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
import org.example.domain.model.ImportProductModel;
import java.util.List;
import org.example.domain.model.ImportDetailModel;
import org.hibernate.Session;
  
public class ImportProductDAO extends BaseDAO <ImportDetailModel> {
    
    public List<ImportDetailModel> findByName(String productName) {
        EntityManager em = getEntityManager();
        try{
            List<ImportDetailModel> products = em.createQuery("SELECT i FROM ImportProductModel i WHERE i.productName LIKE :productName", ImportDetailModel.class)
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

    public List<ImportDetailModel> findByQuantity(Long minQuantity, Long maxQuantity){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportDetailModel> query = em.createQuery("SELECT e FROM ImportProductModel e WHERE e.quantity BETWEEN :minQuantity AND :maxQuantity", ImportDetailModel.class);
            List<ImportDetailModel> products = query.setParameter("minQuantity", minQuantity)
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

    public List<ImportDetailModel> findByPrice(double minPrice, double maxPrice){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportDetailModel> query = em.createQuery("SELECT e FROM ImportProductModel e WHERE e.totalPrice BETWEEN :minPrice AND :maxPrice", ImportDetailModel.class);
            List<ImportDetailModel> products = query.setParameter("minPrice", minPrice)
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
    
//    public void saveImportDetail(ImportDetailModel importDetailModel) throws HeuristicMixedException, RollbackException, SecurityException, HeuristicRollbackException, SystemException {
//    Session session;
//        session = importDetailModel.openSession();
//    Transaction tx = (Transaction) session.beginTransaction();
//    session.saveOrUpdate(importDetailModel);
//    tx.commit();
//    session.close();
//}


    public List<ImportDetailModel> findBySupplier(String supplier){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<ImportDetailModel> query = em.createQuery(
                    "SELECT e FROM ImportProductModel e WHERE e.supplierModel.name LIKE :supplier", ImportDetailModel.class
            );
            query.setParameter("supplier", "%" + supplier + "%");
            List<ImportDetailModel> products = query.getResultList();
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
 

