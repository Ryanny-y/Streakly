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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import todolist.TaskModel;

/**
 *
 * @author Wendell
 */
public class TaskContainer extends javax.swing.JPanel {

    private final ConnectionDb connDb = new ConnectionDb();

    private String status;

    public TaskContainer() {
        initComponents();
        addComponents();
    }

    public TaskContainer(String status) {
        initComponents();
        this.status = status;
        addComponents();
    }

    private ArrayList<TaskModel> fetchPendingTasks() {
        String query = "SELECT * FROM todos WHERE status = ?";
        ArrayList<TaskModel> tasks = new ArrayList<>(); // List to store TaskModel objects

        try (Connection con = connDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "pending");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String inner_status = rs.getString("status");

                TaskModel task = new TaskModel(id, name, inner_status);

                tasks.add(task);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaskContainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.reverse(tasks);
        return tasks;
    }
    
    private ArrayList<TaskModel> fetchCompletedTasks() {
        String query = "SELECT * FROM todos WHERE status = ?";
        ArrayList<TaskModel> tasks = new ArrayList<>(); // List to store TaskModel objects

        try (Connection con = connDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "completed");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String inner_status = rs.getString("status");

                TaskModel task = new TaskModel(id, name, inner_status);

                tasks.add(task);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaskContainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.reverse(tasks);
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

        ArrayList<TaskModel> tasks = status.equals("pending") ? (ArrayList<TaskModel>) fetchPendingTasks() : (ArrayList<TaskModel>) fetchCompletedTasks();

        int row = 0;
        for (int i = 0; i < tasks.size(); i++) {
            gbc.gridy = row;

            SingleTask newTask = new SingleTask(this, status, tasks.get(i).getId(), tasks.get(i).getName());
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
