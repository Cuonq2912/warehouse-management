package org.example.utils;

import org.example.constant.ErrorMessage;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;

/**
 * Utility class for various validation operations
 */
public class ValidateUtil {

    private static final UserDAO userDAO = new UserDAO();

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        return phone.matches("^[0-9]{10,11}$");
    }

    public static boolean isValidPassword(String password) {
        return isNotEmpty(password) && password.length() >= 8;
    }

    public static boolean isPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }



    public static boolean isUsernameExists(String username) {
        try {
            UserModel user = userDAO.getUserByUsername(username);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isEmailExists(String email) {
        try {
            UserModel user = userDAO.getUserByEmail(email);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class ValidationResult {
        private final boolean valid;
        private final String errorMessage;

        public ValidationResult(boolean valid, String errorMessage) {
            this.valid = valid;
            this.errorMessage = errorMessage;
        }

        public boolean isValid() {
            return valid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public static ValidationResult success() {
            return new ValidationResult(true, null);
        }

        public static ValidationResult error(String message) {
            return new ValidationResult(false, message);
        }
    }

    public static ValidationResult validateUsername(String username) {
        if (isEmpty(username)) {
            return ValidationResult.error(ErrorMessage.User.ERR_USERNAME_IS_EMPTY);
        }
        if (isUsernameExists(username)) {
            return ValidationResult.error(ErrorMessage.User.ERR_DUPLICATE_USERNAME);
        }
        return ValidationResult.success();
    }

    public static ValidationResult validateEmail(String email) {
        if (isEmpty(email)) {
            return ValidationResult.error(ErrorMessage.User.ERR_EMAIL_IS_EMPTY);
        }
        if (!isValidEmail(email)) {
            return ValidationResult.error(ErrorMessage.User.ERR_EMAIL_INCOMPATIBLE);
        }
        if (isEmailExists(email)) {
            return ValidationResult.error(ErrorMessage.User.ERR_DUPLICATE_EMAIL);
        }
        return ValidationResult.success();
    }

    public static ValidationResult validatePassword(String password) {
        if (isEmpty(password)) {
            return ValidationResult.error(ErrorMessage.User.ERR_PASSWORD_IS_EMPTY);
        }
        if (!isValidPassword(password)) {
            return ValidationResult.error(ErrorMessage.User.ERR_PASSWORD_AT_LEAST);
        }
        return ValidationResult.success();
    }

    public static ValidationResult validateConfirmPassword(String password, String confirmPassword) {
        if (isEmpty(confirmPassword)) {
            return ValidationResult.error(ErrorMessage.User.ERR_PASSWORD_CONFIRM_IS_EMPTY);
        }
        if (!isPasswordsMatch(password, confirmPassword)) {
            return ValidationResult.error(ErrorMessage.User.ERR_PASSWORD_NOT_MATCH);
        }
        return ValidationResult.success();
    }


}
