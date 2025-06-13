package org.example.controller;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.util.Properties;

public class ForgotPasswordController {
    public void sendResetEmail(String email, JDialog dialog) {
        if (email == null || email.isBlank()) {
            JOptionPane.showMessageDialog(dialog, "Vui lòng nhập địa chỉ email.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(dialog, "Email không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final String fromEmail = "phamthach2103@gmail.com"; // GMAIL gửi đi
        final String password = "ixkm bbix lzoi euvo"; // App password (không phải mật khẩu Gmail)
        final String subject = "Đặt lại mật khẩu - Warehouse App";
        final String messageText = "Bạn đã yêu cầu đặt lại mật khẩu.\nVui lòng nhấn vào liên kết sau để đặt lại:\n" +
                "https://example.com/reset-password?email=" + email;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server
        props.put("mail.smtp.port", "587"); // TLS port
        props.put("mail.smtp.auth", "true"); // Enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS


        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            JOptionPane.showMessageDialog(dialog, "Đã gửi hướng dẫn đặt lại mật khẩu đến:\n" + email);
            dialog.dispose();
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(dialog, "Gửi email thất bại.\n" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
