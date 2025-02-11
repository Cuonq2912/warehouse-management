package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.domain.model.CategoryModel;

import java.util.Date;
import java.util.List;

public class CategoryDAO extends BaseDAO<CategoryModel> {

    public List<CategoryModel> findByName(String name){
        EntityManager em = getEntityManager();
        try{
            List<CategoryModel> categories = em.createQuery("SELECT c FROM CategoryModel c WHERE c.name LIKE :name", CategoryModel.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
            if(categories.isEmpty()){
                throw new RuntimeException("Category not found with name: " + name);
            }
            return categories;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding category by name ", e);
        } finally {
            em.close();
        }
    }

    public List<CategoryModel> findByCreatedDate(Date minDate, Date maxDate){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CategoryModel> query = em.createQuery("SELECT c FROM CategoryModel c WHERE c.createdAt BETWEEN :minDate AND :maxDate", CategoryModel.class);
            List<CategoryModel> categories = query.setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
            if(categories.isEmpty()){
                throw new RuntimeException("Category not found with createdDate: " + minDate + " - " + maxDate);
            }
            return categories;
        } catch (RuntimeException e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error finding category by createdDate ", e);
        } finally {
            em.close();
        }
    }
}
