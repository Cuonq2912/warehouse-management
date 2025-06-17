package org.example.service.impl;

import org.example.service.EmailService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.util.Random;

/**
 * Mock Email Service để test chức năng quên mật khẩu
 * mà không cần cấu hình email thật
 */
public class MockEmailServiceImpl implements EmailService {

    @Override
    public boolean sendOTP(String email, String otp) {
        try {
            Thread.sleep(500);

            SwingUtilities.invokeLater(() -> showOTPDialog(email, otp));
            return true;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showOTPDialog(String email, String otp) {
        JDialog dialog = new JDialog((Frame) null, "Thông Báo OTP", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        mainPanel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);

        JLabel headerLabel = new JLabel("Mã OTP Đã Được Gửi");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerLabel.setForeground(new Color(65, 131, 215));
        headerPanel.add(headerLabel);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel otpTitleLabel = new JLabel("Mã OTP của bạn:");
        otpTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        otpTitleLabel.setForeground(new Color(52, 58, 64));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        contentPanel.add(otpTitleLabel, gbc);

        JPanel otpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        otpPanel.setBackground(Color.WHITE);

        JTextField otpField = new JTextField(otp);
        otpField.setEditable(false);
        otpField.setFont(new Font("Segoe UI", Font.BOLD, 28));
        otpField.setHorizontalAlignment(JTextField.CENTER);
        otpField.setBackground(new Color(255, 248, 220));
        otpField.setForeground(new Color(133, 100, 4));
        otpField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7), 2),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        otpField.setPreferredSize(new Dimension(200, 60));
        otpPanel.add(otpField);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        contentPanel.add(otpPanel, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton copyButton = new JButton("Sao Chép OTP");
        styleButton(copyButton, new Color(40, 167, 69));
        copyButton.addActionListener(e -> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(otp), null);
            copyButton.setText("Đã Sao Chép!");
            copyButton.setBackground(new Color(25, 135, 84));
            Timer timer = new Timer(2000, evt -> {
                copyButton.setText("Sao Chép OTP");
                copyButton.setBackground(new Color(40, 167, 69));
            });
            timer.setRepeats(false);
            timer.start();
        });

        JButton closeButton = new JButton("Đóng");
        styleButton(closeButton, new Color(108, 117, 125));
        closeButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(copyButton);
        buttonPanel.add(closeButton);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(mainPanel);
        dialog.setVisible(true);
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(140, 40));
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    @Override
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); 
        return String.valueOf(otp);
    }
}
