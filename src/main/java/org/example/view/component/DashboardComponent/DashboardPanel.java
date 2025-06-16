package org.example.view.component.DashboardComponent;

import org.example.service.DashboardService;
import org.example.service.impl.DashboardServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class DashboardPanel extends JPanel {

    private final DashboardService dashboardService;
    private JPanel statsPanel;
    private JButton refreshButton;

    public DashboardPanel() {
        this.dashboardService = new DashboardServiceImpl();
        initComponents();
        loadStats();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 247));

        // Header panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // Stats panel
        statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2, 4, 15, 15));
        statsPanel.setBackground(new Color(245, 245, 247));
        add(statsPanel, BorderLayout.CENTER);

        // Welcome panel at bottom
        JPanel welcomePanel = createWelcomePanel();
        add(welcomePanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(245, 245, 247));
        headerPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        JLabel titleLabel = new JLabel("Dashboard Overview");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Refresh button
        refreshButton = new JButton("Refresh");
        styleButton(refreshButton, new Color(52, 152, 219));
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshStats();
            }
        });

        headerPanel.add(refreshButton, BorderLayout.EAST);
        return headerPanel;
    }

    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(Color.WHITE);
        welcomePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                new EmptyBorder(20, 20, 20, 20)));

        JLabel welcomeLabel = new JLabel("Welcome to Warehouse Management System");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(51, 51, 51));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel descLabel = new JLabel("Manage your warehouse efficiently with comprehensive tools");
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descLabel.setForeground(new Color(127, 140, 141));
        descLabel.setHorizontalAlignment(JLabel.CENTER);

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(descLabel, BorderLayout.SOUTH);

        return welcomePanel;
    }

    private void loadStats() {
        statsPanel.removeAll();

        Map<String, Long> entityCounts = dashboardService.getEntityCounts();
        Color[] colors = {
                new Color(52, 152, 219),  // Blue
                new Color(46, 204, 113),  // Green
                new Color(155, 89, 182),  // Purple
                new Color(241, 196, 15),  // Yellow
                new Color(231, 76, 60),   // Red
                new Color(230, 126, 34),  // Orange
                new Color(149, 165, 166)  // Gray
        };

        int colorIndex = 0;
        for (Map.Entry<String, Long> entry : entityCounts.entrySet()) {
            JPanel card = createStatsCard(entry.getKey(), entry.getValue(), colors[colorIndex % colors.length]);
            statsPanel.add(card);
            colorIndex++;
        }

        statsPanel.revalidate();
        statsPanel.repaint();
    }

    private JPanel createStatsCard(String title, Long count, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(20, 15, 20, 15)));

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(127, 140, 141));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Count
        JLabel countLabel = new JLabel(count.toString());
        countLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        countLabel.setForeground(color);
        countLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Icon panel
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(color);
        iconPanel.setPreferredSize(new Dimension(40, 4));
        iconPanel.setMaximumSize(new Dimension(40, 4));
        iconPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(Box.createVerticalGlue());
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(countLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(iconPanel);
        card.add(Box.createVerticalGlue());

        return card;
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

    private void refreshStats() {
        loadStats();
        JOptionPane.showMessageDialog(this, 
            "Dashboard refreshed successfully!", 
            "Refresh", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
