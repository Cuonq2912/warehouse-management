package org.example.controller;

import org.example.domain.model.CategoryModel;
import org.example.service.CategoryService;
import org.example.service.impl.CategoryServiceImpl;
import org.example.view.component.CategoryPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryController {

    private final CategoryService categoryService;
    private JComponent viewComponent;
    private JTable categoryTable;

    public CategoryController() {
        this.categoryService = new CategoryServiceImpl();
    }

    public void setView(CategoryPanel panel) {
        this.viewComponent = panel;
        this.categoryTable = panel.getTblCategories();
    }

    public void loadCategories(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<CategoryModel> categories = categoryService.getAllCategories();
        for (CategoryModel category : categories) {
            model.addRow(new Object[]{
                    category.getId(),
                    category.getName(),
                    category.getCreatedAt(),
                    category.getUpdatedAt()
            });
        }
    }

    public void searchCategories(String searchTerm, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (searchTerm == null || searchTerm.isEmpty()) {
            loadCategories(table);
            return;
        }

        List<CategoryModel> categories = categoryService.getAllCategories();
        List<CategoryModel> filteredCategories = categories.stream()
                .filter(category ->
                        category.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());

        for (CategoryModel category : filteredCategories) {
            model.addRow(new Object[]{
                    category.getId(),
                    category.getName(),
                    category.getCreatedAt(),
                    category.getUpdatedAt()
            });
        }
    }

    public void addCategory(String name) {
        CategoryModel category = new CategoryModel();
        category.setName(name);
        category.setCreatedAt(LocalDate.now());
        category.setUpdatedAt(LocalDate.now());

        boolean success = categoryService.createCategory(category);
        if (success) {
            JOptionPane.showMessageDialog(viewComponent, "Category added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadCategories(categoryTable);
        } else {
            JOptionPane.showMessageDialog(viewComponent, "Failed to add category", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCategory(Long id, String name) {
        CategoryModel category = categoryService.getCategoryById(id);
        if (category != null) {
            category.setName(name);
            category.setUpdatedAt(LocalDate.now());

            boolean success = categoryService.updateCategory(id, category);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Category updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadCategories(categoryTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Failed to update category", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteCategory(Long id) {
        int confirm = JOptionPane.showConfirmDialog(viewComponent,
                "Are you sure you want to delete this category?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = categoryService.deleteCategory(id);
            if (success) {
                JOptionPane.showMessageDialog(viewComponent, "Category deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadCategories(categoryTable);
            } else {
                JOptionPane.showMessageDialog(viewComponent, "Failed to delete category", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public CategoryModel getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }
}