/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employer;

import com.model.Magasin;
import static com.model.Magasin.searchData;
import static com.model.Magasin.txtCode;
import static com.model.Magasin.txtFour;
import static com.model.Magasin.txtMat;
import static com.model.Magasin.txtRan;
import static com.model.Magasin.txtRef;
import static com.model.Magasin.txtStock;
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
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.Category;
import employer.article;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class commande extends javax.swing.JFrame {

    private DefaultTableModel model, model2;
    private JComboBox<String> itemCc;
    private article articleInstance;
    private int matricule;

    public commande() throws SQLException {
        initComponents();
        Connect();
        // Rendre le champ non modifiable
        model = new DefaultTableModel(new String[]{"Reference", "libelle", "Quantite Disponible"}, 0);
        tableRech.setModel(model);
loadData();
        //AffichL();
        Fill_Date();
        FillData();

    }

    public commande(int m) throws SQLException {
        this();
        this.matricule = m;
        txtMat.setText(String.valueOf(m));

    }

    public int getMat() {
        return matricule;
    }
    Connection con;
    PreparedStatement pstmt, pstmt2;
    ResultSet rs, rs2;

    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Fill_Date() {
        java.util.Date date = new java.util.Date();
        txtDate.setDateFormatString("dd MMMM yyyy");
        txtDate.setDate(null);
    }

    public void FillData() {

// We have already a register number
        try {
            // Setup db connection
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            String dateDemandesql = "SELECT dateDemande FROM faire  ";
            PreparedStatement St = con.prepareStatement(dateDemandesql);

            ResultSet rs = St.executeQuery();
            while (rs.next()) {
                Date dt = rs.getDate("dateDemande");
                txtDate.setDate(dt);
                Fill_Date();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
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

            DefaultTableModel model1 = new DefaultTableModel(new String[]{"matricule", "Reference", "libelle", "Quantite", "Date de réception"}, 0);
            table.setModel(model1);

            String sql = "select * from recevoir";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                int m = rs.getInt("matricule");
                // txtMat.setText(String.valueOf(m));
                int qtt = rs.getInt("qttEntree");
                String refArt = rs.getString("refArt");
                String libelle = rs.getString("libelle");
                Date dt = rs.getDate("dateEntree");
                model1.addRow(new Object[]{m, refArt, libelle, qtt, dt});

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void AffichL() {
//        try {
//            int q;
//            pstmt = con.prepareStatement("SELECT refArt,libelle,stock_entree FROM article");
//            rs = pstmt.executeQuery();
//            ResultSetMetaData res = rs.getMetaData();
//            q = res.getColumnCount();
//
//            DefaultTableModel df = (DefaultTableModel) tableRech.getModel();
//            df.setRowCount(0);
//
//            while (rs.next()) {
//                Vector vec = new Vector();
//                for (int i = 1; i <= q; i++) {
//                    vec.add(rs.getString("refArt"));
//                    vec.add(rs.getString("libelle"));
//                    vec.add(rs.getString("stock_entree"));
//                }
//                df.addRow(vec);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private void AffichCo() {
//        try {
//            int q;
//            pstmt2 = con.prepareStatement("SELECT matricule,refArt,libelle,qttEntre,dateRecep FROM recevoir");
//            rs2 = pstmt2.executeQuery();
//            ResultSetMetaData res = rs2.getMetaData();
//            q = res.getColumnCount();
//
//            DefaultTableModel df = (DefaultTableModel) table.getModel();
//            df.setRowCount(0);
//
//            while (rs2.next()) {
//                Vector vec = new Vector();
//                for (int i = 1; i <= q; i++) {
//                    vec.add(rs2.getString("matricule"));
//                    vec.add(rs2.getString("refArt"));
//                    vec.add(rs2.getString("libelle"));
//                    vec.add(rs2.getString("qttDispo"));
//                    vec.add(rs2.getString("dateRecep"));
//                }
//                df.addRow(vec);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtRef = new javax.swing.JTextField();
        txtlibel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchr = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRech = new javax.swing.JTable();
        btnComm = new javax.swing.JButton();
        btnAnn = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        txtRef.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtlibel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel1.setText("Code d'article :");

        jLabel2.setText("Libelle :");

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
        jLabel5.setText("COMMANDE ");

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

        tableRech.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "refArticle", "Libelle", "Stock dispo"
            }
        ));
        tableRech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRechMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRech);

        btnComm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComm.setForeground(new java.awt.Color(0, 102, 0));
        btnComm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/ajouter(1).png"))); // NOI18N
        btnComm.setText("Commander");
        btnComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommActionPerformed(evt);
            }
        });

        btnAnn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnn.setForeground(new java.awt.Color(255, 0, 0));
        btnAnn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/supprimer(1).png"))); // NOI18N
        btnAnn.setText("Annuler");
        btnAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 153, 102));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/editer(1)-1.png"))); // NOI18N
        btnEdit.setText("Modifier");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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

        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(204, 0, 0));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/la-gauche-1.png"))); // NOI18N
        exit.setText("Retour");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("Recherche d'article :");

        jLabel10.setText("Quantité demandée :");

        txtStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel11.setText("Matricule :");

        txtMat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel12.setText("Date de commande :");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricule", "CodeArt", "Libelle", "Quantité", "Date commande"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/chercher.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cherche)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(724, 724, 724)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtlibel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(60, 60, 60)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btnComm))
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnAnn)
                                .addGap(81, 81, 81))))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(exit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cherche)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnAnn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtlibel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnComm)))
                        .addGap(97, 97, 97))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked

    }//GEN-LAST:event_chercheMouseClicked
    public commande(article articleInstance) {
        this.articleInstance = articleInstance;
        // Autres initialisations...
    }

    private void btnCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommActionPerformed
        /*  String idC = txtcArt.getText();
        String nC = txtlibel.getText();

        // Vérifier si les champs sont vides
        if (idC.isEmpty() || nC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }

        try {

            // Vérifier si le codeCat existe déjà
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM CATEGORIE WHERE codeCat = ?");
            pstmt.setString(1, idC);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Le code de catégorie existe déjà. Veuillez en choisir un autre.");
                return;
            }

            pstmt = con.prepareStatement("INSERT INTO CATEGORIE (codeCat,nomCat) VALUES (?,?)");
            pstmt.setString(1, idC);
            pstmt.setString(2, nC);

            int i = pstmt.executeUpdate();

            if (i == 1) {
                model.addRow(new Object[]{idC, nC});
                JOptionPane.showMessageDialog(this, "Categorie ajouté avec succès");
                txtcArt.setText("");
                txtlibel.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Categorie non ajouté ");

            }
        } catch (SQLException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);

        }

        nbrCateg();*/

        int qtt;
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);

            java.sql.Date date = java.sql.Date.valueOf(java.time.LocalDate.now().toString());
            qtt = Integer.parseInt(txtStock.getText());
            String refArt = txtRef.getText();
            String lib = txtlibel.getText();
            String sq = "select stock_entree from article where refArt=?";
            PreparedStatement stmt1 = con.prepareStatement(sq);
            stmt1.setString(1, refArt);
            ResultSet rs = stmt1.executeQuery();
            rs.next();

            int stock = rs.getInt("stock_entree");
            int r = stock - qtt;
            String sql = "insert into recevoir (matricule,refArt,libelle,qttEntree,dateEntree)values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, getMat());
            stmt.setString(2, refArt);
            stmt.setString(3, lib);
            stmt.setInt(4, qtt);
            stmt.setDate(5, date);
            stmt.executeUpdate();

            if (r < 0) {

                JOptionPane.showMessageDialog(new JFrame(), "le stock est insuffisant", "Alerte", JOptionPane.ERROR_MESSAGE);

                txtlibel.setText("");
                txtRef.setText("");

                txtStock.setText("");

            } else if (r >= 1) {
                String s1 = "update article set stock_entree=? where refArt=?";
                PreparedStatement st = con.prepareStatement(s1);
                st.setInt(1, r);
                st.setString(2, refArt);
                st.executeUpdate();
                txtlibel.setText("");
                txtRef.setText("");
                txtStock.setText("");
                loadData();
                FillData();
            }

            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCommActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String ref = txtRef.getText();
        String lib = txtlibel.getText();

        String qtt = txtStock.getText();
        int row = tableRech.getSelectedRow();

        if (row >= 0) {
            String encien = tableRech.getValueAt(row, 0).toString();

            try {

                // Vérifier si le codeCat existe déjà
//                pstmt = con.prepareStatement("SELECT COUNT(*) FROM recevoir WHERE refArt = ?");
//                pstmt.setString(1, ref);
//                ResultSet rs = pstmt.executeQuery();
                pstmt = con.prepareStatement("UPDATE recevoir SET qtt=? WHERE matricule=?");

                pstmt.setString(1, qtt);
                pstmt.setInt(2, getMat());

                int affR = pstmt.executeUpdate();

                if (affR > 0) {
                    JOptionPane.showMessageDialog(this, "Modification réussie");

                    txtRef.setText("");
                    txtlibel.setText("");

                    txtStock.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "vous ne pouvez modifier que la quantite");

                }

            } catch (SQLException ex) {
                Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionner la ligne à modifier");

        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void tableRechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRechMouseClicked
        int row = tableRech.getSelectedRow();

        if (row >= 0) {
            String cC = tableRech.getValueAt(row, 0).toString();
            String nmC = tableRech.getValueAt(row, 1).toString();

            txtRef.setText(cC);
            txtlibel.setText(nmC);
        }
    }//GEN-LAST:event_tableRechMouseClicked

    private void btnAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnActionPerformed

        int row = tableRech.getSelectedRow();
        if (row >= 0) {
            String cC = tableRech.getValueAt(row, 0).toString();
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer cet enregistrement ?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {

                    pstmt = con.prepareStatement("DELETE FROM CATEGORIE WHERE codeCat=?");
                    pstmt.setString(1, cC);

                    int affectR = pstmt.executeUpdate();

                    if (affectR > 0) {
                        JOptionPane.showMessageDialog(this, "Suppression réussie");
                        txtRef.setText("");
                        txtlibel.setText("");
                        model.removeRow(row);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer");

        }


    }//GEN-LAST:event_btnAnnActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        loadData();
//        AffichL();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        setVisible(false);
        new seconn().setVisible(true);

    }//GEN-LAST:event_exitMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        String pid = txtchr.getText().toString();

        try {

            if (pid.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "mot obligatoire", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                model.setRowCount(0);

                String sql = "SELECT refArt,libelle,stock_entree FROM article WHERE refArt LIKE ? OR libelle LIKE ?";
                pstmt = con.prepareStatement(sql);

                pstmt.setString(1, "%" + pid + "%");
                pstmt.setString(2, "%" + pid + "%");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String ref = rs.getString("refArt");
                    String libelle = rs.getString("libelle");
                    String qtt = rs.getString("stock_entree");
                    model.addRow(new Object[]{ref, libelle, qtt});

                }
                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Aucun résultat trouvé.");
                }

            }

        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();

        if (row >= 0) {
            int mat = Integer.parseInt(table.getValueAt(row, 0).toString());
            String ref = table.getValueAt(row, 1).toString();
            String libelle = table.getValueAt(row, 2).toString();
            int qtt = Integer.parseInt(table.getValueAt(row, 3).toString());
           
            txtMat.setText(String.valueOf(mat));
            txtRef.setText(ref);
            txtlibel.setText(libelle);
            txtMat.setText(String.valueOf(qtt));

        }
    }//GEN-LAST:event_tableMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    article articleWindow = new article();
                    commande categoryWindow = new commande(articleWindow);
                    new commande().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnn;
    private javax.swing.JButton btnComm;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel cherche;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable tableRech;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtchr;
    private javax.swing.JTextField txtlibel;
    // End of variables declaration//GEN-END:variables

}
