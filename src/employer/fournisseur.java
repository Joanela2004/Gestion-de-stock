/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.Category;
import employer.article;
import java.util.HashMap;
import java.util.Map;

public class fournisseur extends javax.swing.JFrame {

    private DefaultTableModel modelFour;
    private DefaultTableModel modelFour2;

    private article articleInstance;
    private Map<String, String> articleMap = new HashMap<>();

    public fournisseur() throws SQLException {
        initComponents();
        Connect();
        LoadData();
        LoadData2();
        modelFour = new DefaultTableModel(new String[]{"codeF", "nomF"}, 0);
        tableFour.setModel(modelFour);
        modelFour2 = new DefaultTableModel(new String[]{"codeF", "refArt", "libelle", "prixU"}, 0);
        tableFr2.setModel(modelFour2);
        AffichL();
        AffichL2();
        actuT();
        ajoutA();
        ajoutF();

    }
    Connection con;
    PreparedStatement pstmt, pstmt2;
    ResultSet rs, rs2;

    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void LoadData() {

        try {
            pstmt = con.prepareStatement("SELECT codeF FROM fournisseur");
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void LoadData2() {
        try {
            pstmt2 = con.prepareStatement("SELECT * FROM appartenir");
            rs2 = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AffichL() {
        try {
            int q;
            pstmt = con.prepareStatement("SELECT * FROM fournisseur");
            rs = pstmt.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            q = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) tableFour.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector vec = new Vector();
                for (int i = 1; i <= q; i++) {
                    vec.add(rs.getString("codeF"));
                    vec.add(rs.getString("nomF"));
                }
                df.addRow(vec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AffichL2() {
        try {
            int q2;
            pstmt2 = con.prepareStatement("SELECT * FROM appartenir");
            rs2 = pstmt2.executeQuery();
            ResultSetMetaData res = rs2.getMetaData();
            q2 = res.getColumnCount();

            DefaultTableModel df1 = (DefaultTableModel) tableFr2.getModel();
            df1.setRowCount(0);

            while (rs2.next()) {
                Vector vec1 = new Vector();
                for (int i = 1; i <= q2; i++) {
                    vec1.add(rs2.getString("codeF"));
                    vec1.add(rs2.getString("refArt"));
                    vec1.add(rs2.getString("libelle"));
                    vec1.add(rs2.getString("prixU"));
                }
                df1.addRow(vec1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actuT() {
        try {
            // Réinitialiser les modèles de tables
            modelFour.setRowCount(0);
            modelFour2.setRowCount(0);

            // Requête SQL avec jointure entre fournisseur et appartenir
            String sql = "SELECT f.codeF, f.nomF, a.codeF, a.refArt, a.libelle, a.prixU "
                    + "FROM fournisseur f "
                    + "JOIN appartenir a ON f.codeF = a.codeF";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Itération sur le résultat de la requête
            while (rs.next()) {
                String cC = rs.getString("codeF");
                String nC = rs.getString("nomF");
                String codF = rs.getString("codeF");
                String refAr = rs.getString("refArt");
                String nomAr = rs.getString("libelle"); // Utiliser la colonne libelle correctement
                String prxU = rs.getString("prixU");

                // Ajouter les lignes dans les deux modèles de table
                modelFour.addRow(new Object[]{cC, nC});
                modelFour2.addRow(new Object[]{codF, refAr, nomAr, prxU});

            }

            // Vérification si aucun enregistrement n'a été trouvé
            if (modelFour.getRowCount() == 0 && modelFour2.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
        }
    }

    private void ajoutF() {
        String sql = "SELECT codeF  from fournisseur ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                txtFrC.addItem(rs.getString("codeF"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void ajoutA() {
        try {
            pstmt = con.prepareStatement("SELECT libelle FROM ARTICLE");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                nomArt.addItem(rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des articles : " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodeF = new javax.swing.JTextField();
        txtNomF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchrF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFour = new javax.swing.JTable();
        btnAjout = new javax.swing.JButton();
        btnSupp = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        puF = new javax.swing.JTextField();
        txtchr1 = new javax.swing.JTextField();
        cherche1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFr2 = new javax.swing.JTable();
        btnAjout1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnSupp1 = new javax.swing.JButton();
        txtFrC = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        nomArt = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        refArtFr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        txtCodeF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtNomF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel1.setText("Code du Founisseur :");

        jLabel2.setText("Nom du Fournisseur :");

        cherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chercheMouseClicked(evt);
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
        jLabel5.setText("FOURNISSEUR D'ARTICLE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tableFour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Fournisseur", "Attribut"
            }
        ));
        tableFour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFourMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableFour);

        btnAjout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAjout.setForeground(new java.awt.Color(0, 102, 0));
        btnAjout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/ajouter(1).png"))); // NOI18N
        btnAjout.setText("Ajouter");
        btnAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutActionPerformed(evt);
            }
        });

        btnSupp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupp.setForeground(new java.awt.Color(255, 0, 0));
        btnSupp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/supprimer(1)-1.png"))); // NOI18N
        btnSupp.setText("Supprimer");
        btnSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 153, 102));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/editer(1).png"))); // NOI18N
        btnEdit.setText("Modifier");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Fournisseur :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/faire-tourner-en-sens-inverse.png"))); // NOI18N
        jLabel6.setText("Actualiser");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(204, 0, 0));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/la-gauche-1.png"))); // NOI18N
        exit.setText("Retour");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel8.setText("Code du Founisseur :");

        jLabel9.setText("Prix Unitaire :");

        puF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        cherche1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cherche1MouseClicked(evt);
            }
        });

        tableFr2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Fournisseur", "Nom Article", "Référence Article", "Prix unitaire"
            }
        ));
        tableFr2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFr2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableFr2);

        btnAjout1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAjout1.setForeground(new java.awt.Color(0, 102, 0));
        btnAjout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/ajouter(1).png"))); // NOI18N
        btnAjout1.setText("Ajouter");
        btnAjout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjout1ActionPerformed(evt);
            }
        });

        btnEdit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit1.setForeground(new java.awt.Color(255, 153, 102));
        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/editer(1).png"))); // NOI18N
        btnEdit1.setText("Modifier");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        btnSupp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupp1.setForeground(new java.awt.Color(255, 0, 0));
        btnSupp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/supprimer(1)-1.png"))); // NOI18N
        btnSupp1.setText("Supprimer");
        btnSupp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupp1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Nom de l'article :");

        nomArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomArtActionPerformed(evt);
            }
        });

        jLabel7.setText("Référence de l'article :");

        refArtFr.setEditable(false);
        refArtFr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refArtFrActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setText(" Prix unitaire d'article :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAjout)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit)
                            .addGap(31, 31, 31)
                            .addComponent(btnSupp))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodeF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNomF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtchrF, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cherche)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(puF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtchr1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cherche1)))
                                    .addComponent(txtFrC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(168, 168, 168)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refArtFr, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAjout1)
                                .addGap(44, 44, 44)
                                .addComponent(btnEdit1)
                                .addGap(31, 31, 31)
                                .addComponent(btnSupp1)
                                .addGap(160, 160, 160))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242)
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(exit))
                                .addGap(51, 51, 51)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFrC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(puF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(refArtFr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cherche1)
                            .addComponent(txtchr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cherche)
                            .addComponent(txtchrF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjout)
                    .addComponent(btnEdit)
                    .addComponent(btnSupp)
                    .addComponent(btnAjout1)
                    .addComponent(btnEdit1)
                    .addComponent(btnSupp1))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked
        String pid = txtchrF.getText().toString();
        try {
            modelFour.setRowCount(0);

            pstmt = con.prepareStatement("SELECT * FROM fournisseur WHERE codeF LIKE ? OR nomF LIKE ?");
            pstmt.setString(1, pid + "%");
            pstmt.setString(2, pid + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String cdeF = rs.getString("codeF");
                String nmF = rs.getString("nomF");
                modelFour.addRow(new Object[]{cdeF, nmF});
            }

            if (modelFour.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chercheMouseClicked


    private void btnAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutActionPerformed
        String idf = txtCodeF.getText();
        String nF = txtNomF.getText();

        // Vérifier si les champs sont vides
        if (idf.isEmpty() || nF.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }

        try {

            // Vérifier si le codeCat existe déjà
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM fournisseur WHERE codeF = ?");
            pstmt.setString(1, idf);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Le code de Fournisseur existe déjà. Veuillez en choisir un autre.");
                return;
            }

            pstmt = con.prepareStatement("INSERT INTO FOURNISSEUR (codeF,nomF) VALUES (?,?)");
            pstmt.setString(1, idf);
            pstmt.setString(2, nF);

            int i = pstmt.executeUpdate();

            if (i == 1) {
                modelFour.addRow(new Object[]{idf, nF});
                JOptionPane.showMessageDialog(this, "Fournisseur ajouté avec succès");
                txtCodeF.setText("");
                txtNomF.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Fournisseur non ajouté ");

            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnAjoutActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String idC = txtCodeF.getText();
        String nC = txtNomF.getText();
        int row = tableFour.getSelectedRow();

        if (row >= 0) {
            String encien = tableFour.getValueAt(row, 0).toString();

            try {
                pstmt = con.prepareStatement("UPDATE FOURNISSEUR SET codeF=?, nomF=? WHERE codeF=?");

                pstmt.setString(1, idC);
                pstmt.setString(2, nC);
                pstmt.setString(3, encien);

                int affR = pstmt.executeUpdate();

                if (affR > 0) {

                    modelFour.setValueAt(idC, row, 0);
                    modelFour.setValueAt(nC, row, 1);

                    JOptionPane.showMessageDialog(this, "Fournisseur modifié");

                    txtCodeF.setText("");
                    txtNomF.setText("");

                } else {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la modification");

                }

            } catch (SQLException ex) {
                Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionner la ligne à modifier");

        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void tableFourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFourMouseClicked
        int row = tableFour.getSelectedRow();

        if (row >= 0) {
            String cF = tableFour.getValueAt(row, 0).toString();
            String nmF = tableFour.getValueAt(row, 1).toString();

            txtCodeF.setText(cF);
            txtNomF.setText(nmF);
        }
    }//GEN-LAST:event_tableFourMouseClicked

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed

        int row = tableFour.getSelectedRow();
        if (row >= 0) {
            String cC = tableFour.getValueAt(row, 0).toString();
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer ce fournisseur?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {

                    pstmt = con.prepareStatement("DELETE FROM fournisseur WHERE codeF=?");
                    pstmt.setString(1, cC);

                    int affectR = pstmt.executeUpdate();

                    if (affectR > 0) {
                        JOptionPane.showMessageDialog(this, "Fournisseur supprimé");
                        txtCodeF.setText("");
                        txtNomF.setText("");
                        modelFour.removeRow(row);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer");

        }

    }//GEN-LAST:event_btnSuppActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        actuT();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_exitMouseClicked

    private void cherche1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cherche1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cherche1MouseClicked

    private void tableFr2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFr2MouseClicked
        int row = tableFr2.getSelectedRow();

        if (row >= 0) {
            String cF1 = tableFr2.getValueAt(row, 0).toString();
            String nmF2 = tableFr2.getValueAt(row, 1).toString();
            String cF3 = tableFr2.getValueAt(row, 2).toString();
            String nmF4 = tableFr2.getValueAt(row, 3).toString();

            txtFrC.setSelectedItem(cF1);
            nomArt.setSelectedItem(nmF2);
            refArtFr.setText(cF3);
            refArtFr.setText(nmF4);
        }
    }//GEN-LAST:event_tableFr2MouseClicked

    private void btnAjout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjout1ActionPerformed
        String codF = (String) txtFrC.getSelectedItem();
        String refAr = this.refArtFr.getText();
        String nomAr = (String) nomArt.getSelectedItem();
        String prxU = puF.getText();

        if (codF.isEmpty() || refAr.isEmpty() || nomAr.isEmpty() || prxU.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }

        try {
            pstmt2 = con.prepareStatement("INSERT INTO appartenir (codeF, refArt, libelle, prixU) VALUES (?, ?, ?, ?)");
            pstmt2.setString(1, codF);
            pstmt2.setString(2, refAr);
            pstmt2.setString(3, nomAr);
            pstmt2.setString(4, prxU);

            int i = pstmt2.executeUpdate();

            if (i == 1) {
                DefaultTableModel modelFour2 = (DefaultTableModel) tableFr2.getModel();
                modelFour2.addRow(new Object[]{codF, refAr, nomAr, prxU});

                JOptionPane.showMessageDialog(this, "Ajouté avec succès");
                // Réinitialiser les champs
                txtCodeF.setText("");
                refArtFr.setText("");
                puF.setText("");
                txtFrC.setSelectedIndex(0);
                nomArt.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout de l'article");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur lors de l'insertion : " + ex.getMessage());
        }

    }//GEN-LAST:event_btnAjout1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnSupp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupp1ActionPerformed

    private void refArtFrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refArtFrActionPerformed

    }//GEN-LAST:event_refArtFrActionPerformed

    private void nomArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomArtActionPerformed
        String libel = (String) nomArt.getSelectedItem();
        try {
            pstmt = con.prepareStatement("SELECT refArt FROM ARTICLE WHERE libelle = ?");
            pstmt.setString(1, libel);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                refArtFr.setText(rs.getString("refArt"));
            }
        } catch (Exception ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_nomArtActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fournisseur().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjout;
    private javax.swing.JButton btnAjout1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnSupp;
    private javax.swing.JButton btnSupp1;
    private javax.swing.JLabel cherche;
    private javax.swing.JLabel cherche1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> nomArt;
    private javax.swing.JTextField puF;
    private javax.swing.JTextField refArtFr;
    private javax.swing.JTable tableFour;
    private javax.swing.JTable tableFr2;
    private javax.swing.JTextField txtCodeF;
    private javax.swing.JComboBox<String> txtFrC;
    private javax.swing.JTextField txtNomF;
    private javax.swing.JTextField txtchr1;
    private javax.swing.JTextField txtchrF;
    // End of variables declaration//GEN-END:variables

}
