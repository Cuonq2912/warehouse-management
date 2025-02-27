package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.exception.NotFoundException;
import org.example.utils.HibernateUtils;

import java.util.List;

public abstract class BaseDAO<T> {

    protected EntityManager getEntityManager() {
        return HibernateUtils.getEntityManager();
    }

    public void create(T entity){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error creating entity ", e);
        } finally {
            em.close();
        }
    }

    public T findById(Class<T> entityClass, Long id){
        EntityManager em = getEntityManager();
        T entity;
        try{
            entity = em.find(entityClass, id);
            if(entity == null){
                throw new NotFoundException("Entity not found with ID: " + id);
            }
        } finally {
            em.close();
        }
        return entity;
    }

    public void update(T entity){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error updating entity ", e);
        } finally {
            em.close();
        }
    }

    public void delete(Class<T> entityClass, Long id){
        EntityManager em = getEntityManager();
        T entity;
        try{
            entity = em.find(entityClass, id);
            em.getTransaction().begin();
            if(entity == null){
                throw new NotFoundException("Entity not found with ID: " + id);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } catch(RuntimeException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error deleting entity ", e);
        } finally {
            em.close();
        }
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
