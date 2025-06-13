package org.example.service.impl;

import org.example.repository.*;
import org.example.service.DashboardService;

import java.util.LinkedHashMap;
import java.util.Map;

public class DashboardServiceImpl implements DashboardService {

    private final ProductDAO productDAO = new ProductDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final SupplierDAO supplierDAO = new SupplierDAO();
    private final ImportProductDAO importProductDAO = new ImportProductDAO();
    private final ExportProductDAO exportProductDAO = new ExportProductDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public Map<String, Long> getEntityCounts() {
        Map<String, Long> counts = new LinkedHashMap<>();

        try {
            counts.put("Products", (long) productDAO.getAllProducts().size());
        } catch (Exception e) {
            counts.put("Products", 0L);
        }

        try {
            counts.put("Customers", (long) customerDAO.getAllCustomers().size());
        } catch (Exception e) {
            counts.put("Customers", 0L);
        }

        try {
            counts.put("Suppliers", (long) supplierDAO.getAllSuppliers().size());
        } catch (Exception e) {
            counts.put("Suppliers", 0L);
        }

        try {
            counts.put("Imports", (long) importProductDAO.getAllImportProducts().size());
        } catch (Exception e) {
            counts.put("Imports", 0L);
        }

        try {
            counts.put("Exports", (long) exportProductDAO.getAllExportProducts().size());
        } catch (Exception e) {
            counts.put("Exports", 0L);
        }

        try {
            counts.put("Categories", (long) categoryDAO.getAllCategories().size());
        } catch (Exception e) {
            counts.put("Categories", 0L);
        }

        return counts;
    }
}
