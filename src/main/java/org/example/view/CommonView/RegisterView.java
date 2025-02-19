/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view.CommonView;

import java.util.Arrays;
import javax.swing.JOptionPane;

import org.example.controller.UserController;
import org.example.domain.model.Role;
import org.example.domain.model.Status;
import org.example.domain.model.UserModel;
import org.example.view.DashboardUser;

/**
 *
 * @author admin
 */
public class RegisterView extends javax.swing.JFrame {

    /**
     * Creates new form SignUpView
     */
    public RegisterView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void validateInput() {
        if (txtFullnameSignup.getText().isEmpty() ||
                Arrays.toString(txtPasswordSignup.getPassword()).isEmpty() ||
                txtEmailSignup.getText().isEmpty() ||
                txtPhoneSignup.getText().isEmpty() ||
                txtUsernameSignup.getText().isEmpty()) {
            throw new IllegalArgumentException("All field are required!");
        }
    }

    private void clearFields() {
        txtUsernameSignup.setText("");
        txtPasswordSignup.setText("");
        txtFullnameSignup.setText("");
        txtEmailSignup.setText("");
        txtPhoneSignup.setText("");
        txtAddressSignup.setText("");
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

        Right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUsernameSignup = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonSignup = new javax.swing.JButton();
        txtPasswordSignup = new javax.swing.JPasswordField();
        showPasswordCheckbox = new javax.swing.JCheckBox();
        txtFullnameSignup = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmailSignup = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPhoneSignup = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddressSignup = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        Right.setBackground(new java.awt.Color(102, 0, 102));
        Right.setForeground(new java.awt.Color(255, 153, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES1/Warehouse_Manager_logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("We make inventory simple, ");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("you can focus on growing your business.");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Copyright © warehouse manager company All rights reversed");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
                RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(RightLayout.createSequentialGroup()
                                                .addGroup(RightLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(RightLayout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(jLabel4))
                                                        .addGroup(RightLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(RightLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3)
                                                                        .addGroup(RightLayout.createSequentialGroup()
                                                                                .addGap(45, 45, 45)
                                                                                .addComponent(jLabel2)))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        RightLayout.setVerticalGroup(
                RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(103, 103, 103)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Username");

        txtUsernameSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtUsernameSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtUsernameSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameSignupActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("Password");

        buttonSignup.setBackground(new java.awt.Color(102, 0, 102));
        buttonSignup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonSignup.setForeground(new java.awt.Color(255, 255, 255));
        buttonSignup.setText("SIGN UP");
        buttonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignupActionPerformed(evt);
            }
        });

        txtPasswordSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtPasswordSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtPasswordSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordSignupActionPerformed(evt);
            }
        });

        showPasswordCheckbox.setForeground(new java.awt.Color(102, 0, 102));
        showPasswordCheckbox.setText("Show password");
        showPasswordCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckboxActionPerformed(evt);
            }
        });

        txtFullnameSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtFullnameSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtFullnameSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullnameSignupActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setText("Fullname");

        txtEmailSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtEmailSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailSignupActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
        jLabel9.setText("Email");

        txtPhoneSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtPhoneSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtPhoneSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneSignupActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("Phone ");

        txtAddressSignup.setBackground(new java.awt.Color(153, 0, 153));
        txtAddressSignup.setForeground(new java.awt.Color(255, 255, 255));
        txtAddressSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressSignupActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 102));
        jLabel11.setText("Address");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
                LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(buttonSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(LeftLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addGap(16, 16, 16)
                                                .addGroup(LeftLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(txtEmailSignup,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 263,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFullnameSignup,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 263,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeftLayout
                                                .createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(LeftLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(LeftLayout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtUsernameSignup))
                                                        .addGroup(LeftLayout.createSequentialGroup()
                                                                .addGroup(LeftLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addGroup(LeftLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel11,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel10)))
                                                                .addGap(16, 16, 16)
                                                                .addGroup(LeftLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addGroup(LeftLayout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(showPasswordCheckbox))
                                                                        .addGroup(LeftLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(txtAddressSignup,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        263,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtPhoneSignup,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        263,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtPasswordSignup,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        263,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(41, 41, 41)));
        LeftLayout.setVerticalGroup(
                LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUsernameSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPasswordSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showPasswordCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtFullnameSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmailSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPhoneSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAddressSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addComponent(buttonSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("SIGN UP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, 390,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(149, 149, 149))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addComponent(jLabel5)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, 481,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUsernameSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtUsernameSignupActionPerformed

    private void buttonSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSignupActionPerformed
        validateInput();
        try {
            UserModel user = UserModel.builder()
                    .username(txtUsernameSignup.getText().trim())
                    .password(txtPasswordSignup.getPassword().toString().trim())
                    .fullname(txtFullnameSignup.getText().trim())
                    .email(txtEmailSignup.getText().trim())
                    .phoneNumber(txtPhoneSignup.getText().trim())
                    .address(txtAddressSignup.getText().trim())
                    .role(Role.USER)
                    .status(Status.ACTIVE)
                    .build();
            clearFields();
            UserController userController = new UserController();
            userController.insert(user);
            JOptionPane.showMessageDialog(this,
                    "Registration successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
            new DashboardUser().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Registration failed: " + e.getMessage(), "Error: ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_buttonSignupActionPerformed

    private void txtPasswordSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPasswordSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPasswordSignupActionPerformed

    private void showPasswordCheckboxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_showPasswordCheckboxActionPerformed
        // TODO add your handling code here:
        if (showPasswordCheckbox.isSelected()) {
            txtPasswordSignup.setEchoChar((char) 0);
        } else {
            txtPasswordSignup.setEchoChar('*');
        }
    }// GEN-LAST:event_showPasswordCheckboxActionPerformed

    private void txtFullnameSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFullnameSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFullnameSignupActionPerformed

    private void txtEmailSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtEmailSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtEmailSignupActionPerformed

    private void txtPhoneSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPhoneSignupActionPerformed

    private void txtAddressSignupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAddressSignupActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAddressSignupActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton buttonSignup;
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
    private javax.swing.JCheckBox showPasswordCheckbox;
    private javax.swing.JTextField txtAddressSignup;
    private javax.swing.JTextField txtEmailSignup;
    private javax.swing.JTextField txtFullnameSignup;
    private javax.swing.JPasswordField txtPasswordSignup;
    private javax.swing.JTextField txtPhoneSignup;
    private javax.swing.JTextField txtUsernameSignup;
    // End of variables declaration//GEN-END:variables
}
