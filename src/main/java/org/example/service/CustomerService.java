package org.example.service;

import java.util.List;

import org.example.domain.model.CustomerModel;

public interface CustomerService {


    boolean createCustomer(CustomerModel customerModel);
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(Long id);
    boolean updateCustomer(Long id, CustomerModel customerModel);
    boolean deleteCustomer(Long id);
    
}
