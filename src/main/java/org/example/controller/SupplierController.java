package org.example.controller;


import org.example.domain.model.SupplierModel;
import org.example.service.SupplierService;
import org.example.service.impl.SupplierServiceImpl;
import org.example.view.component.SupplierComponent.SupplierPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;
import org.example.domain.model.CategoryModel;

public class SupplierController {

    private final SupplierService supplierService;
    private JComponent viewComponent;
    private JTable supplierTable;

    public SupplierController() {
        this.supplierService = new SupplierServiceImpl();
    }

    public void setSupplierTable(JTable supplierTable) {
        this.supplierTable = supplierTable;
    }

    public void setView(SupplierPanel panel) {
        this.viewComponent = panel;
        this.supplierTable = panel.getTblSuppliers();
    }

    public void loadSuppliers(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<SupplierModel> suppliers = supplierService.getAllSupplier();
        for (SupplierModel supplier : suppliers) {
            model.addRow(new Object[]{
                    supplier.getId(),
                    supplier.getName(),
                    supplier.getEmail(),
                    supplier.getPhoneNumber(),
                    supplier.getAddress()
            });
        }
    }

    public void searchSuppliers(String searchTerm, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (searchTerm == null || searchTerm.isEmpty()) {
            loadSuppliers(table);
            return;
        }

        List<SupplierModel> suppliers = supplierService.getAllSupplier();
        List<SupplierModel> filteredSuppliers = suppliers.stream()
                .filter(supplier ->
                        supplier.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        supplier.getEmail().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        supplier.getPhoneNumber().toLowerCase().contains(searchTerm.toLowerCase()))
                .toList();

        for (SupplierModel supplier : filteredSuppliers) {
            model.addRow(new Object[]{
                    supplier.getId(),
                    supplier.getName(),
                    supplier.getEmail(),
                    supplier.getPhoneNumber(),
                    supplier.getAddress()
            });
        }
    }

    public void addSupplier(Long supplierId, String name, String email, String address, String phone) {
            SupplierModel supplierModel = new SupplierModel();
        supplierModel.setName(name);
        supplierModel.setEmail(email);
        supplierModel.setAddress(address);
        supplierModel.setPhoneNumber(phone);

        boolean success = supplierService.createSupplier(supplierModel);
        if (success) {
            JOptionPane.showMessageDialog(viewComponent, "Thêm nhà cung cấp thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            if (supplierTable != null) {
                loadSuppliers(supplierTable);
            }
        } else {
            JOptionPane.showMessageDialog(viewComponent, "Thêm nhà cung cấp thất bại", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateSupplier(Long id, String name, String email, String address, String phone) {
        SupplierModel supplierModel = supplierService.getSupplierById(id);
        if (supplierModel != null) {
            supplierModel.setName(name);
            supplierModel.setEmail(email);
            supplierModel.setAddress(address);
            supplierModel.setPhoneNumber(phone);
            
            boolean success = supplierService.updateSupplier(id, supplierModel);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Cập nhật nhà cung cấp thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadSuppliers(supplierTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Cập nhật nhà cung cấp thất bại", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteSupplier(Long id) {
        int confirm = JOptionPane.showConfirmDialog(viewComponent,
                "Bạn có chắc chắn muốn xóa nhà cung cấp này?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = supplierService.deleteSupplier(id);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Xóa nhà cung cấp thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadSuppliers(supplierTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Xóa nhà cung cấp thất bại", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public SupplierModel getSupplierById(Long id) {
        return supplierService.getSupplierById(id);
    }
}