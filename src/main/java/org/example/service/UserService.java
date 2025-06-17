package org.example.service;

import java.util.List;
import org.example.domain.model.UserModel;

public interface UserService {
    boolean createUser(UserModel userModel);

    boolean updateUser(UserModel userModel);

    boolean deleteUser(Long id);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);

    UserModel findByEmail(String email);
}