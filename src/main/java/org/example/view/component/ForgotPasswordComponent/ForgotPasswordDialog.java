package org.example.view.component.ForgotPasswordComponent;

import org.example.controller.ForgotPasswordController;
import org.example.utils.IconUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ForgotPasswordDialog extends JDialog {
    private final ForgotPasswordController controller;
    private JTextField txtEmail;
    private JButton btnSendOTP;
    private JButton btnCancel;

    public ForgotPasswordDialog(Window parent, ForgotPasswordController controller) {
        super(parent, "Quên Mật Khẩu", Dialog.ModalityType.APPLICATION_MODAL);
        this.controller = controller;
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(450, 350);
        setResizable(false);

        IconUtil.setDialogIcon(this);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        mainPanel.setBackground(Color.WHITE); 
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Khôi Phục Mật Khẩu");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(65, 131, 215));

        titlePanel.add(lblTitle); 
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblDescription = new JLabel("<html><div style='text-align: center;'>" +
                "Nhập email tài khoản của bạn để nhận mã OTP<br/>" + "đặt lại mật khẩu." +
                "</div></html>");
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescription.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 15, 0);
        formPanel.add(lblDescription, gbc); // Email Label
        JLabel lblEmail = new JLabel("Địa chỉ Email:");
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 0);
        formPanel.add(lblEmail, gbc);

        txtEmail = new JTextField();
        txtEmail.setPreferredSize(new Dimension(320, 40));
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(65, 131, 215), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)));
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setToolTipText("Nhập email tài khoản đã đăng ký");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 25, 0);
        formPanel.add(txtEmail, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.WHITE);
        btnSendOTP = new JButton("Gửi Mã OTP");
        styleButton(btnSendOTP, new Color(40, 167, 69));
        btnSendOTP.addActionListener(this::sendOTP);

        btnCancel = new JButton("Hủy Bỏ");
        styleButton(btnCancel, new Color(108, 117, 125));
        btnCancel.addActionListener(this::cancel);

        buttonPanel.add(btnSendOTP);
        buttonPanel.add(btnCancel);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);
        formPanel.add(buttonPanel, gbc);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);

        txtEmail.addActionListener(this::sendOTP);
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 40));
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

    private void sendOTP(ActionEvent e) {
        String email = txtEmail.getText().trim();

        if (email.isEmpty()) {
            controller.showErrorMessage(this, "Vui lòng nhập địa chỉ email!");
            txtEmail.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            controller.showErrorMessage(this, "Địa chỉ email không hợp lệ!");
            txtEmail.requestFocus();
            return;
        }

        btnSendOTP.setEnabled(false);
        btnSendOTP.setText("Đang gửi...");

        SwingUtilities.invokeLater(() -> {
            boolean success = controller.sendOTPToEmail(email, this);

            btnSendOTP.setEnabled(true);
            btnSendOTP.setText("Gửi Mã OTP");

            if (success) {
                dispose();
            }
        });
    }

    private void cancel(ActionEvent e) {
        dispose();
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
