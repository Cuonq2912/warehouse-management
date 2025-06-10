package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.constant.ErrorMessage;
import org.example.domain.model.ExportProductModel;
import org.example.domain.model.ExportDetailModel;
import org.example.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class ExportProductDAO {

    private EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void createExportProduct(ExportProductModel exportProductModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(exportProductModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to create export product: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void updateExportProduct(Long id, ExportProductModel exportProductModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ExportProductModel existingExport = em.find(ExportProductModel.class, id);
            if (existingExport == null) {
                throw new RuntimeException("Export product not found with ID: " + id);
            }

            existingExport.setExportDate(exportProductModel.getExportDate());
            existingExport.setUserModel(exportProductModel.getUserModel());
            existingExport.setCustomerModel(exportProductModel.getCustomerModel());

            if (existingExport.getExportDetailModel() != null) {
                existingExport.getExportDetailModel().clear();
                em.flush(); 
            }

            if (exportProductModel.getExportDetailModel() != null) {
                for (ExportDetailModel detail : exportProductModel.getExportDetailModel()) {
                    detail.setExportProductModel(existingExport);
                    existingExport.getExportDetailModel().add(detail);
                }
            }

            em.merge(existingExport);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Failed to update export product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public ExportProductModel getExportProductById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ExportProductModel exportProduct = em.find(ExportProductModel.class, id);
            if (exportProduct == null) {
                throw new RuntimeException("Export product not found with ID: " + id);
            }
            exportProduct.getExportDetailModel().size();
            em.getTransaction().commit();
            return exportProduct;
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to get export product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public List<ExportProductModel> getAllExportProducts() {
        EntityManager em = getEntityManager();
        List<ExportProductModel> exportProducts = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<ExportProductModel> query = em.createQuery(
                    "SELECT DISTINCT e FROM ExportProductModel e " +
                            "LEFT JOIN FETCH e.userModel " +
                            "LEFT JOIN FETCH e.customerModel " +
                            "LEFT JOIN FETCH e.exportDetailModel ed " +
                            "LEFT JOIN FETCH ed.productModel",
                    ExportProductModel.class);
            exportProducts = query.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get all export products");
        } finally {
            em.close();
        }
        return exportProducts;
    }

    public void deleteExportProduct(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ExportProductModel exportProduct = em.find(ExportProductModel.class, id);
            if (exportProduct == null) {
                throw new RuntimeException("Export product not found with ID: " + id);
            }
            em.remove(exportProduct);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete export product with ID: " + id);
        } finally {
            em.close();
        }
    }

    public List<ExportProductModel> searchExportProducts(String searchTerm) {
        EntityManager em = getEntityManager();
        List<ExportProductModel> exportProducts = new ArrayList<>();
        try {
            em.getTransaction().begin();
            TypedQuery<ExportProductModel> query = em.createQuery(
                    "SELECT DISTINCT e FROM ExportProductModel e " +
                            "LEFT JOIN FETCH e.userModel u " +
                            "LEFT JOIN FETCH e.customerModel c " +
                            "LEFT JOIN FETCH e.exportDetailModel ed " +
                            "LEFT JOIN FETCH ed.productModel p " +
                            "WHERE LOWER(u.fullName) LIKE LOWER(:searchTerm) " +
                            "OR LOWER(c.name) LIKE LOWER(:searchTerm) " +
                            "OR LOWER(p.name) LIKE LOWER(:searchTerm) " +
                            "OR CAST(e.id AS string) LIKE :searchTerm",
                    ExportProductModel.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            exportProducts = query.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return exportProducts;
    }
}
