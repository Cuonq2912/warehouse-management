/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import org.example.domain.model.CustomerModel;
import org.example.repository.CustomerDAO;
import org.example.utils.ExcelUtils;
import java.util.*;

public class CustomerController {
    private final CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    public void insert(CustomerModel customer) {
        try {
            customerDAO.create(customer);
        } catch (Exception e) {
            throw new RuntimeException("Error saving customer: " + e.getMessage());
        }
    }

    public void update(CustomerModel customer) {
        try {
            customerDAO.update(customer);
        } catch (Exception e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            customerDAO.delete(CustomerModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage());
        }
    }

    public List<CustomerModel> getAll() {
        try {
            return customerDAO.findAll(CustomerModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all customers: " + e.getMessage());
        }
    }

    public List<CustomerModel> search(String searchTerm) {
        try {
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return getAll();
            }
            return customerDAO.findByName(searchTerm.trim());
        } catch (Exception e) {
            throw new RuntimeException("Error searching customers: " + e.getMessage());
        }
    }

    public CustomerModel findById(String id) {
        try {
            return customerDAO.findById(CustomerModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding customer: " + e.getMessage());
        }
    }

    public void exportToExcel(String filePath) {
        try {
            List<CustomerModel> customers = getAll();
            List<String> headers = Arrays.asList("Id", "Name", "Email", "Address", "Phone Number", "Points");
            List<Map<String, Object>> data = new ArrayList<>();

            for (CustomerModel customer : customers) {
                Map<String, Object> row = new HashMap<>();
                row.put("Id", customer.getId());
                row.put("Name", customer.getName());
                row.put("Email", customer.getEmail());
                row.put("Address", customer.getAddress());
                row.put("Phone Number", customer.getPhoneNumber());
                row.put("Points", customer.getPoints());
                data.add(row);
            }

            ExcelUtils.exportToExcel(filePath, "Customers", headers, data);
        } catch (Exception e) {
            throw new RuntimeException("Error exporting to Excel: " + e.getMessage());
        }
    }

}
