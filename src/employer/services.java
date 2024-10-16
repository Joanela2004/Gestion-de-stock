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

public class services extends javax.swing.JFrame {

    private DefaultTableModel model;
    private JComboBox<String> itemCc;
    private article articleInstance;

    public services() throws SQLException {
        initComponents();
        Connect();
        LoadData();
        model = new DefaultTableModel(new String[]{"idServices", "nomServices"}, 0);
        tableServ.setModel(model); // Assurez-vous que tableCat est le nom de votre JTable
        AffichL();
        actuT();
        nbrCateg();

    }
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public void Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void LoadData() {

        try {
            pstmt = con.prepareStatement("SELECT idServices FROM services");
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void AffichL() {
        try {
            int q;
            pstmt = con.prepareStatement("SELECT * FROM services");
            rs = pstmt.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            q = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) tableServ.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector vec = new Vector();
                for (int i = 1; i <= q; i++) {
                    vec.add(rs.getString("idServices"));
                    vec.add(rs.getString("nomServices"));
                }
                df.addRow(vec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actuT() {
        try {
            model.setRowCount(0);

            pstmt = con.prepareStatement("SELECT * FROM services");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                txtchrS.setText("");
                String cC = rs.getString("idServices");
                String nC = rs.getString("nomServices");
                model.addRow(new Object[]{cC, nC});
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun enregistrement trouvé");

            }
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
        }
        nbrCateg();
    }

    private void nbrCateg() {
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) AS total FROM services");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int totalCategories = rs.getInt("total");
                nbrCat.setText(String.valueOf(totalCategories)); // Mettre à jour le TextField

            }
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erreur SQL: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        codeC = new javax.swing.JTextField();
        nameCat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cherche = new javax.swing.JLabel();
        txtchrS = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServ = new javax.swing.JTable();
        btnAjout = new javax.swing.JButton();
        btnSupp = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        actS = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nbrCat = new javax.swing.JTextField();
        exit = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(80, 80));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1207, 597));

        codeC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        nameCat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 153, 51)));

        jLabel1.setText("Code Service :");

        jLabel2.setText("Service :");

        cherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chercheMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chercheMouseEntered(evt);
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
        jLabel5.setText("SERVICES DES EMPLOYERS");

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

        tableServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code service", "Services"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableServ);

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

        actS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        actS.setForeground(new java.awt.Color(255, 153, 51));
        actS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/faire-tourner-en-sens-inverse-1.png"))); // NOI18N
        actS.setText("Actualiser");
        actS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actSMouseClicked(evt);
            }
        });

        jLabel7.setText("Nombre de catégorie d'articles :");

        nbrCat.setEditable(false);
        nbrCat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nbrCat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(204, 0, 0));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/la-gauche-1.png"))); // NOI18N
        exit.setText("Retour");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stages sary/chercher.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAjout)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeC, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameCat, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cherche)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbrCat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(txtchrS, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(actS)
                        .addGap(51, 51, 51)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnEdit)
                        .addGap(41, 41, 41)
                        .addComponent(btnSupp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nbrCat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(exit)
                                .addComponent(actS))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(cherche))
                    .addComponent(txtchrS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(codeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(nameCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSupp)
                            .addComponent(btnEdit)
                            .addComponent(btnAjout)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked
  
    }//GEN-LAST:event_chercheMouseClicked
    public services(article articleInstance) {
        this.articleInstance = articleInstance;
        // Autres initialisations...
    }

    private void btnAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutActionPerformed
        String idC = codeC.getText();
        String nC = nameCat.getText();

        // Vérifier si les champs sont vides
        if (idC.isEmpty() || nC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }

        try {

            // Vérifier si le codeCat existe déjà
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM services WHERE idServices = ?");
            pstmt.setString(1, idC);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Le code de catégorie existe déjà. Veuillez en choisir un autre.");
                return;
            }

            pstmt = con.prepareStatement("INSERT INTO services (idServices,nomServices) VALUES (?,?)");
            pstmt.setString(1, idC);
            pstmt.setString(2, nC);

            int i = pstmt.executeUpdate();

            if (i == 1) {
                model.addRow(new Object[]{idC, nC});
                JOptionPane.showMessageDialog(this, "Services ajouté avec succès");
                codeC.setText("");
                nameCat.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Services non ajouté ");

            }
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);

        }

        nbrCateg();
    }//GEN-LAST:event_btnAjoutActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String idC = codeC.getText();
        String nC = nameCat.getText();
        int row = tableServ.getSelectedRow();

        if (row >= 0) {
            String encien = tableServ.getValueAt(row, 0).toString();

            try {

                pstmt = con.prepareStatement("UPDATE services SET idServices=?, nomServices=? WHERE idServices=?");

                pstmt.setString(1, idC);
                pstmt.setString(2, nC);
                pstmt.setString(3, encien);

                int affR = pstmt.executeUpdate();

                if (affR > 0) {
                    JOptionPane.showMessageDialog(this, "Modification réussie");

                    model.setValueAt(idC, row, 0);
                    model.setValueAt(nC, row, 1);

                    codeC.setText("");
                    nameCat.setText("");

                } else {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la modification");

                }

            } catch (SQLException ex) {
                Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionner la ligne à modifier");

        }

        nbrCateg();
    }//GEN-LAST:event_btnEditActionPerformed

    private void tableServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServMouseClicked
        int row = tableServ.getSelectedRow();

        if (row >= 0) {
            String cC = tableServ.getValueAt(row, 0).toString();
            String nmC = tableServ.getValueAt(row, 1).toString();

            codeC.setText(cC);
            nameCat.setText(nmC);
        }
    }//GEN-LAST:event_tableServMouseClicked

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed

        int row = tableServ.getSelectedRow();
        if (row >= 0) {
            String cC = tableServ.getValueAt(row, 0).toString();
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer ce service ?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {

                    pstmt = con.prepareStatement("DELETE FROM services WHERE idServices=?");
                    pstmt.setString(1, cC);

                    int affectR = pstmt.executeUpdate();

                    if (affectR > 0) {
                        JOptionPane.showMessageDialog(this, "Suppression réussie");
                        codeC.setText("");
                        nameCat.setText("");
                        model.removeRow(row);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer");

        }

        nbrCateg();
    }//GEN-LAST:event_btnSuppActionPerformed

    private void actSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actSMouseClicked
        actuT();
    }//GEN-LAST:event_actSMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        setVisible(false);
        new menu().setVisible(true);

    }//GEN-LAST:event_exitMouseClicked

    private void chercheMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_chercheMouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
              String pide = txtchrS.getText().toString();
        try {
            model.setRowCount(0);

            pstmt = con.prepareStatement("SELECT * FROM services WHERE idServices LIKE ? OR nomServices LIKE ?");
            pstmt.setString(1, "%" + pide + "%");
            pstmt.setString(2, "%" + pide + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String cdeS = rs.getString("idServices");
                String nmS = rs.getString("nomServices");
                model.addRow(new Object[]{cdeS, nmS});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun résultat trouvé.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur SQL : " + ex.getMessage());
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    article articleWindow = new article();
                    services categoryWindow = new services(articleWindow);
                    new services().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actS;
    private javax.swing.JButton btnAjout;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSupp;
    private javax.swing.JLabel cherche;
    private javax.swing.JTextField codeC;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameCat;
    private javax.swing.JTextField nbrCat;
    private javax.swing.JTable tableServ;
    private javax.swing.JTextField txtchrS;
    // End of variables declaration//GEN-END:variables

}
