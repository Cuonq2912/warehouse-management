package org.example.view.component.CustomerComponent;

import lombok.Getter;
import org.example.controller.CustomerController;
import org.example.domain.model.CustomerModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerPanel extends JPanel {

    private final CustomerController controller;
    private final JFrame parentFrame;

    @Getter
    private JTable tblCustomers;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;

    public CustomerPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        controller = new CustomerController();
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        initComponents();
        controller.setCustomerTable(tblCustomers);
        controller.setView(this);
        initListeners();
        controller.loadCustomers(tblCustomers);
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

        JLabel titleLabel = new JLabel("Customer Management");
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

        String[] columns = { "ID", "Name", "Email", "Phone Number", "Address", "Point"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblCustomers = new JTable(model);
        tblCustomers.setRowHeight(30);
        tblCustomers.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblCustomers.setSelectionBackground(new Color(44, 62, 80));
        tblCustomers.setGridColor(new Color(240, 240, 240));
        tblCustomers.setShowVerticalLines(false);

        JTableHeader header = tblCustomers.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(new Color(51, 51, 51));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        header.setPreferredSize(new Dimension(100, 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tblCustomers.getColumnCount(); i++) {
            tblCustomers.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tblCustomers);
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
            CustomerFormDialog dialog = new CustomerFormDialog(parentFrame, controller, tblCustomers);
            dialog.setVisible(true);
        });

        btnUpdate.addActionListener(e -> {
            int row = tblCustomers.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(parentFrame,
                        "Please select a customer to update",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long id = Long.valueOf(tblCustomers.getValueAt(row, 0).toString());
            CustomerModel customer = controller.getCustomerById(id);
            if (customer != null) {
                CustomerFormDialog dialog = new CustomerFormDialog(parentFrame, controller, tblCustomers, customer);
                dialog.setVisible(true);
                controller.loadCustomers(tblCustomers);
            }
        });

        btnDelete.addActionListener(e -> {
            int row = tblCustomers.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(parentFrame,
                        "Please select a customer to delete",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long id = Long.valueOf(tblCustomers.getValueAt(row, 0).toString());
            controller.deleteCustomer(id);
        });

        btnSearch.addActionListener(e -> {
            String searchTerm = txtSearch.getText().trim();
            controller.searchCustomers(searchTerm, tblCustomers);
        });

        tblCustomers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tblCustomers.getSelectedRow();
                    if (row >= 0) {
                        Long id = Long.valueOf(tblCustomers.getValueAt(row, 0).toString());
                        CustomerModel customer = controller.getCustomerById(id);
                        if (customer != null) {
                            CustomerFormDialog dialog = new CustomerFormDialog(
                                    parentFrame, controller, tblCustomers, customer);
                            dialog.setVisible(true);
                        }
                    }
                }
            }
        });
    }
}
