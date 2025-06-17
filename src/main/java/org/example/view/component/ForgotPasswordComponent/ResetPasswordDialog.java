package org.example.view.component.ForgotPasswordComponent;

import org.example.controller.ForgotPasswordController;
import org.example.utils.IconUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResetPasswordDialog extends JDialog {
    private final ForgotPasswordController controller;
    private final String email;
    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnReset;
    private JButton btnCancel;

    public ResetPasswordDialog(Window parent, ForgotPasswordController controller, String email) {
        super(parent, "Đặt Lại Mật Khẩu", Dialog.ModalityType.APPLICATION_MODAL);
        this.controller = controller;
        this.email = email;
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(550, 500);
        setResizable(false);
        IconUtil.setDialogIcon(this);

        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(new Color(245, 247, 250));

        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(new Color(65, 131, 215));
        headerPanel.setPreferredSize(new Dimension(550, 100));

        GridBagConstraints headerGbc = new GridBagConstraints();
        headerGbc.gridx = 0;
        headerGbc.gridy = 0;
        headerGbc.insets = new Insets(0, 0, 5, 0);

        JLabel titleLabel = new JLabel("Đặt Lại Mật Khẩu");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, headerGbc);

        headerGbc.gridy = 1;
        JLabel subtitleLabel = new JLabel("Tạo mật khẩu mới cho tài khoản của bạn");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(220, 230, 245));
        headerPanel.add(subtitleLabel, headerGbc);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 247, 250));
        formPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        JLabel emailLabel = new JLabel("Tài khoản với email: " + email);
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        emailLabel.setForeground(new Color(65, 131, 215));
        formPanel.add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel lblNewPassword = new JLabel("Mật khẩu mới:");
        lblNewPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNewPassword.setForeground(new Color(60, 60, 60));
        formPanel.add(lblNewPassword, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtNewPassword = new JPasswordField();
        setupPasswordField(txtNewPassword);
        formPanel.add(txtNewPassword, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel lblConfirmPassword = new JLabel("Xác nhận mật khẩu:");
        lblConfirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblConfirmPassword.setForeground(new Color(60, 60, 60));
        formPanel.add(lblConfirmPassword, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtConfirmPassword = new JPasswordField();
        setupPasswordField(txtConfirmPassword);
        formPanel.add(txtConfirmPassword, gbc); 
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(new Color(245, 247, 250));

        btnReset = new JButton("Xác nhận");
        btnCancel = new JButton("Hủy");
        setupButton(btnReset, new Color(40, 167, 69), Color.WHITE);
        setupButton(btnCancel, new Color(108, 117, 125), Color.WHITE);

        btnReset.addActionListener(this::resetPassword);
        btnCancel.addActionListener(this::cancel);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnCancel);
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        mainContainer.add(headerPanel, BorderLayout.NORTH);
        mainContainer.add(formPanel, BorderLayout.CENTER);
        add(mainContainer);

        setupFocusAndKeys();
    }

    private void setupPasswordField(JPasswordField field) {
        field.setPreferredSize(new Dimension(450, 35));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        field.setBackground(Color.WHITE);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(65, 131, 215), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)));
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(220, 220, 220), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)));
            }
        });
    }

    private void setupButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(140, 40));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    private void setupFocusAndKeys() {
        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtConfirmPassword.requestFocus();
            }
        });
        txtConfirmPassword.addActionListener(this::resetPassword);
        SwingUtilities.invokeLater(() -> txtNewPassword.requestFocus());
    }

    private void resetPassword(ActionEvent e) {
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        if (newPassword.isEmpty()) {
            controller.showErrorMessage(this, "Vui lòng nhập mật khẩu mới!");
            txtNewPassword.requestFocus();
            return;
        }

        if (confirmPassword.isEmpty()) {
            controller.showErrorMessage(this, "Vui lòng xác nhận mật khẩu!");
            txtConfirmPassword.requestFocus();
            return;
        }

        setFormEnabled(false);
        btnReset.setText("Đang xử lý...");

        SwingUtilities.invokeLater(() -> {
            boolean success = controller.resetPassword(email, newPassword, confirmPassword, this);
            setFormEnabled(true);
            btnReset.setText("Xác nhận");

            if (success) {
                dispose();
            } else {
                txtNewPassword.setText("");
                txtConfirmPassword.setText("");
                txtNewPassword.requestFocus();
            }
        });
    }

    private void setFormEnabled(boolean enabled) {
        txtNewPassword.setEnabled(enabled);
        txtConfirmPassword.setEnabled(enabled);
        btnReset.setEnabled(enabled);
        btnCancel.setEnabled(enabled);
    }

    private void cancel(ActionEvent e) {
        dispose();
    }
}
