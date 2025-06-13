package org.example.service;

import java.util.List;

import org.example.domain.model.SupplierModel;

public interface SupplierService {
    boolean createSupplier(SupplierModel supplierModel);
    List<SupplierModel> getAllSupplier();
    SupplierModel getSupplierById(Long id);
    boolean updateSupplier(Long id, SupplierModel supplierModel);
    boolean deleteSupplier(Long id);
}