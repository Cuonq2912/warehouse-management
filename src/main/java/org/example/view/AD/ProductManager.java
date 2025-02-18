/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.AD;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.S;
import org.example.controller.ProductController;
import org.example.domain.model.ProductModel;

/**
 *
 * @author ADMIN
 */
public class ProductManager extends javax.swing.JFrame {

    private ProductController productController;

    /**
     * Creates new form ProductManager
     */
    public ProductManager() {
        productController = new ProductController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStockQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCategotyid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "ID ", "Name ", "Price", "StockQuantity", "CategoryId"
                }) {
            Class[] types = new Class[] {
                    java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Long.class,
                    java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("Delete");

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name :");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Price :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("StockQuantity");

        txtStockQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockQuantityActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CategoryId :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAdd)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(btnDelete)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(btnExit))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                182, Short.MAX_VALUE)
                                                        .addComponent(txtPrice))
                                                .addGap(89, 89, 89)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4))
                                                .addGap(23, 23, 23)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtCategotyid,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 177,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtStockQuantity))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtCategotyid, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtStockQuantity, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnDelete))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validateInput() throws IllegalAccessException {
        if (txtName.getText().trim().isEmpty() ||
                txtPrice.getText().trim().isEmpty() ||
                txtStockQuantity.getText().trim().isEmpty()) {
            throw new IllegalAccessException(" All fields are required ");
        }

    }

    // private long getCategoryIdFromComboBox() {
    // Object selectedItem = ComboBoxCategories.getSelectedItem();
    // if (selectedItem == null) {
    // throw new IllegalArgumentException("Please select a category");
    // }
    //
    // try {
    // return Long.parseLong(selectedItem.toString());
    // } catch (NumberFormatException e) {
    // throw new IllegalArgumentException("Invalid category format");
    // }
    // }
    //
    // }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed

        try {
            validateInput();
            double price;
            try {
                price = Double.parseDouble(txtPrice.getText().trim());
                if (price < 0) {
                    throw new IllegalArgumentException("Price cannot be negative");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Price must be a valid number");
            }
            long description;
            try {
                description = Long.parseLong(txtStockQuantity.getText().trim());
                if (description < 0) {
                    throw new IllegalArgumentException("Points cannot be negative");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Points must be a valid number");
            }

            ProductModel productmodel = ProductModel.builder()
                    // .id Long.parseLong(txtId.getText().trim())
                    .name("Laptop")
                    .stockQuantity(10L)
                    .price(1000.0)
                    // .categoryId(txtCategotyid.getText().trim().isEmpty() ? null :
                    // Long.parseLong(txtCategotyid.getText().trim()))// Đảm bảo không null
                    .build();

            productController.insert(productmodel);
            JOptionPane.showMessageDialog(this, " inserted successfully!");
            clearFields();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error updating customer: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
        new ADMIN1().setVisible(true);
    }// GEN-LAST:event_btnExitActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNameActionPerformed

    private void txtStockQuantityActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtStockQuantityActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtStockQuantityActionPerformed

    private void clearFields() {
        txtName.setText("");
        txtStockQuantity.setText("");
        txtPrice.setText("");
        txtCategotyid.setText("");
    }

    private void refreshTable() {
        try {
            List<ProductModel> customers = productController.getAll();
            // JTable customerTable = new JTable();
            DefaultTableModel model = (DefaultTableModel) productTable.getModel();
            model.setRowCount(0);

            for (ProductModel customer : customers) {
                model.addRow(new Object[] {
                        customer.getId(),
                        customer.getName(),
                        customer.getPrice(),
                        customer.getStockQuantity(),
                        customer.getCategoryModel(),

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error refreshing table: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductManager.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField txtCategotyid;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockQuantity;
    // End of variables declaration//GEN-END:variables
}
