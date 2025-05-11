/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import javax.swing.JPanel;
import todolist.ConnectionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import todolist.TaskModel;

/**
 *
 * @author Wendell
 */
public class TaskContainer extends javax.swing.JPanel {

    private ConnectionDb connDb = new ConnectionDb();

    public TaskContainer() {
        initComponents();
        addComponents();
    }

    private ArrayList<TaskModel> fetchTasks() {
        String query = "SELECT * FROM todos WHERE status = ?";
        ArrayList<TaskModel> tasks = new ArrayList<>(); // List to store TaskModel objects

        try (Connection con = connDb.getConnection(); 
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "pending");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");

                TaskModel task = new TaskModel(id, name, status);

                tasks.add(task);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaskContainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tasks;
    }
    
    protected void refetchTasks() {
        removeAll();
        revalidate();
        repaint();
        addComponents();
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.weighty = 0; // Prevent components from expanding vertically
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align to the top-left

        ArrayList<TaskModel> tasks = (ArrayList<TaskModel>) fetchTasks();
        
        int row = 0;
        for (int i = 0; i < tasks.size(); i++) {
            gbc.gridy = row;

            SingleTask newTask = new SingleTask(this, tasks.get(i).getId(), tasks.get(i).getName());
            newTask.setPreferredSize(new Dimension(650, 43));
            add(newTask, gbc);
            row++;
        }

        if (row < 7) {
            gbc.gridy = row; // Stay in the same row as the last element
            gbc.weighty = 1; // Ensure that remaining space is distributed
            add(new JPanel(), gbc);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
