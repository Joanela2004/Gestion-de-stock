/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.model;


import com.model.menu;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class Employe extends javax.swing.JFrame {

    /**
     * Creates new form EmployeForm
     */
    public Employe() {
        initComponents();
      
        loadData();
        ajoutservices();
        ajoutrefJirama();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
      public void loadData() {
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"Matricule", "nom", "prenom", "services", "IdServices", "RefJirama", "NomVille"}, 0);
            table.setModel(model);

            try {

                String sql = "SELECT * FROM employe ";

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                //JFrame fenetre = new JFrame ("Liste des personne");
                //fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (rs.next()) {

                    int m = Integer.parseInt(rs.getString("matricule"));
                    String n = rs.getString("nom");
                    String p = rs.getString("prenom");
                    String i = rs.getString("idServices");
                    String r = rs.getString("refJirama");
                    String s = rs.getString("services");
                    String nomv = rs.getString("ville");
                    model.addRow(new Object[]{m, n, p, s, i, r, nomv});
                } 
                rs.close();
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void ajoutservices() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT nomServices  from services ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtServices.removeAllItems();
                while (rs.next()) {
                    txtServices.addItem(rs.getString("nomServices"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ajoutrefJirama() {
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);
            String sql = "SELECT * from jirama ";
            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                txtRefJirama.removeAllItems();
                while (rs.next()) {
                    txtRefJirama.addItem(rs.getString("refJirama"));
                }
            } catch (SQLException e) {
                Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, e);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
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

        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrenom = new javax.swing.JTextField();
        searchData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtServices = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        employer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtRefJirama = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnajout = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSup = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel2.setText("Nom :");

        txtNom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel3.setText("Prénom :");

        txtPrenom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel4.setText("Service :");

        txtServices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtServices.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 153, 51));

        employer.setBackground(new java.awt.Color(255, 153, 0));
        employer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employer.setText("EMPLOYE");
        employer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employerActionPerformed(evt);
            }
        });

        jButton1.setText("accueil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employer, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(160, 160, 160)
                .addComponent(employer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtRefJirama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtRefJirama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Référence de la JIRAMA :");

        jLabel6.setText("Mot de passe :");

        btnajout.setText("ajouter");
        btnajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajoutActionPerformed(evt);
            }
        });

        btnEdit.setText("Modifier");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSup.setText("Supprimer");
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });

        btnmodifier.setText("Enregistrer");
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });

        btnsearch.setText("chercher");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Confirmer le mot de passe :");

        txtPass1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSup))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnmodifier))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnajout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRefJirama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(462, 462, 462))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsearch))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSup)
                                    .addComponent(btnajout))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtRefJirama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnmodifier))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employerActionPerformed

    private void btnajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajoutActionPerformed
        String n, p, s, i, v, r;
        String pa, pa1;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            if ("".equals(txtNom.getText()) || "".equals(txtPrenom.getText()) || "".equals(txtServices.getSelectedItem())
                    || "".equals(txtRefJirama.getSelectedItem()) || "".equals(txtPass.getPassword())) {

                JOptionPane.showMessageDialog(new JFrame(), "Veuillez remplir tous les champs de saisie.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                n = txtNom.getText();
                p = txtPrenom.getText();
                s = txtServices.getSelectedItem().toString();
                r = txtRefJirama.getSelectedItem().toString();
                pa = txtPass.getText();
                pa1 = txtPass1.getText();
           

                String sql1 = "select ville from jirama where refJirama=?";
                PreparedStatement stmt2 = con.prepareStatement(sql1);
                stmt2.setString(1, r);
                ResultSet rs = stmt2.executeQuery();
                rs.next();
                v = rs.getString("ville");
                String sqls = "SELECT idServices FROM services WHERE nomServices =?";
                PreparedStatement stmt = con.prepareStatement(sqls);
                stmt.setString(1, s); // Set the parameter value here
                ResultSet k = stmt.executeQuery();
                k.next();
                i = k.getString("idServices");

                String query = "INSERT INTO employe (nom,prenom,idServices,refJirama,services,pass,pass1,ville) VALUES(?,?,?,?,?,?,?,?)"; // Added closing parenthesis
                PreparedStatement stmt1 = con.prepareStatement(query);

                stmt1.setString(1, n);
                stmt1.setString(2, p);
                stmt1.setString(3, i); // Get the idServices from the result set
                stmt1.setString(4, r);
                stmt1.setString(5, s);
                stmt1.setString(6, pa);
                stmt1.setString(7, pa1);
                stmt1.setString(8, v);
                stmt1.executeUpdate();
                
                if (pa1.equals(pa)) {
                    JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                    txtNom.setText("");
                    txtPrenom.setText("");
                    txtServices.setSelectedItem("");
                    txtRefJirama.setSelectedItem("");
                    txtPass.setText("");
                    txtPass1.setText("");
                 
                  loadData();
                  ajoutrefJirama();
                  ajoutservices();
                } else if (!pa1.equals(pa)) {
                    JOptionPane.showMessageDialog(null, "Resaisissez votre mot de passe");

                }

                stmt1.close();
                stmt.close();
                con.close();

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnajoutActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
       String n;
        int m;
          
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
           Statement st = con.createStatement();
            
             DefaultTableModel model = new DefaultTableModel(new String[]{"Matricule", "nom", "prenom", "services", "IdServices", "RefJirama", "NomVille"}, 0);
           table.setModel(model);
    
           n = searchData.getText();
        
            m = Integer.parseInt(searchData.getText());
           
            if (((Integer) m).equals("") && (n.equals(""))) {
                JOptionPane.showMessageDialog(new JFrame(), "Nom ou matricule obligatoire", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "SELECT nom,matricule,prenom,services,idServices,refJirama,ville FROM employe WHERE nom LIKE '%"+n+"%' OR matricule LIKE '%"+(int)m+"%' ";
                PreparedStatement pstmt = con.prepareStatement(sql);
                
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    int matricule = rs.getInt("matricule");
                   String prenom = rs.getString("prenom");
                    String idServices= rs.getString("idServices");
                    String refJirama = rs.getString("refJirama");
                    String services = rs.getString("services");
                    String nomVille = rs.getString("ville");
                  
                  if(n.equals(nom)){
                  model.addRow(new Object[]{matricule, n, prenom, services, idServices, refJirama, nomVille});
              
                  }else if(((Integer)m).equals(matricule)){
                   model.addRow(new Object[]{matricule, nom, prenom, services, idServices, refJirama, nomVille});
              
                  }

                   
                  
                }

                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aucun résultat trouvé", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            con.close();
        } catch ( ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Employe.super.dispose();
        menu art = new menu();
        art.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
String n, p, s, r, i, pa,pa1, v;
        int m = 0;
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        n = txtNom.getText();
        p = txtPrenom.getText();
        s = txtServices.getSelectedItem().toString();
        r = txtRefJirama.getSelectedItem().toString();
        pa = txtPass.getText();
        pa1=txtPass1.getText();
        // Get the value of the matricule column from the selected row
        m = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String sqls = "SELECT idServices FROM services WHERE nomServices = ?";
            PreparedStatement stmt1 = con.prepareStatement(sqls);
            stmt1.setString(1, s); // Set the parameter value here
            ResultSet k = stmt1.executeQuery();

            String sql1 = "select ville from jirama where refJirama=?";
            PreparedStatement stmt2 = con.prepareStatement(sql1);
            stmt2.setString(1, r);
            ResultSet rs = stmt2.executeQuery();

            if (rs.next()) {
                v = rs.getString("ville");
                if (k.next()) {

                    i = k.getString("idServices");

                    String sql = "UPDATE employe SET nom=?, prenom=?, services=?, idServices=?, refJirama=?,ville=? ,pass=?,pass1=? WHERE matricule=?";
                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, n);
                    stmt.setString(2, p);
                    stmt.setString(3, s);
                    stmt.setString(4, i);
                    stmt.setString(5, r);
                    stmt.setString(6, v);
                    stmt.setString(7, pa);
                     stmt.setString(8, pa1);
                    stmt.setInt(9, m);
                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    table.setValueAt(m, selectedRow, 0);
                    table.setValueAt(n, selectedRow, 1);
                    table.setValueAt(p, selectedRow, 2);
                    table.setValueAt(s, selectedRow, 3);
                    table.setValueAt(i, selectedRow, 4);
                    table.setValueAt(r, selectedRow, 5);

                    table.setValueAt(v, selectedRow, 6);
                } else {
                    // Handle the case where no service ID is found
                    JOptionPane.showMessageDialog(this, "Service introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

            con.close();
            stmt1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

String pa;

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
                int m = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                String n = table.getValueAt(selectedRow, 1).toString();
                String p = table.getValueAt(selectedRow, 2).toString();
                String s = table.getValueAt(selectedRow, 3).toString();
                String i = table.getValueAt(selectedRow, 4).toString();
                String r = table.getValueAt(selectedRow, 5).toString();
                String v = table.getValueAt(selectedRow, 6).toString();
                //  pa = txtPass.getText();
                String sql = "SELECT pass,pass1 from employe where matricule=? ";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, m);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                txtPass.setText(rs.getString("pass"));
                txtPass1.setText(rs.getString("pass1"));
                txtNom.setText(n);
                txtPrenom.setText(p);
                txtServices.setSelectedItem(s);
                txtRefJirama.setSelectedItem(r);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
       supprimerPersonneSelectionnee();
    }//GEN-LAST:event_btnSupActionPerformed
    private void supprimerPersonneSelectionnee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String m = table.getValueAt(selectedRow, 0).toString();
            try {
                String url = "jdbc:mysql://localhost:3306/stock";
                String pwd = "";
                String user = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);

           
                // Ensuite, supprimer la personne de la table "personne"
                String deletePersonneQuery = "DELETE FROM employe WHERE matricule = ?";
                PreparedStatement pstmtDeletePersonne = con.prepareStatement(deletePersonneQuery);
                pstmtDeletePersonne.setString(1, m);
                int rowsDeletedPersonne = pstmtDeletePersonne.executeUpdate();
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSup;
    private javax.swing.JButton btnajout;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton employer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchData;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtNom;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JComboBox<String> txtRefJirama;
    private javax.swing.JComboBox<String> txtServices;
    // End of variables declaration//GEN-END:variables
}
