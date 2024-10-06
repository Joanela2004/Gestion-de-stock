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
public class fournisseur extends javax.swing.JFrame {

    /**
     * Creates new form appartenir
     */
    public fournisseur() {
        initComponents();
         ajoutArt();
        ajoutcodeF();
        loadData();
        loadData1();
    }
     public void loadData() {

        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"code du fournisseur", "Nom du fournisseur"}, 0);
            table.setModel(model);

            String sql = "select * from fournisseur";

            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nomF = rs.getString("nomF");
                String codeF = rs.getString("codeF");
                model.addRow(new Object[]{codeF, nomF});
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public void ajoutcodeF() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT codeF  from fournisseur ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtCodeF1.removeAllItems();
                while (rs.next()) {
                    txtCodeF1.addItem(rs.getString("codeF"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  public void ajoutArt() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT refArt  from article ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtRef.removeAllItems();
                while (rs.next()) {
                    txtRef.addItem(rs.getString("refArt"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void loadData1(){

 try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"code du fournisseur", "reference","prix unitaire"}, 0);
            Table.setModel(model);

            String sql = "select * from appartenir";

            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String refArt = rs.getString("refArt");
                String codeF = rs.getString("codeF");
                 int pu = rs.getInt("prixU");
                model.addRow(new Object[]{codeF, refArt,pu});
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
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

        searchData = new javax.swing.JTextField();
        btnajout1 = new javax.swing.JButton();
        btnsearch1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnSup1 = new javax.swing.JButton();
        btnmodifier1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodeF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtPrix = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnmodif = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnsup = new javax.swing.JButton();
        txtCodeF1 = new javax.swing.JComboBox<>();
        txtRef = new javax.swing.JComboBox<>();
        txtNomF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });

        btnajout1.setText("ajouter");
        btnajout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajout1ActionPerformed(evt);
            }
        });

        btnsearch1.setText("chercher");
        btnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearch1ActionPerformed(evt);
            }
        });

        btnEdit1.setText("Modifier");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        btnSup1.setText("Supprimer");
        btnSup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSup1ActionPerformed(evt);
            }
        });

        btnmodifier1.setText("Enregistrer");
        btnmodifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifier1ActionPerformed(evt);
            }
        });

        jButton2.setText("accueil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("code du fournisseur");

        jLabel4.setText("Nom du fournisseur");

        txtCodeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeFActionPerformed(evt);
            }
        });

        jLabel5.setText("prix d'un article");

        jLabel6.setText("reference d' article");

        jLabel7.setText("codeFournisseur");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Table);

        jLabel8.setText("prix unitaire");

        jButton3.setText("ajouter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnmodif.setText("modifier");
        btnmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifActionPerformed(evt);
            }
        });

        btnsave.setText("enregistrer");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnsup.setText("supprimer");
        btnsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupActionPerformed(evt);
            }
        });

        txtCodeF1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtRef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(105, 105, 105)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCodeF1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(33, 33, 33)
                                .addComponent(btnmodif)
                                .addGap(29, 29, 29)
                                .addComponent(btnsave)
                                .addGap(38, 38, 38)
                                .addComponent(btnsup)))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodeF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnmodif)
                    .addComponent(btnsave)
                    .addComponent(btnsup))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

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
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(btnajout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodeF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEdit1)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnmodifier1)
                                        .addGap(47, 47, 47)
                                        .addComponent(btnSup1)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchData)
                            .addComponent(btnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit1)
                            .addComponent(btnajout1)
                            .addComponent(btnSup1)
                            .addComponent(btnmodifier1))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed

    }//GEN-LAST:event_searchDataActionPerformed

    private void btnajout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajout1ActionPerformed
        String nomF, codeF;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            if ("".equals(txtNomF.getText()) || "".equals(txtCodeF.getText())) {

                JOptionPane.showMessageDialog(new JFrame(), "Veuillez remplir tous les champs de saisie.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                codeF = txtCodeF.getText();
                nomF = txtNomF.getText();

                // pa= txtPass.getPassword().toString();
                String query = "INSERT INTO fournisseur (nomF,codeF) VALUES(?,?)"; // Added closing parenthesis
                PreparedStatement stmt1 = con.prepareStatement(query);

                stmt1.setString(1, nomF);

                stmt1.setString(2, codeF); // Get the idServices from the result set
                stmt1.executeUpdate();

                JOptionPane.showMessageDialog(null, "Ajouté avec succès");

                txtNomF.setText("");
                txtCodeF.setText("");

                loadData();

                stmt1.close();
            }

            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnajout1ActionPerformed

    private void btnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearch1ActionPerformed
        String c,nf;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement st = con.createStatement();
            DefaultTableModel model = new DefaultTableModel(new String[]{"idServices", "Nom du Services"}, 0);
            table.setModel(model);

            c = searchData.getText();
            nf = searchData.getText();
            if (c.equals("") && (nf.equals(""))) {
                JOptionPane.showMessageDialog(new JFrame(), "Nom du fournisseur ou code du fournisseur obligatoire", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "SELECT * FROM fournisseur WHERE  nomF LIKE '%"+nf+"%' OR codeF LIKE '%"+c+"%'";
                PreparedStatement pstmt = con.prepareStatement(sql);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String nomF = rs.getString("nomF");
                    String codeF = rs.getString("codeF");

                    if(nf.equalsIgnoreCase(nomF)){
                        model.addRow(new Object[]{codeF, nf});

                    }else if(c.equalsIgnoreCase(codeF)){
                        model.addRow(new Object[]{c, nomF});

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
    }//GEN-LAST:event_btnsearch1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed

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

                String codeF = table.getValueAt(selectedRow, 0).toString();
                String nomF = table.getValueAt(selectedRow, 1).toString();

                txtCodeF.setText(codeF);

                txtNomF.setText(nomF);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnSup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSup1ActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String code = table.getValueAt(selectedRow, 0).toString();
            try {
                String url = "jdbc:mysql://localhost:3306/stock";
                String pwd = "";
                String user = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                String deletePersonneQuery = "DELETE FROM fournisseur WHERE nomF = ?";
                PreparedStatement pstmtDeletePersonne = con.prepareStatement(deletePersonneQuery);
                pstmtDeletePersonne.setString(1, code);
                int rowsDeletedPersonne = pstmtDeletePersonne.executeUpdate();
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSup1ActionPerformed

    private void btnmodifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifier1ActionPerformed
        String nomF, codeF;

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nomF = txtNomF.getText().toString();

        codeF = txtCodeF.getText();

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String sql = "UPDATE fournisseur SET nomF=? where  codeF=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nomF);
            stmt.setString(2, codeF);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

            table.setValueAt(nomF, selectedRow, 0);
            table.setValueAt(codeF, selectedRow, 1);
            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmodifier1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        menu art = new menu();
        art.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCodeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeFActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String refArt,codeF,pu;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            codeF= txtCodeF1.getSelectedItem().toString();
            refArt =txtRef.getSelectedItem().toString();
            pu = txtPrix.getText();
            if ( ( txtCodeF1.getSelectedItem().toString().equals(""))||(pu.equals(""))||( txtRef.getSelectedItem().toString().equals(""))) {
                JOptionPane.showMessageDialog(new JFrame(), "  bbjjjjj", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            } else {

//                String sq = "select codeF from fournisseur";
//                PreparedStatement st = con.prepareStatement(sq);
//                ResultSet rs1 = st.executeQuery();
//                rs1.next();
//                codeF = rs1.getString("codeF");
//
//                String sql = "select refArt from article";
//                PreparedStatement st1 = con.prepareStatement(sql);
//                ResultSet rs2 = st1.executeQuery();
//                rs2.next();
//                refArt = rs2.getString("RefArt");

                String sql1 = "insert into appartenir(refArt,codeF,prixU) values(?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql1);

                pstmt.setString(1, refArt);
                pstmt.setString(2, codeF);
                pstmt.setString(3, pu);

                pstmt.executeUpdate();
                loadData1();
                ajoutcodeF();
                ajoutArt();

            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifActionPerformed
          try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            int selectedRow = Table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                String codeF1 = Table.getValueAt(selectedRow, 0).toString();
                String RefArt = Table.getValueAt(selectedRow, 1).toString();
                int prix = Integer.parseInt(Table.getValueAt(selectedRow, 2).toString());
              
                txtCodeF1.setSelectedItem(codeF1);
                txtRef.setSelectedItem(RefArt);

                txtPrix.setText(String.valueOf(prix));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmodifActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
 String refArt, codeF1;
 int prix;

        int selectedRow = Table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        refArt = txtRef.getSelectedItem().toString();

        codeF1 = txtCodeF1.getSelectedItem().toString();
        prix =Integer.parseInt(txtPrix.getText());
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String sql = "UPDATE appartenir SET refArt=? or prixU=? where  codeF=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, refArt);
            stmt.setInt(2, prix);
            stmt.setString(3, codeF1);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

            Table.setValueAt(codeF1, selectedRow, 0);
            Table.setValueAt(refArt, selectedRow, 1);
             Table.setValueAt(prix, selectedRow, 2);
          
            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupActionPerformed
      
          int selectedRow = Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String codeF = Table.getValueAt(selectedRow, 0).toString();
            try {
                String url = "jdbc:mysql://localhost:3306/stock";
                String pwd = "";
                String user = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                String deletePersonneQuery = "DELETE FROM appartenir WHERE codeF = ?";
                PreparedStatement pstmtDeletePersonne = con.prepareStatement(deletePersonneQuery);
                pstmtDeletePersonne.setString(1, codeF);
                int rowsDeletedPersonne = pstmtDeletePersonne.executeUpdate();
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnsupActionPerformed

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
            java.util.logging.Logger.getLogger(fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fournisseur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnSup1;
    private javax.swing.JButton btnajout1;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnmodifier1;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch1;
    private javax.swing.JButton btnsup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField searchData;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCodeF;
    private javax.swing.JComboBox<String> txtCodeF1;
    private javax.swing.JTextField txtNomF;
    private javax.swing.JTextField txtPrix;
    private javax.swing.JComboBox<String> txtRef;
    // End of variables declaration//GEN-END:variables
}
