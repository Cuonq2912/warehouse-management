/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import org.example.domain.model.ImportDetailModel;
import org.example.repository.ImportProductDAO;
import org.example.utils.ExcelUtils;
import java.util.*;
import org.example.domain.model.ImportProductModel;
/**
 *
 * @author ADMIN
 */
public class ImportDetaiModelController {

      private final ImportProductDAO importproductDAO;
       
public ImportDetaiModelController(){
    this.importproductDAO=  new ImportProductDAO();
}

 public void insert(ImportDetailModel importproduct) {
        try {
             importproductDAO.create(importproduct);
        } catch (Exception e) {
            throw new RuntimeException("Error saving  importproduct: " + e.getMessage());
        }
    }
 
  public void update(ImportDetailModel importproduct) {
        try {
            importproductDAO.update(importproduct);
        } catch (Exception e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage());
        }
    }
  
     public void delete(String id) {
        try {
            importproductDAO.delete(ImportDetailModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage());
        }
    }
     
        public List<ImportDetailModel> getAll() {
        try {
            return importproductDAO.findAll(ImportDetailModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all customers: " + e.getMessage());
        }
    }
        
            public List<ImportDetailModel> search(String searchTerm) {
        try {
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return getAll();
            }
            return importproductDAO.findByName(searchTerm.trim());
        } catch (Exception e) {
            throw new RuntimeException("Error searching customers: " + e.getMessage());
        }
    }

    public ImportDetailModel findById(String id) {
        try {
            return importproductDAO.findById(ImportDetailModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding customer: " + e.getMessage());
        }
    }
    
     public void exportToExcel(String filePath) {
        try {
            List<ImportDetailModel> customers = getAll();
            List<String> headers = Arrays.asList("Id", "Name", "Quantity", "Price", "Date");
            List<Map<String, Object>> data = new ArrayList<>();

            for (ImportDetailModel customer : customers) {
                Map<String, Object> row = new HashMap<>();
                row.put("Id", customer.getId());
                row.put("Name", customer.getProductName());
                row.put("Quantity", customer.getQuantity());
                row.put(" Price", customer.getTotalPrice());
                row.put("Date", customer.getImportDate());
                data.add(row);
            }

            ExcelUtils.exportToExcel(filePath, "Customers", headers, data);
        } catch (Exception e) {
            throw new RuntimeException("Error exporting to Excel: " + e.getMessage());
        }
    }
    
}
