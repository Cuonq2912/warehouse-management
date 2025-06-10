package org.example.service.impl;

import org.example.domain.model.CustomerModel;
import org.example.repository.CustomerDAO;
import org.example.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public boolean createCustomer(CustomerModel customerModel) {
        try {
            customerDAO.create(customerModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        List<CustomerModel> customerModels = new ArrayList<>();
        try {
            customerModels = customerDAO.getAllCustomers();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return customerModels;
    }

    @Override
    public CustomerModel getCustomerById(Long id) {
        CustomerModel customerModel = new CustomerModel();
        try {
            customerModel = customerDAO.getCustomerById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return customerModel;
    }

    @Override
    public boolean updateCustomer(Long id, CustomerModel customerModel) {
        try {
            customerDAO.update(id, customerModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {
        try {
            customerDAO.delete(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}