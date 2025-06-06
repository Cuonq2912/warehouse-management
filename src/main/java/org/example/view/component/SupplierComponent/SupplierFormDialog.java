package org.example.view.component.SupplierComponent;

import net.miginfocom.swing.MigLayout;
import org.example.controller.SupplierController;
import org.example.domain.model.SupplierModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SupplierFormDialog extends JDialog {

    private final SupplierController controller;
    private final JTable parentTable;
    private final boolean isEdit;

    private Long supplierId;
    private final JTextField txtSupplierId;
    private final JTextField txtSupplierName;
    private final JTextField txtPhone;
    private final JTextField txtEmail;
    private final JTextField txtAddress;

    private final JButton btnSave;
    private final JButton btnCancel;

    public SupplierFormDialog(JFrame parent, SupplierController controller, JTable parentTable) {
        this(parent, controller, parentTable, null);
    }

    public SupplierFormDialog(JFrame parent, SupplierController controller, JTable parentTable, SupplierModel supplier) {
        super(parent, true);
        this.controller = controller;
        this.parentTable = parentTable;
        this.isEdit = supplier != null;

        txtSupplierId = new JTextField(20);
        txtSupplierName = new JTextField(20);
        txtPhone = new JTextField(20);
        txtEmail = new JTextField(20);
        txtAddress = new JTextField(20);

        btnSave = new JButton(isEdit ? "Update" : "Save");
        btnCancel = new JButton("Cancel");

        if (isEdit) {
            supplierId = supplier.getId();
            txtSupplierId.setText(String.valueOf(supplierId));
            txtSupplierName.setText(supplier.getName());
            txtPhone.setText(supplier.getPhoneNumber());
            txtEmail.setText(supplier.getEmail());
            txtAddress.setText(supplier.getAddress());
        }

        controller.setSupplierTable(parentTable);
        initComponents();
        initListeners();
    }

    private void initComponents() {
        setTitle(isEdit ? "Edit Supplier" : "Add New Supplier");
        setSize(450, 400);
        setLocationRelativeTo(getOwner());
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel titleLabel = new JLabel(isEdit ? "Edit Supplier" : "Add New Supplier");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new MigLayout("fillx, insets 0", "[right]10[grow,fill]", "[]15[]15[]15[]15[]"));
        formPanel.setBackground(Color.WHITE);

        if (isEdit) {
            formPanel.add(new JLabel("Supplier ID:"), "");
            txtSupplierId.setEditable(false);
            styleTextField(txtSupplierId);
            formPanel.add(txtSupplierId, "wrap");
        }

        formPanel.add(new JLabel("Name:"), "");
        styleTextField(txtSupplierName);
        formPanel.add(txtSupplierName, "wrap");

        formPanel.add(new JLabel("Phone:"), "");
        styleTextField(txtPhone);
        formPanel.add(txtPhone, "wrap");

        formPanel.add(new JLabel("Email:"), "");
        styleTextField(txtEmail);
        formPanel.add(txtEmail, "wrap");

        formPanel.add(new JLabel("Address:"), "");
        styleTextField(txtAddress);
        formPanel.add(txtAddress, "wrap");

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

    private void initListeners() {
        btnSave.addActionListener(e -> {
            String name = txtSupplierName.getText().trim();
            String phone = txtPhone.getText().trim();
            String email = txtEmail.getText().trim();
            String address = txtAddress.getText().trim();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (isEdit) {
                controller.updateSupplier(supplierId, name,email,address,phone);
            } else {
                controller.addSupplier(supplierId, name, email, address, phone);
            }

            SwingUtilities.invokeLater(() -> controller.loadSuppliers(parentTable));
            dispose();
        });

        btnCancel.addActionListener(e -> dispose());
    }

    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
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
