package org.example.controller;

import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;

public class UserController {
    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void insert(UserModel user) {
        userDAO.create(user);
    }
}
