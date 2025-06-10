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
    private JPanel chartPanel;
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

        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), 1, true),
                new EmptyBorder(20, 20, 20, 20)));
        add(chartPanel, BorderLayout.CENTER);

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
        chartPanel.removeAll();

        Map<String, Long> entityCounts = dashboardService.getEntityCounts();
        Color[] colors = {
                new Color(52, 152, 219), // Blue
                new Color(46, 204, 113), // Green
                new Color(155, 89, 182), // Purple
                new Color(241, 196, 15), // Yellow
                new Color(231, 76, 60), // Red
                new Color(230, 126, 34), // Orange
                new Color(149, 165, 166) // Gray
        };

        JPanel chartMainPanel = createBarChart(entityCounts, colors);
        chartPanel.add(chartMainPanel, BorderLayout.CENTER);

        chartPanel.revalidate();
        chartPanel.repaint();
    }

    private JPanel createBarChart(Map<String, Long> data, Color[] colors) {
        JPanel chartContainer = new JPanel();
        chartContainer.setLayout(new BorderLayout());
        chartContainer.setBackground(Color.WHITE);

        JLabel chartTitle = new JLabel("Warehouse Data Overview", JLabel.CENTER);
        chartTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        chartTitle.setForeground(new Color(51, 51, 51));
        chartTitle.setBorder(new EmptyBorder(0, 0, 20, 0));
        chartContainer.add(chartTitle, BorderLayout.NORTH);

        JPanel chartArea = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBarChart(g, data, colors);
            }
        };
        chartArea.setBackground(Color.WHITE);
        chartArea.setPreferredSize(new Dimension(600, 300));
        chartContainer.add(chartArea, BorderLayout.CENTER);

        JPanel legendPanel = createLegend(data, colors);
        chartContainer.add(legendPanel, BorderLayout.SOUTH);

        return chartContainer;
    }

    private void drawBarChart(Graphics g, Map<String, Long> data, Color[] colors) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (data.isEmpty())
            return;

        int width = getWidth();
        int height = getHeight();
        int margin = 40;
        int chartWidth = width - 2 * margin;
        int chartHeight = height - 2 * margin;

        long maxValue = data.values().stream().mapToLong(Long::longValue).max().orElse(1);
        if (maxValue == 0)
            maxValue = 1;

        int barCount = data.size();
        int barWidth = chartWidth / (barCount * 2); 
        int barSpacing = barWidth;

        g2d.setColor(new Color(200, 200, 200));
        for (int i = 0; i <= 5; i++) {
            long value = (maxValue * i) / 5;
            int y = margin + chartHeight - (chartHeight * i) / 5;
            g2d.drawLine(margin, y, margin + chartWidth, y);

            g2d.setColor(new Color(127, 140, 141));
            g2d.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            g2d.drawString(String.valueOf(value), 5, y + 5);
            g2d.setColor(new Color(200, 200, 200));
        }

        int x = margin + barSpacing / 2;
        int colorIndex = 0;
        for (Map.Entry<String, Long> entry : data.entrySet()) {
            String label = entry.getKey();
            long value = entry.getValue();

            int barHeight = (int) ((double) value / maxValue * chartHeight);
            int barY = margin + chartHeight - barHeight;

            g2d.setColor(colors[colorIndex % colors.length]);
            g2d.fillRect(x, barY, barWidth, barHeight);

            g2d.setColor(new Color(220, 220, 220));
            g2d.drawRect(x, barY, barWidth, barHeight);

            g2d.setColor(new Color(51, 51, 51));
            g2d.setFont(new Font("Segoe UI", Font.BOLD, 12));
            String valueStr = String.valueOf(value);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(valueStr);
            g2d.drawString(valueStr, x + (barWidth - textWidth) / 2, barY - 5);

            g2d.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            fm = g2d.getFontMetrics();
            textWidth = fm.stringWidth(label);
            g2d.drawString(label, x + (barWidth - textWidth) / 2, margin + chartHeight + 15);

            x += barWidth + barSpacing;
            colorIndex++;
        }
    }

    private JPanel createLegend(Map<String, Long> data, Color[] colors) {
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        legendPanel.setBackground(Color.WHITE);
        legendPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        int colorIndex = 0;
        for (String key : data.keySet()) {
            JPanel legendItem = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            legendItem.setBackground(Color.WHITE);

            JPanel colorSquare = new JPanel();
            colorSquare.setBackground(colors[colorIndex % colors.length]);
            colorSquare.setPreferredSize(new Dimension(15, 15));
            colorSquare.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

            JLabel label = new JLabel(key);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            label.setForeground(new Color(51, 51, 51));

            legendItem.add(colorSquare);
            legendItem.add(label);
            legendPanel.add(legendItem);

            colorIndex++;
        }

        return legendPanel;
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
