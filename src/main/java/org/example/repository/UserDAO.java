package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.utils.HibernateUtils;
import org.hibernate.Hibernate;

public class UserDAO {

    private EntityManager getEntityManager(){
        return HibernateUtils.getEntityManager();
    }
    
    
    
}

