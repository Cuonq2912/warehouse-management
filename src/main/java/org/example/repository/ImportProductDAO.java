package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.constant.ErrorMessage;
import org.example.domain.model.ImportProductModel;
import org.example.domain.model.ImportDetailModel;
import org.example.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class ImportProductDAO {

    private EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void createImportProduct(ImportProductModel importProductModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(importProductModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to create import product: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void updateImportProduct(Long id, ImportProductModel importProductModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ImportProductModel existingImport = em.find(ImportProductModel.class, id);
            if (existingImport == null) {
                throw new RuntimeException("Import product not found with ID: " + id);
            }

            existingImport.setImportDate(importProductModel.getImportDate());
            existingImport.setUserModel(importProductModel.getUserModel());
            existingImport.setSupplierModel(importProductModel.getSupplierModel());

            if (existingImport.getImportDetails() != null) {
                existingImport.getImportDetails().clear();
                em.flush(); 
            }

            if (importProductModel.getImportDetails() != null) {
                for (ImportDetailModel detail : importProductModel.getImportDetails()) {
                    detail.setImportProductModel(existingImport);
                    existingImport.getImportDetails().add(detail);
                }
            }

            em.merge(existingImport);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to update import product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public ImportProductModel getImportProductById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ImportProductModel importProduct = em.find(ImportProductModel.class, id);
            if (importProduct == null) {
                throw new RuntimeException("Import product not found with ID: " + id);
            }
            importProduct.getImportDetails().size();
            em.getTransaction().commit();
            return importProduct;
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to get import product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public List<ImportProductModel> getAllImportProducts() {
        EntityManager em = getEntityManager();
        List<ImportProductModel> importProducts = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<ImportProductModel> query = em.createQuery(
                    "SELECT DISTINCT i FROM ImportProductModel i " +
                            "LEFT JOIN FETCH i.userModel " +
                            "LEFT JOIN FETCH i.supplierModel " +
                            "LEFT JOIN FETCH i.importDetails id " +
                            "LEFT JOIN FETCH id.productModel",
                    ImportProductModel.class);
            importProducts = query.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get all import products");
        } finally {
            em.close();
        }
        return importProducts;
    }

    public void deleteImportProduct(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ImportProductModel importProduct = em.find(ImportProductModel.class, id);
            if (importProduct == null) {
                throw new RuntimeException("Import product not found with ID: " + id);
            }
            em.remove(importProduct);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete import product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public List<ImportProductModel> searchImportProducts(String searchTerm) {
        EntityManager em = getEntityManager();
        List<ImportProductModel> importProducts = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<ImportProductModel> query = em.createQuery(
                    "SELECT DISTINCT i FROM ImportProductModel i " +
                            "LEFT JOIN FETCH i.userModel u " +
                            "LEFT JOIN FETCH i.supplierModel s " +
                            "LEFT JOIN FETCH i.importDetails id " +
                            "LEFT JOIN FETCH id.productModel p " +
                            "WHERE LOWER(u.fullName) LIKE LOWER(:searchTerm) " +
                            "OR LOWER(s.name) LIKE LOWER(:searchTerm) " +
                            "OR LOWER(p.name) LIKE LOWER(:searchTerm) " +
                            "OR CAST(i.id AS string) LIKE :searchTerm",
                    ImportProductModel.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            importProducts = query.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return importProducts;
    }
}
