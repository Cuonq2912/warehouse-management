package org.example.view.component.SupplierComponent;

import lombok.Getter;
import org.example.controller.SupplierController;
import org.example.domain.model.SupplierModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplierPanel extends JPanel {

    private final SupplierController controller;
    private final JFrame parentFrame;

    @Getter
    private JTable tblSuppliers;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;

    public SupplierPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.controller = new SupplierController();

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        initComponents();
        controller.setSupplierTable(tblSuppliers);
        controller.setView(this);
        initListeners();
        controller.loadSuppliers(tblSuppliers);
    }

    private void initComponents() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 247));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel title = new JLabel("Supplier Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(51, 51, 51));
        panel.add(title, BorderLayout.WEST);

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
        panel.add(searchPanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        String[] columns = { "ID", "Name", "Email", "Phone", "Address" };
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tblSuppliers = new JTable(model);
        tblSuppliers.setRowHeight(30);
        tblSuppliers.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblSuppliers.setSelectionBackground(new Color(44, 62, 80));
        tblSuppliers.setGridColor(new Color(240, 240, 240));
        tblSuppliers.setShowVerticalLines(false);

        JTableHeader header = tblSuppliers.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(new Color(51, 51, 51));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        header.setPreferredSize(new Dimension(100, 35));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblSuppliers.getColumnCount(); i++) {
            tblSuppliers.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tblSuppliers);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBackground(new Color(245, 245, 247));

        btnAdd = new JButton("Add");
        styleButton(btnAdd, new Color(66, 139, 202));

        btnUpdate = new JButton("Update");
        styleButton(btnUpdate, new Color(91, 192, 222));

        btnDelete = new JButton("Delete");
        styleButton(btnDelete, new Color(217, 83, 79));

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);

        return panel;
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }

    private void initListeners() {
        btnAdd.addActionListener(e -> new SupplierFormDialog(parentFrame, controller, tblSuppliers).setVisible(true));

        btnUpdate.addActionListener(e -> {
            int row = tblSuppliers.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(parentFrame, "Please select a supplier to update", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long id = Long.valueOf(tblSuppliers.getValueAt(row, 0).toString());
            SupplierModel supplier = controller.getSupplierById(id);
            if (supplier != null) {
                new SupplierFormDialog(parentFrame, controller, tblSuppliers, supplier).setVisible(true);
                controller.loadSuppliers(tblSuppliers);
            }
        });

        btnDelete.addActionListener(e -> {
            int row = tblSuppliers.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(parentFrame, "Please select a supplier to delete", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long id = Long.valueOf(tblSuppliers.getValueAt(row, 0).toString());
            controller.deleteSupplier(id);
        });

        btnSearch.addActionListener(e -> {
            String keyword = txtSearch.getText().trim();
            controller.searchSuppliers(keyword, tblSuppliers);
        });

        tblSuppliers.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tblSuppliers.getSelectedRow();
                    if (row >= 0) {
                        Long id = Long.valueOf(tblSuppliers.getValueAt(row, 0).toString());
                        SupplierModel supplier = controller.getSupplierById(id);
                        if (supplier != null) {
                            new SupplierFormDialog(parentFrame, controller, tblSuppliers, supplier).setVisible(true);
                        }
                    }
                }
            }
        });
    }
}
