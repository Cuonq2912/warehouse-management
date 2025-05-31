package org.example.controller;

import org.example.domain.model.Role;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.utils.ValidateUtil;
import org.example.utils.ValidateUtil.ValidationResult;
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

        ValidationResult usernameResult = ValidateUtil.validateUsername(username);
        if (!usernameResult.isValid()) {
            JOptionPane.showMessageDialog(parentFrame,
                    usernameResult.getErrorMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        ValidationResult emailResult = ValidateUtil.validateEmail(email);
        if (!emailResult.isValid()) {
            JOptionPane.showMessageDialog(parentFrame,
                    emailResult.getErrorMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        ValidationResult passwordResult = ValidateUtil.validatePassword(password);
        if (!passwordResult.isValid()) {
            JOptionPane.showMessageDialog(parentFrame,
                    passwordResult.getErrorMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        ValidationResult confirmPasswordResult = ValidateUtil.validateConfirmPassword(password,
                confirmPassword);
        if (!confirmPasswordResult.isValid()) {
            JOptionPane.showMessageDialog(parentFrame,
                    confirmPasswordResult.getErrorMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void navigateToLogin(JFrame parentFrame) {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        parentFrame.dispose();
    }
}