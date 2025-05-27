package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.constant.ErrorMessage;
import org.example.domain.model.CustomerModel;
import org.example.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void create(CustomerModel customerModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customerModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException(ErrorMessage.Customer.ERR_CREATE_CUSTOMER);
        } finally {
            em.close();
        }
    }

    public void update(Long id, CustomerModel customerModel) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            CustomerModel existing = em.find(CustomerModel.class, id);
            if (existing == null) {
                throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_GET_BY_ID_CUSTOMER, id));
            }

            existing.setName(customerModel.getName());
            existing.setEmail(customerModel.getEmail());
            existing.setAddress(customerModel.getAddress());
            em.merge(existing);

            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_UPDATE_CUSTOMER, id));
        } finally {
            em.close();
        }
    }

    public CustomerModel getCustomerById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            CustomerModel customer = em.find(CustomerModel.class, id);
            em.getTransaction().commit();
            if (customer == null) {
                throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_GET_BY_ID_CUSTOMER, id));
            }
            return customer;
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_GET_BY_ID_CUSTOMER, id));
        } finally {
            em.close();
        }
    }

    public List<CustomerModel> getAllCustomers() {
        EntityManager em = getEntityManager();
        List<CustomerModel> customers = new ArrayList<>();
        try {
            em.getTransaction().begin();
            customers = em.createQuery("SELECT c FROM CustomerModel c", CustomerModel.class)
                    .getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(ErrorMessage.Customer.ERR_NOT_FOUND);
        } finally {
            em.close();
        }
        return customers;
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            CustomerModel customer = em.find(CustomerModel.class, id);
            if (customer == null) {
                throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_GET_BY_ID_CUSTOMER, id));
            }
            em.remove(customer);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException(String.format(ErrorMessage.Customer.ERR_DELETE_CUSTOMER, id));
        } finally {
            em.close();
        }
    }
}
