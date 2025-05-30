package org.example.controller;

import org.example.domain.model.Role;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.view.Login;

import javax.swing.*;

public class RegisterController {

    private UserDAO userDAO;

    public RegisterController() {
        this.userDAO = new UserDAO();
    }
    public boolean handleRegister(String username, String email, String password, String confirmPassword,
            JFrame parentFrame) {
        if (!validateInput(username, email, password, confirmPassword, parentFrame)) {
            return false;
        }

        if (isUsernameExists(username)) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Username already exists. Please choose a different username.",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (isEmailExists(email)) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Email already exists. Please use a different email.",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            UserModel newUser = UserModel.builder()
                    .username(username.trim())
                    .email(email.trim())
                    .password(password) 
                    .fullName(username.trim()) 
                    .phoneNumber("") 
                    .address("") 
                    .role(Role.USER) 
                    .build();

            userDAO.createUser(newUser);

            JOptionPane.showMessageDialog(parentFrame,
                    "Registration successful! Please login with your credentials.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            navigateToLogin(parentFrame);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame,
                    "Registration failed: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    private boolean validateInput(String username, String email, String password, String confirmPassword,
            JFrame parentFrame) {
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Please enter username",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email == null || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Please enter email",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Please enter a valid email address",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Please enter password",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Password must be at least 6 characters long",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Please confirm your password",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Passwords do not match",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }


    private boolean isUsernameExists(String username) {
        try {
            UserModel user = userDAO.getUserByUsername(username);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private boolean isEmailExists(String email) {
        try {
            UserModel user = userDAO.getUserByEmail(email);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void navigateToLogin(JFrame parentFrame) {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        parentFrame.dispose();
    }
}