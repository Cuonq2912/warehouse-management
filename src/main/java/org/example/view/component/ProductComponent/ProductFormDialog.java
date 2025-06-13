package org.example.view.component.ProductComponent;

import org.example.controller.ProductController;
import org.example.domain.model.CategoryModel;
import org.example.domain.model.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ProductFormDialog extends JDialog {

    private final ProductController productController;
    private ProductModel productModel;

    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtRemainingQuantity;
    private JTextField txtSoldQuantity;
    private JComboBox<CategoryModel> cmbCategory;
    private JButton btnSave;
    private JButton btnCancel;

    public ProductFormDialog(Frame parent, boolean modal, ProductController productController) {
        super(parent, modal);
        this.productController = productController;
        this.productModel = null;
        initComponents();
        loadCategories();
    }

    public ProductFormDialog(Frame parent, boolean modal, ProductController productController,
            ProductModel productModel) {
        super(parent, modal);
        this.productController = productController;
        this.productModel = productModel;
        initComponents();
        loadCategories();
        populateFields();
    }

    private void initComponents() {
        setTitle("Product Form");
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 20));
        formPanel.setBackground(Color.WHITE);

        JLabel lblName = new JLabel("Product Name:");
        txtName = new JTextField();
        styleTextField(txtName);

        JLabel lblPrice = new JLabel("Price:");
        txtPrice = new JTextField();
        styleTextField(txtPrice);

        JLabel lblRemainingQuantity = new JLabel("Remaining Quantity:");
        txtRemainingQuantity = new JTextField();
        styleTextField(txtRemainingQuantity);

        JLabel lblSoldQuantity = new JLabel("Sold Quantity:");
        txtSoldQuantity = new JTextField();
        styleTextField(txtSoldQuantity);

        JLabel lblCategory = new JLabel("Category:");
        cmbCategory = new JComboBox<>();
        styleComboBox(cmbCategory);

        formPanel.add(lblName);
        formPanel.add(txtName);
        formPanel.add(lblPrice);
        formPanel.add(txtPrice);
        formPanel.add(lblRemainingQuantity);
        formPanel.add(txtRemainingQuantity);
        formPanel.add(lblSoldQuantity);
        formPanel.add(txtSoldQuantity);
        formPanel.add(lblCategory);
        formPanel.add(cmbCategory);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(Color.WHITE);

        btnSave = new JButton("Save");
        styleButton(btnSave, new Color(92, 184, 92));

        btnCancel = new JButton("Cancel");
        styleButton(btnCancel, new Color(217, 83, 79));

        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        mainPanel.add(new JLabel("Enter Product Details"), BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void styleTextField(JTextField field) {
        field.setPreferredSize(new Dimension(200, 30));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setPreferredSize(new Dimension(200, 30));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(0, 5, 0, 5)));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 35));
    }

    private void loadCategories() {
        List<CategoryModel> categories = productController.getAllCategories();
        cmbCategory.removeAllItems();
        for (CategoryModel category : categories) {
            cmbCategory.addItem(category);
        }

        cmbCategory.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof CategoryModel) {
                    value = ((CategoryModel) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    private void populateFields() {
        if (productModel != null) {
            txtName.setText(productModel.getName());
            txtPrice.setText(String.valueOf(productModel.getPrice()));
            txtRemainingQuantity.setText(String.valueOf(productModel.getRemainingQuantity()));
            txtSoldQuantity.setText(String.valueOf(productModel.getSoldQuantity()));

            if (productModel.getCategoryModel() != null) {
                for (int i = 0; i < cmbCategory.getItemCount(); i++) {
                    CategoryModel category = cmbCategory.getItemAt(i);
                    if (category.getId().equals(productModel.getCategoryModel().getId())) {
                        cmbCategory.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }

    private void saveProduct() {
        try {
            String name = txtName.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price;
            try {
                price = Double.parseDouble(txtPrice.getText().trim());
                if (price < 0) {
                    JOptionPane.showMessageDialog(this, "Giá sản phẩm không được phép âm!", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá của sản phẩm!", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            long remainingQty;
            try {
                remainingQty = Long.parseLong(txtRemainingQuantity.getText().trim());
                if (remainingQty < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng tồn kho không được phép âm", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng tồn kho hợp lệ!", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            long soldQty;
            try {
                soldQty = Long.parseLong(txtSoldQuantity.getText().trim());
                if (soldQty < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng đã bán không được phép âm!", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Nhập số lượng đã bán hợp lệ", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            CategoryModel selectedCategory = (CategoryModel) cmbCategory.getSelectedItem();
            if (selectedCategory == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn thể loại!", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (productModel == null) {
                productModel = new ProductModel();
                productModel.setCreatedAt(LocalDate.now());
            }

            productModel.setName(name);
            productModel.setPrice(price);
            productModel.setRemainingQuantity(remainingQty);
            productModel.setSoldQuantity(soldQty);
            productModel.setCategoryModel(selectedCategory);

            boolean success = productController.saveProduct(productModel);

            if (success) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
