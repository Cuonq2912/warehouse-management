package org.example.service.impl;

import org.example.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailServiceImpl implements EmailService {


    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String EMAIL_USERNAME = "nguyenncuongg291@gmail.com";
    private static final String EMAIL_PASSWORD = "rkcl xufg iuyk afwo";

    private JavaMailSender createMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(SMTP_HOST);
        mailSender.setPort(SMTP_PORT);
        mailSender.setUsername(EMAIL_USERNAME);
        mailSender.setPassword(EMAIL_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.debug", "false");

        return mailSender;
    }

    @Override
    public boolean sendOTP(String email, String otp) {
        try {
            JavaMailSender mailSender = createMailSender();
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(EMAIL_USERNAME);
            helper.setTo(email);
            helper.setSubject("Warehouse Management - Reset Password OTP");

            String htmlContent = String.format(
                    "<html>" +
                            "<body style='font-family: Arial, sans-serif;'>" +
                            "<div style='max-width: 600px; margin: 0 auto; padding: 20px;'>" +
                            "<h2 style='color: #4183d7;'>Warehouse Management System</h2>" +
                            "<p>Bạn đã yêu cầu đặt lại mật khẩu cho tài khoản của mình.</p>" +
                            "<p>Mã OTP của bạn là:</p>" +
                            "<div style='background-color: #f8f9fa; padding: 20px; text-align: center; margin: 20px 0;'>"
                            +
                            "<h1 style='color: #4183d7; font-size: 32px; margin: 0; letter-spacing: 4px;'>%s</h1>" +
                            "</div>" +
                            "<p><strong>Lưu ý:</strong></p>" +
                            "<ul>" +
                            "<li>Mã OTP này có hiệu lực trong 5 phút</li>" +
                            "<li>Không chia sẻ mã này với bất kỳ ai</li>" +
                            "<li>Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này</li>" +
                            "</ul>" +
                            "<p>Trân trọng,<br/>Warehouse Management Team</p>" +
                            "</div>" +
                            "</body>" +
                            "</html>",
                    otp);

            helper.setText(htmlContent, true);

            mailSender.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // 6 digit OTP
        return String.valueOf(otp);
    }
}
