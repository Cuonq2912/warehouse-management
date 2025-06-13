package org.example.service.impl;

import org.example.domain.model.ImportProductModel;
import org.example.repository.ImportProductDAO;
import org.example.service.ImportProductService;

import java.util.ArrayList;
import java.util.List;

public class ImportProductServiceImpl implements ImportProductService {

    private final ImportProductDAO importProductDAO = new ImportProductDAO();

    @Override
    public boolean createImportProduct(ImportProductModel importProductModel) {
        try {
            importProductDAO.createImportProduct(importProductModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ImportProductModel> getAllImportProducts() {
        List<ImportProductModel> importProducts = new ArrayList<>();
        try {
            importProducts = importProductDAO.getAllImportProducts();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return importProducts;
    }

    @Override
    public ImportProductModel getImportProductById(Long id) {
        ImportProductModel importProduct = null;
        try {
            importProduct = importProductDAO.getImportProductById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return importProduct;
    }

    @Override
    public boolean updateImportProduct(Long id, ImportProductModel importProductModel) {
        try {
            importProductDAO.updateImportProduct(id, importProductModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteImportProduct(Long id) {
        try {
            importProductDAO.deleteImportProduct(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ImportProductModel> searchImportProducts(String searchTerm) {
        List<ImportProductModel> importProducts = new ArrayList<>();
        try {
            importProducts = importProductDAO.searchImportProducts(searchTerm);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return importProducts;
    }
}
