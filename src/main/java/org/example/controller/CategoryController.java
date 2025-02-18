/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import org.example.domain.model.CategoryModel;
import org.example.repository.CategoryDAO;

/**
 *
 * @author ADMIN
 */
public class CategoryController {
    private final CategoryDAO categoryDAO;

    public CategoryController() {
        this.categoryDAO = new CategoryDAO();
    }

    public List<CategoryModel> getAll() {
        try {
            return categoryDAO.findAll(CategoryModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Erroe getting category" + e.getMessage());
        }
    }
}
