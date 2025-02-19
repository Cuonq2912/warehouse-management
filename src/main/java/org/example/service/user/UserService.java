package org.example.service.user;

import org.example.domain.model.UserModel;

public interface UserService {
    void updateProfile(UserModel user);
    UserModel getUserById(Long id);
}
