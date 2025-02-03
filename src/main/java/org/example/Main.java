package org.example;


import org.example.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        // Connection and create table
        try {
            EntityManager em = HibernateUtils.getEntityManager();
            System.out.println("Database connected successfully!");

            em.getTransaction().begin();
            em.getTransaction().commit();

            em.close();
        } catch (Exception e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        } finally {
            HibernateUtils.shutdown();
        }
    }
}