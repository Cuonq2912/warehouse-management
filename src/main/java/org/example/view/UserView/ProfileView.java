/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.UserView;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.example.domain.model.UserModel;
import org.example.repository.UserDAO;
import org.example.service.user.UserService;
import org.example.service.user.IMPL.UserServiceImpl;
import org.example.utils.SessionManager;

/**
 *
 * @author admin
 */
public class ProfileView extends javax.swing.JFrame {
    private UserService userService;
    private UserModel userModel;

    /**
     * Creates new form UpdateAccountView
     */
    public ProfileView(UserService userService, UserModel userModel) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.userService = userService;
        this.userModel = userModel;

        if (SessionManager.getCurrentUser() == null) {
            JOptionPane.showMessageDialog(this,
                    "No active session found. Please login first.",
                    "Session Error",
                    JOptionPane.WARNING_MESSAGE);
            this.dispose();
            return;
        }

        txtUsername.setEditable(false);
        txtFullname.setEditable(false);
        txtEmail.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtAddress.setEditable(false);
        txtPassword.setEditable(false);

        updateButton.setVisible(false);
        loadUserData();

        // Add window listener to handle closure
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

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        updateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ACOUNT INFOMATION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/11zon_cropped.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 180, 170));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Full name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        txtFullname.setBackground(new java.awt.Color(255, 204, 204));
        txtFullname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtFullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Phone Number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        txtPhoneNumber.setBackground(new java.awt.Color(255, 204, 204));
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 240, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("Email:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        txtEmail.setBackground(new java.awt.Color(255, 204, 204));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 240, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 153));
        jLabel10.setText("Address: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        txtAddress.setBackground(new java.awt.Color(255, 204, 204));
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 240, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 153));
        jLabel11.setText("Username:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtUsername.setBackground(new java.awt.Color(255, 204, 204));
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 240, 30));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 30));

        txtPassword.setBackground(new java.awt.Color(255, 204, 204));
        txtPassword.setText("jPasswordField1");
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 240, 30));

        updateButton.setBackground(new java.awt.Color(255, 204, 204));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/mau-background-dep-75.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Feature will be available in upcoming updates", "Messenger",
                JOptionPane.OK_OPTION);
    }// GEN-LAST:event_updateButton1ActionPerformed}

    private void loadUserData() {
        try {
            UserModel user = SessionManager.getCurrentUser();
            if (user != null) {
                txtUsername.setText(user.getUsername());
                txtFullname.setText(user.getFullname());
                txtEmail.setText(user.getEmail());
                txtPhoneNumber.setText(user.getPhoneNumber());
                txtAddress.setText(user.getAddress());
                txtPassword.setText("********");
            } else {
                JOptionPane.showMessageDialog(this,
                        "No user session found. Please login again.",
                        "Session Error",
                        JOptionPane.WARNING_MESSAGE);
                this.dispose();
                new UserDashboard().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading user data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            this.dispose();
            new UserDashboard().setVisible(true);
        }
    }

    private void validateInput() {
        if (txtFullname.getText().isEmpty() ||
                Arrays.toString(txtPassword.getPassword()).isEmpty() ||
                txtEmail.getText().isEmpty() ||
                txtPhoneNumber.getText().isEmpty() ||
                txtUsername.getText().isEmpty()) {
            throw new IllegalArgumentException("All field are required!");
        }

        String email = txtEmail.getText().trim();
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UserDashboard().setVisible(true);
    }// GEN-LAST:event_updateButtonActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtUsernameActionPerformed

    private void txtFullnameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFullnameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFullnameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtEmailActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAddressActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserDAO userDAO = new UserDAO();
                UserService userService = new UserServiceImpl(userDAO);
                UserModel currentUser = SessionManager.getCurrentUser();
                if (currentUser != null) {
                    new ProfileView(userService, currentUser).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please login first!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
