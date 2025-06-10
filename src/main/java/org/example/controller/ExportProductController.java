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

public class ExportProductController {

    private final ExportProductService exportProductService;
    private final UserService userService;
    private final CustomerService customerService;
    private final ProductService productService;
    private JTable exportTable;

    public ExportProductController() {
        this.exportProductService = new ExportProductServiceImpl();
        this.userService = new UserServiceImpl();
        this.customerService = new CustomerServiceImpl();
        this.productService = new ProductServiceImpl();
    }

    public void setExportTable(JTable table) {
        this.exportTable = table;
    }

    public void loadExportProducts(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<ExportProductModel> exports = exportProductService.getAllExportProducts();
        for (ExportProductModel exportProduct : exports) {
            StringBuilder productDetails = new StringBuilder();
            int totalQuantity = 0;

            for (ExportDetailModel detail : exportProduct.getExportDetailModel()) {
                if (productDetails.length() > 0) {
                    productDetails.append(", ");
                }
                productDetails.append(detail.getProductModel().getName())
                        .append(" (")
                        .append(detail.getQuantity())
                        .append(")");
                totalQuantity += detail.getQuantity();
            }

            double totalValue = calculateTotalValue(exportProduct.getExportDetailModel());

            Object[] row = {
                    exportProduct.getId(),
                    exportProduct.getExportDate(),
                    exportProduct.getUserModel().getFullName(),
                    exportProduct.getCustomerModel().getName(),
                    productDetails.toString(),
                    totalQuantity,
                    String.format("%.2f", totalValue)
            };
            model.addRow(row);
        }
    }

    public void searchExportProducts(String searchTerm, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<ExportProductModel> exports = exportProductService.searchExportProducts(searchTerm);
        for (ExportProductModel exportProduct : exports) {
            StringBuilder productDetails = new StringBuilder();
            int totalQuantity = 0;

            for (ExportDetailModel detail : exportProduct.getExportDetailModel()) {
                if (productDetails.length() > 0) {
                    productDetails.append(", ");
                }
                productDetails.append(detail.getProductModel().getName())
                        .append(" (")
                        .append(detail.getQuantity())
                        .append(")");
                totalQuantity += detail.getQuantity();
            }

            double totalValue = calculateTotalValue(exportProduct.getExportDetailModel());

            Object[] row = {
                    exportProduct.getId(),
                    exportProduct.getExportDate(),
                    exportProduct.getUserModel().getFullName(),
                    exportProduct.getCustomerModel().getName(),
                    productDetails.toString(),
                    totalQuantity,
                    String.format("%.2f", totalValue)
            };
            model.addRow(row);
        }
    }

    public boolean createExportProduct(LocalDate exportDate, UserModel user, CustomerModel customer,
            List<ExportDetailModel> details) {
        ExportProductModel exportProduct = ExportProductModel.builder()
                .exportDate(exportDate)
                .userModel(user)
                .customerModel(customer)
                .exportDetailModel(details)
                .build();

        for (ExportDetailModel detail : details) {
            detail.setExportProductModel(exportProduct);
        }

        boolean success = exportProductService.createExportProduct(exportProduct);

        return success;
    }

    public boolean updateExportProduct(Long id, LocalDate exportDate, UserModel user, CustomerModel customer,
            List<ExportDetailModel> details) {
        ExportProductModel exportProduct = ExportProductModel.builder()
                .id(id)
                .exportDate(exportDate)
                .userModel(user)
                .customerModel(customer)
                .exportDetailModel(details)
                .build();

        for (ExportDetailModel detail : details) {
            detail.setExportProductModel(exportProduct);
        }

        boolean success = exportProductService.updateExportProduct(id, exportProduct);

        return success;
    }

    public boolean deleteExportProduct(Long id) {
        boolean success = exportProductService.deleteExportProduct(id);
        return success;
    }

    public ExportProductModel getExportProductById(Long id) {
        return exportProductService.getExportProductById(id);
    }

    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    public List<ExportProductModel> getAllExportProducts() {
        return exportProductService.getAllExportProducts();
    }

    public String formatProductDetails(List<ExportDetailModel> exportDetails) {
        if (exportDetails == null || exportDetails.isEmpty()) {
            return "No products";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exportDetails.size(); i++) {
            ExportDetailModel detail = exportDetails.get(i);
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(detail.getProductModel().getName())
                    .append(" (Qty: ")
                    .append(detail.getQuantity())
                    .append(")");
        }
        return sb.toString();
    }

    public String formatTotalAmount(List<ExportDetailModel> exportDetails) {
        return String.format("$%.2f", calculateTotalValue(exportDetails));
    }

    public double calculateTotalValue(List<ExportDetailModel> exportDetails) {
        if (exportDetails == null || exportDetails.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (ExportDetailModel detail : exportDetails) {
            total += detail.getProductModel().getPrice() * detail.getQuantity();
        }
        return total;
    }
    public ValidateUtil.ValidationResult validateExportProductForm(CustomerModel customer, ProductModel product,
            String quantityText, String priceText) {
        if (customer == null) {
            return ValidateUtil.ValidationResult.error(ErrorMessage.ExportProduct.ERR_CUSTOMER_NOT_SELECTED);
        }

        if (product == null) {
            return ValidateUtil.ValidationResult.error(ErrorMessage.ExportProduct.ERR_PRODUCT_NOT_SELECTED);
        }

        ValidateUtil.ValidationResult quantityResult = ValidateUtil.validateExportQuantity(quantityText);
        if (!quantityResult.isValid()) {
            return quantityResult;
        }

        ValidateUtil.ValidationResult priceResult = ValidateUtil.validateExportPrice(priceText);
        if (!priceResult.isValid()) {
            return priceResult;
        }

        return ValidateUtil.ValidationResult.success();
    }

    public ValidateUtil.ValidationResult validateStockAvailability(ProductModel product, long requestedQuantity) {
        if (requestedQuantity > product.getRemainingQuantity()) {
            String message = String.format(ErrorMessage.ExportProduct.ERR_INSUFFICIENT_STOCK,
                    product.getRemainingQuantity(), requestedQuantity);
            return ValidateUtil.ValidationResult.error(message);
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

    public void showStockErrorMessage(JDialog parent, String message) {
        JOptionPane.showMessageDialog(parent, message, CommonMessage.STOCK_ERROR_TITLE,
                JOptionPane.ERROR_MESSAGE);
    }
}
