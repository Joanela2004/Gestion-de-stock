package employer;

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

import com.mod.Listcategorie;
import com.mod.article_produit;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.table.TableCellRenderer;

public class article extends javax.swing.JFrame {

    private DefaultTableModel model1;
    private String ancien;

    public article() throws SQLException {

        initComponents();
        Connect();
        loadData();
        nbrCateg();
        ajoutfour();
        ajoutcat();
        dateR.setText(LocalDate.now().toString());
        dateR.setEditable(false);
        model1 = new DefaultTableModel(new String[]{"Reference", "libelle", "Code categorie", "categorie", "rangement", "fournisseur", "stock"}, 0);
        table.setModel(model1);
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

    private void nbrCateg() {
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) AS total FROM article");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int totalCategories = rs.getInt("total");
                nbrArt.setText(String.valueOf(totalCategories)); // Mettre à jour le TextField

            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
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

            DefaultTableModel model = new DefaultTableModel(new String[]{"Code categorie", "Reference", "libelle", "rangement", "categorie", "fournisseur", "stock"}, 0);
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


                    model.addRow(new Object[]{codeCat, refArt, libelle, rangement, Cat, fournisseur, stock});

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
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dateR = new javax.swing.JTextField();

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
                .addContainerGap(454, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218)
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
        btnAjoutA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/ajouter(1).png"))); // NOI18N
        btnAjoutA.setText("Ajouter");
        btnAjoutA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutAActionPerformed(evt);
            }
        });

        btnSuppA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuppA.setForeground(new java.awt.Color(255, 0, 0));
        btnSuppA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/supprimer(1)-1.png"))); // NOI18N
        btnSuppA.setText("Supprimer");
        btnSuppA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppAActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Remplissez le formulaire  ci-dessous :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/faire-tourner-en-sens-inverse-1.png"))); // NOI18N
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

        txtCat.setForeground(new java.awt.Color(255, 102, 51));
        txtCat.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/la-gauche.png"))); // NOI18N
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
        btnSuppA1.setForeground(new java.awt.Color(0, 204, 204));
        btnSuppA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/fleche-de-cercle-de-disquette-vers-la-droite(2).png"))); // NOI18N
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
                "Reference de l' article", "Libelle", " Catégorie", "Code categorie", "Fournisseur", "Rangement", "stock", "Date de reception"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/chercher.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setText("Date de réception :");

        dateR.setEditable(false);
        dateR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(303, 303, 303))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAjoutA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSuppA1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSuppA))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cherche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCat, javax.swing.GroupLayout.Alignment.LEADING, 0, 293, Short.MAX_VALUE)
                                        .addComponent(txtFour, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRan, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(128, 128, 128))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(dateR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(cherche))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(txtFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(txtRan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAjoutA)
                                    .addComponent(btnSuppA)
                                    .addComponent(btnSuppA1)))
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked

    }//GEN-LAST:event_chercheMouseClicked


    private void btnAjoutAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutAActionPerformed

        String Cat, four, code, ref, rang, li;
        int s;

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, pwd)) {

                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Le code de l'article existe déjà. Veuillez en choisir un autre.");
                    return;
                }
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

                    s = Integer.parseInt(txtStock.getText());
                    pstmt = con.prepareStatement("SELECT COUNT(*) FROM ARTICLE WHERE refArt = ?");
                    pstmt.setString(1, ref);
                    ResultSet rs = pstmt.executeQuery();
                    String sqls = "SELECT codeCat FROM categorie WHERE nomCat =?";
                    PreparedStatement stmt = con.prepareStatement(sqls);
                    stmt.setString(1, Cat); // Set the parameter value here
                    ResultSet k = stmt.executeQuery();

                    // Vérifier si l'article existe déjà
                    if (k.next()) {
                        code = k.getString("codeCat");
                        // Insertion de l'article avec la date et l'heure actuelles
                  String sql = "INSERT INTO article(codeCat,refArt,libelle,fournisseur,rangement,stock_entree,categorie) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);

                        st.setString(1, code);
                        st.setString(2, ref);
                        st.setString(3, li);
                        st.setString(4, four);
                        st.setString(5, rang);

                        st.setInt(6, s);
                        st.setString(7, Cat);
      
                      
                        int i = st.executeUpdate();

                        if (i == 1) {
                          

                            JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                            txtFour.setSelectedItem("");
                            txtRef.setText("");
                            txtLibelle.setText("");
                            txtRan.setText("");
                            
                            txtStock.setText("");
                     loadData();
                     ajoutcat();
                     ajoutfour();
                     st.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "failed");

                        }
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }

        nbrCateg();

    }//GEN-LAST:event_btnAjoutAActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (row >= 0) {
                String codecat = table.getValueAt(row, 0).toString();
                String ref = table.getValueAt(row, 1).toString();
                String libelle = table.getValueAt(row, 2).toString();
                String rangement = table.getValueAt(row, 3).toString();
                String categorie = table.getValueAt(row, 4).toString();

                String four = table.getValueAt(row, 5).toString();
                int stock = Integer.parseInt(table.getValueAt(row, 6).toString());

                txtCat.setSelectedItem(categorie);
                txtRef.setText(ref);
                txtFour.setSelectedItem(four);
                txtLibelle.setText(libelle);
                txtRan.setText(rangement);
                txtStock.setText(String.valueOf(stock));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Listcategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnSuppAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppAActionPerformed
        String cat, four, rangement, libelle, refArt;
        int stock;

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cat = txtCat.getSelectedItem().toString();
        four = txtFour.getSelectedItem().toString();
        rangement = txtRan.getText();
        libelle = txtLibelle.getText();
        refArt = txtRef.getText();
        stock = Integer.parseInt(txtStock.getText());
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String query = "select codeCat from categorie where nomCat=?";
            PreparedStatement st1 = con.prepareStatement(query);
            st1.setString(1, cat);
            ResultSet rs1 = st1.executeQuery();
            rs1.next();
            String code = rs1.getString("codeCat");

