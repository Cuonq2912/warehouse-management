package org.example.controller;

import org.example.constant.CommonMessage;
import org.example.constant.ErrorMessage;
import org.example.domain.model.*;
import org.example.service.*;
import org.example.service.impl.*;
import org.example.utils.ValidateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

public class ImportProductController {

    private final ImportProductService importProductService;
    private final UserService userService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private JTable importTable;

    public ImportProductController() {
        this.importProductService = new ImportProductServiceImpl();
        this.userService = new UserServiceImpl();
        this.supplierService = new SupplierServiceImpl();
        this.productService = new ProductServiceImpl();
    }

    public void setImportTable(JTable table) {
        this.importTable = table;
    }

    public void loadImportProducts(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<ImportProductModel> imports = importProductService.getAllImportProducts();
        for (ImportProductModel importProduct : imports) {
            StringBuilder productDetails = new StringBuilder();
            int totalQuantity = 0;

            for (ImportDetailModel detail : importProduct.getImportDetails()) {
                productDetails.append(detail.getProductModel().getName());
                totalQuantity += detail.getQuantity();
            }

            double totalValue = calculateTotalValue(importProduct.getImportDetails());

            Object[] row = {
                    importProduct.getId(),
                    importProduct.getImportDate(),
                    importProduct.getUserModel().getFullName(),
                    importProduct.getSupplierModel().getName(),
                    productDetails.toString(),
                    totalQuantity,
                    String.format("%.2f", totalValue)
            };
            model.addRow(row);
        }
    }

    public void searchImportProducts(String searchTerm, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<ImportProductModel> imports = importProductService.searchImportProducts(searchTerm);
        for (ImportProductModel importProduct : imports) {
            StringBuilder productDetails = new StringBuilder();
            int totalQuantity = 0;

            for (ImportDetailModel detail : importProduct.getImportDetails()) {
                if (productDetails.length() > 0) {
                    productDetails.append(", ");
                }
                productDetails.append(detail.getProductModel().getName());
                totalQuantity += detail.getQuantity();
            }

            double totalValue = calculateTotalValue(importProduct.getImportDetails());

            Object[] row = {
                    importProduct.getId(),
                    importProduct.getImportDate(),
                    importProduct.getUserModel().getFullName(),
                    importProduct.getSupplierModel().getName(),
                    productDetails.toString(),
                    totalQuantity,
                    String.format("%.2f", totalValue)
            };
            model.addRow(row);
        }
    }

    public boolean createImportProduct(LocalDate importDate, UserModel user, SupplierModel supplier,
            List<ImportDetailModel> details) {
        ImportProductModel importProduct = ImportProductModel.builder()
                .importDate(importDate)
                .userModel(user)
                .supplierModel(supplier)
                .importDetails(details)
                .build();

        for (ImportDetailModel detail : details) {
            detail.setImportProductModel(importProduct);
        }

        boolean success = importProductService.createImportProduct(importProduct);
        return success;
    }

    public boolean updateImportProduct(Long id, LocalDate importDate, UserModel user, SupplierModel supplier,
            List<ImportDetailModel> details) {
        ImportProductModel importProduct = ImportProductModel.builder()
                .id(id)
                .importDate(importDate)
                .userModel(user)
                .supplierModel(supplier)
                .importDetails(details)
                .build();

        for (ImportDetailModel detail : details) {
            detail.setImportProductModel(importProduct);
        }

        boolean success = importProductService.updateImportProduct(id, importProduct);
        return success;
    }

    public boolean deleteImportProduct(Long id) {
        boolean success = importProductService.deleteImportProduct(id);
        return success;
    }

    public ImportProductModel getImportProductById(Long id) {
        return importProductService.getImportProductById(id);
    }

    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    public List<SupplierModel> getAllSuppliers() {
        return supplierService.getAllSupplier();
    }

    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    public List<ImportProductModel> getAllImportProducts() {
        return importProductService.getAllImportProducts();
    }

    public ValidateUtil.ValidationResult validateImportProductForm(SupplierModel supplier, ProductModel product,
            String quantityText, String priceText) {
        if (supplier == null) {
            return ValidateUtil.ValidationResult.error(ErrorMessage.ImportProduct.ERR_SUPPLIER_NOT_SELECTED);
        }

        if (product == null) {
            return ValidateUtil.ValidationResult.error(ErrorMessage.ImportProduct.ERR_PRODUCT_NOT_SELECTED);
        }

        ValidateUtil.ValidationResult quantityResult = ValidateUtil.validateQuantity(quantityText);
        if (!quantityResult.isValid()) {
            return quantityResult;
        }

        ValidateUtil.ValidationResult priceResult = ValidateUtil.validatePrice(priceText);
        if (!priceResult.isValid()) {
            return priceResult;
        }

        return ValidateUtil.ValidationResult.success();
    }

    public void showErrorMessage(JDialog parent, String message) {
        JOptionPane.showMessageDialog(parent, message, CommonMessage.VALIDATION_ERROR_TITLE,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessMessage(JDialog parent, String message) {
        JOptionPane.showMessageDialog(parent, message, CommonMessage.SUCCESS_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorDialog(JDialog parent, String message) {
        JOptionPane.showMessageDialog(parent, message, CommonMessage.ERROR_TITLE,
                JOptionPane.ERROR_MESSAGE);
    }

    public double calculateTotalValue(List<ImportDetailModel> importDetails) {
        if (importDetails == null || importDetails.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (ImportDetailModel detail : importDetails) {
            total += detail.getProductModel().getPrice() * detail.getQuantity();
        }
        return total;
    }
}
