/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;


import java.util.List;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;

/**
 *
 * @author ADMIN
 */
public class UserController {
    
    private final UserDAO userDAO;
       
public UserController(){
    this.userDAO=  new UserDAO();
}

 public void insert(UserModel user) {
        try {
            userDAO.create(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving  user: " + e.getMessage());
        }
    }
 
  public void update(UserModel user) {
        try {
            userDAO.update(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }
  
     public void delete(Long id) {
        try {
            userDAO.delete(UserModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
     
        public List<UserModel> getAll() {
        try {
            return userDAO.findAll(UserModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all user: " + e.getMessage());
        }
    }
        
            public List<UserModel> search(String searchTerm) {
        try {
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return getAll();
            }
            return userDAO.findByName(searchTerm.trim());
        } catch (Exception e) {
            throw new RuntimeException("Error searching customers: " + e.getMessage());
        }
    }

    public UserModel findById(Long id) {
        try {
            return userDAO.findById(UserModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding customer: " + e.getMessage());
        }
    }
    
//     public void exportToExcel(String filePath) {
//        try {
//            List<ImportProductModel> customers = getAll();
//            List<String> headers = Arrays.asList("Id", "Name", "Quantity", "Price", "Date");
//            List<Map<String, Object>> data = new ArrayList<>();
//
//            for (ImportProductModel customer : customers) {
//                Map<String, Object> row = new HashMap<>();
//                row.put("Id", customer.getId());
//                row.put("Name", customer.getProductName());
//                row.put("Quantity", customer.getQuantity());
//                row.put(" Price", customer.getTotalPrice());
////                row.put("Date", customer.getImportDate());
//                data.add(row);
//            }
//
//            ExcelUtils.exportToExcel(filePath, "Customers", headers, data);
//        } catch (Exception e) {
//            throw new RuntimeException("Error exporting to Excel: " + e.getMessage());
//        }
//    }
    
}
