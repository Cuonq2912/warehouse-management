/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.UserView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.example.utils.ExcelUtils;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;

import org.example.controller.CustomerController;
import org.example.domain.model.CustomerModel;
import org.example.view.DashboardUser;

/**
 *
 * @author admin
 */
public class CustomerManagerView extends javax.swing.JFrame {

    /**
     * Creates new form CustomerManagerView
     */

    private CustomerController customerController;

    public CustomerManagerView() {
        initComponents();
        customerController = new CustomerController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        txtPoints = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPoint = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 0));
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        exportButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CUSTOMER MANAGER");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, -1));

        editButton.setBackground(new java.awt.Color(204, 204, 255));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setText("Edit");
        editButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 74, 25));

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 240, 22));

        txtPoints.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPointsActionPerformed(evt);
            }
        });
        getContentPane().add(txtPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 70, 22));

        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 240, 22));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 240, 22));

        deleteButton.setBackground(new java.awt.Color(204, 204, 255));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 74, 25));

        searchButton.setBackground(new java.awt.Color(204, 204, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 74, 25));

        insertButton.setBackground(new java.awt.Color(204, 204, 255));
        insertButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insertButton.setText("Insert");
        insertButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        getContentPane().add(insertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 74, 25));

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 240, 22));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone Number:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        txtPoint.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPoint.setForeground(new java.awt.Color(255, 255, 255));
        txtPoint.setText("Point:");
        getContentPane().add(txtPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 110));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 204, 204)));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 80, 30));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "Id", "Name", "Email", "Address", "Phone Number", "Points"
                }) {
            Class[] types = new Class[] {
                    java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 920, 330));

        exportButton.setBackground(new java.awt.Color(0, 153, 51));
        exportButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exportButton.setForeground(new java.awt.Color(255, 255, 255));
        exportButton.setText("Export Excel");
        exportButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 120, 30));

        cancelButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/image1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 980, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validateInput() {
        if (txtName.getText().trim().isEmpty() ||
                txtEmail.getText().trim().isEmpty() ||
                txtAddress.getText().trim().isEmpty() ||
                txtPhoneNumber.getText().trim().isEmpty() ||
                txtPoints.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("All fields are required");
        }
    }

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_insertButtonActionPerformed
        try {
            validateInput();
            long points;
            try {
                points = Long.parseLong(txtPoints.getText().trim());
                if (points < 0) {
                    throw new IllegalArgumentException("Points cannot be negative");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Points must be a valid number");
            }

            CustomerModel customer = CustomerModel.builder()
                    .name(txtName.getText().trim())
                    .email(txtEmail.getText().trim())
                    .address(txtAddress.getText().trim())
                    .phoneNumber(txtPhoneNumber.getText().trim())
                    .points(points)
                    .build();

            customerController.insert(customer);
            JOptionPane.showMessageDialog(this, "Customer inserted successfully!");
            clearFields();
            refreshTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error inserting customer: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_insertButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a customer to edit");
                return;
            }
            validateInput();
            Long customerId = (Long) customerTable.getValueAt(selectedRow, 0);
            long points;
            try {
                points = Long.parseLong(txtPoints.getText().trim());
                if (points < 0) {
                    throw new IllegalArgumentException("Points cannot be negative");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Points must be a valid number");
            }

            CustomerModel customer = CustomerModel.builder()
                    .id(customerId)
                    .name(txtName.getText().trim())
                    .email(txtEmail.getText().trim())
                    .address(txtAddress.getText().trim())
                    .phoneNumber(txtPhoneNumber.getText().trim())
                    .points(points)
                    .build();

            customerController.update(customer);
            JOptionPane.showMessageDialog(this, "Customer updated successfully!");
            clearFields();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error updating customer: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this customer?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            Long id = (Long) customerTable.getValueAt(selectedRow, 0);
            customerController.delete(id);
            JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
            clearFields();
            refreshTable();
        } else {
            clearFields();
        }

    }// GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String searchName = txtName.getText().trim();
            String searchEmail = txtEmail.getText().trim();
            String phoneString = txtPhoneNumber.getText().trim();
            String addString = txtAddress.getText().trim();

            List<CustomerModel> customers = customerController.getAll();

            customers = customers.stream()
                    .filter(c -> {
                        boolean matchesName = searchName.isEmpty() ||
                                (c.getName() != null && c.getName().toLowerCase().contains(searchName.toLowerCase()));

                        boolean matchesEmail = searchEmail.isEmpty() ||
                                (c.getEmail() != null
                                        && c.getEmail().toLowerCase().contains(searchEmail.toLowerCase()));

                        boolean matchesPhone = phoneString.isEmpty() ||
                                (c.getPhoneNumber() != null && c.getPhoneNumber().contains(phoneString));

                        boolean matchesAddress = addString.isEmpty() ||
                                (c.getAddress() != null
                                        && c.getAddress().toLowerCase().contains(addString.toLowerCase()));

                        return matchesName && matchesEmail && matchesPhone && matchesAddress;
                    })
                    .collect(Collectors.toList());

            updateTableData(customers);
            if (customers.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No customers found matching the search criteria",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error searching customer: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
    }// GEN-LAST:event_cancelButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DashboardUser().setVisible(true);
        // DashboardUser dashboardUser = new DashboardUser().setVisible(true);
    }// GEN-LAST:event_backButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
            int rowCount = model.getRowCount();

            List<String> headers = Arrays.asList("ID", "Name", "Email", "Address", "Phone Number", "Points");
            List<Map<String, Object>> data = new ArrayList<>();

            for (int i = 0; i < rowCount; i++) {
                Map<String, Object> rowData = new HashMap<>();
                rowData.put("ID", model.getValueAt(i, 0));
                rowData.put("Name", model.getValueAt(i, 1));
                rowData.put("Email", model.getValueAt(i, 2));
                rowData.put("Address", model.getValueAt(i, 3));
                rowData.put("Phone Number", model.getValueAt(i, 4));
                rowData.put("Points", model.getValueAt(i, 5));
                data.add(rowData);
            }

            JFileChooser fileChooser = new JFileChooser("D:\\Java\\prj-hit"); // Nơi lưu file
            fileChooser.setDialogTitle("Save Excel File");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                ExcelUtils.exportToExcel(filePath, "Customers", headers, data);
                JOptionPane.showMessageDialog(this,
                        "Data exported successfully to " + filePath,
                        "Export Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error exporting data: " + e.getMessage(),
                    "Export Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtEmailActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAddressActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtPointsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPointsActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPointsActionPerformed

    private void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
        txtPoints.setText("");
    }

    private void refreshTable() {
        try {
            List<CustomerModel> customers = customerController.getAll();
            DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
            model.setRowCount(0);

            for (CustomerModel customer : customers) {
                model.addRow(new Object[] {
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getAddress(),
                        customer.getPhoneNumber(),
                        customer.getPoints()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error refreshing table: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTableData(List<CustomerModel> customers) {
        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);

        for (CustomerModel customer : customers) {
            tableModel.addRow(new Object[] {
                    customer.getId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getAddress(),
                    customer.getPhoneNumber(),
                    customer.getPoints()
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        // try {
        // for (javax.swing.UIManager.LookAndFeelInfo info :
        // javax.swing.UIManager.getInstalledLookAndFeels()) {
        // if ("Nimbus".equals(info.getName())) {
        // javax.swing.UIManager.setLookAndFeel(info.getClassName());
        // break;
        // }
        // }
        // } catch (ClassNotFoundException ex) {
        // java.util.logging.Logger.getLogger(CustomerManagerView.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (InstantiationException ex) {
        // java.util.logging.Logger.getLogger(CustomerManagerView.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (IllegalAccessException ex) {
        // java.util.logging.Logger.getLogger(CustomerManagerView.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        // java.util.logging.Logger.getLogger(CustomerManagerView.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerManagerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JLabel txtPoint;
    private javax.swing.JTextField txtPoints;
    // End of variables declaration//GEN-END:variables
}
