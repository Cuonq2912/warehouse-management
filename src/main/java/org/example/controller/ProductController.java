/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import org.example.domain.model.ImportDetailModel;
import org.example.domain.model.ProductModel;
import org.example.repository.ImportProductDAO;
import org.example.repository.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class ProductController {
    
      private final ProductDAO productDAO;
       
public ProductController(){
    this.productDAO=  new ProductDAO();
}

 public void insert(ProductModel product) {
        try {
             productDAO.create(product);
        } catch (Exception e) {
            throw new RuntimeException("Error saving  importproduct: " + e.getMessage());
        }
    }
 
  public void update(ProductModel product) {
        try {
            productDAO.update(product);
        } catch (Exception e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage());
        }
    }
  
     public void delete(Long id) {
        try {
            productDAO.delete(ProductModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage());
        }
    }
     
        public List<ProductModel> getAll() {
        try {
            return productDAO.findAll(ProductModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all customers: " + e.getMessage());
        }
    }
        
//            public List<ProductModel> search(String searchTerm) {
//        try {
//            if (searchTerm == null || searchTerm.trim().isEmpty()) {
//                return getAll();
//            }
//            return productDAO.findByName(searchTerm.trim());
//        } catch (Exception e) {
//            throw new RuntimeException("Error searching customers: " + e.getMessage());
//        }
//    }

    public ProductModel findById(Long id) {
        try {
            return productDAO.findById(ProductModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding customer: " + e.getMessage());
        }
    }
    
}
