package org.example.utils;

import com.mysql.cj.protocol.Message;
import com.sun.jdi.connect.Transport;
import jakarta.mail.MessagingException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import jakarta.mail.internet.MimeMessage;
import org.hibernate.Session;
   import java.util.Properties;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.example.View.InternetAddress;
public class SendMailUtils {

    public static void sendEmail(String recipient, String subject, String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     //(password)
    //email : 
    //petu ieqx nboa dyxo
//   public static void sendResetLink(String recipientEmail) {
//        final String senderEmail = "ktpm834@gmail.com"; // Thay bằng email của bạn
//        final String senderPassword = "gnci kmsh lktc kdf"; // Thay bằng App Password
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session;
//       session = Session.getInstance(props, new Authenticator() {
//           protected PasswordAuthentication getPasswordAuthentication() {
//               return new PasswordAuthentication(senderEmail, senderPassword);
//           }
//       });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(senderEmail));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            message.setSubject("Password Reset Request");
//            message.setText("""
//                            Click the link below to reset your password:
//                            
//                            https://yourwebsite.com/reset-password?email=""" + recipientEmail);
//
//            Transport.send(message);
//            System.out.println("Reset link sent to " + recipientEmail);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//   }
//    public static void sendEmail(String recipientEmail, String subject, String messageText) {
//        // Thông tin email người gửi
//        final String senderEmail = "youremail@gmail.com"; // Thay bằng email của bạn
//        final String senderPassword = "yourapppassword"; // Thay bằng mật khẩu ứng dụng
//
//        // Cấu hình SMTP cho Gmail
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        // Tạo session với xác thực
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, senderPassword.toCharArray());
//            }
//        });
//
//        try {
//            // Tạo tin nhắn
//         Message message = (Message) new MimeMessage((MimeMessage) session);
//            message.setFrom(new InternetAddress(senderEmail));
//
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            message.setSubject(subject);
//            message.setText(messageText);
//
//            // Gửi email
//            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Email đã gửi thành công!");
//        } catch (MessagingException e) {
//            JOptionPane.showMessageDialog(null, "Gửi email thất bại: " + e.getMessage());
//        }
//    }
}

