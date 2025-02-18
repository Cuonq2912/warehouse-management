//package org.example.repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.example.domain.model.SupplierModel;
//
//import java.util.List;
//
//public class SupplierDAO extends BaseDAO<SupplierModel> {
//
//    public List<SupplierModel> findByName(String compayName){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.name LIKE :companyName", SupplierModel.class);
//            query.setParameter("companyName", "%" + compayName + "%");
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with companyName: " + compayName);
//            }
//            return suppliers;
//        } catch (RuntimeException e) {
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by companyName ", e);
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<SupplierModel> findByEmail(String email){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery(("SELECT s FROM SupplierModel s WHERE s.email LIKE :email"), SupplierModel.class);
//            query.setParameter("email", "%" + email + "%");
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with email: " + email);
//            }
//            return suppliers;
//        } catch (RuntimeException e){
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by email ", e);
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<SupplierModel> findByAddress(String address){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.address LIKE :address", SupplierModel.class);
//            query.setParameter("address", "%" + address + "%");
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with address: " + address);
//            }
//            return suppliers;
//        } catch (RuntimeException e) {
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by address ", e);
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<SupplierModel> findByStatus(String status){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.status = :status", SupplierModel.class);
//            query.setParameter("status",status);
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with status: " + status);
//            }
//            return suppliers;
//        } catch (RuntimeException e) {
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by status ", e);
//        } finally {
//            em.close();
//        }
//    }
//
//    public List<SupplierModel> findByPhone(String phone){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.phone LIKE :phone", SupplierModel.class);
//            query.setParameter("phone", "%" + phone + "%");
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with phone: " + phone);
//            }
//            return suppliers;
//        } catch (RuntimeException e) {
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by phone ", e);
//        } finally {
//            em.close();
//        }
//    }
//
//        public List<SupplierModel> findById(Long id){
//        EntityManager em = getEntityManager();
//        try{
//            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.id LIKE :id", SupplierModel.class);
//            query.setParameter("phone", "%" + id + "%");
//            List<SupplierModel> suppliers = query.getResultList();
//            if(suppliers.isEmpty()){
//                throw new RuntimeException("Supplier not found with id: " +id);
//            }
//            return suppliers;
//        } catch (RuntimeException e) {
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            throw new RuntimeException("Error finding supplier by id ", e);
//        } finally {
//            em.close();
//        }
//    }
//}

package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.SupplierModel;

import java.util.List;

public class SupplierDAO extends BaseDAO<SupplierModel> {

    public List<SupplierModel> findByName(String compayName){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.name LIKE :companyName", SupplierModel.class);
            query.setParameter("companyName", "%" + compayName + "%");
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with companyName: " + compayName);
            }
            return suppliers;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by companyName ", e);
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

    public List<SupplierModel> findByStatus(String status){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.status = :status", SupplierModel.class);
            query.setParameter("status",status);
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with status: " + status);
            }
            return suppliers;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by status ", e);
        } finally {
            em.close();
        }
    }

    public List<SupplierModel> findByPhone(String phone){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<SupplierModel> query = em.createQuery("SELECT s FROM SupplierModel s WHERE s.phone LIKE :phone", SupplierModel.class);
            query.setParameter("phone", "%" + phone + "%");
            List<SupplierModel> suppliers = query.getResultList();
            if(suppliers.isEmpty()){
                throw new RuntimeException("Supplier not found with phone: " + phone);
            }
            return suppliers;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding supplier by phone ", e);
        } finally {
            em.close();
        }
    }
}