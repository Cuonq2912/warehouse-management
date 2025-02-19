package org.example.utils;

import jakarta.persistence.EntityManager;
import org.example.domain.model.UserModel;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

import static org.example.utils.HibernateUtils.getEntityManager;

public class AuthUtils {

    public boolean verifyUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_]+$");
    }

    public String getErrorMessage(String username) {
        if (username == null || username.trim().isEmpty()) {
            return "Username cannot be empty";
        }
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        }
        if (username.length() > 20) {
            return "Username cannot exceed 20 characters";
        }
        if (!username.matches("^[a-zA-Z0-9_]+$")) {
            return "Username can only contain letters, numbers and underscore";
        }
        return null;
    }

    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        try {
            if (!hashedPassword.startsWith("$2a$")) {
                throw new IllegalArgumentException("Invalid hash format");
            }
            return BCrypt.checkpw(plainPassword, hashedPassword);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Password verification failed: " + e.getMessage());
        }
    }
//    Phương thức chuyển đổi mật khẩu đã lưu trữ từ DB sang bcrypt
    public void updateExistingPasswords() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<UserModel> users = em.createQuery("SELECT u FROM UserModel u", UserModel.class).getResultList();

            for (UserModel user : users) {
                if (!user.getPassword().startsWith("$2a$")) {
                    String hashedPassword = hashPassword(user.getPassword());
                    user.setPassword(hashedPassword);
                    em.merge(user);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to update passwords: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
