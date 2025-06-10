package org.example.view.component.ExportProductComponent;

import org.example.constant.CommonMessage;
import org.example.constant.ErrorMessage;
import org.example.controller.ExportProductController;
import org.example.domain.model.*;
import org.example.utils.SessionManager;
import org.example.utils.ValidateUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExportProductFormDialog extends JDialog {
    private final ExportProductController exportProductController;
    private ExportProductModel exportProductModel;

    private JTextField txtExportDate;
    private JComboBox<UserModel> cmbUser;
    private JComboBox<CustomerModel> cmbCustomer;
    private JComboBox<ProductModel> cmbProduct;
    private JTextField txtQuantity;
    private JTextField txtPrice;
    private JButton btnSave;
    private JButton btnCancel;

    public ExportProductFormDialog(Window parent, ExportProductController exportProductController) {
        super(parent, CommonMessage.ExportProduct.DIALOG_TITLE_ADD, Dialog.ModalityType.APPLICATION_MODAL);
        this.exportProductController = exportProductController;
        this.exportProductModel = null;
        initComponents();
        loadComboBoxData();
        setLocationRelativeTo(parent);
    }

    public ExportProductFormDialog(Window parent, ExportProductController exportProductController,
            ExportProductModel exportProductModel) {
        super(parent, CommonMessage.ExportProduct.DIALOG_TITLE_EDIT, Dialog.ModalityType.APPLICATION_MODAL);
        this.exportProductController = exportProductController;
        this.exportProductModel = exportProductModel;
        initComponents();
        loadComboBoxData();
        populateFields();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        formPanel.add(new JLabel("Export Date:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtExportDate = new JTextField();
        txtExportDate.setText(LocalDate.now().toString());
        txtExportDate.setEditable(false);
        txtExportDate.setBackground(new Color(240, 240, 240));
        styleTextField(txtExportDate);
        formPanel.add(txtExportDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(new JLabel("User:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        cmbUser = new JComboBox<>();
        cmbUser.setEnabled(false);
        styleComboBox(cmbUser);
        formPanel.add(cmbUser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Customer:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        cmbCustomer = new JComboBox<>();
        styleComboBox(cmbCustomer);
        formPanel.add(cmbCustomer, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Product:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        cmbProduct = new JComboBox<>();
        styleComboBox(cmbProduct);
        formPanel.add(cmbProduct, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Quantity:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtQuantity = new JTextField();
        styleTextField(txtQuantity);
        formPanel.add(txtQuantity, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Price:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtPrice = new JTextField();
        styleTextField(txtPrice);
        formPanel.add(txtPrice, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        btnSave = new JButton("Save");
        styleButton(btnSave, new Color(92, 184, 92));
        btnSave.addActionListener(this::saveExportProduct);
        btnCancel = new JButton("Cancel");
        styleButton(btnCancel, new Color(217, 83, 79));
        btnCancel.addActionListener(this::cancelAction);

        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void styleTextField(JTextField field) {
        field.setPreferredSize(new Dimension(200, 30));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setPreferredSize(new Dimension(200, 30));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1),
                BorderFactory.createEmptyBorder(0, 5, 0, 5)));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 35));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void loadComboBoxData() {
        List<UserModel> users = exportProductController.getAllUsers();
        cmbUser.removeAllItems();
        for (UserModel user : users) {
            cmbUser.addItem(user);
        }
        cmbUser.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof UserModel) {
                    value = ((UserModel) value).getFullName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        UserModel currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser != null) {
            for (int i = 0; i < cmbUser.getItemCount(); i++) {
                UserModel user = cmbUser.getItemAt(i);
                if (user.getId().equals(currentUser.getId())) {
                    cmbUser.setSelectedIndex(i);
                    break;
                }
            }
        }

        List<CustomerModel> customers = exportProductController.getAllCustomers();
        cmbCustomer.removeAllItems();
        for (CustomerModel customer : customers) {
            cmbCustomer.addItem(customer);
        }
        cmbCustomer.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof CustomerModel) {
                    value = ((CustomerModel) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        List<ProductModel> products = exportProductController.getAllProducts();
        cmbProduct.removeAllItems();
        for (ProductModel product : products) {
            cmbProduct.addItem(product);
        }
        cmbProduct.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof ProductModel) {
                    value = ((ProductModel) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    private void populateFields() {
        if (exportProductModel != null) {
            txtExportDate.setText(exportProductModel.getExportDate().toString());

            if (exportProductModel.getUserModel() != null) {
                for (int i = 0; i < cmbUser.getItemCount(); i++) {
                    UserModel user = cmbUser.getItemAt(i);
                    if (user.getId().equals(exportProductModel.getUserModel().getId())) {
                        cmbUser.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (exportProductModel.getCustomerModel() != null) {
                for (int i = 0; i < cmbCustomer.getItemCount(); i++) {
                    CustomerModel customer = cmbCustomer.getItemAt(i);
                    if (customer.getId().equals(exportProductModel.getCustomerModel().getId())) {
                        cmbCustomer.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (exportProductModel.getExportDetailModel() != null
                    && !exportProductModel.getExportDetailModel().isEmpty()) {
                ExportDetailModel firstDetail = exportProductModel.getExportDetailModel().get(0);

                // Set product
                ProductModel detailProduct = firstDetail.getProductModel();
                for (int i = 0; i < cmbProduct.getItemCount(); i++) {
                    ProductModel product = cmbProduct.getItemAt(i);
                    if (product.getId().equals(detailProduct.getId())) {
                        cmbProduct.setSelectedIndex(i);
                        break;
                    }
                }

                txtQuantity.setText(String.valueOf(firstDetail.getQuantity()));
                txtPrice.setText(String.valueOf(detailProduct.getPrice()));
            }
        }
    }

    private void saveExportProduct(java.awt.event.ActionEvent e) {
        try {
            // Sử dụng ValidateUtil để validate form
            ValidateUtil.ValidationResult validationResult = exportProductController.validateExportProductForm(
                    (CustomerModel) cmbCustomer.getSelectedItem(),
                    (ProductModel) cmbProduct.getSelectedItem(),
                    txtQuantity.getText(),
                    txtPrice.getText());

            if (!validationResult.isValid()) {
                exportProductController.showErrorMessage(this, validationResult.getErrorMessage());
                return;
            } // Parse validated data
            long quantity = Long.parseLong(txtQuantity.getText().trim());

            ProductModel selectedProduct = (ProductModel) cmbProduct.getSelectedItem();

            // Validate stock availability
            ValidateUtil.ValidationResult stockValidation = exportProductController
                    .validateStockAvailability(selectedProduct, quantity);
            if (!stockValidation.isValid()) {
                exportProductController.showStockErrorMessage(this, stockValidation.getErrorMessage());
                return;
            }

            LocalDate exportDate = LocalDate.parse(txtExportDate.getText().trim());
            UserModel selectedUser = (UserModel) cmbUser.getSelectedItem();
            CustomerModel selectedCustomer = (CustomerModel) cmbCustomer.getSelectedItem();

            ExportDetailModel detail = ExportDetailModel.builder()
                    .productModel(selectedProduct)
                    .quantity(quantity)
                    .build();

            List<ExportDetailModel> detailsList = new ArrayList<>();
            detailsList.add(detail);

            boolean success;
            if (exportProductModel == null) {
                success = exportProductController.createExportProduct(exportDate, selectedUser, selectedCustomer,
                        detailsList);
            } else {
                success = exportProductController.updateExportProduct(exportProductModel.getId(), exportDate,
                        selectedUser, selectedCustomer, detailsList);
            }

            if (success) {
                String successMessage = exportProductModel == null ? CommonMessage.ExportProduct.SUCCESS_CREATE
                        : CommonMessage.ExportProduct.SUCCESS_UPDATE;
                exportProductController.showSuccessMessage(this, successMessage);
                dispose();
            } else {
                String errorMessage = exportProductModel == null ? ErrorMessage.ExportProduct.ERR_CREATE_FAILED
                        : ErrorMessage.ExportProduct.ERR_UPDATE_FAILED;
                exportProductController.showErrorDialog(this, errorMessage);
            }

        } catch (Exception ex) {
            String errorMessage = String.format(ErrorMessage.ExportProduct.ERR_SAVE_FAILED, ex.getMessage());
            exportProductController.showErrorDialog(this, errorMessage);
        }
    }

    private void cancelAction(java.awt.event.ActionEvent e) {
        dispose();
    }
}