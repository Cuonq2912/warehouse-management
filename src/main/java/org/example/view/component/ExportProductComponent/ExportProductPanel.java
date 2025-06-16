package org.example.view.component.ExportProductComponent;

import org.example.controller.ExportProductController;
import org.example.domain.model.ExportProductModel;
import org.example.domain.model.ExportDetailModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ExportProductPanel extends JPanel {
    private JTextField searchField;
    private JTable exportTable;
    private DefaultTableModel tableModel;
    private JButton addButton, updateButton, deleteButton, searchButton;
    private ExportProductController exportProductController;

    public ExportProductPanel() {
        exportProductController = new ExportProductController();
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        initComponents();
        exportProductController.setExportTable(exportTable);
        loadData();
    }

    private void initComponents() {
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        JPanel tablePanel = createTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(245, 245, 247));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel titleLabel = new JLabel("Export Product Management");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(new Color(245, 245, 247));

        searchField = new JTextField(15);
        searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(7, 10, 7, 10)));

        searchButton = new JButton("Search");
        styleButton(searchButton, new Color(92, 184, 92));

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchExportProducts();
            }
        });
        searchButton.addActionListener(this::searchExportProductsAction);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        headerPanel.add(searchPanel, BorderLayout.EAST);

        return headerPanel;
    }

    private void searchExportProductsAction(java.awt.event.ActionEvent e) {
        searchExportProducts();
    }

    private void addExportProductAction(java.awt.event.ActionEvent e) {
        addExportProduct();
    }

    private void updateExportProductAction(java.awt.event.ActionEvent e) {
        updateExportProduct();
    }

    private void deleteExportProductAction(java.awt.event.ActionEvent e) {
        deleteExportProduct();
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        String[] columnNames = { "Export ID", "Export Date", "Customer Name", "Employee Name", "Product", "Quantity",
                "Price" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        exportTable = new JTable(tableModel);
        exportTable.setRowHeight(30);
        exportTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        exportTable.setSelectionBackground(new Color(44, 62, 80));
        exportTable.setGridColor(new Color(240, 240, 240));
        exportTable.setShowVerticalLines(false);

        JTableHeader header = exportTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(new Color(51, 51, 51));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        header.setPreferredSize(new Dimension(100, 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < exportTable.getColumnCount(); i++) {
            exportTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        exportTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        exportTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        exportTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        exportTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        exportTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        exportTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        exportTable.getColumnModel().getColumn(6).setPreferredWidth(100);

        exportTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = exportTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        Long exportId = ((Number) tableModel.getValueAt(selectedRow, 0)).longValue();
                        ExportProductModel exportProduct = exportProductController.getExportProductById(exportId);
                        if (exportProduct != null) {
                            ExportProductFormDialog dialog = new ExportProductFormDialog(
                                    (Window) SwingUtilities.getWindowAncestor(ExportProductPanel.this),
                                    exportProductController,
                                    exportProduct);
                            dialog.setVisible(true);
                            loadData();
                        }
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(exportTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 245, 247));

        addButton = new JButton("Add");
        styleButton(addButton, new Color(66, 139, 202));

        updateButton = new JButton("Update");
        styleButton(updateButton, new Color(91, 192, 222));
        deleteButton = new JButton("Delete");
        styleButton(deleteButton, new Color(217, 83, 79));
        addButton.addActionListener(this::addExportProductAction);
        updateButton.addActionListener(this::updateExportProductAction);
        deleteButton.addActionListener(this::deleteExportProductAction);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        return buttonPanel;
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<ExportProductModel> exportProducts = exportProductController.getAllExportProducts();

        for (ExportProductModel exportProduct : exportProducts) {

            if (exportProduct.getExportDetailModel() != null && !exportProduct.getExportDetailModel().isEmpty()) {
                ExportDetailModel firstDetail = exportProduct.getExportDetailModel().get(0);

                Object[] row = {
                        exportProduct.getId(),
                        exportProduct.getExportDate(),
                        exportProduct.getCustomerModel() != null ? exportProduct.getCustomerModel().getName() : "N/A",
                        exportProduct.getUserModel() != null ? exportProduct.getUserModel().getFullName() : "N/A",
                        firstDetail.getProductModel() != null ? firstDetail.getProductModel().getName() : "N/A",
                        firstDetail.getQuantity(),
                        String.format("$%.2f", firstDetail.getProductModel().getPrice())
                };
                tableModel.addRow(row);
            }
        }
    }

    private void searchExportProducts() {
        String searchText = searchField.getText().trim();
        tableModel.setRowCount(0);

        List<ExportProductModel> exportProducts;
        if (searchText.isEmpty()) {
            exportProducts = exportProductController.getAllExportProducts();
        } else {
            exportProducts = exportProductController.getAllExportProducts().stream()
                    .filter(export -> export.getId().toString().contains(searchText) ||
                            (export.getCustomerModel() != null &&
                                    export.getCustomerModel().getName().toLowerCase()
                                            .contains(searchText.toLowerCase()))
                            ||
                            (export.getUserModel() != null &&
                                    export.getUserModel().getFullName().toLowerCase()
                                            .contains(searchText.toLowerCase())))
                    .collect(java.util.stream.Collectors.toList());
        }

        for (ExportProductModel exportProduct : exportProducts) {
            if (exportProduct.getExportDetailModel() != null && !exportProduct.getExportDetailModel().isEmpty()) {
                ExportDetailModel firstDetail = exportProduct.getExportDetailModel().get(0);

                Object[] row = {
                        exportProduct.getId(),
                        exportProduct.getExportDate(),
                        exportProduct.getCustomerModel() != null ? exportProduct.getCustomerModel().getName() : "N/A",
                        exportProduct.getUserModel() != null ? exportProduct.getUserModel().getFullName() : "N/A",
                        firstDetail.getProductModel() != null ? firstDetail.getProductModel().getName() : "N/A",
                        firstDetail.getQuantity(),
                        String.format("$%.2f", firstDetail.getProductModel().getPrice())
                };
                tableModel.addRow(row);
            }
        }
    }

    private void addExportProduct() {
        ExportProductFormDialog dialog = new ExportProductFormDialog(
                (Window) SwingUtilities.getWindowAncestor(this),
                exportProductController);
        dialog.setVisible(true);
        loadData();
    }

    private void updateExportProduct() {
        int selectedRow = exportTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn phiếu xuất muốn cập nhật", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Long exportId = ((Number) tableModel.getValueAt(selectedRow, 0)).longValue();
        ExportProductModel exportProduct = exportProductController.getExportProductById(exportId);
        if (exportProduct != null) {
            ExportProductFormDialog dialog = new ExportProductFormDialog(
                    (Window) SwingUtilities.getWindowAncestor(this),
                    exportProductController,
                    exportProduct);
            dialog.setVisible(true);
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu xuất", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteExportProduct() {
        int selectedRow = exportTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn phiếu xuất muốn xóa", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Long exportId = ((Number) tableModel.getValueAt(selectedRow, 0)).longValue();
        String customerName = (String) tableModel.getValueAt(selectedRow, 2);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn chắc chắn muốn xóa phiếu xuất cho khách hàng: " + customerName + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                exportProductController.deleteExportProduct(exportId);
                JOptionPane.showMessageDialog(this, "Xóa phiếu xuất thành công!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                loadData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa phiếu xuất thất bại: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void refreshData() {
        loadData();
    }

    public void clearSearch() {
        searchField.setText("");
        loadData();
    }
}