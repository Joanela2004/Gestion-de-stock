/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mod;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class article_produit extends javax.swing.JFrame {

    /**
     * Creates new form article_produit
     */
    public article_produit() {
        initComponents();
         loadData();
        ajoutcat();
        ajoutcat1();
        ajoutfour();
       
    }
     public void loadData() {
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"Code categorie", "Reference", "libelle", "rangement","categorie", "fournisseur","stock_entree"}, 0);
            table.setModel(model);

            try {

                String sql = "SELECT * FROM article";

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                while (rs.next()) {
                    String Cat = rs.getString("categorie");
                    String codeCat = rs.getString("codeCat");
                    String refArt = rs.getString("refArt");
                    String libelle = rs.getString("libelle");
                    String rangement = rs.getString("rangement");

                    String fournisseur = rs.getString("fournisseur");
                   
                    
                    int stock = rs.getInt("stock_entree");
                    model.addRow(new Object[]{codeCat, refArt, libelle, rangement,Cat, fournisseur, stock});
              
                   
                }
                
                rs.close();
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
        public void ajoutcat() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT nomCat from categorie  ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtCat.removeAllItems();
                while (rs.next()) {
                    txtCat.addItem(rs.getString("nomCat"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
          public void ajoutcat1() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT nomCat from categorie  ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtCat1.removeAllItems();
                while (rs.next()) {
                    txtCat1.addItem(rs.getString("nomCat"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
         public void ajoutfour() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String sql = "SELECT nomF from fournisseur  ";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                txtFour.removeAllItems();
                while (rs.next()) {
                    txtFour.addItem(rs.getString("nomF"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtLibelle = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtCat = new javax.swing.JComboBox<>();
        txtFour = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();
        btnSup = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchData = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnsearch1 = new javax.swing.JButton();
        txtCat1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane2.setViewportView(table);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("categorie  :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 10, 100, 27);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("fournisseur  :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(260, 10, 90, 20);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("reference    :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 50, 70, 27);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("libelle   :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(40, 100, 90, 27);
        jPanel2.add(txtLibelle);
        txtLibelle.setBounds(120, 100, 100, 30);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("stock   :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(270, 60, 70, 27);
        jPanel2.add(txtRan);
        txtRan.setBounds(120, 140, 100, 30);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("rangement   :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 150, 90, 27);
        jPanel2.add(txtRef);
        txtRef.setBounds(120, 50, 100, 30);
        jPanel2.add(txtStock);
        txtStock.setBounds(360, 60, 100, 30);

        jButton3.setText("ajouter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 220, 72, 23);

        txtCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(txtCat);
        txtCat.setBounds(120, 10, 96, 22);

        txtFour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(txtFour);
        txtFour.setBounds(360, 10, 90, 22);

        btnEdit.setText("Modifier");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit);
        btnEdit.setBounds(120, 220, 75, 23);

        btnmodifier.setText("Enregistrer");
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });
        jPanel2.add(btnmodifier);
        btnmodifier.setBounds(250, 220, 86, 23);

        btnSup.setText("Supprimer");
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });
        jPanel2.add(btnSup);
        btnSup.setBounds(370, 220, 85, 23);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("recherche par catégorie :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 30, 250, 30);
        jPanel3.add(searchData);
        searchData.setBounds(140, 140, 180, 40);

        jButton2.setText("actualiser");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(310, 10, 80, 23);

        btnsearch1.setText("chercher");
        btnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearch1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnsearch1);
        btnsearch1.setBounds(20, 150, 76, 23);

        txtCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(txtCat1);
        txtCat1.setBounds(140, 80, 180, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ajout();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
loadData();      
    }//GEN-LAST:event_jButton2ActionPerformed

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

                String codecat = table.getValueAt(selectedRow, 0).toString();
                String ref = table.getValueAt(selectedRow, 1).toString();
                String libelle = table.getValueAt(selectedRow, 2).toString();
                 String rangement = table.getValueAt(selectedRow, 3).toString();
                String categorie = table.getValueAt(selectedRow, 4).toString();
               
                String four = table.getValueAt(selectedRow, 5).toString();
                int stock = Integer.parseInt(table.getValueAt(selectedRow, 6).toString());

                
                txtCat.setSelectedItem(categorie);
                txtRef.setText(ref);
                txtFour.setSelectedItem(four);
                txtLibelle.setText(libelle);
                  txtRan.setText(rangement);
                   
                  

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Listcategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
        String cat,four,rangement,libelle,refArt;
        int stock;

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cat= txtCat.getSelectedItem().toString();
        four= txtFour.getSelectedItem().toString();
        rangement=txtRan.getText();
        libelle=txtLibelle.getText();
        refArt=txtRef.getText();
        stock=Integer.parseInt(txtStock.getText());
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
             String query="select codeCat from categorie where nomCat=?";
             PreparedStatement st1 = con.prepareStatement(query);
            st1.setString(1,cat);
            ResultSet rs1=st1.executeQuery();
            rs1.next();
            String code=rs1.getString("codeCat");

             
            String sq="select stock_entree from article where refArt=?";
            PreparedStatement st = con.prepareStatement(sq);
            st.setString(1,refArt);
            ResultSet rs=st.executeQuery();
            rs.next();
            int stock_tab=rs.getInt("stock_entree");

            int stock_nouveau = stock_tab + stock;
            String sql = "UPDATE article SET stock_entree=?,rangement=?,fournisseur=?,libelle=?,categorie=? where refArt=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, stock_nouveau);
            stmt.setString(2, rangement);
             stmt.setString(3, four);
              stmt.setString(4, libelle);
               stmt.setString(5, cat);
               stmt.setString(6,refArt);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

            table.setValueAt(code, selectedRow, 0);
            table.setValueAt(refArt, selectedRow, 1);
            table.setValueAt(libelle, selectedRow, 2);
            table.setValueAt(rangement, selectedRow, 3);
            table.setValueAt(cat, selectedRow, 4);
           
            table.setValueAt(four, selectedRow, 5);
            table.setValueAt(stock_nouveau, selectedRow, 6);
            
            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Listcategorie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Listcategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String refArt = table.getValueAt(selectedRow, 1).toString();
            try {
                String url = "jdbc:mysql://localhost:3306/stock";
                String pwd = "";
                String user = "root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                String deletePersonneQuery = "DELETE FROM article WHERE refArt = ?";
                PreparedStatement pstmtDeletePersonne = con.prepareStatement(deletePersonneQuery);
                pstmtDeletePersonne.setString(1, refArt);
                int rowsDeletedPersonne = pstmtDeletePersonne.executeUpdate();
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSupActionPerformed

    private void btnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearch1ActionPerformed
        String lib,ref,nomCat;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement st = con.createStatement();
            DefaultTableModel model = new DefaultTableModel(new String[]{"Code categorie", "Reference", "libelle", "rangement","categorie", "fournisseur","stock_entree"}, 0);
            table.setModel(model);
            
            ref = searchData.getText();
            lib = searchData.getText();
            nomCat=txtCat1.getSelectedItem().toString();
             
         
         
           
                 
             
                String sql = "SELECT * FROM article WHERE categorie LIKE ? or libelle LIKE ? OR refArt LIKE ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, ref + "%");
            pstmt.setString(2, lib + "%"); 
            pstmt.setString(3, nomCat + "%");
           
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String libelle= rs.getString("libelle");
                    String refArt = rs.getString("refArt");
                    String Cat = rs.getString("categorie");
                    String codeCat = rs.getString("codeCat");
                    String rangement = rs.getString("rangement");
                    String fournisseur = rs.getString("fournisseur");
                    int stock = rs.getInt("stock_entree");
                   
                    if(lib.equalsIgnoreCase(libelle)){
                        model.addRow(new Object[]{codeCat, refArt, lib, rangement,Cat, fournisseur, stock});
              
                    }else if(ref.equalsIgnoreCase(refArt)){
                        model.addRow(new Object[]{codeCat, ref, libelle, rangement,Cat, fournisseur, stock});
              
                    }else{
         
                         model.addRow(new Object[]{codeCat, refArt, libelle, rangement,nomCat, fournisseur, stock});
                         ajoutcat1();
                    }
                       
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Aucun résultat trouvé", "Dialog", JOptionPane.ERROR_MESSAGE);
                }

            
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsearch1ActionPerformed
 public void ajout(){
     String Cat,four,code, ref, rang,li;
     int s;
      
                try { 
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
         try (Connection con = DriverManager.getConnection(url, user, pwd)) {
             
             if (txtCat.getSelectedItem().toString().equals("") || txtRef.getText().equals("") 
                     || txtLibelle.getText().equals("")
                     || txtFour.getSelectedItem().equals("") || txtRan.getText().equals("")
                     || txtStock.getText().equals("")) {
                 JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
             } else {
                 
                 Cat = txtCat.getSelectedItem().toString();
                 four = txtFour.getSelectedItem().toString();
                 ref = txtRef.getText();
                 li = txtLibelle.getText();
                 rang = txtRan.getText();
                // pr = Integer.parseInt(txtPrix.getText());
                 s = Integer.parseInt(txtStock.getText());
                 
                String sqls = "SELECT codeCat FROM categorie WHERE nomCat =?";
                PreparedStatement stmt = con.prepareStatement(sqls);
                stmt.setString(1, Cat); // Set the parameter value here
                ResultSet k = stmt.executeQuery();
                

                
                if(k.next()){
                code = k.getString("codeCat");
                 String sql = "INSERT INTO article(codeCat,refArt,libelle,fournisseur,rangement,stock_entree,categorie) VALUES (?,?,?,?,?,?,?)";
                 PreparedStatement st = con.prepareStatement(sql);
                 
               
                st.setString(1, code);
                 st.setString(2, ref);
                 st.setString(3, li);
                 st.setString(4, four);
                 st.setString(5, rang);
               
                 st.setInt(6, s);
                 st.setString(7, Cat);
                 
                 
                 int k2= st.executeUpdate();
                 if(k2==1){
                     
                     JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                     txtFour.setSelectedItem("");
                     txtRef.setText("");
                     txtLibelle.setText("");
                     txtRan.setText("");
                     //txtPrix.setText("");
                     txtStock.setText("");
                     
                     loadData();
                     ajoutcat();
                     ajoutfour();
                     st.close();
                 }else{
                     JOptionPane.showMessageDialog(null, "failed");
                     
                 }
                }
             }
         }
        } catch (SQLException | ClassNotFoundException |NumberFormatException ex) {
            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(article_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(article_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(article_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(article_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new article_produit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSup;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnsearch1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchData;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> txtCat;
    private javax.swing.JComboBox<String> txtCat1;
    private javax.swing.JComboBox<String> txtFour;
    private javax.swing.JTextField txtLibelle;
    private javax.swing.JTextField txtRan;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
