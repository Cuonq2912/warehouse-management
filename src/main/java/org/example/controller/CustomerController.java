package org.example.controller;

import org.example.domain.model.CustomerModel;
import org.example.service.CustomerService;
import org.example.service.impl.CustomerServiceImpl;
import org.example.view.component.CustomerComponent.CustomerPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

public class CustomerController {

    private final CustomerService customerService;
    private JComponent viewComponent;
    private JTable customerTable;

    public void setCustomerTable(JTable customerTable) {
        this.customerTable = customerTable;
    }

    public CustomerController() {
        this.customerService = new CustomerServiceImpl();
    }

    public void setView(CustomerPanel panel) {
        this.viewComponent = panel;
        this.customerTable = panel.getTblCustomers();
    }

    public void loadCustomers(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<CustomerModel> customers = customerService.getAllCustomers();
        for (CustomerModel customer : customers) {
            model.addRow(new Object[]{
                    customer.getId(),
                    customer.getName(),
            });
        }
    }

    public void searchCustomers(String searchTerm, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (searchTerm == null || searchTerm.isEmpty()) {
            loadCustomers(table);
            return;
        }

        List<CustomerModel> customers = customerService.getAllCustomers();
        List<CustomerModel> filteredCustomers = customers.stream()
                .filter(customer ->
                        customer.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .toList();

        for (CustomerModel customer : filteredCustomers) {
            model.addRow(new Object[]{
                    customer.getId(),
                    customer.getName(),
            });
        }
    }

    public void addCustomer(String name) {
        CustomerModel customer = new CustomerModel();
        customer.setName(name);

        boolean success = customerService.createCustomer(customer);
        if (success) {
            JOptionPane.showMessageDialog(viewComponent, "Thêm khách hàng thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            if (customerTable != null) {
                loadCustomers(customerTable);
            }
        } else {
            JOptionPane.showMessageDialog(viewComponent, "Thêm khách hàng thất bại", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCustomer(Long id, String name) {
        CustomerModel customer = customerService.getCustomerById(id);
        if (customer != null) {
            customer.setName(name);

            boolean success = customerService.updateCustomer(id, customer);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Cập nhật khách hàng thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadCustomers(customerTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Cập nhật khách hàng thất bại", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteCustomer(Long id) {
        int confirm = JOptionPane.showConfirmDialog(viewComponent,
                "Bạn có chắc chắn muốn xóa khách hàng này không?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = customerService.deleteCustomer(id);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Xóa khách hàng thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadCustomers(customerTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Xóa khách hàng thất bại", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public CustomerModel getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }
}
