package org.example;


import org.example.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set Look and Feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize database connection
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