package org.example.controller;

import org.example.constant.ErrorMessage;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.utils.SessionManager;
import org.example.view.MainDashboard;
import org.example.view.Register;

import javax.swing.*;

public class LoginController {

    private UserDAO userDAO;

    public LoginController() {
        this.userDAO = new UserDAO();
    }

    public UserModel authenticateUser(String username, String password) {
        try {
            UserModel user = userDAO.getUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void handleLogin(String username, String password, JFrame parentFrame) {
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    ErrorMessage.User.ERR_USERNAME_IS_EMPTY,
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    ErrorMessage.User.ERR_PASSWORD_IS_EMPTY,
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        UserModel user = authenticateUser(username.trim(), password);
        if (user == null) {
            JOptionPane.showMessageDialog(parentFrame,
                    ErrorMessage.User.ERR_USERNAME_OR_PASSWORD_INCOMPATIBLE,
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SessionManager.getInstance().setCurrentUser(user);

            MainDashboard dashboard = new MainDashboard();
            dashboard.setVisible(true);
            parentFrame.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame,
                    "Error opening dashboard: " + e.getMessage(),
                    "System Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void navigateToRegister(JFrame parentFrame) {
        Register registerFrame = new Register();
        registerFrame.setVisible(true);
        parentFrame.dispose();
    }

}
