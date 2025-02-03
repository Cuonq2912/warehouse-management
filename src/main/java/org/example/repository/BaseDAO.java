package org.example.repository;

import jakarta.persistence.EntityManager;
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

    public T findById(Class<T> entityClass, Long id){
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

    public void delete(Class<T> entityClass, Long id){
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        em.getTransaction().begin();
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
}
