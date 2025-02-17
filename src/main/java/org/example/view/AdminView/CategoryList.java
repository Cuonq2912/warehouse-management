package org.example.view.AdminView;

import java.util.ArrayList;
import java.util.List;

import org.example.controller.CategoryController;
import org.example.domain.model.CategoryModel;

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
