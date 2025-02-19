package org.example.controller;

import org.example.domain.DTO.Request.LoginRequest;
import org.example.domain.DTO.Response.LoginResponse;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.utils.AuthUtils;

public class AuthController {
    private final UserDAO userDAO;
    private final AuthUtils authUtils;

    public AuthController() {
        this.userDAO = new UserDAO();
        this.authUtils = new AuthUtils();
    }

    public LoginResponse login(LoginRequest request) throws Exception {

        if (request == null) {
            throw new IllegalArgumentException("Login request cannot be null");
        }

        try {
            if (!authUtils.verifyUsername(request.getUsername())) {
                String errorMsg = authUtils.getErrorMessage(request.getUsername());
                throw new Exception(errorMsg != null ? errorMsg : "Invalid username format");
            }

            UserModel user = userDAO.findToAuthController(request.getUsername());
            if (user == null) {
                throw new Exception("User not found!");
            }

            try {
                if (!authUtils.verifyPassword(request.getPassword(), user.getPassword())) {
                    throw new IllegalArgumentException("Invalid password");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Password verification failed: " + e.getMessage());
            }

            LoginResponse response = new LoginResponse();
            response.setUsername(user.getUsername());
            response.setRole(user.getRole().toString());
            return response;
        } catch (Exception e) {
            throw new Exception("Login failed: " + e.getMessage());
        }

    }

}