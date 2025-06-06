/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example.service;

import java.util.List;
import org.example.domain.model.CategoryModel;
import org.example.domain.model.SupplierModel;

/**
 *
 * @author ADMIN
 */
public interface SupplierService {
    boolean createSupplier(SupplierModel supplierModel);
    List<SupplierModel> getAllSupplier();
    SupplierModel getSupplierById(Long id);
    boolean updateSupplier(Long id, SupplierModel supplierModel);
    boolean deleteSupplier(Long id);
}
