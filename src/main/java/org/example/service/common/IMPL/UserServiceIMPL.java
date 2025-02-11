package org.example.service.common.IMPL;

import org.example.domain.DTO.Request.LoginRequest;
import org.example.domain.DTO.Response.LoginResponse;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.service.common.UserService;
import org.example.utils.AuthUtils;

public class UserServiceIMPL implements UserService {
//    private UserDAO userDAO;
//    private AuthUtils authUtils;
//
//    @Override
//    public LoginResponse login(LoginRequest request) {
//        UserModel user = userDAO.findByUsername(request.getUsername());
//
//        if (user != null && authUtils.verifyPassword(request.getPassword(), user.getPassword())) {
//
//        }
//    }
}
