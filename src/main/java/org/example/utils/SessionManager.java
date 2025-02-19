package org.example.utils;

import org.example.domain.model.UserModel;

public class SessionManager {
    private static UserModel currentUser;

    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }

    public static UserModel getCurrentUser() {
        return currentUser;
    }

    public static void clearSession() {
        currentUser = null;
    }

}
