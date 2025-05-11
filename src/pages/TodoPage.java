package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import todolist.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wendell
 */
public class TodoPage extends javax.swing.JFrame {

    private final ConnectionDb conDb = new ConnectionDb();
    
    public TodoPage() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);

        setSize(900, 500);
        setTitle("Dailist");
        setPreferredSize(new Dimension(900, 500));
        setLocationRelativeTo(null);
        jScrollPane1.getViewport().setOpaque(false);
        
        fieldListener(add_field);
        setVisible(true);
    }

    private void fieldListener(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(field.getText().equals("Type Here")) {
                    field.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(field.getText().isBlank()) {
                    field.setText("Type Here");
                }
            }
            
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidenav1 = new pages.Sidenav();
        add_field = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskContainer1 = new pages.TaskContainer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        add_field.setBackground(new java.awt.Color(240, 240, 240));
        add_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_field.setText("Type Here");
        add_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        add_field.setOpaque(true);

        add_btn.setBackground(new java.awt.Color(58, 187, 189));
        add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("Add Task");
        add_btn.setBorder(null);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        taskContainer1.setOpaque(false);
        jScrollPane1.setViewportView(taskContainer1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidenav1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_field, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidenav1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(add_field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
        String taskName = add_field.getText();
        if(taskName.isBlank() || taskName.equals("Type here")) {
            JOptionPane.showMessageDialog(null, "Field must not be empty!", "Empty Field", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String query = "INSERT INTO todos(name) VALUES (?)";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setString(1, taskName);
            
            pstmt.executeUpdate();
            taskContainer1.refetchTasks();
            add_field.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(TodoPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_add_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField add_field;
    private javax.swing.JScrollPane jScrollPane1;
    private pages.Sidenav sidenav1;
    private pages.TaskContainer taskContainer1;
    // End of variables declaration//GEN-END:variables
}
