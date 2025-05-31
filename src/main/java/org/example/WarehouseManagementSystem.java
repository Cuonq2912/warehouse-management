package org.example;


import javax.swing.*;

import org.example.utils.DatabaseUtil;
import org.example.view.Login;


public class WarehouseManagementSystem {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error initializing application look and feel: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // clone về thì uncomment dòng 24 để tạo db
        // DatabaseUtil.regenerateDatabase();

        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });

    }
   
    
}