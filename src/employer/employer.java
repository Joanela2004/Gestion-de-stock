package employer;

import com.model.Employe;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class employer extends javax.swing.JFrame {

    private DefaultTableModel model1;
    private String ancien;

    public employer() throws SQLException {

        initComponents();
        Connect();
        loadData();
        ajoutservices();
        ajoutrefJirama();
        model1 = new DefaultTableModel(new String[]{"Matricule", "nom", "prenom", "services", "IdServices", "RefJirama", "NomVille"}, 0);
        tableE.setModel(model1);
//        AffichL();
//        actuT();
        nbrPersonne();
       
        //ajoutF();
    }
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
//
    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);

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

            DefaultTableModel model = new DefaultTableModel(new String[]{"Matricule", "nom", "prenom", "services", "IdServices", "RefJirama", "NomVille"}, 0);
            tableE.setModel(model);

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
                Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, e);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

                       
                     
//
//    public void LoadData() {
//
//        try {
//            pstmt = con.prepareStatement("SELECT matricule FROM employe");
//            rs = pstmt.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private void AffichL() {
//        try {
//            pstmt = con.prepareStatement("SELECT matricule, nom, prenom, nomServices, refJirama FROM EMPLOYE");
//            rs = pstmt.executeQuery();
//            ResultSetMetaData res = rs.getMetaData();
//            int q = res.getColumnCount();
//
//            DefaultTableModel df = (DefaultTableModel) tableE.getModel();
//            df.setRowCount(0);
//
//            while (rs.next()) {
//                Vector vec = new Vector();
//                vec.add(rs.getString("matricule"));
//                vec.add(rs.getString("nom"));
//                vec.add(rs.getString("prenom"));
//                vec.add(rs.getString("nomServices"));
//                vec.add(rs.getString("refJirama"));  // Ajout de refJirama dans le Vector
//
//                df.addRow(vec);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void actuT() {
//        try {
//            model.setRowCount(0);
//
//            pstmt = con.prepareStatement("SELECT * FROM EMPLOYE");
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                String rA = rs.getString("matricule");
//                String lB = rs.getString("nom");
//                String cC = rs.getString("prenom");
//                String rG = rs.getString("nomServices");
//                String fR = rs.getString("refJirama");
//                model.addRow(new Object[]{rA, lB, cC, rG, fR});
//            }
//            if (model.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé");
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
//        }
//        nbrCateg();
//    }

    private void nbrPersonne() {
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) AS total FROM employe");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int totalCategories = rs.getInt("total");
                nbrArt.setText(String.valueOf(totalCategories)); // Mettre à jour le TextField

            }
        } catch (SQLException ex) {
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cherche = new javax.swing.JLabel();
        txtchr = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableE = new javax.swing.JTable();
        btnAjoutA = new javax.swing.JButton();
        btnSuppA = new javax.swing.JButton();
        btnEditA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nbrArt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtRefJirama = new javax.swing.JComboBox<>();
        txtPrenom = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtPass1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        txtServices = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

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
        jLabel5.setText("GESTION DES PERSONNELS");

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

        tableE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricule", "Nom", "Prénom", "Service", "RefJirama"
            }
        ));
        tableE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableE);

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

        btnEditA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditA.setForeground(new java.awt.Color(255, 153, 102));
        btnEditA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/editer(1).png"))); // NOI18N
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
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/faire-tourner-en-sens-inverse.png"))); // NOI18N
        jLabel6.setText("Actualiser");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Nombre d'employee :");

        nbrArt.setEditable(false);
        nbrArt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nbrArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/la-gauche.png"))); // NOI18N
        jLabel10.setText("Retour");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/chercher.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel2.setText("Nom :");

        txtNom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtRefJirama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtRefJirama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPrenom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        txtPass1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel13.setText("Service :");

        txtServices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtServices.setBorder(null);

        jLabel14.setText("Référence de la JIRAMA :");

        jLabel1.setText("Confirmer le mot de passe :");

        jLabel15.setText("Mot de passe :");

        jLabel16.setText("Prénom :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnEditA)
                                .addGap(178, 178, 178))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAjoutA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuppA)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRefJirama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbrArt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addComponent(cherche)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtRefJirama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAjoutA)
                            .addComponent(btnEditA)
                            .addComponent(btnSuppA))
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                        .addGap(68, 68, 68))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked
       
    }//GEN-LAST:event_chercheMouseClicked


    private void btnAjoutAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutAActionPerformed
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
                   nbrPersonne();
                } else if (!pa1.equals(pa)) {
                    JOptionPane.showMessageDialog(null, "Resaisissez votre mot de passe");

                }

                stmt1.close();
                stmt.close();
                con.close();

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        } 
       

    }//GEN-LAST:event_btnAjoutAActionPerformed

    private void btnEditAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAActionPerformed
 String n, p, s, r, i, pa,pa1, v;
        int m = 0;
        int selectedRow = tableE.getSelectedRow();

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
        m = Integer.parseInt(tableE.getValueAt(selectedRow, 0).toString());

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
                    tableE.setValueAt(m, selectedRow, 0);
                    tableE.setValueAt(n, selectedRow, 1);
                    tableE.setValueAt(p, selectedRow, 2);
                    tableE.setValueAt(s, selectedRow, 3);
                    tableE.setValueAt(i, selectedRow, 4);
                    tableE.setValueAt(r, selectedRow, 5);

                    tableE.setValueAt(v, selectedRow, 6);
                    nbrPersonne();
                    
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

        // Mise à jour des catégories si nécessaire
       


    }//GEN-LAST:event_btnEditAActionPerformed

    private void tableEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEMouseClicked
