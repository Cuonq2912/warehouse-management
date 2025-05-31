package org.example.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtil {

    public static void regenerateDatabase() {
        try {
            dropDatabase();
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse");
            emf.close();
            
            System.out.println("Database regenerated successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void dropDatabase() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", "root", "");
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("DROP DATABASE IF EXISTS warehouse_database");
            stmt.execute("CREATE DATABASE warehouse_database");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}