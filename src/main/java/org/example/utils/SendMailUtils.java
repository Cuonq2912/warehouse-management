package org.example.utils;
//

import java.util.Properties;
import javax.mail.MessagingException;

public class SendMailUtils {

    public void sendMail(String recipient, String subject, String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public class MailService {
        private static final String FROM_EMAIL = "ktpm88907@gmail.com"; // Thay bằng email của bạn
        private static final String PASSWORD = "ulsd wxxm ccdd rzeo"; // Mật khẩu ứng dụng Gmail

        public static void sendMail(String toEmail, String subject, String messageText) throws MessagingException {
            // Cấu hình SMTP
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

        }
    }

}
