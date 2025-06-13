package org.example.utils;

import org.example.domain.model.UserModel;

/**
 * Singleton class to manage user session
 */
public class SessionManager {
    private static SessionManager instance;
    private UserModel currentUser;

    private SessionManager() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setCurrentUser(UserModel user) {
        this.currentUser = user;
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
    }

    public String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }

    public String getCurrentUserFullName() {
        return currentUser != null ? currentUser.getFullName() : null;
    }

    public Long getCurrentUserId() {
        return currentUser != null ? currentUser.getId() : null;
    }

    public org.example.domain.model.Role getCurrentUserRole() {
        return currentUser != null ? currentUser.getRole() : null;
    }
}
