/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Listservices extends javax.swing.JFrame {

    /**
     * Creates new form Listservices
     */
    public Listservices() {
        initComponents();
        loadData();
    }

    public void loadData() {

        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"idServices", "Nom du Services"}, 0);
            table.setModel(model);

            String sql = "select * from services";

            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nomServices = rs.getString("nomServices");
                String idServices = rs.getString("idServices");
                model.addRow(new Object[]{idServices, nomServices});
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnajout = new javax.swing.JButton();
        btnSup = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdServices = new javax.swing.JTextField();
        txtServices = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchData = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnajout.setText("ajouter");
        btnajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutActionPerformed(evt);
            }
        });

        btnSup.setText("Supprimer");
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });

        btnEdit.setText("Modifier");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnmodifier.setText("Enregistrer");
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });

        jLabel1.setText("idServices");

        jLabel2.setText("Nom du services");

        txtIdServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdServicesActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });

        btnsearch.setText("chercher");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jButton1.setText("accueil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(146, 146, 146)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdServices, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnajout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnEdit)
                                .addGap(33, 33, 33)
                                .addComponent(btnmodifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSup)))))
                .addGap(447, 447, 447))
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchData)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtIdServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnajout)
                    .addComponent(btnSup)
                    .addComponent(btnmodifier))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutActionPerformed
        String ns, i;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            if ("".equals(txtServices.getText()) || "".equals(txtIdServices.getText())) {

                JOptionPane.showMessageDialog(new JFrame(), "Veuillez remplir tous les champs de saisie.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                i = txtIdServices.getText();
                ns = txtServices.getText();

                // pa= txtPass.getPassword().toString();
                String query = "INSERT INTO services (nomServices,idServices) VALUES(?,?)"; // Added closing parenthesis
                PreparedStatement stmt1 = con.prepareStatement(query);

                stmt1.setString(1, ns);

                stmt1.setString(2, i); // Get the idServices from the result set
                stmt1.executeUpdate();
                
                 JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                    
                    txtServices.setText("");
                    txtIdServices.setText("");
                   
                loadData();
                
              stmt1.close();
            }
            

                con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:        // TODO add your handling code here:

    }//GEN-LAST:event_btnajoutActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
       int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String i = table.getValueAt(selectedRow, 0).toString();
            try {
                String url = "jdbc:mysql://localhost:3306/stock";
                String pwd = "";
                String user = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                 String deletePersonneQuery = "DELETE FROM services WHERE idServices = ?";
                PreparedStatement pstmtDeletePersonne = con.prepareStatement(deletePersonneQuery);
                pstmtDeletePersonne.setString(1, i);
                int rowsDeletedPersonne = pstmtDeletePersonne.executeUpdate();
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }//GEN-LAST:event_btnSupActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                String i = table.getValueAt(selectedRow, 0).toString();
                String ns = table.getValueAt(selectedRow, 1).toString();

                txtIdServices.setText(i);

                txtServices.setText(ns);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
        String ns, i;
       
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ns = txtServices.getText().toString();

        i = txtIdServices.getText();

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String sql = "UPDATE services SET nomServices=? where  idServices=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, ns);
            stmt.setString(2, i);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

            table.setValueAt(ns, selectedRow, 0);
            table.setValueAt(i, selectedRow, 1);
            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Listservices.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void txtIdServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdServicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdServicesActionPerformed

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed
      
    }//GEN-LAST:event_searchDataActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
   String i,ns;
 
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement st = con.createStatement();
             DefaultTableModel model = new DefaultTableModel(new String[]{"idServices", "Nom du Services"}, 0);
            table.setModel(model);

        
            i = searchData.getText();
            ns = searchData.getText();
            if (i.equals("") || (ns.equals(""))) {
                JOptionPane.showMessageDialog(new JFrame(), "NomServices ou idServices obligatoire", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "SELECT * FROM services WHERE  nomServices LIKE '%"+ns+"%' OR idServices LIKE '%"+i+"%'";
                PreparedStatement pstmt = con.prepareStatement(sql);
                
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String nomServices = rs.getString("nomServices");
                  String idServices = rs.getString("idServices");
                  
                  if(ns.equalsIgnoreCase(nomServices)){
                   model.addRow(new Object[]{idServices, ns});
          
                  }else if(i.equalsIgnoreCase(idServices)){
                      model.addRow(new Object[]{i, nomServices});
          
                  }
                
                }else{
                   JOptionPane.showMessageDialog(new JFrame(), "Aucun résultat trouvé", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                  }
            

            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu art = new menu();
        art.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listservices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listservices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listservices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listservices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listservices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSup;
    private javax.swing.JButton btnajout;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchData;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtIdServices;
    private javax.swing.JTextField txtServices;
    // End of variables declaration//GEN-END:variables
}
