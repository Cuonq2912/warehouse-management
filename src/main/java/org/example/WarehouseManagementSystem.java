package org.example;

import org.example.config.DatabaseConfig;
import org.example.controller.UserController;

import javax.swing.*;

import org.example.domain.model.Role;
import org.example.domain.model.Status;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.utils.AuthUtils;
import org.example.view.CommonView.LoginView;

public class WarehouseManagementSystem {
    public static void main(String[] args) {

        if (DatabaseConfig.initializeDatabase()) {
            SwingUtilities.invokeLater(() -> { // Đảm bảo an toàn luồng khi làm việc với GUI
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cannot connect to database!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        // alpha -> hashcode for password

         AuthUtils authUtils = new AuthUtils();
         authUtils.updateExistingPasswords();

    }
}