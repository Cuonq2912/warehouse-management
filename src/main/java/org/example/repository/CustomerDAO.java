package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.CustomerModel;

import java.util.List;

public class CustomerDAO extends BaseDAO<CustomerModel> {

    public List<CustomerModel> findByName(String username){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CustomerModel> query = em.createQuery("SELECT c FROM CustomerModel c WHERE c.name LIKE :username", CustomerModel.class);
            query.setParameter("username", "%" + username + "%");
            List<CustomerModel> users = query.getResultList();
            if(users.isEmpty()){
                throw new RuntimeException("User not found with username: " + username);
            }
            return users;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by username ", e);
        } finally {
            em.close();
        }
    }

    public List<CustomerModel> findByEmail(String email){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CustomerModel> query = em.createQuery(("SELECT c FROM CustomerModel c WHERE c.email LIKE :email"), CustomerModel.class);
            query.setParameter("email", "%" +  email + "%");
            List<CustomerModel> users = query.getResultList();
            if(users.isEmpty()){
                throw new RuntimeException("User not found with email: " + email);
            }
            return users;
        } catch (RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by email ", e);
        } finally {
            em.close();
        }
    }

    public List<CustomerModel> findByAddress(String address){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CustomerModel> query = em.createQuery("SELECT c FROM CustomerModel c WHERE c.address LIKE :address", CustomerModel.class);
            query.setParameter("address", "%"+ address + "%");
            List<CustomerModel> users = query.getResultList();
            if(users.isEmpty()){
                throw new RuntimeException("User not found with address: " + address);
            }
            return users;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding user by address ", e);
        } finally {
            em.close();
        }
    }

//    public List<CustomerModel> findAll(Class<CustomerModel> aClass) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}