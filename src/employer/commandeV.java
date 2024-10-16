/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employer;

import com.model.Magasin;
import static com.model.Magasin.searchData;
import static com.model.Magasin.txtCode;
import static com.model.Magasin.txtFour;
import static com.model.Magasin.txtRan;
import static com.model.Magasin.txtRef;
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
import java.awt.HeadlessException;
import java.sql.Statement;
import java.util.Date;

public class commandeV extends javax.swing.JFrame {

    private DefaultTableModel model;
    private article articleInstance;
    private int matricule;
    public commandeV() throws SQLException {
        initComponents();
        Connect();
        //LoadData();
        model = new DefaultTableModel(new String[]{"refArt", "libelle", "qttDispo"}, 0);
        table2.setModel(model); 
        AffichL();
        //actuT();
        loadData();
        
        FillData();
        Fill_Date();

    }   
    public commandeV(int m) throws SQLException {
        this();
        this.matricule = m;
        txtMat.setText(String.valueOf(m));

    }

    public int getMat() {
        return matricule;
    }
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
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

    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);

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
            tableComm.setModel(model1);

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
            Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
        }}
//public void loadData() {
//
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/stock";
//            String pwd = "";
//            String user = "root";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, user, pwd);
//            con.setAutoCommit(false);
//
//            DefaultTableModel model1 = new DefaultTableModel(new String[]{"matricule", "Reference", "libelle", "Quantite", "Date de réception"}, 0);
//            tableComm.setModel(model1);
//
//            String sql = "select * from article";
//            PreparedStatement st = con.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                int m = rs.getInt("matricule");
//               // txtMat.setText(String.valueOf(m));
//                int qtt = rs.getInt("qttEntree");
//                String refArt = rs.getString("refArt");
//                 String libelle = rs.getString("libelle");
//                Date dt = rs.getDate("dateEntree");
//                model1.addRow(new Object[]{m,refArt,libelle, qtt, dt});
//
//            }
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    private void AffichL() {
        
        try {
            int q;
            pstmt = con.prepareStatement("SELECT refArt,libelle,stock_entree FROM article");
            rs = pstmt.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            q = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector vec = new Vector();
                for (int i = 1; i <= q; i++) {
                    vec.add(rs.getString("refArt"));
                    vec.add(rs.getString("libelle"));
                    vec.add(rs.getString("stock_entree"));
                }
                df.addRow(vec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(commande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void actuT() {
//        try {
//            model.setRowCount(0);
//
//            pstmt = con.prepareStatement("SELECT * FROM CATEGORIE");
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                String cC = rs.getString("codeCat");
//                String nC = rs.getString("nomCat");
//                model.addRow(new Object[]{cC, nC});
//            }
//            if (model.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé");
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
//        }
//        
//    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtRef = new javax.swing.JTextField();
        txtLib = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchr = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableComm = new javax.swing.JTable();
        btnComm1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        txtRef.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtLib.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

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

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libelle", "Stock dispo"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        btnComm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComm.setForeground(new java.awt.Color(51, 153, 0));
        btnComm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/ajouter(1).png"))); // NOI18N
        btnComm.setText("Commander");
        btnComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommActionPerformed(evt);
            }
        });

        btnAnn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnn.setForeground(new java.awt.Color(255, 0, 0));
        btnAnn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/supprimer(1)-1.png"))); // NOI18N
        btnAnn.setText("Annuler");
        btnAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnActionPerformed(evt);
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
        jLabel4.setText("Remplissez le formulaire  ci-dessous :");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("Recherche d'article :");

        jLabel10.setText("Quantité demandée :");

        txtStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel11.setText("Matricule :");

        txtMat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        tableComm.setModel(new javax.swing.table.DefaultTableModel(
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
        tableComm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCommMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableComm);

        btnComm1.setBackground(new java.awt.Color(0, 153, 51));
        btnComm1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComm1.setForeground(new java.awt.Color(255, 255, 255));
        btnComm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/reserver-plus.png"))); // NOI18N
        btnComm1.setText("Valider");
        btnComm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComm1ActionPerformed(evt);
            }
        });

        btnEdit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit1.setForeground(new java.awt.Color(51, 102, 255));
        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/impression.png"))); // NOI18N
        btnEdit1.setText("Imprimer");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 51));
        jLabel9.setText("Liste des articles en rupture de stock :");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "refArticle", "Libelle", "Stock dispo"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/probleme-loupe.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel12.setText("Date de commande :");

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
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(783, 783, 783)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComm1))
                        .addGap(616, 616, 616))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLib, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnComm)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEdit1)
                                .addGap(59, 59, 59)
                                .addComponent(btnEdit)
                                .addGap(68, 68, 68)
                                .addComponent(btnAnn)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(937, Short.MAX_VALUE)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cherche)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(229, 229, 229)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnComm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnComm)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnAnn)
                            .addComponent(btnEdit1))
                        .addGap(31, 31, 31))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(342, Short.MAX_VALUE)))
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
    public commandeV(article articleInstance) {
        this.articleInstance = articleInstance;
        // Autres initialisations...
    }

    private void btnCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommActionPerformed
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
            String lib = txtLib.getText();
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
                
                txtLib.setText("");
                txtRef.setText("");
     
                txtStock.setText("");

            } else if (r >= 1) {
                 String s1 = "update article set stock_entree=? where refArt=?";
                PreparedStatement st = con.prepareStatement(s1);
                st.setInt(1, r);
                st.setString(2, refArt);
                st.executeUpdate();
                txtLib.setText("");
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
//        String idC = txtCode.getText();
//        String nC = txtLib.getText();
//        int row = table2.getSelectedRow();
//
//        if (row >= 0) {
//            String encien = table2.getValueAt(row, 0).toString();
//
//            try {
//
//                // Vérifier si le codeCat existe déjà
//                pstmt = con.prepareStatement("SELECT COUNT(*) FROM CATEGORIE WHERE codeCat = ?");
//                pstmt.setString(1, idC);
//                ResultSet rs = pstmt.executeQuery();
//
//                if (rs.next() && rs.getInt(1) > 0) {
//                    JOptionPane.showMessageDialog(this, "Le code de catégorie existe déjà. Veuillez en choisir un autre.");
//                    return;
//                }
//                pstmt = con.prepareStatement("UPDATE categorie SET codeCat=?, nomCat=? WHERE codeCat=?");
//
//                pstmt.setString(1, idC);
//                pstmt.setString(2, nC);
//                pstmt.setString(3, encien);
//
//                int affR = pstmt.executeUpdate();
//
//                if (affR > 0) {
//                    JOptionPane.showMessageDialog(this, "Modification réussie");
//
//                    model.setValueAt(idC, row, 0);
//                    model.setValueAt(nC, row, 1);
//
//                    txtCode.setText("");
//                    txtLib.setText("");
//
//                } else {
//                    JOptionPane.showMessageDialog(this, "Erreur lors de la modification");
//
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
//
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Sélectionner la ligne à modifier");
//
//        }
//
//        
    }//GEN-LAST:event_btnEditActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked


    }//GEN-LAST:event_table2MouseClicked

    private void btnAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnActionPerformed

