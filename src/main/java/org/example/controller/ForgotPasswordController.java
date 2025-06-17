package org.example.controller;

import org.example.domain.model.UserModel;
import org.example.service.EmailService;
import org.example.service.UserService;
import org.example.service.impl.MockEmailServiceImpl;
import org.example.service.impl.UserServiceImpl;
import org.example.utils.PasswordEncoder;
import org.example.view.Login;
import org.example.view.component.ForgotPasswordComponent.ForgotPasswordDialog;
import org.example.view.component.ForgotPasswordComponent.OTPVerificationDialog;
import org.example.view.component.ForgotPasswordComponent.ResetPasswordDialog;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ForgotPasswordController {
    private final UserService userService;
    private final EmailService emailService;
    private final Map<String, OTPSession> otpSessions;

    public ForgotPasswordController() {
        this.userService = new UserServiceImpl(); 
        this.emailService = new MockEmailServiceImpl();
        this.otpSessions = new HashMap<>();
    }

    public void showForgotPasswordDialog(Window parent) {
        ForgotPasswordDialog dialog = new ForgotPasswordDialog(parent, this);
        dialog.setVisible(true);
    }

    public boolean sendOTPToEmail(String email, Window parent) {
        try {
            if (!userService.existsByEmail(email)) {
                showErrorMessage(parent, "Email không tồn tại trong hệ thống!");
                return false;
            }

            String otp = emailService.generateOTP();

            if (emailService.sendOTP(email, otp)) {
                // Lưu session OTP
                OTPSession session = new OTPSession(otp, LocalDateTime.now().plusMinutes(5), email);
                otpSessions.put(email, session);

                showSuccessMessage(parent, "OTP đã được gửi đến email của bạn!");

                showOTPVerificationDialog(parent, email);
                return true;
            } else {
                showErrorMessage(parent, "Không thể gửi email! Vui lòng thử lại sau.");
                return false;
            }

        } catch (Exception e) {
            showErrorMessage(parent, "Đã xảy ra lỗi: " + e.getMessage());
            return false;
        }
    }

    public void showOTPVerificationDialog(Window parent, String email) {
        OTPVerificationDialog dialog = new OTPVerificationDialog(parent, this, email);
        dialog.setVisible(true);
    }

    public boolean verifyOTP(String email, String inputOTP, Window parent) {
        OTPSession session = otpSessions.get(email);

        if (session == null) {
            showErrorMessage(parent, "Session không hợp lệ! Vui lòng thử lại.");
            return false;
        }

        if (LocalDateTime.now().isAfter(session.getExpiryTime())) {
            otpSessions.remove(email);
            showErrorMessage(parent, "OTP đã hết hạn! Vui lòng yêu cầu lại.");
            return false;
        }

        if (!session.getOtp().equals(inputOTP)) {
            showErrorMessage(parent, "OTP không chính xác!");
            return false;
        }

        showResetPasswordDialog(parent, email);
        return true;
    }

    public void showResetPasswordDialog(Window parent, String email) {
        ResetPasswordDialog dialog = new ResetPasswordDialog(parent, this, email);
        dialog.setVisible(true);
    }

    public boolean resetPassword(String email, String newPassword, String confirmPassword, Window parent) {
        try {
            if (!newPassword.equals(confirmPassword)) {
                showErrorMessage(parent, "Mật khẩu xác nhận không khớp!");
                return false;
            }

            if (newPassword.length() < 6) {
                showErrorMessage(parent, "Mật khẩu phải có ít nhất 6 ký tự!");
                return false;
            }

            // Cập nhật mật khẩu mới
            UserModel user = userService.findByEmail(email);
            if (user != null) {
                String hashedPassword = PasswordEncoder.encode(newPassword);
                user.setPassword(hashedPassword);

                if (userService.updateUser(user)) {
                    // Xóa session OTP
                    otpSessions.remove(email);

                    showSuccessMessage(parent, "Đặt lại mật khẩu thành công! Vui lòng đăng nhập lại.");

                    closeAllDialogsAndShowLogin(parent);
                    return true;
                } else {
                    showErrorMessage(parent, "Không thể cập nhật mật khẩu! Vui lòng thử lại.");
                    return false;
                }
            } else {
                showErrorMessage(parent, "Không tìm thấy người dùng!");
                return false;
            }

        } catch (Exception e) {
            showErrorMessage(parent, "Đã xảy ra lỗi: " + e.getMessage());
            return false;
        }
    }

    public void resendOTP(String email, Window parent) {
        sendOTPToEmail(email, parent);
    }

    private void closeAllDialogsAndShowLogin(Window parent) {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JDialog && window.isDisplayable()) {
                window.dispose();
            }
        }

        // Hiển thị lại màn hình login
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    public void showSuccessMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Thành công", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    } 

    private static class OTPSession {
        private final String otp;
        private final LocalDateTime expiryTime;

        public OTPSession(String otp, LocalDateTime expiryTime, String email) {
            this.otp = otp;
            this.expiryTime = expiryTime;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getExpiryTime() {
            return expiryTime;
        }
    }
}
