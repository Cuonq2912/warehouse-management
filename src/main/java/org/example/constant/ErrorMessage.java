package org.example.constant;

public class ErrorMessage {

    public class Category {
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

        public static final String ERR_CREATE_USER = " Lỗi thêm người dùng";
        public static final String ERR_UPDATE_USER = " Lỗi cập nhật người dùng";
        public static final String ERR_GET_BY_ID_USER = " Không có người dùng có id hợp lệ";
        public static final String ERR_NOT_FOUND = " Lỗi lấy ra người dùng";
        public static final String ERR_CHECK_EMAIL = "lỗi email";
        public static final String ERR_CHECK_USERNAME = "lỗi người dùng";

    }

    public class Supplier {
        public static final String ERR_CREATE_SUP = "Lỗi thêm khuyến mãi ";
        public static final String ERR_UPDATE_SUP = "Lỗi cập nhật khuyến mãi";
        public static final String ERR_GET_BY_ID_SUP = "Lỗi lấy khuyến mãi theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy khuyến mãi";
    }

    public static class Customer {
        public static final String ERR_CREATE_CUSTOMER = "Lỗi thêm khách hàng";
        public static final String ERR_UPDATE_CUSTOMER = "Lỗi cập nhật khách hàng theo id = %d";
        public static final String ERR_GET_BY_ID_CUSTOMER = "Lỗi lấy khách hàng theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy danh sách khách hàng";
        public static final String ERR_DELETE_CUSTOMER = "Lỗi xóa khách hàng theo id = %d";
    }

    public static class ImportProduct {
        public static final String ERR_SUPPLIER_NOT_SELECTED = "Please select a supplier!";
        public static final String ERR_PRODUCT_NOT_SELECTED = "Please select a product!";
        public static final String ERR_QUANTITY_EMPTY = "Please enter quantity!";
        public static final String ERR_PRICE_EMPTY = "Please enter price!";
        public static final String ERR_QUANTITY_INVALID = "Please enter a valid quantity!";
        public static final String ERR_PRICE_INVALID = "Please enter a valid price!";
        public static final String ERR_QUANTITY_MUST_BE_POSITIVE = "Quantity must be greater than 0!";
        public static final String ERR_PRICE_MUST_BE_POSITIVE = "Price must be greater than 0!";
        public static final String ERR_CREATE_FAILED = "Failed to create import product!";
        public static final String ERR_UPDATE_FAILED = "Failed to update import product!";
        public static final String ERR_SAVE_FAILED = "Error saving import product: %s";
    }

    public static class ExportProduct {
        public static final String ERR_CUSTOMER_NOT_SELECTED = "Please select a customer!";
        public static final String ERR_PRODUCT_NOT_SELECTED = "Please select a product!";
        public static final String ERR_QUANTITY_EMPTY = "Please enter quantity!";
        public static final String ERR_PRICE_EMPTY = "Please enter price!";
        public static final String ERR_QUANTITY_INVALID = "Please enter a valid quantity!";
        public static final String ERR_PRICE_INVALID = "Please enter a valid price!";
        public static final String ERR_QUANTITY_MUST_BE_POSITIVE = "Quantity must be greater than 0!";
        public static final String ERR_PRICE_MUST_BE_POSITIVE = "Price must be greater than 0!";
        public static final String ERR_INSUFFICIENT_STOCK = "Insufficient stock! Available: %d, Requested: %d";
        public static final String ERR_CREATE_FAILED = "Failed to create export product!";
        public static final String ERR_UPDATE_FAILED = "Failed to update export product!";
        public static final String ERR_SAVE_FAILED = "Error saving export product: %s";
    }

}
