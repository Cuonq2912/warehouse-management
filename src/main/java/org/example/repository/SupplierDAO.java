package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.SupplierModel;

import java.util.List;

public class SupplierDAO extends BaseDAO<SupplierModel> {

    public List<SupplierModel> findByName(String supplierName){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.name LIKE :supplierName", SupplierModel.class);
            query.setParameter("supplierName", "%" + supplierName + "%");
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with supplierName: " + supplierName);
            }
            return suppliers;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by supplierName ", e);
        } finally {
            em.close();
        }
    }

    public List<SupplierModel> findByEmail(String email){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery(("SELECT s FROM SupplierModel s WHERE s.email LIKE :email"), SupplierModel.class);
            query.setParameter("email", "%" + email + "%");
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with email: " + email);
            }
            return suppliers;
        } catch (RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by email ", e);
        } finally {
            em.close();
        }
    }

    public List<SupplierModel> findByAddress(String address){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.address LIKE :address", SupplierModel.class);
            query.setParameter("address", "%" + address + "%");
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with address: " + address);
            }
            return suppliers;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by address ", e);
        } finally {
            em.close();
        }
    }

}