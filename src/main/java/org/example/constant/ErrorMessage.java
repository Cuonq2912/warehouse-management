package org.example.constant;

public class ErrorMessage {

    public class Category{
        public static final String ERR_CREATE_CATEGORY = "Lỗi thêm danh mục";
        public static final String ERR_UPDATE_CATEGORY = "Lỗi cập nhật danh mục";
        public static final String ERR_GET_BY_ID_CATEGORY = "Lỗi lấy danh mục theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy danh mục";
    }

    public class Product {
        public static final String ERR_CREATE_PRODUCT = "Lỗi thêm sản phẩm";
        public static final String ERR_UPDATE_PRODUCT = "Lỗi cập nhật sản phẩm";
        public static final String ERR_GET_BY_ID_PRODUCT = "Lỗi lấy sản phẩm theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy sản phẩm";
    }
    
    public class User {
        public static final String ERR_USERNAME_IS_EMPTY = "Please enter username";
        public static final String ERR_PASSWORD_IS_EMPTY = "Please enter password";
        public static final String ERR_EMAIL_IS_EMPTY = "Please enter email";
        public static final String ERR_USERNAME_OR_PASSWORD_INCOMPATIBLE = "Username does not exist or incorrect password";
        public static final String ERR_EMAIL_INCOMPATIBLE = "Please enter a valid email address";
        public static final String ERR_DUPLICATE_USERNAME = "Username already exists. Please choose a different username";
        public static final String ERR_DUPLICATE_EMAIL = "Email already exists. Please use a different email.";
        public static final String ERR_PASSWORD_AT_LEAST = "Password must be at least 8 characters long";
        public static final String ERR_PASSWORD_CONFIRM_IS_EMPTY = "Please confirm your password";
        public static final String ERR_PASSWORD_NOT_MATCH = "Passwords do not match";

    }

}
