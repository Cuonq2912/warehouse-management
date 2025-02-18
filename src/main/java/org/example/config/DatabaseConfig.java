package org.example.config;

import org.example.utils.HibernateUtils;

import jakarta.persistence.EntityManager;

public class DatabaseConfig {
    public static boolean initializeDatabase() {
        try {
            EntityManager em = HibernateUtils.getEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeDatabase() {
        HibernateUtils.shutdown();
    }
}
