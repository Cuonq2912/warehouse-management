package org.example.service;

import org.example.domain.model.ExportProductModel;

import java.util.List;

public interface ExportProductService {

    boolean createExportProduct(ExportProductModel exportProductModel);

    List<ExportProductModel> getAllExportProducts();

    ExportProductModel getExportProductById(Long id);

    boolean updateExportProduct(Long id, ExportProductModel exportProductModel);

    boolean deleteExportProduct(Long id);

    List<ExportProductModel> searchExportProducts(String searchTerm);
}
