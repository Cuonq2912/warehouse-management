package org.example.view.component.CustomerComponent;

import net.miginfocom.swing.MigLayout;
import org.example.controller.CustomerController;
import org.example.domain.model.CustomerModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomerFormDialog extends JDialog {

    private final CustomerController controller;
    private Long customerId;
    private final JTextField txtCustomerId;
    private final JTextField txtCustomerName;
    private final JTextField txtEmail;
    private final JTextField txtPhoneNumber;
    private final JTextField txtAddress;
    private final JTextField txtPoint;
    private final JButton btnSave;
    private final JButton btnCancel;
    private final JTable parentTable;
    private final boolean isEdit;

    public CustomerFormDialog(JFrame parent, CustomerController controller, JTable parentTable) {
        this(parent, controller, parentTable, null);
    }

    public CustomerFormDialog(JFrame parent, CustomerController controller, JTable parentTable,
                              CustomerModel customer) {
        super(parent, true);
        this.controller = controller;
        this.parentTable = parentTable;
        this.isEdit = customer != null;

        controller.setCustomerTable(parentTable);

        txtCustomerId = new JTextField(20);
        txtCustomerName = new JTextField(20);
        txtEmail = new JTextField(20);
        txtPhoneNumber = new JTextField(20);
        txtAddress = new JTextField(20);
        txtPoint = new JTextField(20);
        btnSave = new JButton(isEdit ? "Update" : "Save");
        btnCancel = new JButton("Cancel");

        if (isEdit && customer != null) {
            customerId = customer.getId();
            txtCustomerId.setText(String.valueOf(customer.getId()));
            txtCustomerName.setText(customer.getName());
            txtEmail.setText(customer.getEmail());
            txtPhoneNumber.setText(customer.getPhoneNumber());
            txtAddress.setText(customer.getAddress());
        }

        initComponents();
        initListeners();
    }

    private void initComponents() {
        setTitle(isEdit ? "Edit Customer" : "Add New Customer");
        setSize(400, 500);
        setLocationRelativeTo(getOwner());
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel titleLabel = new JLabel(isEdit ? "Edit Customer" : "Add New Customer");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new MigLayout("fillx, insets 0", "[right]10[grow,fill]", "[]15[]15[]15[]15[]15[]15[]15[]"));
        formPanel.setBackground(Color.WHITE);

        if (isEdit) {
            addLabelAndField(formPanel, "Customer ID:", txtCustomerId, false);
        }

        addLabelAndField(formPanel, "Customer Name:", txtCustomerName, true);
        addLabelAndField(formPanel, "Email:", txtEmail, true);
        addLabelAndField(formPanel, "Phone Number:", txtPhoneNumber, true);
        addLabelAndField(formPanel, "Address:", txtAddress, true);
        addLabelAndField(formPanel, "Point:", txtPoint, true);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(Color.WHITE);

        styleButton(btnSave, new Color(66, 139, 202));
        styleButton(btnCancel, new Color(153, 153, 153));

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private void addLabelAndField(JPanel panel, String label, JTextField textField, boolean editable) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(jLabel, "");

        textField.setEditable(editable);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        panel.add(textField, "wrap");
    }

    private void initListeners() {
        btnSave.addActionListener(actionEvent -> {
            String name = txtCustomerName.getText().trim();
            String email = txtEmail.getText().trim();
            String phone = txtPhoneNumber.getText().trim();
            String address = txtAddress.getText().trim();
            String pointStr = txtPoint.getText().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || pointStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng nhập đầy đủ thông tin khách hàng.",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double point;
            try {
                point = Double.parseDouble(pointStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Point phải là một số.",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            CustomerModel customer = new CustomerModel();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhoneNumber(phone);
            customer.setAddress(address);

            if (isEdit) {
                controller.updateCustomer(customerId, customer);
            } else {
                controller.addCustomer(customer);
            }

            SwingUtilities.invokeLater(() -> controller.loadCustomers(parentTable));
            dispose();
        });

        btnCancel.addActionListener(actionEvent -> dispose());
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }
}
