package org.example.service.impl;

import org.example.domain.model.CategoryModel;
import org.example.repository.CategoryDAO;
import org.example.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public boolean createCategory(CategoryModel categoryModel) {
        try {
            categoryDAO.create(categoryModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> categoryModels = new ArrayList<>();
        try{
            categoryModels = categoryDAO.getAllCategories();
            return categoryModels;
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        return categoryModels;
    }

    @Override
    public CategoryModel getCategoryById(Long id) {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel = categoryDAO.getCategoryById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return categoryModel;
    }


    @Override
    public boolean updateCategory(Long id, CategoryModel categoryModel) {
        try{
            categoryDAO.update(id, categoryModel);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Long id) {
        try{
            categoryDAO.delete(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
