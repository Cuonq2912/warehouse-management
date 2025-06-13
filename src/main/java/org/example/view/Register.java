package org.example.view;

import lombok.Getter;
import org.example.controller.RegisterController;
import org.example.utils.IconUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

    private JPanel contentPanel;
    @Getter
    private JTextField txtUsername;
    @Getter
    private JTextField txtEmail;
    @Getter
    private JPasswordField txtPassword;
    @Getter
    private JPasswordField txtConfirmPassword;
    @Getter
    private JLabel labelLogin;
    @Getter
    private JButton btnRegister;

    private RegisterController registerController;

    public Register() {
        this.registerController = new RegisterController();
        initComponents();
        setupEventHandlers();
    }

    private void initComponents() {

        setTitle("Warehouse Management");
        setSize(1200, 800);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set application icon
        IconUtil.setFrameIcon(this);
        setLocationRelativeTo(null);

        contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL imageUrl = getClass().getClassLoader().getResource("image/kho-hang-2.jpg");
                if (imageUrl != null) {
                    ImageIcon icon = new ImageIcon(imageUrl);
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPanel.setLayout(new BorderLayout());
        setContentPane(contentPanel);

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setOpaque(false);
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(255, 255, 255, 250));
        registerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(25, 24, 30, 24)));
        registerPanel.setPreferredSize(new Dimension(470, 650));

        JLabel lblTitle = new JLabel("Create New Account");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        JPanel loginLinkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginLinkPanel.setBackground(null);
        JLabel lblHaveAccount = new JLabel("Already have an account?");
        lblHaveAccount.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        labelLogin = new JLabel("Login");
        labelLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
        labelLogin.setForeground(new Color(65, 131, 215));
        labelLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLinkPanel.add(lblHaveAccount);
        loginLinkPanel.add(labelLogin);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername = new JTextField();
        txtUsername.setPreferredSize(new Dimension(350, 42));
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        txtUsername.setBackground(Color.WHITE);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail = new JTextField();
        txtEmail.setPreferredSize(new Dimension(350, 42));
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        txtEmail.setBackground(Color.WHITE);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(350, 42));
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        txtPassword.setBackground(Color.WHITE);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setPreferredSize(new Dimension(350, 42));
        txtConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        txtConfirmPassword.setBackground(Color.WHITE);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegister.setBackground(new Color(46, 204, 113));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        btnRegister.setPreferredSize(new Dimension(350, 45));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        registerPanel.add(lblTitle, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);
        registerPanel.add(loginLinkPanel, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 0);
        registerPanel.add(lblUsername, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        registerPanel.add(txtUsername, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 0);
        registerPanel.add(labelEmail, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        registerPanel.add(txtEmail, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 0);
        registerPanel.add(lblPassword, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        registerPanel.add(txtPassword, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 8, 0);
        registerPanel.add(lblConfirmPassword, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 30, 0);
        registerPanel.add(txtConfirmPassword, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        registerPanel.add(btnRegister, gbc);

        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        wrapperPanel.add(registerPanel, mainGbc);
        contentPanel.add(wrapperPanel, BorderLayout.CENTER);
    }

    private void setupEventHandlers() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });

        labelLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerController.navigateToLogin(Register.this);
            }
        });
    }

    private void handleRegister() {
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        registerController.handleRegister(username, email, password, confirmPassword, this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Register register = new Register();
                register.setVisible(true);
            }
        });
    }
}
