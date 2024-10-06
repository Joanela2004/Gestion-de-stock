package com.model;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.model.categ;
import com.mod.EmployeForm;
import com.mod.Listcategorie;
import com.mod.article_produit;
import java.awt.HeadlessException;
import java.sql.Statement;
import javax.swing.table.TableCellRenderer;

public class article extends javax.swing.JFrame {

    private DefaultTableModel model;
    private String ancien;

    public article() throws SQLException {

        initComponents();
        Connect();
        loadData();
      
       
        ajoutCateg();
    }
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void loadData() {
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model = new DefaultTableModel(new String[]{"Code categorie", "Reference", "libelle", "rangement","categorie", "fournisseur","stock"}, 0);
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
                    
//                   if(stock<=0){
//                    JOptionPane.showMessageDialog(this, "Votre stock ne doit pas etre insuffisant", "Erreur", JOptionPane.ERROR_MESSAGE);
//                     return;
//                   }
//                   else{

                    model.addRow(new Object[]{codeCat, refArt, libelle, rangement,Cat, fournisseur, stock});
              
                   
                }
                
                rs.close();
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLibelle = new javax.swing.JTextField();
        txtRan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchr = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAjoutA = new javax.swing.JButton();
        btnSuppA = new javax.swing.JButton();
        btnEditA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nbrArt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCat = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFour = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnSuppA1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        txtLibelle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtRan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel1.setText("Libelle :");

        jLabel2.setText("Rangement");

        cherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chercheMouseClicked(evt);
            }
        });

        txtchr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchrActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(652, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText(" X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 153, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GESTION DES ARTICLES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        btnAjoutA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAjoutA.setForeground(new java.awt.Color(0, 102, 0));
        btnAjoutA.setText("Ajouter");
        btnAjoutA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutAActionPerformed(evt);
            }
        });

        btnSuppA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuppA.setForeground(new java.awt.Color(255, 0, 0));
        btnSuppA.setText("Supprimer");
        btnSuppA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppAActionPerformed(evt);
            }
        });

        btnEditA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditA.setForeground(new java.awt.Color(255, 153, 102));
        btnEditA.setText("Modifier");
        btnEditA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Remplissez le formulaire  ci-dessous :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("Actualiser");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Nombre d'articles :");

        nbrArt.setEditable(false);
        nbrArt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nbrArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nbrArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbrArtActionPerformed(evt);
            }
        });

        jLabel8.setText("Reference de l'article :");

        jLabel9.setText("Catégorie :");

        txtCat.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Retour");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        txtRef.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel11.setText("fournisseur");

        txtFour.setBorder(null);

        jLabel12.setText("stock :");

        txtStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        btnSuppA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuppA1.setForeground(new java.awt.Color(255, 0, 0));
        btnSuppA1.setText("Enregistrer");
        btnSuppA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppA1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reference de l' article", "Libelle", " Catégorie", "Code categorie", "Fournisseur", "Rangement", "stock"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFour, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRan, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAjoutA)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSuppA1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEditA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSuppA)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel6)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cherche))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(31, 31, 31)
                        .addComponent(txtFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(txtRan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAjoutA)
                            .addComponent(btnEditA)
                            .addComponent(btnSuppA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuppA1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked
        String pid = txtchr.getText().toString();
        try {
            model.setRowCount(0);

            pstmt = con.prepareStatement("SELECT * FROM categorie WHERE codeCat LIKE ? OR nomCat LIKE ?");
            pstmt.setString(1, pid + "%");
            pstmt.setString(2, pid + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String cdeCat = rs.getString("codeCat");
                String nmCat = rs.getString("nomCat");
                model.addRow(new Object[]{cdeCat, nmCat});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chercheMouseClicked


    private void btnAjoutAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutAActionPerformed
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
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAjoutAActionPerformed

    private void btnEditAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAActionPerformed

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
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Mise à jour des catégories si nécessaire
        


    }//GEN-LAST:event_btnEditAActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();

        if (row >= 0) {
            String cA = table.getValueAt(row, 0).toString();
            String nmA = table.getValueAt(row, 1).toString();
            String cC = table.getValueAt(row, 2).toString();
            String puA = table.getValueAt(row, 3).toString();

            txtRef.setText(cA);
            txtLibelle.setText(nmA);
            txtCat.setSelectedItem(cC);
            txtRan.setText(puA);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnSuppAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppAActionPerformed
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
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                                        

   
    }//GEN-LAST:event_btnSuppAActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnSuppA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppA1ActionPerformed
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
    }//GEN-LAST:event_btnSuppA1ActionPerformed

    private void nbrArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbrArtActionPerformed

    private void txtchrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchrActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new article().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjoutA;
    private javax.swing.JButton btnEditA;
    private javax.swing.JButton btnSuppA;
    private javax.swing.JButton btnSuppA1;
    private javax.swing.JLabel cherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nbrArt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> txtCat;
    private javax.swing.JComboBox<String> txtFour;
    private javax.swing.JTextField txtLibelle;
    private javax.swing.JTextField txtRan;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtchr;
    // End of variables declaration//GEN-END:variables

    private void ajoutCateg() {
        String sql = "SELECT codeCat  from categorie ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                txtCat.addItem(rs.getString("codeCat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
