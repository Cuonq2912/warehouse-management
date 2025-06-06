package org.example.repository;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.config.DatabaseConfig;
import org.example.constant.ErrorMessage;
import org.example.domain.model.CategoryModel;
import org.example.domain.model.SupplierModel;
import org.example.utils.HibernateUtils;


public class SupplierDAO{
 private EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void create(SupplierModel supplierModel) {

        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(supplierModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessage.Supplier.ERR_CREATE_SUP);
        } finally {
            em.close();
        }
    }

    public void update(Long id, SupplierModel supplierModel) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            SupplierModel existingSupplier = em.find(SupplierModel.class, id);
            if (existingSupplier == null) {
                throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_GET_BY_ID_SUP, id));
            }
            existingSupplier.setName(supplierModel.getName());
            existingSupplier.setAddress(supplierModel.getAddress());
            existingSupplier.setPhoneNumber(supplierModel.getPhoneNumber());
            existingSupplier.setEmail(supplierModel.getEmail());
         
            em.merge(existingSupplier);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_UPDATE_SUP, id));
        } finally {
            em.close();
        }
    }

    public SupplierModel getSupplierById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            SupplierModel supplierModel = em.find(SupplierModel.class, id);
            em.getTransaction().commit();
            if (supplierModel == null) {
                throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_GET_BY_ID_SUP, id));
            }
            return supplierModel;
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_GET_BY_ID_SUP, id));
        } finally {
            em.close();
        }
    }

    public List<SupplierModel> getAllSuppliers() {
        EntityManager em = getEntityManager();
        List<SupplierModel> suppliers = new ArrayList<>();
        try {
            em.getTransaction().begin();
            suppliers = em.createQuery("SELECT c FROM SupplierModel c", SupplierModel.class)
                    .getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(ErrorMessage.Supplier.ERR_NOT_FOUND);
        }
        return suppliers;
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            SupplierModel suppliers = em.find(SupplierModel.class, id);
            if (suppliers == null) {
                throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_GET_BY_ID_SUP, id));
            }
            em.remove(suppliers);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format(ErrorMessage.Supplier.ERR_GET_BY_ID_SUP, id));
        } finally {
            em.close();
        }

    }
}