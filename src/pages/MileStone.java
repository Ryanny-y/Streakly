package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import todolist.ConnectionDb;

/**
 *
 * @author wendell
 */
public class MileStone extends javax.swing.JFrame {

    private final ConnectionDb conDb = new ConnectionDb();
    private int total_count = 0;

    public MileStone() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);

        setSize(900, 500);
        setTitle("Dailist");
        setPreferredSize(new Dimension(900, 500));
        setLocationRelativeTo(null);
        fetchCompletedTasksCount();
        setMilesTone();
        setVisible(true);
    }

    private void setMilesTone() {
        m1.setVisible(false);
        m2.setVisible(false);
        m3.setVisible(false);
        m4.setVisible(false);
        m5.setVisible(false);
        m6.setVisible(false);
        m7.setVisible(false);

        if (total_count >= 1) {
            m1.setVisible(true);
        } else if (total_count >= 10) {
            m2.setVisible(true);
        } else if (total_count >= 20) {
            m3.setVisible(true);
        } else if (total_count >= 40) {
            m4.setVisible(true);
        } else if (total_count >= 60) {
            m5.setVisible(true);
        } else if (total_count >= 80) {
            m6.setVisible(true);
        } else if (total_count >= 100) {
            m7.setVisible(true);
        }

    }

    private void setIcon(JLabel lbl, String path) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lbl.setIcon(scaledIcon);
    }

    private void fetchCompletedTasksCount() {
        String query = "SELECT COUNT(*) AS completedCount FROM todos WHERE status = ?";

        try (Connection con = conDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "completed");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int count = rs.getInt("completedCount");
                this.total_count = count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaskContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidenav1 = new pages.Sidenav();
        jLabel1 = new javax.swing.JLabel();
        m1 = new javax.swing.JLabel();
        m2 = new javax.swing.JLabel();
        m3 = new javax.swing.JLabel();
        m4 = new javax.swing.JLabel();
        m5 = new javax.swing.JLabel();
        m6 = new javax.swing.JLabel();
        m7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MileStone");

        m1.setBackground(new java.awt.Color(245, 245, 245));
        m1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m1.setText("Congrats on creating your first task!");
        m1.setOpaque(true);

        m2.setBackground(new java.awt.Color(245, 245, 245));
        m2.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m2.setText("Congrats for having 10 consecutive Streak!");
        m2.setOpaque(true);

        m3.setBackground(new java.awt.Color(245, 245, 245));
        m3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m3.setText("Congrats for having 20 consecutive Streak!");
        m3.setOpaque(true);

        m4.setBackground(new java.awt.Color(245, 245, 245));
        m4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m4.setText("Congrats for having 40 consecutive Streak!");
        m4.setOpaque(true);

        m5.setBackground(new java.awt.Color(245, 245, 245));
        m5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m5.setText("Congrats for having 60 consecutive Streak!");
        m5.setOpaque(true);

        m6.setBackground(new java.awt.Color(245, 245, 245));
        m6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m6.setText("Congrats for having 80 consecutive Streak!");
        m6.setOpaque(true);

        m7.setBackground(new java.awt.Color(245, 245, 245));
        m7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        m7.setText("Congrats for having 100 consecutive Streak!");
        m7.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidenav1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m4, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(m5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(m7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidenav1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel m1;
    private javax.swing.JLabel m2;
    private javax.swing.JLabel m3;
    private javax.swing.JLabel m4;
    private javax.swing.JLabel m5;
    private javax.swing.JLabel m6;
    private javax.swing.JLabel m7;
    private pages.Sidenav sidenav1;
    // End of variables declaration//GEN-END:variables
}
