package org.example.service.user.IMPL;

import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.service.user.UserService;

public class UserServiceImpl implements UserService {

    private final UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateProfile(UserModel user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        UserModel existingUser = userDao.findById(UserModel.class, user.getId());

        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAddress(user.getAddress());

        userDao.update(existingUser);
    }

    @Override
    public UserModel getUserById(Long id) {
        return userDao.findById(UserModel.class, id);
    }
}