//            String sq="select stock_entree from article where refArt=?";
//            PreparedStatement st = con.prepareStatement(sq);
//            st.setString(1,refArt);
//            ResultSet rs=st.executeQuery();
//            rs.next();
//            int stock_tab=rs.getInt("stock_entree");
            // int stock_nouveau = stock_tab + stock;
            String sql = "UPDATE article SET stock_entree=?,rangement=?,fournisseur=?,libelle=?,categorie=? where refArt=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, stock);
            stmt.setString(2, rangement);
            stmt.setString(3, four);
            stmt.setString(4, libelle);
            stmt.setString(5, cat);
            stmt.setString(6, refArt);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

            table.setValueAt(code, selectedRow, 0);
            table.setValueAt(refArt, selectedRow, 1);
            table.setValueAt(libelle, selectedRow, 2);
            table.setValueAt(rangement, selectedRow, 3);
            table.setValueAt(cat, selectedRow, 4);

            table.setValueAt(four, selectedRow, 5);
            table.setValueAt(stock, selectedRow, 6);

            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSuppAActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
loadData();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setVisible(false);
        new menu().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jLabel10MouseClicked

    private void nbrArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbrArtActionPerformed

    private void txtchrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchrActionPerformed

    private void btnSuppA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppA1ActionPerformed
        String cat, four, rangement, libelle, refArt;
        int stock;

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cat = txtCat.getSelectedItem().toString();
        four = txtFour.getSelectedItem().toString();
        rangement = txtRan.getText();
        libelle = txtLibelle.getText();
        refArt = txtRef.getText();
        stock = Integer.parseInt(txtStock.getText());
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            String query = "select codeCat from categorie where nomCat=?";
            PreparedStatement st1 = con.prepareStatement(query);
            st1.setString(1, cat);
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                String code = rs1.getString("codeCat");

                String sq = "select stock_entree from article where refArt=?";
                PreparedStatement st = con.prepareStatement(sq);
                st.setString(1, refArt);
                ResultSet rs = st.executeQuery();
                rs.next();
                int stock_tab = rs.getInt("stock_entree");

                String sql = "UPDATE article SET stock_entree=?,rangement=?,fournisseur=?,libelle=?,categorie=? where refArt=?";
                PreparedStatement stmt = con.prepareStatement(sql);

                int stock_nouveau = stock_tab + stock;
                stmt.setInt(1, stock_nouveau);
                stmt.setString(2, rangement);
                stmt.setString(3, four);
                stmt.setString(4, libelle);
                stmt.setString(5, cat);
                stmt.setString(6, refArt);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "La ligne a été modifiée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);

                table.setValueAt(code, selectedRow, 0);
                table.setValueAt(refArt, selectedRow, 1);
                table.setValueAt(libelle, selectedRow, 2);
                table.setValueAt(rangement, selectedRow, 3);
                table.setValueAt(cat, selectedRow, 4);
                table.setValueAt(four, selectedRow, 5);
                table.setValueAt(stock_nouveau, selectedRow, 6);

                stmt.close();
            }
            st1.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuppA1ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        String pide = txtchr.getText().toString();
        try {
            model1.setRowCount(0);

            pstmt = con.prepareStatement("SELECT * FROM article WHERE refArt LIKE ? OR libelle LIKE ?");
            pstmt.setString(1, "%" + pide + "%");
            pstmt.setString(2, "%" + pide + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String Cat = rs.getString("categorie");
                String codeCat = rs.getString("codeCat");
                String refArt = rs.getString("refArt");
                String libelle = rs.getString("libelle");
                String rangement = rs.getString("rangement");

                String fournisseur = rs.getString("fournisseur");

                int stock = rs.getInt("stock_entree");

                model1.addRow(new Object[]{codeCat, refArt, libelle, rangement, Cat, fournisseur, stock});
            }

            if (model1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat trouvé.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur SQL : " + ex.getMessage());
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

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
    private javax.swing.JButton btnSuppA;
    private javax.swing.JButton btnSuppA1;
    private javax.swing.JLabel cherche;
    private javax.swing.JTextField dateR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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

}
