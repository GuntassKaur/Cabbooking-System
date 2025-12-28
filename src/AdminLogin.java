
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import vmm.DBLoader;

public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
        getContentPane().setBackground( new Color(240,248,255));
        setSize(488, 450);
        setLocationRelativeTo(null);
        setTitle("Admin Login");
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtf = new javax.swing.JTextField();
        jpf = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 2, 14)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 99, 235));
        jLabel1.setText("Admin Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 290, 60);

        jtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfActionPerformed(evt);
            }
        });
        getContentPane().add(jtf);
        jtf.setBounds(260, 100, 172, 42);

        jpf.setText("jPasswordField1");
        jpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfActionPerformed(evt);
            }
        });
        getContentPane().add(jpf);
        jpf.setBounds(260, 200, 172, 42);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 99, 235));
        jLabel2.setText("EMail :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 100, 110, 42);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 99, 235));
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 200, 150, 42);

        jbt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbt.setForeground(new java.awt.Color(37, 99, 235));
        jbt.setText("Login");
        jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActionPerformed(evt);
            }
        });
        getContentPane().add(jbt);
        jbt.setBounds(180, 300, 135, 37);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 120, 0, 0);

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 530, 440);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 99, 235));
        jLabel6.setText("Forgot Password?? No Worries");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 360, 250, 30);

        jButton1.setBackground(new java.awt.Color(37, 99, 235));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Click Here");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 360, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfActionPerformed

    private void jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActionPerformed
        String email = jtf.getText();
        String password = jpf.getText();
        Global.log_in_email=jtf.getText();
        
        try {
            ResultSet rs = DBLoader.executeQuery("Select * from admin where email='" + email + "' and password='" + password + "' ");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                         AdminHome obj = new AdminHome();        
        obj.setVisible(true);         
            this.dispose(); 
           

            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database.");
        }


    }//GEN-LAST:event_jbtActionPerformed

    private void jpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jpfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AdminForgotPassword obj=new AdminForgotPassword();
       obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbt;
    private javax.swing.JPasswordField jpf;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables
}
