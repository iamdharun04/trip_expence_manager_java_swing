/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class output extends javax.swing.JFrame {
     private ArrayList<String> userInputData;
     private ArrayList<String> userInputList;
     private String   accomdationRes;
     private String   transportRes;
     private String   activitiestRes;
     private String   shoppingRes;
     private String   entertainmentRes;
     private String   foodRes;
     private double totalAmount;

    /**
     * Creates new form output
     */
    private String loggedInUsername;
    public output(ArrayList<String> userInput,ArrayList<String> userInputL,String usernam) {
        initComponents();
        this.userInputData = userInput;
        this.userInputList = userInputL;
        this.loggedInUsername = usernam;
        fetchDataFromBackend();
        
    }
     private void fetchDataFromBackend() {
        try {
            String URL = "jdbc:mysql://localhost:3306/javapro";
            String user = "root";
            String password = "0000";

        Connection connection = DriverManager.getConnection(URL, user, password);

        String accomdationQuery = "SELECT accommodationchargeid FROM accommodationcharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";


        PreparedStatement accomdation = connection.prepareStatement(accomdationQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));

        ResultSet accomdationResult = accomdation.executeQuery();

        accomdationRes = "";
        
        while (accomdationResult.next()) {
        accomdationRes = accomdationResult.getString("accommodationchargeid");
        }
        
       String transportQuery = "SELECT transportchargeid FROM transportcharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?";


       PreparedStatement transportc= connection.prepareStatement(transportQuery);
       transportc.setString(1, userInputData.get(0));
       transportc.setString(2, userInputData.get(1));
       transportc.setString(3, userInputData.get(2));
       transportc.setString(4, userInputData.get(3));
      
       ResultSet transportResult = transportc.executeQuery();

        transportRes = "";
        if (transportResult.next()) {
            transportRes = transportResult.getString("transportchargeid");
        }
        String activitiesQuery = "SELECT activitieschargeid FROM activitiescharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?";

        PreparedStatement activitiesc= connection.prepareStatement(activitiesQuery);
        activitiesc.setString(1, userInputData.get(0));
        activitiesc.setString(2, userInputData.get(1));
        activitiesc.setString(3, userInputData.get(2));
        activitiesc.setString(4, userInputData.get(3));
        
      
        ResultSet activitiesResult =activitiesc.executeQuery();

        activitiestRes = "";
        while (activitiesResult.next()) {
        activitiestRes = activitiesResult.getString("activitieschargeid");
        }
        
       String shoppingQuery = "SELECT shoppingchargeid FROM shoppingexpence WHERE tripid=? and categoryid=? and membersetid=? and durationid=?";
       PreparedStatement shoppingc= connection.prepareStatement(shoppingQuery);
       shoppingc.setString(1, userInputData.get(0));
       shoppingc.setString(2, userInputData.get(1));
       shoppingc.setString(3, userInputData.get(2));
       shoppingc.setString(4, userInputData.get(3));
       
      
       ResultSet shoppingResult = shoppingc.executeQuery();

        shoppingRes = "";
        if (shoppingResult.next()) {
            shoppingRes = shoppingResult.getString("shoppingchargeid");
        }
        String entertainmentQuery = "SELECT entertainmentchargeid FROM entertainmentexpence WHERE tripid=? and categoryid=? and membersetid=? and durationid=?";
       PreparedStatement entertainmentc= connection.prepareStatement(entertainmentQuery);
       entertainmentc.setString(1, userInputData.get(0));
       entertainmentc.setString(2, userInputData.get(1));
       entertainmentc.setString(3, userInputData.get(2));
       entertainmentc.setString(4, userInputData.get(3));
      
       ResultSet entertainmentResult = entertainmentc.executeQuery();

        entertainmentRes = "";
        if (entertainmentResult.next()) {
            entertainmentRes = entertainmentResult.getString("entertainmentchargeid");
        }
        String foodQuery = "SELECT foodchargeid FROM foodcharge WHERE tripid=? and categoryid=? and membersetid=? and durationid=?";
       PreparedStatement foodc= connection.prepareStatement(foodQuery);
       foodc.setString(1, userInputData.get(0));
       foodc.setString(2, userInputData.get(1));
       foodc.setString(3, userInputData.get(2));
       foodc.setString(4, userInputData.get(3));
      
       ResultSet foodResult = foodc.executeQuery();

        foodRes = "";
        if (foodResult.next()) {
            foodRes = foodResult.getString("foodchargeid");
        }
        System.out.println("Accommodation Result: " + accomdationRes);
        System.out.println("Transport Result: " + transportRes);
        System.out.println("Activities Result: " + activitiestRes);
        System.out.println("Shopping Result: " + shoppingRes);
        System.out.println("Entertainment Result: " + entertainmentRes);
        System.out.println("Food Result: " + foodRes);
       accomdationQuery = "SELECT amount FROM accommodationcharge WHERE accommodationchargeid=?";
       accomdation= connection.prepareStatement(accomdationQuery);
       accomdation.setString(1, accomdationRes);
      
        accomdationResult = accomdation.executeQuery();

        String accomdationamt = "";
        if (accomdationResult.next()) {
            accomdationamt = accomdationResult.getString("amount");
        }
        transportQuery = "SELECT amount FROM transportcharge WHERE transportchargeid=?";
        transportc= connection.prepareStatement( transportQuery);
        transportc.setString(1, transportRes);
      
        transportResult = transportc.executeQuery();

        String transportamt = "";
        if (transportResult.next()) {
            transportamt = transportResult.getString("amount");
        }
         activitiesQuery = "SELECT amount FROM activitiescharge WHERE activitieschargeid=?";
        activitiesc= connection.prepareStatement(activitiesQuery);
        activitiesc.setString(1, activitiestRes);
      
        activitiesResult = activitiesc.executeQuery();

        String activitiesamt = "";
        if (activitiesResult.next()) {
           activitiesamt = activitiesResult.getString("amount");
        }
        shoppingQuery = "SELECT amount FROM shoppingexpence WHERE shoppingchargeid=?";
        shoppingc= connection.prepareStatement(shoppingQuery);
        shoppingc.setString(1, shoppingRes);
      
        shoppingResult = activitiesc.executeQuery();

        String shoppingamt = "";
        if (shoppingResult.next()) {
           shoppingamt = shoppingResult.getString("amount");
        }
        entertainmentQuery = "SELECT amount FROM entertainmentexpence WHERE entertainmentchargeid=?";
        entertainmentc= connection.prepareStatement(entertainmentQuery);
        entertainmentc.setString(1, entertainmentRes);
      
        entertainmentResult = entertainmentc.executeQuery();

        String entertainmentamt = "";
        if (entertainmentResult.next()) {
           entertainmentamt = entertainmentResult.getString("amount");
        }
        foodQuery = "SELECT amount FROM foodcharge WHERE foodchargeid=?";
        foodc= connection.prepareStatement(foodQuery);
        foodc.setString(1, foodRes);
      
        foodResult = foodc.executeQuery();

        String foodamt = "";
        if (foodResult.next()) {
           foodamt = foodResult.getString("amount");
        }
        start.setText(userInputList.get(0));
        end.setText(userInputList.get(1));
        category.setText(userInputList.get(2));
        membersincluded.setText(userInputList.get(3));
        tripduration.setText(userInputList.get(4));
        
        
        accomodation.setText(accomdationamt);
        transport.setText(transportamt);
        activities.setText(activitiesamt);
        shopping.setText(shoppingamt);
        entertainment.setText(entertainmentamt);
        food.setText(foodamt);
        totalAmount = Double.parseDouble(accomdationamt) + 
                            Double.parseDouble(transportamt) + 
                            Double.parseDouble(activitiesamt) + 
                            Double.parseDouble(shoppingamt) + 
                            Double.parseDouble(entertainmentamt) + 
                            Double.parseDouble(foodamt);

        // Set total amount to the label
        expamount.setText(String.valueOf(totalAmount));
        
            
       
         
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        end = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        membersincluded = new javax.swing.JLabel();
        tripduration = new javax.swing.JLabel();
        transport = new javax.swing.JLabel();
        food = new javax.swing.JLabel();
        activities = new javax.swing.JLabel();
        accomodation = new javax.swing.JLabel();
        shopping = new javax.swing.JLabel();
        entertainment = new javax.swing.JLabel();
        expamount = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        starttrip = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        todoaccomo = new javax.swing.JButton();
        todotrans = new javax.swing.JButton();
        todofood = new javax.swing.JButton();
        todoenter = new javax.swing.JButton();
        todoactiv = new javax.swing.JButton();
        todoshop = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("End                               :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 160, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trip category             :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 160, 20));

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duration                      :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 170, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Accomodation charge:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 650, 170, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Transport charge       :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 750, 170, 20));

        jLabel6.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Food charge                 :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 860, 180, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Entertainment charge:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 960, -1, 30));

        jLabel8.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Activities charge         :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 1070, 180, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Shopping charge         :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 1180, 170, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total charge                 :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 1280, 170, 36));

        end.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        end.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 140, 30));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 135, 43, -1));

        membersincluded.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        membersincluded.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(membersincluded, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 130, 40));

        tripduration.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        tripduration.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tripduration, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 120, 60));

        transport.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        transport.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(transport, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 740, 130, 40));

        food.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        food.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(food, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 850, 140, 40));

        activities.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        activities.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(activities, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1070, 110, 20));

        accomodation.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        accomodation.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(accomodation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 640, 140, 30));

        shopping.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        shopping.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(shopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1170, 130, 40));

        entertainment.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        entertainment.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(entertainment, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 950, 130, 40));

        expamount.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        expamount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(expamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1280, 100, 40));

        jLabel22.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Start                            :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 160, 51));

        start.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 130, 30));

        starttrip.setText("Start Trip");
        starttrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starttripMouseClicked(evt);
            }
        });
        jPanel1.add(starttrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 1460, 89, -1));

        jLabel11.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Members included     :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 170, -1));

        category.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        category.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 140, 30));

        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 1460, -1, -1));

        todoaccomo.setText("To-Do");
        todoaccomo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todoaccomoMouseClicked(evt);
            }
        });
        todoaccomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoaccomoActionPerformed(evt);
            }
        });
        jPanel1.add(todoaccomo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 640, -1, -1));

        todotrans.setText("To-do");
        todotrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todotransActionPerformed(evt);
            }
        });
        jPanel1.add(todotrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 740, -1, -1));

        todofood.setText("To-Do");
        todofood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todofoodMouseClicked(evt);
            }
        });
        jPanel1.add(todofood, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 850, -1, -1));

        todoenter.setText("To-Do");
        todoenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todoenterMouseClicked(evt);
            }
        });
        jPanel1.add(todoenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 960, -1, -1));

        todoactiv.setText("To-Do");
        todoactiv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todoactivMouseClicked(evt);
            }
        });
        jPanel1.add(todoactiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 1060, -1, -1));

        todoshop.setText("To-Do");
        todoshop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todoshopMouseClicked(evt);
            }
        });
        jPanel1.add(todoshop, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 1170, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\Safarnamaa Travel and Lifestyle Flyer in Brown and White Corporate Style.png")); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1960, 1740));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 620));

        setSize(new java.awt.Dimension(1399, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void starttripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starttripMouseClicked
       
        
     try {
    
    String URL = "jdbc:mysql://localhost:3306/javapro";
    String user = "root";
    String password = "0000";

    // Establish a connection
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT state FROM customerstripdetails WHERE customerid = ? AND state = 'active'";
        PreparedStatement checkActiveTripStatement = connection.prepareStatement(checkActiveTripQuery);
        checkActiveTripStatement.setString(1, loggedInUsername);

        ResultSet activeTripResult = checkActiveTripStatement.executeQuery();

        if (activeTripResult.next()) {
            // User already has an active trip, display a message box
            JOptionPane.showMessageDialog(this, "You already have an active trip. Close it to start another one.");
        } else {
    String insertQuery = "INSERT INTO customerstripdexp (accommodationchargeid, transportchargeid, foodchargeid, "
            + "activitieschargeid, shoppingchrageid, entertainmentchargeid, totalcost, review, ratings) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // Create a prepared statement
    PreparedStatement insertStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

    // Set values for the parameters
    insertStatement.setFloat(1, 0.0f); // Set accommodationchargeid to 0
    insertStatement.setFloat(2, 0.0f); // Set trnsportchargeid to 0
    insertStatement.setFloat(3, 0.0f); // Set foodchargeid to 0
    insertStatement.setFloat(4, 0.0f); // Set activitieschargeid to 0
    insertStatement.setFloat(5, 0.0f); // Set shoppingchrageid to 0
    insertStatement.setFloat(6, 0.0f); // Set entertainmentchargeid to 0
    insertStatement.setFloat(7, 0.0f); // Set totalcost to 0
    insertStatement.setString(8, "your_review");
    insertStatement.setFloat(9, 0.0f); // Set ratings to 0

    // Execute the insert query
    int rowsInserted = insertStatement.executeUpdate();

    // Check if the insertion was successful
    if (rowsInserted > 0) {
        System.out.println("A new row has been inserted into customerstripdexp!");
    } else {
        System.out.println("Failed to insert a new row into customerstripdexp!");
    }
    try {
   

    // Fetch customertripid from customerstripdexp
    String selectTripIdQuery = "SELECT customertripid FROM customerstripdexp ORDER BY customertripid DESC LIMIT 1";
    Statement selectTripIdStatement = connection.createStatement();
    ResultSet tripIdResult = selectTripIdStatement.executeQuery(selectTripIdQuery);

    int customerTripId = 0;  // Default value if no tripid is found
    if (tripIdResult.next()) {
        customerTripId = tripIdResult.getInt("customertripid");
    }

    String active="active";
    String insertDetailsQuery = "INSERT INTO customerstripdetails (customertripid,customerid,tripid, categoryid, membersetid, durationid, accommodationchargeid, transportchargeid, foodchargeid, activitieschargeid, shoppingchargeid, entertainmentchargeid, totalcostexp, state, description)" +
"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    // Create a prepared statement
    PreparedStatement insertDetailsStatement = connection.prepareStatement(insertDetailsQuery, Statement.RETURN_GENERATED_KEYS);

    // Set values for the parameters
    insertDetailsStatement.setInt(1, customerTripId);
    insertDetailsStatement.setString(2,loggedInUsername);
    insertDetailsStatement.setString(3,userInputData.get(0));
    insertDetailsStatement.setString(4,userInputData.get(1));
    insertDetailsStatement.setString(5,userInputData.get(2));
    insertDetailsStatement.setString(6,userInputData.get(3));
    insertDetailsStatement.setString(7,accomdationRes);
    insertDetailsStatement.setString(8,transportRes);
    insertDetailsStatement.setString(9,activitiestRes);
    insertDetailsStatement.setString(10,shoppingRes);
    insertDetailsStatement.setString(11,entertainmentRes);
    insertDetailsStatement.setString(12,foodRes);
    insertDetailsStatement.setDouble(13,totalAmount);
    insertDetailsStatement.setString(14, active);
    insertDetailsStatement.setString(15, "");
    System.out.println("Generated SQL Query: " + insertDetailsStatement.toString());

    // Execute the insert query
    int detailsRowsInserted = insertDetailsStatement.executeUpdate();

    // Check if the insertion was successful
    if (detailsRowsInserted > 0) {
    System.out.println("A new row has been inserted into customerstripdetails!");
    JOptionPane.showMessageDialog(this, "Trip started! ");
    dispose();

    // Open the menu page (replace MenuPageClass with the actual class name of your menu page)
    menu menuPage = new menu(loggedInUsername);
    menuPage.setVisible(true);
    
} else {
    System.out.println("Failed to insert a new row into customerstripdetails!");
}

    // Close the connection
    connection.close();
} catch (Exception e) {
    e.printStackTrace();
}


        }   
    connection.close();
} catch (Exception e) {
    e.printStackTrace();
}
       

    }//GEN-LAST:event_starttripMouseClicked

    private void todoaccomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoaccomoActionPerformed
        try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM accommodationcharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_todoaccomoActionPerformed

    private void todotransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todotransActionPerformed
         try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM transportcharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_todotransActionPerformed

    private void todoaccomoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todoaccomoMouseClicked
       
    }//GEN-LAST:event_todoaccomoMouseClicked

    private void todofoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todofoodMouseClicked
         try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM foodcharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_todofoodMouseClicked

    private void todoenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todoenterMouseClicked
         try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM entertainmentexpence WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_todoenterMouseClicked

    private void todoactivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todoactivMouseClicked
        try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM activitiescharge WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_todoactivMouseClicked

    private void todoshopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todoshopMouseClicked
         try {
    
        String URL = "jdbc:mysql://localhost:3306/javapro";
         String user = "root";
         String password = "0000";

   
    Connection connection = DriverManager.getConnection(URL, user, password);

    String checkActiveTripQuery = "SELECT description FROM shoppingexpence WHERE tripid=? AND categoryid=? AND membersetid=? AND durationid=?;";
        PreparedStatement accomdation = connection.prepareStatement(checkActiveTripQuery);
        accomdation.setString(1, userInputData.get(0));
        accomdation.setString(2, userInputData.get(1));
        accomdation.setString(3, userInputData.get(2));
        accomdation.setString(4, userInputData.get(3));
        ResultSet resultSet = accomdation.executeQuery();
        if (resultSet.next()) {
        // Retrieve the description from the result set
        String description = resultSet.getString("description");

        // Display the description in a message box
        JOptionPane.showMessageDialog(null, "Accommodation Description:\n" + description, "Description", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Handle the case where no results were found
        JOptionPane.showMessageDialog(null, "No description found for the provided criteria.", "No Description", JOptionPane.WARNING_MESSAGE);
    }
        } catch (Exception e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_todoshopMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        new menu(loggedInUsername).setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accomodation;
    private javax.swing.JLabel activities;
    private javax.swing.JLabel category;
    private javax.swing.JLabel end;
    private javax.swing.JLabel entertainment;
    private javax.swing.JLabel expamount;
    private javax.swing.JLabel food;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel membersincluded;
    private javax.swing.JLabel shopping;
    private javax.swing.JLabel start;
    private javax.swing.JButton starttrip;
    private javax.swing.JButton todoaccomo;
    private javax.swing.JButton todoactiv;
    private javax.swing.JButton todoenter;
    private javax.swing.JButton todofood;
    private javax.swing.JButton todoshop;
    private javax.swing.JButton todotrans;
    private javax.swing.JLabel transport;
    private javax.swing.JLabel tripduration;
    // End of variables declaration//GEN-END:variables
}
