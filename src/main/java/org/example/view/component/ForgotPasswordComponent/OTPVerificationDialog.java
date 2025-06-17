package org.example.view.component.ForgotPasswordComponent;

import org.example.controller.ForgotPasswordController;
import org.example.utils.IconUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OTPVerificationDialog extends JDialog {
    private final ForgotPasswordController controller;
    private final String email;
    private JTextField txtOTP;
    private JButton btnVerify;
    private JButton btnResend;
    private JButton btnCancel;
    private JLabel lblTimer;
    private Timer countdownTimer;
    private int timeLeft = 300; 

    public OTPVerificationDialog(Window parent, ForgotPasswordController controller, String email) {
        super(parent, "Xác Thực OTP", Dialog.ModalityType.APPLICATION_MODAL);
        this.controller = controller;
        this.email = email;
        initComponents();
        startCountdown();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setResizable(false);

        IconUtil.setDialogIcon(this);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        mainPanel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(65, 131, 215));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Xác Thực OTP", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle, BorderLayout.CENTER);

        JLabel lblSubtitle = new JLabel("Nhập mã xác thực đã được gửi", JLabel.CENTER);
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setForeground(new Color(230, 240, 255));
        headerPanel.add(lblSubtitle, BorderLayout.SOUTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblOTP = new JLabel("Nhập Mã OTP (6 chữ số)");
        lblOTP.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblOTP.setForeground(new Color(52, 58, 64));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        formPanel.add(lblOTP, gbc);

        txtOTP = new JTextField();
        txtOTP.setPreferredSize(new Dimension(350, 50));
        txtOTP.setFont(new Font("Segoe UI", Font.BOLD, 24));
        txtOTP.setHorizontalAlignment(JTextField.CENTER);
        txtOTP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 2),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)));
        txtOTP.setBackground(Color.WHITE);
        txtOTP.setToolTipText("Nhập mã OTP gồm 6 chữ số");

        txtOTP.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException {
                if (str == null)
                    return;

                if (!str.matches("\\d+"))
                    return;

                if (getLength() + str.length() <= 6) {
                    super.insertString(offs, str, a);
                }
            }
        });

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        formPanel.add(txtOTP, gbc);

        lblTimer = new JLabel();
        lblTimer.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTimer.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 25, 0);
        formPanel.add(lblTimer, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(Color.WHITE);

        btnVerify = new JButton("Xác Thực");
        styleButton(btnVerify, new Color(40, 167, 69));
        btnVerify.addActionListener(this::verifyOTP);

        btnResend = new JButton("Gửi Lại");
        styleButton(btnResend, new Color(255, 193, 7));
        btnResend.addActionListener(this::resendOTP);

        btnCancel = new JButton("Hủy Bỏ");
        styleButton(btnCancel, new Color(108, 117, 125));
        btnCancel.addActionListener(this::cancel);

        buttonPanel.add(btnVerify);
        buttonPanel.add(btnResend);
        buttonPanel.add(btnCancel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        txtOTP.addActionListener(this::verifyOTP);

        SwingUtilities.invokeLater(() -> txtOTP.requestFocus());
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

    private void startCountdown() {
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                updateTimerLabel();

                if (timeLeft <= 0) {
                    countdownTimer.stop();
                    lblTimer.setText("Mã OTP đã hết hạn! Vui lòng gửi lại mã mới.");
                    lblTimer.setForeground(new Color(220, 53, 69));
                    btnVerify.setEnabled(false);
                }
            }
        });
        countdownTimer.start();
        updateTimerLabel();
    }

    private void updateTimerLabel() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        lblTimer.setText(String.format("Mã OTP có hiệu lực: %02d:%02d", minutes, seconds));
        lblTimer.setForeground(new Color(40, 167, 69));
    }

    private void verifyOTP(ActionEvent e) {
        String otp = txtOTP.getText().trim();

        if (otp.isEmpty()) {
            controller.showErrorMessage(this, "Vui lòng nhập mã OTP!");
            txtOTP.requestFocus();
            return;
        }

        if (otp.length() != 6) {
            controller.showErrorMessage(this, "Mã OTP phải có đúng 6 chữ số!");
            txtOTP.requestFocus();
            return;
        }

        btnVerify.setEnabled(false);
        btnVerify.setText("Đang xác thực...");

        SwingUtilities.invokeLater(() -> {
            boolean success = controller.verifyOTP(email, otp, this);

            btnVerify.setEnabled(true);
            btnVerify.setText("Xác Thực");

            if (success) {
                countdownTimer.stop();
                dispose();
            } else {
                txtOTP.setText("");
                txtOTP.requestFocus();
            }
        });
    }

    private void resendOTP(ActionEvent e) {
        btnResend.setEnabled(false);
        btnResend.setText("Đang gửi...");

        SwingUtilities.invokeLater(() -> {
            controller.resendOTP(email, this);

            countdownTimer.stop();
            timeLeft = 300;
            startCountdown();
            btnVerify.setEnabled(true);

            txtOTP.setText("");
            txtOTP.requestFocus();

            btnResend.setEnabled(true);
            btnResend.setText("Gửi Lại");
        });
    }

    private void cancel(ActionEvent e) {
        if (countdownTimer != null) {
            countdownTimer.stop();
        }
        dispose();
    }

    @Override
    public void dispose() {
        if (countdownTimer != null) {
            countdownTimer.stop();
        }
        super.dispose();
    }
}
