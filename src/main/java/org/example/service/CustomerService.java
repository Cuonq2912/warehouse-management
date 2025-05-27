package org.example.service;

import org.example.domain.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    boolean createCustomer(CustomerModel customerModel);
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(Long id);
    boolean updateCustomer(Long id, CustomerModel customerModel);
    boolean deleteCustomer(Long id);

}
