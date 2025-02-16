/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import org.example.view.UserView.CustomerManagerView;

/**
 *
 * @author ADMIN
 */
public class DashboardUser extends javax.swing.JFrame {

    /**
     * Creates new form UESR
     */
    public DashboardUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        customerManagerButton = new javax.swing.JButton();
        importManagerButton = new javax.swing.JButton();
        myProfileButton = new javax.swing.JButton();
        updateAccountButton = new javax.swing.JButton();
        exportManagerButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0),
                new java.awt.Dimension(10, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/ảnh mờ 2.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/thiết kế cho user.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/Thiết kế chưa có tên.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/thiết kế cho user.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/Thiết kế chưa có tên.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 255, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 51));
        jLabel1.setText("DASHBOARD USER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 176, -1));

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 204, 204));
        cancelButton.setText("Cancel");
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 530, -1, -1));

        logoutButton.setBackground(new java.awt.Color(0, 204, 204));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

        customerManagerButton.setBackground(new java.awt.Color(49, 196, 196));
        customerManagerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customerManagerButton.setText("Customer Manager");
        customerManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerManagerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(customerManagerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 40));

        importManagerButton.setBackground(new java.awt.Color(49, 196, 196));
        importManagerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        importManagerButton.setText("Import Manager");
        importManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importManagerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(importManagerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 150, 40));

        myProfileButton.setBackground(new java.awt.Color(49, 196, 196));
        myProfileButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myProfileButton.setText("MyProfile");
        myProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(myProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 150, 40));

        updateAccountButton.setBackground(new java.awt.Color(49, 196, 196));
        updateAccountButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateAccountButton.setText("Update Account");
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 150, 40));

        exportManagerButton.setBackground(new java.awt.Color(49, 196, 196));
        exportManagerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exportManagerButton.setText("Export Manager");
        exportManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportManagerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exportManagerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 150, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/RES1/pngtree-fresh-foods-aisle-at-a-grocery-store-image_13155072.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 570));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 10, 350));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 150, 350));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 150, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            javax.swing.JOptionPane.showMessageDialog(this, "Opening Customer Manager...");
            new CustomerManagerView().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error opening Customer Manager: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_customerManagerButtonActionPerformed

    private void importManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_importManagerButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_importManagerButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_logoutButtonActionPerformed

    private void updateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateAccountButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_updateAccountButtonActionPerformed

    private void myProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_myProfileButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_myProfileButtonActionPerformed

    private void exportManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exportManagerButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_exportManagerButtonActionPerformed

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
        // java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (InstantiationException ex) {
        // java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (IllegalAccessException ex) {
        // java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        // java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // new DashboardUser();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DashboardUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton customerManagerButton;
    private javax.swing.JButton exportManagerButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton importManagerButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton myProfileButton;
    private javax.swing.JButton updateAccountButton;
    // End of variables declaration//GEN-END:variables
}
