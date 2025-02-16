package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.example.utils.HibernateUtils;

public abstract class BaseDAO<T> {

    protected EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void create(T entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T findById(Class<T> entityClass, String id){
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }

    public void update(T entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Class<T> entityClass,String id){
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        em.getTransaction().begin();
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
       public List<T> findAll(Class<T> entityClass){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
            return query.getResultList();
        } catch (RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding all entities ", e);
        }
        finally {
            em.close();
        }
    }
}
