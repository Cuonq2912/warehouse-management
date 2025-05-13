package org.example.constant;

public class ErrorMessage {
    //error validation dto
    public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "Trường này là bắt buộc!";
    public static final String INVALID_SOME_THING_FIELD = "Dữ liệu không hợp lệ!";
    public static final String INVALID_FORMAT_PASSWORD = "Mật khẩu không đáp ứng yêu cầu!";
    public static final String NOT_BLANK_FIELD = "Không thể để trống!";
    public static final String ERR_INVALID_FILE = "Định dạng tệp không hợp lệ!";
    public static final String INVALID_DATE = "Thời gian không hợp lệ!";
    public static final String INVALID_DATE_CHECK_IN = "Ngày nhận phòng không hợp lệ!";
    public static final String INVALID_DATE_CHECK_OUT = "Ngày trả phòng không hợp lệ!";
    public static final String INVALID_FORMAT_SOME_THING_FIELD = "Định dạng không hợp lệ!";

    //error validation entity

    public class Product {
        public static final String INVALID_PRICE_GREATER_THAN_ZERO = "Giá phải lớn hơn 0!";
        public static final String INVALID_REMAINING_QUANTITY_GREATER_THAN_ZERO = "Số lượng còn lại phải lớn hơn hoặc bằng 0!";
        public static final String INVALID_SOLD_OUT_QUANTITY_GREATER_THAN_ZERO = "Số lượng đã bán phải lớn hơn hoặc bằng 0!";
    }


}