//        int row = table2.getSelectedRow();
//        if (row >= 0) {
//            String cC = table2.getValueAt(row, 0).toString();
//            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer cet enregistrement ?", "Confirmation", JOptionPane.YES_NO_OPTION);
//
//            if (confirmation == JOptionPane.YES_OPTION) {
//                try {
//
//                    pstmt = con.prepareStatement("DELETE FROM CATEGORIE WHERE codeCat=?");
//                    pstmt.setString(1, cC);
//
//                    int affectR = pstmt.executeUpdate();
//
//                    if (affectR > 0) {
//                        JOptionPane.showMessageDialog(this, "Suppression réussie");
//                        txtCode.setText("");
//                        txtLib.setText("");
//                        model.removeRow(row);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression");
//
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
//
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer");
//
//        }

     
    }//GEN-LAST:event_btnAnnActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       // actuT();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_exitMouseClicked

    private void btnComm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComm1ActionPerformed
 //int row = tableComm.getSelectedRow();
        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            DefaultTableModel model1 = new DefaultTableModel(new String[]{"Reference", "libelle", "qttDispo"}, 0);
            table2.setModel(model1);

            try {
            
                String sq="select refArt from recevoir ";
                PreparedStatement stmt = con.prepareStatement(sq);
                ResultSet rs=stmt.executeQuery();
                rs.next();
                String refArt=rs.getString("refArt");
                
                String sql = "SELECT libelle,stock_entree FROM article where refArt = ?";
                
                PreparedStatement stmt1 = con.prepareStatement(sql);
                stmt1.setString(1,refArt);
                ResultSet rs1 = stmt1.executeQuery();

                if (rs1.next()) {
                    
                    String libelle = rs1.getString("libelle");
                   
                    int stock = rs1.getInt("stock_entree");

                    model1.addRow(new Object[]{ refArt,libelle,  stock});

                }

                rs.close();
                rs1.close();
                stmt.close();
                stmt1.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnComm1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
     String pid = txtchr.getText().toString();

        try {

            if (pid.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "mot obligatoire", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //model.setRowCount(0);

                String sql = "SELECT refArt,libelle,stock_entree FROM article WHERE refArt LIKE ? OR libelle LIKE ?";
                pstmt = con.prepareStatement(sql);

                pstmt.setString(1, "%" + pid + "%");
                pstmt.setString(2, "%" + pid + "%");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    String ref = rs.getString("refArt");
                    String libelle = rs.getString("libelle");
                    String qtt = rs.getString("stock_entree");
                   // model.addRow(new Object[]{ref, libelle, qtt});
       AffichL();
                }
                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Aucun résultat trouvé.");
                }

            }

        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

    }//GEN-LAST:event_tableMouseClicked

    private void tableCommMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCommMouseClicked
        int row = tableComm.getSelectedRow();

        if (row >= 0) {
            //java.sql.Date date = java.sql.Date.valueOf(java.time.LocalDate.now().toString());
            
            int mat = Integer.parseInt(tableComm.getValueAt(row, 0).toString());
            String ref = tableComm.getValueAt(row, 1).toString();
            String lib = tableComm.getValueAt(row, 2).toString();
         String qtt = tableComm.getValueAt(row, 3).toString();
         
      
            txtMat.setText(String.valueOf(mat));
            txtRef.setText(ref);
            txtLib.setText(lib);
            txtStock.setText(String.valueOf(qtt));
            //txtDate.setDate(date);
        }
    }//GEN-LAST:event_tableCommMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    article articleWindow = new article();
                    commandeV categoryWindow = new commandeV(articleWindow);
                    new commandeV().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(commandeV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnn;
    private javax.swing.JButton btnComm;
    private javax.swing.JButton btnComm1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTable tableComm;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtLib;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtchr;
    // End of variables declaration//GEN-END:variables

}