String pa;

        try {

            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

            int selectedRow = tableE.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                int m = Integer.parseInt(tableE.getValueAt(selectedRow, 0).toString());
                String n = tableE.getValueAt(selectedRow, 1).toString();
                String p = tableE.getValueAt(selectedRow, 2).toString();
                String s = tableE.getValueAt(selectedRow, 3).toString();
                String i = tableE.getValueAt(selectedRow, 4).toString();
                String r = tableE.getValueAt(selectedRow, 5).toString();
                String v = tableE.getValueAt(selectedRow, 6).toString();
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
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableEMouseClicked

    private void btnSuppAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppAActionPerformed
        int selectedRow = tableE.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Aucune employe sélectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer l'employe sélectionnée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            String m = tableE.getValueAt(selectedRow, 0).toString();
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
                  txtNom.setText("");
                    txtServices.setSelectedIndex(0);
                    txtRefJirama.setSelectedIndex(0);// Réinitialiser le combobox
                    txtPrenom.setText("");
                    txtPass.setText("");
                    txtPass1.setText("");
                loadData();
                con.close();

                if (rowsDeletedPersonne > 0) {
                    JOptionPane.showMessageDialog(this, "Suppression effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "La suppression a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

         nbrPersonne();

    }//GEN-LAST:event_btnSuppAActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        loadData();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    // TODO add your handling code here:
     String pid = txtchr.getText().toString();
        try {
            model1.setRowCount(0);

            pstmt = con.prepareStatement("SELECT matricule,nom,prenom,services,refJirama,ville,idServices FROM employe WHERE matricule LIKE ? OR nom LIKE ? OR prenom LIKE ? OR services LIKE ? ");
            pstmt.setString(1, pid + "%");
            pstmt.setString(2, pid + "%");
            pstmt.setString(3, pid + "%");
            pstmt.setString(4, pid + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String rA = rs.getString("matricule");
                String lB = rs.getString("nom");
                String cC = rs.getString("prenom");
                String rG = rs.getString("services");
                String fR = rs.getString("refJirama");
 
                String i = rs.getString("idServices");
                String v = rs.getString("ville");
                model1.addRow(new Object[]{rA, lB, cC,rG,i, fR,v});
            }

            if (model1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new employer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(employer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjoutA;
    private javax.swing.JButton btnEditA;
    private javax.swing.JButton btnSuppA;
    private javax.swing.JLabel cherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nbrArt;
    private javax.swing.JTable tableE;
    private javax.swing.JTextField txtNom;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JComboBox<String> txtRefJirama;
    private javax.swing.JComboBox<String> txtServices;
    private javax.swing.JTextField txtchr;
    // End of variables declaration//GEN-END:variables

}
