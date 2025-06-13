package org.example.view.component.ImportProductComponent;

import org.example.controller.ImportProductController;
import org.example.domain.model.ImportProductModel;
import org.example.domain.model.ImportDetailModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ImportProductPanel extends JPanel {
    private final ImportProductController controller;
    private JTable tblImports;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;

    public ImportProductPanel() {
        controller = new ImportProductController();
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        initComponents();
        controller.setImportTable(tblImports);
        initListeners();
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

        JLabel titleLabel = new JLabel("Import Product Management");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(new Color(245, 245, 247));

        txtSearch = new JTextField(15);
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(7, 10, 7, 10)));

        btnSearch = new JButton("Search");
        styleButton(btnSearch, new Color(92, 184, 92));
        btnSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(92, 184, 92).darker(), 1),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)));

        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);

        headerPanel.add(searchPanel, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        String[] columns = { "ID", "Import Date", "User", "Supplier", "Products", "Quantity", "Price" };
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblImports = new JTable(model);
        tblImports.setRowHeight(30);
        tblImports.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblImports.setSelectionBackground(new Color(44, 62, 80));
        tblImports.setGridColor(new Color(240, 240, 240));
        tblImports.setShowVerticalLines(false);

        JTableHeader header = tblImports.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(new Color(51, 51, 51));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        header.setPreferredSize(new Dimension(100, 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tblImports.getColumnCount(); i++) {
            tblImports.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tblImports);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 245, 247));

        btnAdd = new JButton("Add");
        styleButton(btnAdd, new Color(66, 139, 202));

        btnUpdate = new JButton("Update");
        styleButton(btnUpdate, new Color(91, 192, 222));

        btnDelete = new JButton("Delete");
        styleButton(btnDelete, new Color(217, 83, 79));

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

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

    private void initListeners() {
        btnAdd.addActionListener(e -> {
            ImportProductFormDialog dialog = new ImportProductFormDialog(
                    SwingUtilities.getWindowAncestor(this), controller);
            dialog.setVisible(true);
            loadData();
        });

        btnUpdate.addActionListener(e -> {
            int selectedRow = tblImports.getSelectedRow();
            if (selectedRow >= 0) {
                Long importId = Long.valueOf(tblImports.getValueAt(selectedRow, 0).toString());
                ImportProductModel importProduct = controller.getImportProductById(importId);
                if (importProduct != null) {
                    ImportProductFormDialog dialog = new ImportProductFormDialog(
                            SwingUtilities.getWindowAncestor(this), controller, importProduct);
                    dialog.setVisible(true);
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu nhập", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn phiếu nhập muốn cập nhật", "No Selection",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = tblImports.getSelectedRow();
            if (selectedRow >= 0) {
                Long importId = Long.valueOf(tblImports.getValueAt(selectedRow, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Bạn chắc chắn muốn xóa phiếu nhập này?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (controller.deleteImportProduct(importId)) {
                        JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công");
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thất bại", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn phiếu nhập muốn xóa", "No Selection",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        btnSearch.addActionListener(e -> {
            String searchTerm = txtSearch.getText().trim();
            searchImportProducts(searchTerm);
        });
        tblImports.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = tblImports.getSelectedRow();
                    if (selectedRow >= 0) {
                        Long importId = Long.valueOf(tblImports.getValueAt(selectedRow, 0).toString());
                        ImportProductModel importProduct = controller.getImportProductById(importId);
                        if (importProduct != null) {
                            ImportProductFormDialog dialog = new ImportProductFormDialog(
                                    SwingUtilities.getWindowAncestor(ImportProductPanel.this), controller,
                                    importProduct);
                            dialog.setVisible(true);
                            // Refresh table after dialog closes
                            loadData();
                        }
                    }
                }
            }
        });
    }

    private void searchImportProducts(String searchTerm) {
        DefaultTableModel model = (DefaultTableModel) tblImports.getModel();
        model.setRowCount(0);

        if (searchTerm.isEmpty()) {
            loadData();
            return;
        }

        controller.searchImportProducts(searchTerm, tblImports);
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) tblImports.getModel();
        model.setRowCount(0);

        List<ImportProductModel> importProducts = controller.getAllImportProducts();

        for (ImportProductModel importProduct : importProducts) {
            // Get the first import detail for product info (assuming one product per
            // import)
            if (importProduct.getImportDetails() != null && !importProduct.getImportDetails().isEmpty()) {
                ImportDetailModel firstDetail = importProduct.getImportDetails().get(0);

                Object[] row = {
                        importProduct.getId(),
                        importProduct.getImportDate(),
                        importProduct.getUserModel() != null ? importProduct.getUserModel().getFullName() : "N/A",
                        importProduct.getSupplierModel() != null ? importProduct.getSupplierModel().getName() : "N/A",
                        firstDetail.getProductModel() != null ? firstDetail.getProductModel().getName() : "N/A",
                        firstDetail.getQuantity(),
                        String.format("$%.2f", firstDetail.getProductModel().getPrice())
                };
                model.addRow(row);
            }
        }
    }
}
