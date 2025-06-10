package org.example.view.component.ImportProductComponent;

import org.example.constant.CommonMessage;
import org.example.constant.ErrorMessage;
import org.example.controller.ImportProductController;
import org.example.domain.model.*;
import org.example.utils.SessionManager;
import org.example.utils.ValidateUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImportProductFormDialog extends JDialog {
    private final ImportProductController importProductController;
    private ImportProductModel importProductModel;

    private JTextField txtImportDate;
    private JComboBox<UserModel> cmbUser;
    private JComboBox<SupplierModel> cmbSupplier;
    private JComboBox<ProductModel> cmbProduct;
    private JTextField txtQuantity;
    private JTextField txtPrice;
    private JButton btnSave;
    private JButton btnCancel;

    public ImportProductFormDialog(Window parent, ImportProductController importProductController) {
        super(parent, CommonMessage.ImportProduct.DIALOG_TITLE_ADD, Dialog.ModalityType.APPLICATION_MODAL);
        this.importProductController = importProductController;
        this.importProductModel = null;
        initComponents();
        loadComboBoxData();
        setLocationRelativeTo(parent);
    }

    public ImportProductFormDialog(Window parent, ImportProductController importProductController,
            ImportProductModel importProductModel) {
        super(parent, CommonMessage.ImportProduct.DIALOG_TITLE_EDIT, Dialog.ModalityType.APPLICATION_MODAL);
        this.importProductController = importProductController;
        this.importProductModel = importProductModel;
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
        formPanel.add(new JLabel("Import Date:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtImportDate = new JTextField();
        txtImportDate.setText(LocalDate.now().toString());
        txtImportDate.setEditable(false);
        txtImportDate.setBackground(new Color(240, 240, 240));
        styleTextField(txtImportDate);
        formPanel.add(txtImportDate, gbc);

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
        formPanel.add(new JLabel("Supplier:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        cmbSupplier = new JComboBox<>();
        styleComboBox(cmbSupplier);
        formPanel.add(cmbSupplier, gbc);

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
        btnSave.addActionListener(this::saveImportProduct);
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
        List<UserModel> users = importProductController.getAllUsers();
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

        List<SupplierModel> suppliers = importProductController.getAllSuppliers();
        cmbSupplier.removeAllItems();
        for (SupplierModel supplier : suppliers) {
            cmbSupplier.addItem(supplier);
        }
        cmbSupplier.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof SupplierModel) {
                    value = ((SupplierModel) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        List<ProductModel> products = importProductController.getAllProducts();
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
        if (importProductModel != null) {
            txtImportDate.setText(importProductModel.getImportDate().toString());

            if (importProductModel.getUserModel() != null) {
                for (int i = 0; i < cmbUser.getItemCount(); i++) {
                    UserModel user = cmbUser.getItemAt(i);
                    if (user.getId().equals(importProductModel.getUserModel().getId())) {
                        cmbUser.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (importProductModel.getSupplierModel() != null) {
                for (int i = 0; i < cmbSupplier.getItemCount(); i++) {
                    SupplierModel supplier = cmbSupplier.getItemAt(i);
                    if (supplier.getId().equals(importProductModel.getSupplierModel().getId())) {
                        cmbSupplier.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (importProductModel.getImportDetails() != null && !importProductModel.getImportDetails().isEmpty()) {
                ImportDetailModel firstDetail = importProductModel.getImportDetails().get(0);

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

    private void saveImportProduct(ActionEvent e) {
        try {
            // Use ValidateUtil to validate form
            ValidateUtil.ValidationResult validationResult = importProductController.validateImportProductForm(
                    (SupplierModel) cmbSupplier.getSelectedItem(),
                    (ProductModel) cmbProduct.getSelectedItem(),
                    txtQuantity.getText(),
                    txtPrice.getText());

            if (!validationResult.isValid()) {
                importProductController.showErrorMessage(this, validationResult.getErrorMessage());
                return;
            }

            // Parse validated data
            long quantity = Long.parseLong(txtQuantity.getText().trim());
            LocalDate importDate = LocalDate.parse(txtImportDate.getText().trim());
            UserModel selectedUser = (UserModel) cmbUser.getSelectedItem();
            SupplierModel selectedSupplier = (SupplierModel) cmbSupplier.getSelectedItem();
            ProductModel selectedProduct = (ProductModel) cmbProduct.getSelectedItem();

            ImportDetailModel detail = ImportDetailModel.builder()
                    .productModel(selectedProduct)
                    .quantity(quantity)
                    .build();

            List<ImportDetailModel> detailsList = new ArrayList<>();
            detailsList.add(detail);

            boolean success;
            if (importProductModel == null) {
                success = importProductController.createImportProduct(importDate, selectedUser, selectedSupplier,
                        detailsList);
            } else {
                success = importProductController.updateImportProduct(importProductModel.getId(), importDate,
                        selectedUser, selectedSupplier, detailsList);
            }

            if (success) {
                String successMessage = importProductModel == null ? CommonMessage.ImportProduct.SUCCESS_CREATE
                        : CommonMessage.ImportProduct.SUCCESS_UPDATE;
                importProductController.showSuccessMessage(this, successMessage);
                dispose();
            } else {
                String errorMessage = importProductModel == null ? ErrorMessage.ImportProduct.ERR_CREATE_FAILED
                        : ErrorMessage.ImportProduct.ERR_UPDATE_FAILED;
                importProductController.showErrorDialog(this, errorMessage);
            }
        } catch (Exception ex) {
            String errorMessage = String.format(ErrorMessage.ImportProduct.ERR_SAVE_FAILED, ex.getMessage());
            importProductController.showErrorDialog(this, errorMessage);
        }
    }

    private void cancelAction(java.awt.event.ActionEvent e) {
        dispose();
    }
}