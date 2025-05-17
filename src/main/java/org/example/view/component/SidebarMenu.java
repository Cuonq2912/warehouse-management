package org.example.view.component;

import org.example.controller.CategoryController;
import org.example.domain.model.CategoryModel;

import org.example.view.MainDashboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class SidebarMenu extends JPanel {
    private JLabel lblSelectedMenu;
    private final JFrame parentFrame;
    private final Map<String, JPanel> menuPanels = new HashMap<>();


    public SidebarMenu(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(44, 62, 80));
        setPreferredSize(new Dimension(250, parentFrame.getHeight()));
        setBorder(new EmptyBorder(20, 0, 0, 0));

        // Add logo or app name
//        JLabel lblLogo = new JLabel("WAREHOUSE SYSTEM");
//        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        lblLogo.setForeground(Color.WHITE);
//        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
//        lblLogo.setBorder(new EmptyBorder(0, 0, 30, 0));
//        add(lblLogo);

        // Menu items
        String[] menuItems = {
                "Dashboard",
                "Categories",
                "Products",
                "Suppliers",
                "Customers",
                "Users",
                "Import Products",
                "Export Products"
        };

        for (String menuItem : menuItems) {
            JPanel menuPanel = createMenuItemPanel(menuItem);
            menuPanels.put(menuItem, menuPanel);
            add(menuPanel);
        }

        // Add logout at bottom
        add(Box.createVerticalGlue());
        JPanel logoutPanel = createMenuItemPanel("Logout");
        add(logoutPanel);
        add(Box.createVerticalStrut(20));
    }

    private JPanel createCategoryPanel() {
        return new CategoryPanel(parentFrame);
    }

    private JPanel createMenuItemPanel(String menuText) {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
        menuPanel.setBackground(new Color(44, 62, 80));
        menuPanel.setBorder(new EmptyBorder(12, 20, 12, 20));
        menuPanel.setMaximumSize(new Dimension(250, 50));
        menuPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblMenu = new JLabel(menuText);
        lblMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMenu.setForeground(Color.WHITE);
        menuPanel.add(lblMenu);

        // Make entire panel clickable
        menuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuPanel.setBackground(new Color(52, 73, 94));
                parentFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (lblSelectedMenu != lblMenu) {
                    menuPanel.setBackground(new Color(44, 62, 80));
                }
                parentFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Set this as active menu
                if (lblSelectedMenu != null) {
                    menuPanels.get(lblSelectedMenu.getText()).setBackground(new Color(44, 62, 80));
                }
                lblSelectedMenu = lblMenu;
                menuPanel.setBackground(new Color(52, 73, 94));

                // Update content based on selection
                loadContent(menuText);
            }
        });

        return menuPanel;
    }

    // Set the currently active menu
    public void setActiveMenu(String menuText) {
        if (lblSelectedMenu != null) {
            menuPanels.get(lblSelectedMenu.getText()).setBackground(new Color(44, 62, 80));
        }

        if (menuPanels.containsKey(menuText)) {
            lblSelectedMenu = (JLabel) menuPanels.get(menuText).getComponent(0);
            menuPanels.get(menuText).setBackground(new Color(52, 73, 94));
        }
    }

    private void loadContent(String menuText) {
        if (!(parentFrame instanceof MainDashboard)) {
            return;
        }

        MainDashboard dashboard = (MainDashboard) parentFrame;

        switch (menuText) {
            case "Dashboard":
                dashboard.showWelcomeScreen();
                break;

            case "Categories":
                JPanel categoryPanel = createCategoryPanel();
                dashboard.updateContent(categoryPanel);
                break;

            case "Products":
                // Create placeholder panel
                JPanel placeholderPanel = createPlaceholderPanel("Product Management");
                dashboard.updateContent(placeholderPanel);
                break;

            case "Suppliers":
                JPanel suppliersPanel = createPlaceholderPanel("Supplier Management");
                dashboard.updateContent(suppliersPanel);
                break;

            case "Customers":
                JPanel customersPanel = createPlaceholderPanel("Customer Management");
                dashboard.updateContent(customersPanel);
                break;

            case "Users":
                JPanel usersPanel = createPlaceholderPanel("User Management");
                dashboard.updateContent(usersPanel);
                break;

            case "Import Products":
                JPanel importPanel = createPlaceholderPanel("Import Products");
                dashboard.updateContent(importPanel);
                break;

            case "Export Products":
                JPanel exportPanel = createPlaceholderPanel("Export Products");
                dashboard.updateContent(exportPanel);
                break;

            case "Logout":
                int confirm = JOptionPane.showConfirmDialog(parentFrame,
                        "Are you sure you want to logout?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
        }
    }

    private JPanel createPlaceholderPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel(title + " (Coming Soon)");
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.add(label, BorderLayout.CENTER);

        return panel;
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
}