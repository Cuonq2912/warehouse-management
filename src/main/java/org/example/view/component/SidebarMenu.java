package org.example.view.component;

import org.example.domain.model.Role;
import org.example.domain.model.UserModel;
import org.example.utils.SessionManager;
import org.example.view.Login;
import org.example.view.MainDashboard;
import org.example.view.component.CategoryComponent.CategoryPanel;
import org.example.view.component.CustomerComponent.CustomerPanel;
import org.example.view.component.DashboardComponent.DashboardPanel;
import org.example.view.component.ExportProductComponent.ExportProductPanel;
import org.example.view.component.ImportProductComponent.ImportProductPanel;
import org.example.view.component.ProductComponent.ProductPanel;
import org.example.view.component.SupplierComponent.SupplierPanel;
import org.example.view.component.UserComponent.UserPanel;
import org.example.view.component.UserComponent.MyAccountPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        setPreferredSize(new Dimension(230, parentFrame.getHeight()));
        setBorder(new EmptyBorder(20, 0, 0, 0));

        String[] menuItems = {
                "DASHBOARD",
                "CATEGORIES",
                "PRODUCTS",
                "SUPPLIERS",
                "CUSTOMERS",
                "IMPORT PRODUCTS",
                "EXPORT PRODUCTS",
                getUserMenuText() // Thay đổi ở đây
        };

        for (String menuItem : menuItems) {
            JPanel menuPanel = createMenuItemPanel(menuItem);
            menuPanels.put(menuItem, menuPanel);
            add(menuPanel);
        }

        add(Box.createVerticalGlue());
        JPanel logoutPanel = createMenuItemPanel("Logout");
        add(logoutPanel);
        add(Box.createVerticalStrut(20));
    }

    private String getUserMenuText() {
        UserModel currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser != null && currentUser.getRole() == Role.USER) {
            return "MY ACCOUNT";
        }
        return "USERS";
    }

    private JPanel createCategoryPanel() {
        return new CategoryPanel(parentFrame);
    }

    private JPanel createProductPanel() {
        return new ProductPanel(parentFrame);
    }

    private JPanel createSupplierPanel() {
        return new SupplierPanel(parentFrame);
    }

    private JPanel createCustomerPanel() {
        return new CustomerPanel(parentFrame);
    }

    private JPanel createUserPanel() {
        return new UserPanel(parentFrame);
    }

    private JPanel createImportProductPanel() {
        return new ImportProductPanel();
    }

    private JPanel createExportProductPanel() {
        return new ExportProductPanel();
    }

    private JPanel createMyAccountPanel() {
        return new MyAccountPanel(parentFrame);
    }

    private JPanel createDashboardPanel() {
        return new DashboardPanel();
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
                if (lblSelectedMenu != null) {
                    menuPanels.get(lblSelectedMenu.getText()).setBackground(new Color(44, 62, 80));
                }
                lblSelectedMenu = lblMenu;
                menuPanel.setBackground(new Color(52, 73, 94));

                loadContent(menuText);
            }
        });

        return menuPanel;
    }

    private void loadContent(String menuText) {

        MainDashboard dashboard = (MainDashboard) parentFrame;
        switch (menuText) {
            case "DASHBOARD":
                JPanel dashboardPanel = createDashboardPanel();
                dashboard.updateContent(dashboardPanel);
                break;

            case "CATEGORIES":
                JPanel categoryPanel = createCategoryPanel();
                dashboard.updateContent(categoryPanel);
                break;

            case "PRODUCTS":
                JPanel productPanel = createProductPanel();
                dashboard.updateContent(productPanel);
                break;

            case "SUPPLIERS":
                JPanel suppliersPanel = createSupplierPanel();
                dashboard.updateContent(suppliersPanel);
                break;

            case "CUSTOMERS":
                JPanel customerPanel = createCustomerPanel();
                dashboard.updateContent(customerPanel);
                break;
            case "USERS":
                JPanel userJPanel = createUserPanel();
                dashboard.updateContent(userJPanel);
                break;

            case "MY ACCOUNT":
                JPanel myAccountPanel = createMyAccountPanel();
                dashboard.updateContent(myAccountPanel);
                break;

            case "IMPORT PRODUCTS":
                JPanel importPanel = createImportProductPanel();
                dashboard.updateContent(importPanel);
                break;

            case "EXPORT PRODUCTS":
                JPanel exportPanel = createExportProductPanel();
                dashboard.updateContent(exportPanel);
                break;
            case "Logout":
                int confirm = JOptionPane.showConfirmDialog(parentFrame,
                        "Xác nhận đăng xuất tài khoản?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    SessionManager.getInstance().logout();
                    Login loginFrame = new Login();
                    loginFrame.setVisible(true);
                    parentFrame.dispose();
                }
                break;
        }
    }
}