package org.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.domain.model.SupplierModel;
import org.example.repository.SupplierDAO;
import org.example.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierDAO supplierDAO = new SupplierDAO();

    @Override
    public boolean createSupplier(SupplierModel supplierModel) {
        try {
            supplierDAO.create(supplierModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SupplierModel> getAllSupplier() {
        List<SupplierModel> supplierModels = new ArrayList<>();
        try {
            supplierModels = supplierDAO.getAllSuppliers();
            return supplierModels;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return supplierModels;
    }

    @Override
    public SupplierModel getSupplierById(Long id) {
        SupplierModel supplierModel = new SupplierModel();

        try {
            supplierModel = supplierDAO.getSupplierById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return supplierModel;
    }

    @Override
    public boolean updateSupplier(Long id, SupplierModel supplierModel) {
        try {
            supplierDAO.update(id, supplierModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSupplier(Long id) {

        try {
            supplierDAO.delete(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
