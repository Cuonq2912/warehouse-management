package org.example.view.component.forgot;

import org.example.controller.ForgotPasswordController;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordDialog extends JDialog {

    private ForgotPasswordController forgotPasswordController;

    public ForgotPasswordDialog(JFrame parent) {
        super(parent, "Quên mật khẩu", true);
        this.forgotPasswordController = new ForgotPasswordController();

        setSize(400, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JLabel lblInfo = new JLabel("Nhập email để lấy lại mật khẩu:");
        JTextField txtEmail = new JTextField();
        JButton btnSend = new JButton("Gửi");
        JButton btnCancel = new JButton("Hủy");

        JPanel panelInput = new JPanel(new BorderLayout(10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panelInput.add(lblInfo, BorderLayout.NORTH);
        panelInput.add(txtEmail, BorderLayout.CENTER);

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnSend);
        panelButtons.add(btnCancel);

        add(panelInput, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        btnSend.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            forgotPasswordController.sendResetEmail(email, this);
        });

        btnCancel.addActionListener(e -> dispose());
    }
}
