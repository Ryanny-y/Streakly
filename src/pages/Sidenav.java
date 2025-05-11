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
        todo_list_btn = new javax.swing.JButton();
        todo_list_btn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STREAKLY");

        todo_list_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        todo_list_btn.setForeground(new java.awt.Color(255, 255, 255));
        todo_list_btn.setText("Todo-List");
        todo_list_btn.setBorder(null);
        todo_list_btn.setBorderPainted(false);
        todo_list_btn.setContentAreaFilled(false);
        todo_list_btn.setFocusPainted(false);
        todo_list_btn.setFocusable(false);
        todo_list_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todo_list_btnActionPerformed(evt);
            }
        });

        todo_list_btn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        todo_list_btn1.setForeground(new java.awt.Color(255, 255, 255));
        todo_list_btn1.setText("Streak");
        todo_list_btn1.setBorder(null);
        todo_list_btn1.setBorderPainted(false);
        todo_list_btn1.setContentAreaFilled(false);
        todo_list_btn1.setFocusPainted(false);
        todo_list_btn1.setFocusable(false);
        todo_list_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todo_list_btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(todo_list_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(todo_list_btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(todo_list_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(todo_list_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void todo_list_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todo_list_btnActionPerformed
        // TODO add your handling code here:
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        new TodoPage();
    }//GEN-LAST:event_todo_list_btnActionPerformed

    private void todo_list_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todo_list_btn1ActionPerformed
        // TODO add your handling code here:
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        new StreakPage();
    }//GEN-LAST:event_todo_list_btn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton todo_list_btn;
    private javax.swing.JButton todo_list_btn1;
    // End of variables declaration//GEN-END:variables
}
