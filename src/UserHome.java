
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import vmm.DBLoader;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Guntass Kaur
 */
public class UserHome extends javax.swing.JFrame {

    /**
     * Creates new form UseHome
     */
    public UserHome() {
        initComponents();
         getContentPane().setBackground( new Color(240,248,255));
        jLabel3.setText(Global.username);
        setTitle("UserHome");
        setExtendedState(MAXIMIZED_BOTH);
        getallcars();
    }

    void getallcars() {
        try {

            ResultSet rs = DBLoader.executeQuery("Select * from car_details");
            int i = 0;
            CarDesign arr[] = new CarDesign[100000000];  // Bad idea, we’ll fix this too later

            int x = 20, y = 20;

            while (rs.next()) {
                arr[i] = new CarDesign();  // 🔴 You forgot this!

                String car_id = rs.getInt("car_id") + "";
                String Car_Names = rs.getString("car_names");
                String price_per_day_without_driver = rs.getInt("price_per_day_without_driver") + "";
                String price_per_day_with_driver = rs.getInt("price_per_day_with_driver") + "";
                String Security = rs.getInt("security") + "";
                String photo = rs.getString("photo");
                String description = rs.getString("description");
                String brand = rs.getString("brand");
                String car_type = rs.getString("car_type");

                ImageIcon i2 = null;
                try {

                    System.out.println("Trying to load image from: " + photo);
                    File file = new File(photo);  // photo = "src/myploads/bmw m5.jpg"
                    BufferedImage img = ImageIO.read(file);
                    Image resized = img.getScaledInstance(arr[i].lb1.getWidth(), arr[i].lb1.getHeight(), Image.SCALE_SMOOTH);

                    i2 = new ImageIcon(resized);
                } catch (Exception e) {
                    System.out.println("In Photo Catch");
                    e.printStackTrace();
                }
                arr[i].lb1.setIcon(i2);
                arr[i].lb2.setText("Car Names: " + Car_Names);
                arr[i].lb3.setText("Price Without Driver: " + price_per_day_without_driver);
                arr[i].lb4.setText("Price With Driver: " + price_per_day_with_driver);
                arr[i].lb5.setText("Security: " + Security);
                arr[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Booking obj = new Booking(car_id, photo, Car_Names, brand, description, price_per_day_without_driver, price_per_day_with_driver, Security, car_type);
                        obj.setVisible(true);
                     dispose();
                    }
                });

                arr[i].setBounds(x, y, 750, 350);
                main1.add(arr[i]);
                main1.repaint();
                arr[i].repaint();
                y += 360;
                i++;
            }

            main1.setPreferredSize(new Dimension(700, 365 * i));

            main1.revalidate();
        } catch (Exception ex) {
            System.out.println("In Catch");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        main1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(33, 150, 243));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 99, 235));
        jLabel2.setText("WELCOME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(29, 35, 210, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 40, 230, 40);

        jButton1.setBackground(new java.awt.Color(33, 150, 243));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Booking History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(571, 33, 160, 45);

        jButton2.setBackground(new java.awt.Color(33, 150, 243));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Change Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(770, 33, 170, 45);

        jButton3.setBackground(new java.awt.Color(244, 67, 54));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(963, 33, 160, 45);

        main1.setLayout(null);
        jScrollPane2.setViewportView(main1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(250, 170, 800, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "LOGOUT SUCCESSFULL");
            Global.log_in_email="";
            welcome obj = new welcome();
            obj.setVisible(true);
            

        } else {
            JOptionPane.showMessageDialog(this, "NO CLICKED");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserResetPassword obj=new UserResetPassword();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       UserBookingHistory obj=new  UserBookingHistory();
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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel main1;
    // End of variables declaration//GEN-END:variables
}
