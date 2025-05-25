package org.example.constant;

public class ErrorMessage {

    public class Category{
        public static final String ERR_CREATE_CATEGORY = "Lỗi thêm danh mục";
        public static final String ERR_UPDATE_CATEGORY = "Lỗi cập nhật danh mục";
        public static final String ERR_GET_BY_ID_CATEGORY = "Lỗi lấy danh mục theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy danh mục";
    }

    public class Product{
        public static final String ERR_CREATE_PRODUCT = "Lỗi thêm sản phẩm";
        public static final String ERR_UPDATE_PRODUCT = "Lỗi cập nhật sản phẩm";
        public static final String ERR_GET_BY_ID_PRODUCT = "Lỗi lấy sản phẩm theo id = %d";
        public static final String ERR_NOT_FOUND = "Lỗi lấy sản phẩm";
    }

    public class User{
        public static final String ERR_CREATE_USER= " Lỗi thêm người dùng";
        public static final String ERR_UPDATE_USER= " Lỗi cập nhật người dùng";
        public static final String ERR_GET_BY_ID_USER= " Không có người dùng có id hợp lệ";
        public static final String ERR_NOT_FOUND= " Lỗi lấy ra người dùng";
        public static final String ERR_CHECK_EMAIL="lỗi email";
        public static final String ERR_CHECK_USERNAME="lỗi người dùng";

    }
}
