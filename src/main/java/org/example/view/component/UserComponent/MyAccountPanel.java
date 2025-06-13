package org.example.view.component.UserComponent;

import org.example.controller.UserController;
import org.example.domain.model.UserModel;
import org.example.utils.SessionManager;
import org.example.view.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyAccountPanel extends JPanel {
    private final UserController userController;
    private final JFrame parentFrame;
    private UserModel currentUser; 
    private JTextField txtUsername;
    private JTextField txtFullName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JPasswordField txtPassword;

    private JButton btnUpdate;
    private JButton btnDeleteAccount;

    public MyAccountPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.userController = new UserController();
        this.currentUser = SessionManager.getInstance().getCurrentUser();

        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No user session found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        initComponents();
        loadUserData();

        setVisible(true);
        setPreferredSize(new Dimension(800, 600));
    }

    private void initComponents() {
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(245, 245, 247));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JLabel titleLabel = new JLabel("My Account Information");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        return headerPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0; 
        txtUsername = new JTextField(25);
        txtFullName = new JTextField(25);
        txtEmail = new JTextField(25);
        txtPhone = new JTextField(25);
        txtAddress = new JTextField(25);
        txtPassword = new JPasswordField(25);

        styleTextField(txtUsername);
        styleTextField(txtFullName);
        styleTextField(txtEmail);
        styleTextField(txtPhone);
        styleTextField(txtAddress);
        stylePasswordField(txtPassword);
        
        int row = 0;
        addFormField(formPanel, gbc, row++, "Username:", txtUsername);
        addFormField(formPanel, gbc, row++, "Full Name:", txtFullName);
        addFormField(formPanel, gbc, row++, "Email:", txtEmail);
        addFormField(formPanel, gbc, row++, "Phone:", txtPhone);
        addFormField(formPanel, gbc, row++, "Address:", txtAddress);
        addFormField(formPanel, gbc, row++, "Password:", txtPassword);

        return formPanel;
    }

    private void addFormField(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent component) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.0;

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setPreferredSize(new Dimension(120, 30));
        panel.add(label, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        if (component instanceof JTextField || component instanceof JPasswordField) {
            component.setPreferredSize(new Dimension(300, 60));
        }

        panel.add(component, gbc);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 245, 247));

        btnUpdate = new JButton("Update Account");
        styleButton(btnUpdate, new Color(66, 139, 202));

        btnDeleteAccount = new JButton("Delete Account");
        styleButton(btnDeleteAccount, new Color(217, 83, 79)); 
        btnUpdate.addActionListener(this::updateAccount);
        btnDeleteAccount.addActionListener(this::deleteAccount);

        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDeleteAccount);

        return buttonPanel;
    }

    private void styleTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1),
                BorderFactory.createEmptyBorder(15, 12, 15, 12)));
        field.setBackground(Color.WHITE);
        field.setPreferredSize(new Dimension(300, 60));
        field.setMargin(new Insets(5, 5, 5, 5));
    }

    private void stylePasswordField(JPasswordField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1),
                BorderFactory.createEmptyBorder(15, 12, 15, 12)));
        field.setBackground(Color.WHITE);
        field.setPreferredSize(new Dimension(300, 60));
        field.setMargin(new Insets(5, 5, 5, 5));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private void loadUserData() {
        if (currentUser != null) {
            txtUsername.setText(currentUser.getUsername() != null ? currentUser.getUsername() : "");
            txtFullName.setText(currentUser.getFullName() != null ? currentUser.getFullName() : "");
            txtEmail.setText(currentUser.getEmail() != null ? currentUser.getEmail() : "");
            txtPhone.setText(currentUser.getPhoneNumber() != null ? currentUser.getPhoneNumber() : "");
            txtAddress.setText(currentUser.getAddress() != null ? currentUser.getAddress() : "");
            txtPassword.setText("");
            
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No user session found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateAccount(ActionEvent e) {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "No user session found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String username = txtUsername.getText().trim();
        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String address = txtAddress.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || fullName.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username, Full Name, and Email are required!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!phone.isEmpty() && !phone.matches("^(0[1-9][0-9]{8,9})$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.equals(currentUser.getEmail()) && userController.existsByEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email is already in use!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!username.equals(currentUser.getUsername()) && userController.existsByUsername(username)) {
            JOptionPane.showMessageDialog(this, "Username is already in use!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String finalPassword = password.isEmpty() ? currentUser.getPassword()
                    : org.example.utils.PasswordEncoder.encode(password);

            userController.updateUser(
                    currentUser.getId(),
                    username,
                    finalPassword,
                    fullName,
                    email,
                    phone,
                    address,
                    currentUser.getRole(), 
                    currentUser.getStatus() 
            );

            currentUser = userController.getUserById(currentUser.getId());
            SessionManager.getInstance().setCurrentUser(currentUser);

            loadUserData();

            JOptionPane.showMessageDialog(this, "Account updated successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to update account: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAccount(ActionEvent e) {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "No user session found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete your account?\nThis action cannot be undone and you will be logged out.",
                "Confirm Account Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean success = userController.getUserById(currentUser.getId()) != null;
                if (success) {
                    userController.deleteUser(currentUser.getId());

                    SessionManager.getInstance().logout();

                    JOptionPane.showMessageDialog(this, "Account deleted successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    Login loginFrame = new Login();
                    loginFrame.setVisible(true);
                    parentFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Account not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to delete account: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void refreshData() {
        currentUser = SessionManager.getInstance().getCurrentUser();
        loadUserData();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            refreshData();
        }
    }
}
