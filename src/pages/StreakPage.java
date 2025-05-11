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
public class StreakPage extends javax.swing.JFrame {

    private final ConnectionDb conDb = new ConnectionDb();
    
    public StreakPage() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);

        setSize(900, 500);
        setTitle("Dailist");
        setPreferredSize(new Dimension(900, 500));
        fetchCompletedTasksCount();

        setLocationRelativeTo(null);
        setIcon(streak, "src/images/star.png");
        setVisible(true);
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
                streak.setText("#"+String.valueOf(count));
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
        streak = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><div style='text-align: center';>You have completed your task for # times consecutively. Keep going!</div></html>");

        streak.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        streak.setForeground(new java.awt.Color(255, 255, 255));
        streak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        streak.setText("#0");
        streak.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidenav1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(streak, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidenav1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(streak, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private pages.Sidenav sidenav1;
    private javax.swing.JLabel streak;
    // End of variables declaration//GEN-END:variables
}
