/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
+ *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
public class deletedata extends javax.swing.JFrame {
    private Connection con;

    
    public deletedata() {
        initComponents();
        try {
            String url = "jdbc:mysql://localhost:3306/javapro";
            String user = "root";
            String pass = "0000";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        choose = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Choose a table to delete a data");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 240, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "users", "trips", "tripcategory", "membersincluded", "tripduration", "accomodationcharge", "TransportCharge", "FoodCharge", "ActivitiesCharge", "ShoppingExpence ", "EntertainmentExpence", "Customersexpence" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 190, -1));

        choose.setText("choose");
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });
        getContentPane().add(choose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed
         String selectedTable = (String) jComboBox1.getSelectedItem();
        switch (selectedTable) {
        case "users":
            users();
            break;
        case "trips":
            trips();
            break;
        case "tripcategory":
                tripcategory();
                break;
        case "membersincluded":
                membersincluded();
                break;
        case "tripduration":
               tripduration();
                break;
        case "accomodationcharge":
                accomodationcharge();
                break;
        case "TransportCharge":
                TransportCharge();
                break;
        case "FoodCharge":
                FoodCharge();
                break;
        case "ActivitiesCharge":
                ActivitiesCharge();
                break;
        case "ShoppingExpence ":
               ShoppingExpence();
                break;
        case "EntertainmentExpence":
                EntertainmentExpence();
                break;
            
            case "Customersexpence":
                Customersexpence();
                break;

             default:
                 break;
    }
    }//GEN-LAST:event_chooseActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         this.setVisible(false);
        new Admin1().setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
private void users(){
      try {
        String deleteQuery = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter username to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from users");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void tripcategory() {
    try {
        String deleteQuery = "DELETE FROM tripcategory WHERE categoryid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Category ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from tripcategory");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void Customersexpence() {
    try {
        String deleteQuery = "DELETE FROM customersexpence WHERE customerid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Customer ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from customersexpence");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void membersincluded() {
    try {
        String deleteQuery = "DELETE FROM membersincluded WHERE membersetid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Member Set ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from membersincluded");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

private void accomodationcharge() {
    try {
        String deleteQuery = "DELETE FROM accomodationcharge WHERE accommodationchargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Accommodation Charge ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from accomodationcharge");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

private void TransportCharge() {
    try {
        String deleteQuery = "DELETE FROM transportcharge WHERE transportchargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Transport Charge ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from transportcharge");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

// Add similar methods for other tables...

private void EntertainmentExpence() {
    try {
        String deleteQuery = "DELETE FROM entertainmentexpence WHERE entertainmentchargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Entertainment Charge ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from entertainmentexpence");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void trips() {
    try {
        String deleteQuery = "DELETE FROM trips WHERE tripid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Trip ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from trips");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void tripduration() {
    try {
        String deleteQuery = "DELETE FROM tripduration WHERE durationid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Duration ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from tripduration");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void FoodCharge() {
    try {
        String deleteQuery = "DELETE FROM foodcharge WHERE foodchargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Food Charge ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from foodcharge");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void ActivitiesCharge() {
    try {
        String deleteQuery = "DELETE FROM activitiescharge WHERE activitieschargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Activities Charge ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from activitiescharge");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void ShoppingExpence() {
    try {
        String deleteQuery = "DELETE FROM shoppingexpence WHERE shoppingchargeid = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            String valueToDelete = JOptionPane.showInputDialog("Enter Shopping Expense ID to delete:");
            preparedStatement.setString(1, valueToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully from shoppingexpence");
            } else {
                JOptionPane.showMessageDialog(null, "No data found or deletion failed.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

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
            java.util.logging.Logger.getLogger(deletedata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deletedata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deletedata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deletedata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deletedata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choose;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
