/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.view.AD;

import java.util.ArrayList;
import java.util.List;
import org.example.controller.CategoryController;
import org.example.domain.model.CategoryModel;

/**
 *
 * @author ADMIN
 */
public class CategoryList {
    
    private final List<String> dataCategories;

    private final CategoryController categoryController;

    public CategoryList() {
        dataCategories = new ArrayList<>();
        categoryController = new CategoryController();
    }

    public List<String> getCategories() {
        List<CategoryModel> categoryModels = categoryController.getAll();
        dataCategories.clear();
        for (CategoryModel category : categoryModels) {
            dataCategories.add(category.getName());
        }
        return dataCategories;
    }
}
