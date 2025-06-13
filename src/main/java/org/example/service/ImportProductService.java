package org.example.service;

import org.example.domain.model.ImportProductModel;

import java.util.List;

public interface ImportProductService {
    
    boolean createImportProduct(ImportProductModel importProductModel);
    List<ImportProductModel> getAllImportProducts();
    ImportProductModel getImportProductById(Long id);
    boolean updateImportProduct(Long id, ImportProductModel importProductModel);
    boolean deleteImportProduct(Long id);
    List<ImportProductModel> searchImportProducts(String searchTerm);
}
