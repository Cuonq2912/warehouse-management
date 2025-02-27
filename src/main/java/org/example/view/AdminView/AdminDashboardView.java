package org.example.view.AdminView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;
import org.example.utils.HibernateUtils;

/**
 *
 * @author ADMIN
 */
public class AdminDashboardView extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN1
     */
    public AdminDashboardView() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnProduct = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnSendmail = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/thiet-ke-cua-hang-tap-hoa-2.jpg"))); // NOI18N

        jLabel5.setText("jLabel5");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/thiet-ke-cua-hang-tap-hoa-2.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/thiet-ke-cua-hang-tap-hoa-11.JPG"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/RES1/pngtree-fresh-foods-aisle-at-a-grocery-store-image_13155072.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/RES1/pngtree-fresh-foods-aisle-at-a-grocery-store-image_13155072.jpg"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/RES1/pngtree-fresh-foods-aisle-at-a-grocery-store-image_13155072.jpg"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/ảnh mờ 2.jpg"))); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProduct.setBackground(new java.awt.Color(204, 255, 255));
        btnProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProduct.setText("ProductManager");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 150, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 165, 37, -1));

        btnImport.setBackground(new java.awt.Color(204, 255, 255));
        btnImport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnImport.setText("ImportManager");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        getContentPane().add(btnImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, -1));

        btnExport.setBackground(new java.awt.Color(204, 255, 255));
        btnExport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExport.setText("ExportManager");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        getContentPane().add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 150, -1));

        btnUser.setBackground(new java.awt.Color(204, 255, 255));
        btnUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUser.setText("UserManager");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 150, -1));

        btnUpdate.setBackground(new java.awt.Color(204, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Update Account");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 150, -1));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("Logout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 590, -1, -1));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, -1, -1));

        btnSupplier.setBackground(new java.awt.Color(204, 255, 255));
        btnSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSupplier.setText("Supplier Mgr ");
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(btnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 30));

        jLabel9.setBackground(new java.awt.Color(102, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 51, 0));
        jLabel9.setText("DASHBOARD ADMIN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 40));

        btnSendmail.setBackground(new java.awt.Color(204, 255, 255));
        btnSendmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSendmail.setText("Send email");
        btnSendmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendmailActionPerformed(evt);
            }
        });
        getContentPane().add(btnSendmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 150, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/ảnh làm mờ.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnProductActionPerformed
        this.setVisible(false);
        new ProductManagerView().setVisible(true);
    }// GEN-LAST:event_btnProductActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportActionPerformed
        this.setVisible(false);
        new ImportManagerView().setVisible(true);
    }// GEN-LAST:event_btnImportActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
        var db = HibernateUtils.getEntityManager();

        db.getTransaction().begin();
        db.getTransaction().commit();

        JOptionPane.showMessageDialog(this, " thoát thành công");
        System.exit(0);
    }// GEN-LAST:event_jButton9ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        JOptionPane.showMessageDialog(this, "Feature will be available in upcoming updates", "Messenger",
                JOptionPane.OK_OPTION);
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);

    }// GEN-LAST:event_jButton8ActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportActionPerformed
        this.setVisible(false);
        new ExportManagerView().setVisible(true);
    }// GEN-LAST:event_btnExportActionPerformed

    private void btnSendmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSendmailActionPerformed
        this.setVisible(false);
        new SendMail().setVisible(true);
    }// GEN-LAST:event_btnSendmailActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUserActionPerformed
        this.setVisible(false);
        new UserManagerView().setVisible(true);
    }// GEN-LAST:event_btnUserActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSupplierActionPerformed
        this.setVisible(false);
        new SupplierManagerView().setVisible(true);
    }// GEN-LAST:event_btnSupplierActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnSendmail;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
