package pages;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Sidenav extends javax.swing.JPanel {

    /**
     * Creates new form Sidenav
     */
    public Sidenav() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint paint = new GradientPaint(0, 0, Color.decode("#559da1"), 0, getHeight(), Color.decode("#b2d4d6"));
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        todo_list = new javax.swing.JButton();
        streak = new javax.swing.JButton();
        completed = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STREAKLY");

        todo_list.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        todo_list.setForeground(new java.awt.Color(255, 255, 255));
        todo_list.setText("Todo-List");
        todo_list.setBorder(null);
        todo_list.setBorderPainted(false);
        todo_list.setContentAreaFilled(false);
        todo_list.setFocusPainted(false);
        todo_list.setFocusable(false);
        todo_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todo_listActionPerformed(evt);
            }
        });

        streak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        streak.setForeground(new java.awt.Color(255, 255, 255));
        streak.setText("Streak");
        streak.setBorder(null);
        streak.setBorderPainted(false);
        streak.setContentAreaFilled(false);
        streak.setFocusPainted(false);
        streak.setFocusable(false);
        streak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streakActionPerformed(evt);
            }
        });

        completed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        completed.setForeground(new java.awt.Color(255, 255, 255));
        completed.setText("Completed To-do's");
        completed.setBorder(null);
        completed.setBorderPainted(false);
        completed.setContentAreaFilled(false);
        completed.setFocusPainted(false);
        completed.setFocusable(false);
        completed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(todo_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(streak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(completed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(todo_list, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(streak, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(completed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void todo_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todo_listActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        new TodoPage();
    }//GEN-LAST:event_todo_listActionPerformed

    private void streakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streakActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        new StreakPage();
    }//GEN-LAST:event_streakActionPerformed

    private void completedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton streak;
    private javax.swing.JButton todo_list;
    // End of variables declaration//GEN-END:variables
}
