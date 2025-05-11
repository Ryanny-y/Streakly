/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pages;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Wendell
 */
public class WelcomePage extends javax.swing.JFrame {

    public WelcomePage() {
        initComponents();
        
        setSize(900, 500);
        setTitle("Get wtarted with Dailist");
        setPreferredSize(new Dimension(900, 500));
        setLocationRelativeTo(null);
        getStarted_btn.setBackground(Color.WHITE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomePanel2 = new pages.WelcomePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        getStarted_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STREAKLY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><div style='text-align: center'>Stay organized, focused, and in control with our simple yet powerful to-do list app. Whether you're managing daily tasks, planning big projects, or just trying to remember the little things, we've got you covered. Create, organize, and track your tasks with ease — all in one place.</div></html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        getStarted_btn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getStarted_btn.setForeground(new java.awt.Color(73, 172, 174));
        getStarted_btn.setText("Get Started");
        getStarted_btn.setBorder(null);
        getStarted_btn.setBorderPainted(false);
        getStarted_btn.setFocusPainted(false);
        getStarted_btn.setFocusable(false);
        getStarted_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStarted_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout welcomePanel2Layout = new javax.swing.GroupLayout(welcomePanel2);
        welcomePanel2.setLayout(welcomePanel2Layout);
        welcomePanel2Layout.setHorizontalGroup(
            welcomePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanel2Layout.createSequentialGroup()
                .addGroup(welcomePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomePanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(welcomePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(welcomePanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(getStarted_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(welcomePanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        welcomePanel2Layout.setVerticalGroup(
            welcomePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(getStarted_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getStarted_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStarted_btnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TodoPage();
    }//GEN-LAST:event_getStarted_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getStarted_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private pages.WelcomePanel welcomePanel2;
    // End of variables declaration//GEN-END:variables
}
