/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class imagegallery extends javax.swing.JFrame {

    /**
     * Creates new form imagegallery
     */
    public imagegallery() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-06 at 19.07.58.jpeg")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1313, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 12.37.03.jpeg")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2919, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 12.37.02.jpeg")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4205, -1, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Image Gallery");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 260, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("\"click image to download\"");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 230, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 17.13.22 (1).jpeg")); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 849, 1280));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 1310));

        setSize(new java.awt.Dimension(863, 1300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String imagePath = "C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 17.13.22 (2).jpeg";
        askAndDownloadImage(imagePath);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        String imagePath = "C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 12.37.03 (2).jpeg";
        askAndDownloadImage(imagePath);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String imagePath = "C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-04 at 12.37.03 (2).jpeg";
        askAndDownloadImage(imagePath);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        String imagePath = "C:\\Users\\Admin\\Downloads\\WhatsApp Image 2023-12-06 at 19.07.58 (2).jpeg";
        askAndDownloadImage(imagePath);
    }//GEN-LAST:event_jLabel2MouseClicked
    private void askAndDownloadImage(String imagePath) {
    int response = JOptionPane.showConfirmDialog(this, "Do you want to download this image?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        downloadImage(imagePath);
    }
}

private void downloadImage(String imagePath) {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            try {
                Path sourcePath = Paths.get(imagePath);
                String fileName = sourcePath.getFileName().toString();
                Path destinationFolder = Paths.get(System.getProperty("user.home"), "Downloads");
                Path destination;

                int count = 1;
                // Check if the file already exists in the destination folder
                while (Files.exists(destination = destinationFolder.resolve(fileName))) {
                    // If the file already exists, increment the count and update the destination path
                    String finalFileName = fileName;  // effectively final variable for lambda expression
                    fileName = incrementFileName(finalFileName, count);
                    count++;
                }

                final Path finalDestination = destination;  // effectively final variable for lambda expression

                // Copy the image to the destination
                Files.copy(sourcePath, finalDestination);

                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(imagegallery.this, "Image downloaded successfully to: " + finalDestination.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                });
            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(imagegallery.this, "Failed to download image", "Error", JOptionPane.ERROR_MESSAGE);
                });
            }
            return null;
        }
    };

    worker.execute();
}

private String incrementFileName(String fileName, int count) {
    int dotIndex = fileName.lastIndexOf(".");
    String baseName = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    return baseName + "_" + count + extension;
}

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(imagegallery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new imagegallery().setVisible(true);
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
