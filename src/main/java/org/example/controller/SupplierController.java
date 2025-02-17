/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import org.example.domain.model.SupplierModel;
import org.example.domain.model.UserModel;
import org.example.repository.SupplierDAO;
import org.example.repository.UserDAO;

/**
 *
 * @author ADMIN
 */
public class SupplierController {
    
       private final SupplierDAO supplierDAO;
       
public SupplierController(){
    this.supplierDAO=  new SupplierDAO();
}

 public void insert(SupplierModel a) {
        try {
            supplierDAO.create(a);
        } catch (Exception e) {
            throw new RuntimeException("Error saving  user: " + e.getMessage());
        }
    }
 
  public void update(SupplierModel a) {
        try {
           supplierDAO.update(a);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }
  
     public void delete(Long id) {
        try {
           supplierDAO.delete(SupplierModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
     
        public List<SupplierModel> getAll() {
        try {
            return supplierDAO.findAll(SupplierModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all user: " + e.getMessage());
        }
    }
        
            public List<SupplierModel> search(String searchTerm) {
        try {
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return getAll();
            }
            return supplierDAO.findByName(searchTerm.trim());
        } catch (Exception e) {
            throw new RuntimeException("Error searching customers: " + e.getMessage());
        }
    }

    public SupplierModel findById(Long id) {
        try {           
            return supplierDAO.findById(SupplierModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding customer: " + e.getMessage());
        }
    }
    
}
