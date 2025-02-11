package org.example.utils;

import org.mindrot.jbcrypt.BCrypt;

public class AuthUtils {
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
