package employer;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class article extends javax.swing.JFrame {

    private DefaultTableModel model;
    private String ancien;

    public article() throws SQLException {

        initComponents();
        Connect();
        LoadData();

        // Initialisation de la date d'aujourd'hui dans le champ texte
        dateR.setText(LocalDate.now().toString());
        dateR.setEditable(false); // Rendre le champ non modifiable

        model = new DefaultTableModel(new String[]{"refArt", "libelle", "codeCat", "rangement"}, 0);
        tebleArt.setModel(model);

        AffichL();
        actuT();
        nbrCateg();
        ajoutCateg();
        ajoutF();
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

    public void LoadData() {

        try {
            pstmt = con.prepareStatement("SELECT refArt FROM article");
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void AffichL() {
        try {
            int q;
            pstmt = con.prepareStatement("SELECT refArt,libelle,codeCat,rangement FROM ARTICLE");
            rs = pstmt.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            q = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) tebleArt.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector vec = new Vector();
                for (int i = 1; i <= q; i++) {
                    vec.add(rs.getString("refArt"));
                    vec.add(rs.getString("libelle"));
                    vec.add(rs.getString("codeCat"));
                    vec.add(rs.getString("rangement"));
                }
                df.addRow(vec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actuT() {
        try {
            // Réinitialiser le modèle du tableau (vider le tableau)
            model.setRowCount(0);

            // Exécuter la requête pour récupérer les données de la table ARTICLE
            pstmt = con.prepareStatement("SELECT refArt,libelle,codeCat, rangement FROM ARTICLE");
            rs = pstmt.executeQuery();

            // Parcourir les résultats de la requête et les ajouter au tableau
            while (rs.next()) {
                String rA = rs.getString("refArt");
                String lB = rs.getString("libelle");
                String cC = rs.getString("codeCat");
                String rG = rs.getString("rangement");
                model.addRow(new Object[]{rA, lB, cC, rG});
            }

            // Si aucune ligne n'est trouvée
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé");
            }

            // Réinitialiser les champs de texte après l'actualisation
            txtCart.setText("");
            txtLib.setText("");

            // Vérifier si le JComboBox a des éléments avant de réinitialiser
            if (itemCc.getItemCount() > 0) {
                itemCc.setSelectedIndex(0); // Réinitialiser le combobox
            }

            rang.setText("");

            txtchr.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
        }

        // Mettre à jour les catégories si nécessaire
        nbrCateg();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLib = new javax.swing.JTextField();
        rang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchr = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableArt = new javax.swing.JTable();
        btnAjoutA = new javax.swing.JButton();
        btnSuppA = new javax.swing.JButton();
        btnEditA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nbrArt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemCc = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtCart = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fourn = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        dateR = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        qttE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tebleArt = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtCart1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLib1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAjoutA1 = new javax.swing.JButton();
        btnEditA1 = new javax.swing.JButton();
        btnSuppA1 = new javax.swing.JButton();
        txtChe = new javax.swing.JTextField();
        cherch2 = new javax.swing.JLabel();
        txtCat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        txtLib.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        rang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel1.setText("Libelle :");

        jLabel2.setText("Rangement : ");

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
        jLabel5.setText("GESTION DES ARTICLES");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText(" X");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(522, 522, 522)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tableArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Article", "Libelle", "Code Catégorie", "Fournisseur", "Quantité", "Date de reception"
            }
        ));
        tableArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableArtMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableArt);

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

        jLabel8.setText("Code de l'article :");

        jLabel9.setText("Code Catégorie :");

        itemCc.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Retour");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        txtCart.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel11.setText("Fournisseur :");

        fourn.setBorder(null);

        jLabel12.setText("Quantité entrée :");

        dateR.setEditable(false);
        dateR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel13.setText("Date de réception :");

        qttE.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        tebleArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code Art", "Libelle", "Code Catégorie", "Rangement"
            }
        ));
        tebleArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tebleArtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tebleArt);

        jLabel14.setText("Code de l'article :");

        txtCart1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel15.setText("Libelle :");

        txtLib1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel16.setText("Code Catégorie :");

        btnAjoutA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAjoutA1.setForeground(new java.awt.Color(0, 102, 0));
        btnAjoutA1.setText("Ajouter");
        btnAjoutA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutA1ActionPerformed(evt);
            }
        });

        btnEditA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditA1.setForeground(new java.awt.Color(255, 153, 102));
        btnEditA1.setText("Modifier");
        btnEditA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditA1ActionPerformed(evt);
            }
        });

        btnSuppA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuppA1.setForeground(new java.awt.Color(255, 0, 0));
        btnSuppA1.setText("Supprimer");
        btnSuppA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppA1ActionPerformed(evt);
            }
        });

        txtChe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheActionPerformed(evt);
            }
        });

        cherch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cherch2MouseClicked(evt);
            }
        });

        txtCat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 2173, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAjoutA)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnEditA)))
                        .addGap(32, 32, 32)
                        .addComponent(btnSuppA)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnAjoutA1)
                        .addGap(47, 47, 47)
                        .addComponent(btnEditA1)
                        .addGap(36, 36, 36)
                        .addComponent(btnSuppA1)
                        .addGap(996, 996, 996))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtChe, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCart1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                        .addComponent(txtLib1)
                                        .addComponent(txtCat)))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qttE, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateR, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fourn, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cherch2)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rang, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCart)
                                .addComponent(txtLib)
                                .addComponent(itemCc, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cherche)))
                .addGap(843, 843, 843)
                .addComponent(jLabel6)
                .addGap(67, 67, 67)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemCc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cherch2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLib1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qttE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cherche))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjoutA)
                    .addComponent(btnEditA)
                    .addComponent(btnSuppA)
                    .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnAjoutA1)
                    .addComponent(btnEditA1)
                    .addComponent(btnSuppA1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
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

            pstmt = con.prepareStatement("SELECT refArt,libelle,codeCat,rangement FROM article WHERE refArt LIKE ? OR libelle LIKE ? OR rangement LIKE ? ");
            pstmt.setString(1, pid + "%");
            pstmt.setString(2, pid + "%");
            pstmt.setString(3, pid + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String rAa = rs.getString("refArt");
                String lBa = rs.getString("libelle");
                String cCa = rs.getString("codeCat");
                String rGa = rs.getString("rangement");
                /*  String fRa = rs.getString("nomF");
                String qTa = rs.getString("stock_entree");
                String dt = rs.getString("dateRecep");*/
                model.addRow(new Object[]{rAa, lBa, cCa, rGa});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chercheMouseClicked


    private void btnAjoutAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutAActionPerformed
        String idArt = txtCart.getText();
        String libel = txtLib.getText();
        String idC = itemCc.getSelectedItem().toString();
        String range = rang.getText();
        /*String fr = fourn.getSelectedItem().toString();
        String qt = qttE.getText(); // Récupération de la quantité depuis le champ texte qttE
        LocalDateTime todayDateTime = LocalDateTime.now(); // Date et heure actuelles

        // Formater la date et l'heure en une chaîne compatible avec SQL (format standard)
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fD = todayDateTime.format(ft); // Formatage de la date en 'yyyy-MM-dd HH:mm:ss'
         */
        // Vérification des champs
        if (idArt.isEmpty() || libel.isEmpty() || range.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }
        try {
            // Vérifier si la quantité est bien un nombre entier
            //int quantiteStock = Integer.parseInt(qt);

            // Vérifier si l'article existe déjà
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM ARTICLE WHERE refArt = ?");
            pstmt.setString(1, idArt);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Le code de l'article existe déjà. Veuillez en choisir un autre.");
                return;
            }

            // Insertion de l'article avec la date et l'heure actuelles
            pstmt = con.prepareStatement("INSERT INTO ARTICLE (refArt, libelle, codeCat, rangement) VALUES (?,?,?,?)");
            pstmt.setString(1, idArt);
            pstmt.setString(2, libel);
            pstmt.setString(3, idC);
            pstmt.setString(4, range);
            /*pstmt.setString(5, fr);
            pstmt.setInt(6, quantiteStock); // Insertion de la quantité en tant qu'entier
            pstmt.setString(7, fD);  // Insertion de la date et heure actuelles formatées
             */
            int i = pstmt.executeUpdate();

            if (i == 1) {
                model.addRow(new Object[]{idArt, libel, idC, range});
                JOptionPane.showMessageDialog(this, "Article ajouté avec succès");

                // Réinitialisation des champs
                txtCart.setText("");
                txtLib.setText("");
                itemCc.setSelectedIndex(0);
                rang.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Article non ajouté.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre entier valide pour la quantité.");
        } catch (SQLException ex) {
            Logger.getLogger(categ.class.getName()).log(Level.SEVERE, null, ex);
        }

        nbrCateg();
    }//GEN-LAST:event_btnAjoutAActionPerformed

    private void btnEditAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAActionPerformed
        String idArt = txtCart.getText();
        String libel = txtLib.getText();
        String idC = itemCc.getSelectedItem().toString();
        String range = rang.getText();

        int row = tebleArt.getSelectedRow();

        if (row >= 0) {
            String ancien = tebleArt.getValueAt(row, 0).toString();

            try {
                // Supprimer les colonnes nomF et stock_entree de la requête
                pstmt = con.prepareStatement("UPDATE ARTICLE SET refArt = ?, libelle = ?, codeCat = ?, rangement = ? WHERE refArt = ?");

                pstmt.setString(1, idArt);
                pstmt.setString(2, libel);
                pstmt.setString(3, idC);
                pstmt.setString(4, range);
                pstmt.setString(5, ancien); // Ancienne refArt pour la clause WHERE

                int affR = pstmt.executeUpdate();

                if (affR > 0) {
                    model.setValueAt(idArt, row, 0);
                    model.setValueAt(libel, row, 1);
                    model.setValueAt(idC, row, 2);
                    model.setValueAt(range, row, 3);

                    JOptionPane.showMessageDialog(this, "Article modifié avec succès");

                    // Réinitialisation des champs
                    txtCart.setText("");
                    txtLib.setText("");
                    itemCc.setSelectedIndex(0);
                    rang.setText("");

                } else {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la modification.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier.");
        }
    }//GEN-LAST:event_btnEditAActionPerformed

    private void tableArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableArtMouseClicked
        int row = tableArt.getSelectedRow();

        if (row >= 0) {
            String idArt = tableArt.getValueAt(row, 0).toString();
            String libel = tableArt.getValueAt(row, 1).toString();
            String idC = tableArt.getValueAt(row, 2).toString();
            String range = tableArt.getValueAt(row, 3).toString();
            txtCart.setText(idArt);
            txtLib.setText(libel);
            itemCc.setSelectedItem(idC); // Réinitialiser le combobox
            rang.setText(range);
        }


    }//GEN-LAST:event_tableArtMouseClicked

    private void btnSuppAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppAActionPerformed
        int row = tebleArt.getSelectedRow();

        // Vérifier si une ligne est sélectionnée
        if (row >= 0) {
            String ancien = tebleArt.getValueAt(row, 0).toString(); // Valeur de l'ancienne refArt (référence de l'article)

            try {
                // Préparer la requête de suppression
                pstmt = con.prepareStatement("DELETE FROM ARTICLE WHERE refArt = ?");
                pstmt.setString(1, ancien); // Utiliser la vieille référence pour l'identification

                // Exécuter la requête de suppression
                int affR = pstmt.executeUpdate();

                // Vérifier si la suppression a réussi
                if (affR > 0) {
                    JOptionPane.showMessageDialog(this, "Article supprimé avec succès");

                    // Supprimer la ligne du modèle du tableau
                    model.removeRow(row);

                    // Réinitialisation des champs
                    txtCart.setText("");
                    txtLib.setText("");
                    itemCc.setSelectedIndex(0); // Réinitialiser le combobox
                    fourn.setSelectedIndex(0); // Réinitialiser le combobox
                    rang.setText("");

                } else {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de l'article.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.");
        }

        nbrCateg();
    }//GEN-LAST:event_btnSuppAActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        actuT();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnAjoutA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutA1ActionPerformed
        String idArt = txtCart.getText();
        String libel = txtLib.getText();
        String idC = itemCc.getSelectedItem().toString();
        String range = rang.getText();
       String fr = fourn.getSelectedItem().toString();
        String qt = qttE.getText(); // Récupération de la quantité depuis le champ texte qttE
        LocalDateTime todayDateTime = LocalDateTime.now(); // Date et heure actuelles

        // Formater la date et l'heure en une chaîne compatible avec SQL (format standard)
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fD = todayDateTime.format(ft); // Formatage de la date en 'yyyy-MM-dd HH:mm:ss'
        
        // Vérification des champs
        if (idArt.isEmpty() || libel.isEmpty() || range.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }
        try {
            // Vérifier si la quantité est bien un nombre entier
            int quantiteStock = Integer.parseInt(qt);

            // Vérifier si l'article existe déjà
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM ARTICLE WHERE refArt = ?");
            pstmt.setString(1, idArt);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Le code de l'article existe déjà. Veuillez en choisir un autre.");
                return;
            }

            // Insertion de l'article avec la date et l'heure actuelles
            pstmt = con.prepareStatement("INSERT INTO ARTICLE (refArt, libelle, codeCat, rangement) VALUES (?,?,?,?)");
            pstmt.setString(1, idArt);
            pstmt.setString(2, libel);
            pstmt.setString(3, idC);
            pstmt.setString(4, range);
            pstmt.setString(5, fr);
            pstmt.setInt(6, quantiteStock); // Insertion de la quantité en tant qu'entier
            pstmt.setString(7, fD);  // Insertion de la date et heure actuelles formatées
             
            int i = pstmt.executeUpdate();

            if (i == 1) {
                model.addRow(new Object[]{idArt, libel, idC, range});
                JOptionPane.showMessageDialog(this, "Article ajouté avec succès");

                // Réinitialisation des champs
                txtCart.setText("");
                txtLib.setText("");
                itemCc.setSelectedIndex(0);
                rang.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Article non ajouté.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }

        nbrCateg();
              
    }//GEN-LAST:event_btnAjoutA1ActionPerformed

    private void btnEditA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditA1ActionPerformed

    private void btnSuppA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuppA1ActionPerformed

    private void cherch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cherch2MouseClicked
          String pide = txtChe.getText().toString();
        try {
            model.setRowCount(0);

            pstmt = con.prepareStatement("SELECT refArt,libelle,codeCat, FROM article WHERE refArt LIKE ? OR libelle LIKE ? OR rangement LIKE ? ");
            pstmt.setString(1, pide + "%");
            pstmt.setString(2, pide + "%");
            pstmt.setString(3, pide + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String rAa = rs.getString("refArt");
                String lBa = rs.getString("libelle");
                String cCa = rs.getString("codeCat");
                String rGa = rs.getString("rangement");
                /*  String fRa = rs.getString("nomF");
                String qTa = rs.getString("stock_entree");
                String dt = rs.getString("dateRecep");*/
                model.addRow(new Object[]{rAa, lBa, cCa, rGa});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cherch2MouseClicked

    private void tebleArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tebleArtMouseClicked
        int row = tebleArt.getSelectedRow(); // Récupère la ligne sélectionnée

        // Vérifier si une ligne est bien sélectionnée
        if (row >= 0) {
            // Récupérer les valeurs de la ligne sélectionnée dans la JTable
            String idArt = tebleArt.getValueAt(row, 0).toString();  // refArt
            String libel = tebleArt.getValueAt(row, 1).toString();  // libelle
            String idC = tebleArt.getValueAt(row, 2).toString();    // codeCat
            String range = tebleArt.getValueAt(row, 3).toString();  // rangement
            txtCart.setText(idArt);       // Affiche la référence de l'article dans txtCart
            txtLib.setText(libel);        // Affiche le libellé dans txtLib
            itemCc.setSelectedItem(idC);  // Sélectionne la catégorie correspondante dans itemCc
            rang.setText(range);          // Affiche le rangement dans rang

        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne.");
        }
    }//GEN-LAST:event_tebleArtMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void txtCheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheActionPerformed

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
    private javax.swing.JButton btnAjoutA1;
    private javax.swing.JButton btnEditA;
    private javax.swing.JButton btnEditA1;
    private javax.swing.JButton btnSuppA;
    private javax.swing.JButton btnSuppA1;
    private javax.swing.JLabel cherch2;
    private javax.swing.JLabel cherche;
    private javax.swing.JTextField dateR;
    private javax.swing.JComboBox<String> fourn;
    private javax.swing.JComboBox<String> itemCc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nbrArt;
    private javax.swing.JTextField qttE;
    private javax.swing.JTextField rang;
    private javax.swing.JTable tableArt;
    private javax.swing.JTable tebleArt;
    private javax.swing.JTextField txtCart;
    private javax.swing.JTextField txtCart1;
    private javax.swing.JTextField txtCat;
    private javax.swing.JTextField txtChe;
    private javax.swing.JTextField txtLib;
    private javax.swing.JTextField txtLib1;
    private javax.swing.JTextField txtchr;
    // End of variables declaration//GEN-END:variables

    private void ajoutCateg() {
        String sql = "SELECT codeCat  from categorie ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                itemCc.addItem(rs.getString("codeCat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void ajoutF() {
        String sql = "SELECT nomF  from fournisseur ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                fourn.addItem(rs.getString("nomF"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
