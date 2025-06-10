/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.view.component.UserComponent;

import org.example.controller.UserController;
import org.example.domain.model.UserModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ADMIN
 */
public class UserPanel extends JPanel {

    private final JTable tblUsers;
    private final JButton btnAdd, btnEdit, btnDelete, btnRefresh;
    private final JTextField txtSearch;
    private final JButton btnSearch;
    private final UserController controller;
    private final JFrame parentFrame;

    public UserPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        controller = new UserController();
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        txtSearch = new JTextField(15);
        btnSearch = new JButton("Search");
        btnAdd = new JButton("Add");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnRefresh = new JButton("Refresh");
        tblUsers = new JTable();

        initComponents();
        controller.setUserTable(tblUsers);
        controller.loadUsers(tblUsers);
        initListeners();
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

        JLabel titleLabel = new JLabel("User Management");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(new Color(245, 245, 247));

        txtSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                BorderFactory.createEmptyBorder(7, 10, 7, 10)));

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

        String[] columns = { "ID", "Username", "Full Name", "Email", "Phone", "Address", "Status", "Created At",
                "Updated At" };
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblUsers.setModel(model);
        tblUsers.setRowHeight(30);
        tblUsers.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblUsers.setSelectionBackground(new Color(44, 62, 80));
        tblUsers.setGridColor(new Color(240, 240, 240));
        tblUsers.setShowVerticalLines(false);

        JTableHeader header = tblUsers.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(new Color(51, 51, 51));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        header.setPreferredSize(new Dimension(100, 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tblUsers.getColumnCount(); i++) {
            tblUsers.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tblUsers);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 245, 247));

        styleButton(btnAdd, new Color(66, 139, 202));
        styleButton(btnEdit, new Color(91, 192, 222));
        styleButton(btnDelete, new Color(217, 83, 79));
        styleButton(btnRefresh, new Color(150, 150, 150));

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        return buttonPanel;
    }

    private void initListeners() {
        btnAdd.addActionListener(e -> {
            new UserFormDialog(parentFrame, controller, tblUsers, null).setVisible(true);
        });

        btnEdit.addActionListener(e -> {
            int selectedRow = tblUsers.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(parentFrame, "Please select a user to edit", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long userId = (Long) tblUsers.getValueAt(selectedRow, 0);
            UserModel user = controller.getUserById(userId);
            if (user != null) {
                new UserFormDialog(parentFrame, controller, tblUsers, user).setVisible(true);
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = tblUsers.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(parentFrame, "Please select a user to delete", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Long userId = (Long) tblUsers.getValueAt(selectedRow, 0);
            controller.deleteUser(userId);
        });

        btnRefresh.addActionListener(e -> controller.loadUsers(tblUsers));

        btnSearch.addActionListener(e -> {
            String searchTerm = txtSearch.getText().trim();
            controller.searchUsers(searchTerm, tblUsers);
        });


        tblUsers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tblUsers.getSelectedRow();
                    if (row >= 0) {
                        Long userId = (Long) tblUsers.getValueAt(row, 0);
                        UserModel user = controller.getUserById(userId);
                        if (user != null) {
                            new UserFormDialog(parentFrame, controller, tblUsers, user).setVisible(true);
                        }
                    }
                }
            }
        });
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

    public JTable getTblUsers() {
        return tblUsers;
    }
}