package org.example.controller;

import java.util.List;

import org.example.domain.model.CategoryModel;
import org.example.repository.CategoryDAO;

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
