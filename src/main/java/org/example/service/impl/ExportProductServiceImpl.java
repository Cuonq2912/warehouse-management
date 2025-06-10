package org.example.service.impl;

import org.example.domain.model.ExportProductModel;
import org.example.repository.ExportProductDAO;
import org.example.service.ExportProductService;

import java.util.ArrayList;
import java.util.List;

public class ExportProductServiceImpl implements ExportProductService {

    private final ExportProductDAO exportProductDAO = new ExportProductDAO();

    @Override
    public boolean createExportProduct(ExportProductModel exportProductModel) {
        try {
            exportProductDAO.createExportProduct(exportProductModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExportProductModel> getAllExportProducts() {
        List<ExportProductModel> exportProducts = new ArrayList<>();
        try {
            exportProducts = exportProductDAO.getAllExportProducts();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return exportProducts;
    }

    @Override
    public ExportProductModel getExportProductById(Long id) {
        ExportProductModel exportProduct = null;
        try {
            exportProduct = exportProductDAO.getExportProductById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return exportProduct;
    }

    @Override
    public boolean updateExportProduct(Long id, ExportProductModel exportProductModel) {
        try {
            exportProductDAO.updateExportProduct(id, exportProductModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteExportProduct(Long id) {
        try {
            exportProductDAO.deleteExportProduct(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExportProductModel> searchExportProducts(String searchTerm) {
        List<ExportProductModel> exportProducts = new ArrayList<>();
        try {
            exportProducts = exportProductDAO.searchExportProducts(searchTerm);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return exportProducts;
    }
}
