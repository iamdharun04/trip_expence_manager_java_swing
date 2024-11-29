/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;

public class input extends javax.swing.JFrame {

    /**
     * Creates new form input
     */
    private String loggedInUsername;
    private ArrayList<String> userInputList;
   
    public input(String loggedInUsername, String startLocation, String endLocation) {
        initComponents();
        this.loggedInUsername = loggedInUsername;
        
        // Auto-fill start and end locations
        start.setText(startLocation);
        end.setText(endLocation);
        userInputList = new ArrayList<>();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        next = new javax.swing.JToggleButton();
        Back = new javax.swing.JToggleButton();
        triptype = new javax.swing.JComboBox<>();
        membersincluded = new javax.swing.JComboBox<>();
        duration = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

       
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter your location                                        :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 320, -1));
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 120, 30));

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter place you would like to visit             :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));
        getContentPane().add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 272, 120, 30));

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter the type of trip                                     :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter the no of members                               :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 320, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter trip duration                                         :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 320, -1));

        next.setBackground(new java.awt.Color(204, 204, 204));
        next.setText("Next");
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 553, 110, 30));

        Back.setBackground(new java.awt.Color(204, 204, 204));
        Back.setText("Cancel");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 553, 120, 30));

        triptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Family trip", "Friends Trip", "Personal Trip" }));
        getContentPane().add(triptype, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 322, 120, 30));

        membersincluded.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", " " }));
        getContentPane().add(membersincluded, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 372, -1, 30));

        duration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 422, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-03 at 21.47.11 (2).jpeg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 730));

        setSize(new java.awt.Dimension(1279, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
    String startLocation = start.getText();
    String endLocation = end.getText();
    String tripType = triptype.getSelectedItem().toString();
    String membersIncluded = membersincluded.getSelectedItem().toString();
    String tripDuration = duration.getSelectedItem().toString();

    // Validate input
    if (startLocation.isEmpty() || endLocation.isEmpty() || tripType.isEmpty() || membersIncluded.isEmpty() || tripDuration.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Input Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if any field is empty
    }

    // Rest of your code for database queries and processing
    try {
    userInputList.add(startLocation);
    userInputList.add(endLocation);
    userInputList.add(tripType);
    userInputList.add(membersIncluded);
    userInputList.add(tripDuration);

    try {
        // Assuming you have a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapro", "root", "0000");

       String tripQuery = "SELECT tripid FROM Trips WHERE tripstart = ? and tripend=?";
       PreparedStatement tripStatement = connection.prepareStatement(tripQuery);
       tripStatement.setString(1, startLocation);
       tripStatement.setString(2, endLocation);
       ResultSet tripResult = tripStatement.executeQuery();


        String tripID = "";
        if (tripResult.next()) {
            tripID = tripResult.getString("tripID");
        }

        // Fetch TripCategory ID based on user input
        String categoryQuery = "SELECT CategoryID FROM TripCategory WHERE CategoryName = ?";
        PreparedStatement categoryStatement = connection.prepareStatement(categoryQuery);
        categoryStatement.setString(1, tripType);
        ResultSet categoryResult = categoryStatement.executeQuery();

        String categoryID = "";
        if (categoryResult.next()) {
            categoryID = categoryResult.getString("CategoryID");
        }

        // Fetch MemberSetID based on user input
        String memberSetQuery = "SELECT MemberSetID FROM Membersincluded WHERE totalmemeber = ?";
        PreparedStatement memberSetStatement = connection.prepareStatement(memberSetQuery);
        memberSetStatement.setString(1, membersIncluded);
        ResultSet memberSetResult = memberSetStatement.executeQuery();

        String memberSetID = "";
        if (memberSetResult.next()) {
            memberSetID = memberSetResult.getString("MemberSetID");
        }

        // Fetch TripDuration ID based on user input
        String durationQuery = "SELECT DurationID FROM TripDuration WHERE noofdays = ?";
        PreparedStatement durationStatement = connection.prepareStatement(durationQuery);
        durationStatement.setString(1, tripDuration);
        ResultSet durationResult = durationStatement.executeQuery();

        String durationID = "";
        if (durationResult.next()) {
            durationID = durationResult.getString("DurationID");
        }
        if ("Personal Trip".equalsIgnoreCase(tripType)) {
            // Set the default value for Members Included to 1
            System.out.println("works"); 
            memberSetID="9";
           
        } else {
            membersincluded.setSelectedIndex(0);
            membersincluded.setEnabled(true);
        }
        

        if (tripID.isEmpty() || categoryID.isEmpty() || memberSetID.isEmpty() || durationID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Invalid data retrieved from the database. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
        start.setText("");
        end.setText("");
        triptype.setSelectedIndex(0);
        return;}
        categoryResult.close();
        categoryStatement.close();
        memberSetResult.close();
        memberSetStatement.close();
        durationResult.close();
        durationStatement.close();

        // Close the connection
        connection.close();

        // Now you have the required IDs, you can use them as needed
       
        
        System.out.println("tripid"+ tripID);
        System.out.println("CategoryID: " + categoryID);
        System.out.println("MemberSetID: " + memberSetID);
        System.out.println("DurationID: " + durationID);

        duration.setSelectedIndex(0);
        ArrayList<String> userInputData = new ArrayList<>();
        userInputData.add(tripID);
        userInputData.add(categoryID);
        userInputData.add(memberSetID);
        userInputData.add(durationID);
        output outputPage = new output(userInputData, userInputList,loggedInUsername);
        outputPage.setVisible(true);
        this.setVisible(false);
        

        start.setText("");
        end.setText("");
        triptype.setSelectedIndex(0);
        
        
        
        

    } catch (Exception e) {
        e.printStackTrace();
    }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_nextMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        this.setVisible(false);
        new menu(loggedInUsername).setVisible(true);
    }//GEN-LAST:event_BackMouseClicked

    /**
     * @param args the command line arguments
     */
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JComboBox<String> duration;
    private javax.swing.JTextField end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> membersincluded;
    private javax.swing.JToggleButton next;
    private javax.swing.JTextField start;
    private javax.swing.JComboBox<String> triptype;
    // End of variables declaration//GEN-END:variables
}
