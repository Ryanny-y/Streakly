/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import todolist.ConnectionDb;

/**
 *
 * @author Ryanny
 */
public class SingleTask extends javax.swing.JPanel {

    private final ConnectionDb conDb = new ConnectionDb();
    
    private TaskContainer container;
    private int id;
    private String name, status;
    public SingleTask() {
        initComponents();
        
        setIcon(status_icon, "src/images/circle.png");
        setIcon(remove_icon, "src/images/remove.png");
    }
    
    public SingleTask(TaskContainer container, String status, int id, String name) {
        initComponents();
        this.status = status;
        if(status.equals("pending")) {
           setIcon(status_icon, "src/images/circle.png"); 
        } else {
           setIcon(status_icon, "src/images/check.png");
        }
        
        setIcon(remove_icon, "src/images/remove.png");
        this.container = container;
        this.id = id;
        this.name = name;
        task_lbl.setText(name);
    }
    
    private void setIcon(JButton lbl, String path) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image scaledImage = originalIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lbl.setIcon(scaledIcon);
    }
    
    private void completeTask() {
        String query = "UPDATE todos set status = ? WHERE ID = ? AND name = ?";
        String streakQuery = "UPDATE streak SET count = count + 1;";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             PreparedStatement streakPstmt = con.prepareStatement(streakQuery)) {
            pstmt.setString(1, "completed");
            pstmt.setInt(2, id);
            pstmt.setString(3, name);
            
            pstmt.executeUpdate();
            streakPstmt.executeUpdate();

            container.refetchTasks();
        } catch (SQLException ex) {
            Logger.getLogger(SingleTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void uncompleteTask() {
        String query = "UPDATE todos set status = ? WHERE ID = ? AND name = ?";
        String streakQuery = "UPDATE streak SET count = count - 1;";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             PreparedStatement streakPstmt = con.prepareStatement(streakQuery)) {
            pstmt.setString(1, "pending");
            pstmt.setInt(2, id);
            pstmt.setString(3, name);
            
            pstmt.executeUpdate();
            streakPstmt.executeUpdate();

            container.refetchTasks();
        } catch (SQLException ex) {
            Logger.getLogger(SingleTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void removeTask() {
         String query = "DELETE FROM todos WHERE id = ? AND name = ?";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            
            pstmt.executeUpdate();

            container.refetchTasks();
        } catch (SQLException ex) {
            Logger.getLogger(SingleTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status_icon = new javax.swing.JButton();
        task_lbl = new javax.swing.JLabel();
        remove_icon = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 243, 243));
        setPreferredSize(new java.awt.Dimension(697, 45));

        status_icon.setBorder(null);
        status_icon.setBorderPainted(false);
        status_icon.setContentAreaFilled(false);
        status_icon.setFocusPainted(false);
        status_icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_iconActionPerformed(evt);
            }
        });

        task_lbl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        task_lbl.setText("Task Here");

        remove_icon.setBorder(null);
        remove_icon.setBorderPainted(false);
        remove_icon.setContentAreaFilled(false);
        remove_icon.setFocusPainted(false);
        remove_icon.setFocusable(false);
        remove_icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_iconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(status_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(task_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(task_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remove_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(status_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void status_iconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_iconActionPerformed
        // TODO add your handling code here:
        if(status.equals("pending")) {
           completeTask();
        } else {
           uncompleteTask();
        }
        
    }//GEN-LAST:event_status_iconActionPerformed

    private void remove_iconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_iconActionPerformed
        // TODO add your handling code here:
        removeTask();
    }//GEN-LAST:event_remove_iconActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton remove_icon;
    private javax.swing.JButton status_icon;
    private javax.swing.JLabel task_lbl;
    // End of variables declaration//GEN-END:variables
}
