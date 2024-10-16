/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import static com.itextpdf.text.pdf.PdfName.IM;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Magasin extends javax.swing.JFrame {

    /**
     * Creates new form Magasin
     */
    private int matricule;
private int numDemande;
    public Magasin() {
        initComponents();
     
       ajoutNumD();
        Fill_Date();
        FillData();
    }

    public Magasin(int m) {
        this();
        this.matricule = m;
     //txtNumD.setText(String.valueOf(numD));

    }

    public int getMat() {
        return matricule;
    }
//    public int getNumD(){
//    return numDemande;
//    }
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
            
            DefaultTableModel model = new DefaultTableModel(new String[]{"Reference", "Quantite", "Date"}, 0);
            table.setModel(model);
           
            String sql = "select * from recevoir";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
              
                int m = rs.getInt("matricule");
                txtMat.setText(String.valueOf(m));
                int qtt = rs.getInt("qttEntree");
                String refArt = rs.getString("refArt");
                Date dt = rs.getDate("dateEntree");
                 model.addRow(new Object[]{refArt, qtt, dt});
                
                 
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public void ajoutNumD() {
        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            con.setAutoCommit(false);

                 String sq="select numDemande from demande ";
            
                 try {
                PreparedStatement pstmt = con.prepareStatement(sq);
                ResultSet rs = pstmt.executeQuery();
               
                while (rs.next()) {
                 int numD=rs.getInt("NumDemande");
                 txtNumD.setText(String.valueOf(numD));
                     }
            } catch (SQLException ex) {
                Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtRef = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFour = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtSE = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtMat = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtNumD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(239, 252, 253));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("recherche par catégorie :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(50, 0, 250, 20);

        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });
        jPanel2.add(searchData);
        searchData.setBounds(150, 70, 200, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("code_categorie :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 120, 100, 17);

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        jPanel2.add(txtCode);
        txtCode.setBounds(160, 110, 160, 30);

        txtRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefActionPerformed(evt);
            }
        });
        jPanel2.add(txtRef);
        txtRef.setBounds(160, 150, 160, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("reference     :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 150, 100, 17);

        txtRan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRanActionPerformed(evt);
            }
        });
        jPanel2.add(txtRan);
        txtRan.setBounds(160, 190, 160, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("rangement :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 190, 100, 17);

        txtFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFourActionPerformed(evt);
            }
        });
        jPanel2.add(txtFour);
        txtFour.setBounds(160, 230, 160, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("fournisseur :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 240, 100, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 340, 100, 0);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 380, 100, 0);

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockKeyReleased(evt);
            }
        });
        jPanel2.add(txtStock);
        txtStock.setBounds(150, 310, 160, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Stock sortie  :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 320, 100, 17);

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setText("commander");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(0, 400, 120, 30);

        btnsearch.setText("chercher");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnsearch);
        btnsearch.setBounds(20, 70, 76, 23);
        jPanel2.add(txtDate);
        txtDate.setBounds(150, 350, 150, 22);

        jLabel4.setText("Date de commande");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 350, 110, 16);

        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(200, 400, 110, 30);

        jLabel12.setText("stock :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(30, 280, 70, 16);
        jPanel2.add(txtSE);
        txtSE.setBounds(150, 280, 170, 22);

        jPanel3.setBackground(new java.awt.Color(240, 249, 252));
        jPanel3.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(150, 360, 350, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton6.setText("annuler");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(150, 410, 350, 30);

        txtMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatActionPerformed(evt);
            }
        });
        jPanel3.add(txtMat);
        txtMat.setBounds(170, 100, 160, 20);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable2);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(-330, -100, 790, 90);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel16.setText("Fiche Commande");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel16);
        jLabel16.setBounds(210, 10, 180, 44);

        jLabel11.setText("matricule :");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(30, 100, 56, 16);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Reference", "Quantite", "Date"
            }
        ));
        jScrollPane5.setViewportView(table);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(0, 180, 567, 93);

        jLabel13.setText("Numero de demande :");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 130, 119, 16);
        jPanel3.add(txtNumD);
        txtNumD.setBounds(170, 130, 160, 22);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("resultat");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jButton7.setText("actualiser");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setText("accueil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(550, 550, 550))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
//     try {
//
//            String url = "jdbc:mysql://localhost:3306/stock";
//            String pwd = "";
//            String user = "root";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, user, pwd);
//            
//            try {
//                
//               
//           
//                  
//                 
//
//                  }
//                rs.close();
//                st1.close();
//                con.close();
//            } catch (SQLException e) {
//                System.out.println("Erreur: " + e.getMessage());
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(article_produit.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void txtRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRefActionPerformed

    private void txtRanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRanActionPerformed

    private void txtFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFourActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyReleased

    }//GEN-LAST:event_txtStockKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

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

            String sq = "select stock_entree from article where refArt=?";
            PreparedStatement stmt1 = con.prepareStatement(sq);
            stmt1.setString(1, refArt);
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            
            int stock = rs.getInt("stock_entree");
             int r = stock - qtt;
            String sql = "insert into recevoir (matricule,refArt,qttEntree,dateEntree)values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);


           
            
            stmt.setInt(1, getMat());
            stmt.setString(2, refArt);
            stmt.setInt(3, qtt);
            stmt.setDate(4, date);
            stmt.executeUpdate();

            
            if (r <0) {
             
            JOptionPane.showMessageDialog(new JFrame(), "le stock est insuffisant", "Alerte", JOptionPane.ERROR_MESSAGE);
              txtCode.setText("");
                txtRef.setText("");
                txtFour.setText("");
                txtRan.setText("");
                txtSE.setText("");
                txtStock.setText("");
                
            }
            else if (r == 0){
            String s1 = "update article set stock_entree=? where refArt=?";
            PreparedStatement st = con.prepareStatement(s1);
            st.setInt(1, r);
            st.setString(2, refArt);
            st.executeUpdate();
               JOptionPane.showMessageDialog(new JFrame(), "le stock est maintenant vide", "Alerte", JOptionPane.ERROR_MESSAGE);
                
                txtCode.setText("");
                txtRef.setText("");
                txtFour.setText("");
                txtRan.setText("");
                txtSE.setText("");
                txtStock.setText("");
                loadData();
               // ajoutNumD();
                FillData();}
            else if (r == 1){
            String s1 = "update article set stock_entree=? where refArt=?";
            PreparedStatement st = con.prepareStatement(s1);
            st.setInt(1, r);
            st.setString(2, refArt);
            st.executeUpdate();
               JOptionPane.showMessageDialog(new JFrame(), "il ne reste qu un", "Alerte", JOptionPane.ERROR_MESSAGE);
                
                txtCode.setText("");
                txtRef.setText("");
                txtFour.setText("");
                txtRan.setText("");
                txtSE.setText("");
                txtStock.setText("");
                loadData();
               // ajoutNumD();
                FillData();
                
               
            } else if (r > 1) {
            String s1 = "update article set stock_entree=? where refArt=?";
            PreparedStatement st = con.prepareStatement(s1);
            st.setInt(1, r);
            st.setString(2, refArt);
            st.executeUpdate();
                txtCode.setText("");
                txtRef.setText("");
                txtFour.setText("");
                txtRan.setText("");
                 txtSE.setText("");
                txtStock.setText("");
                loadData();
               // ajoutNumD();
                FillData();
                
                
            }
            con.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

try {
        String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
             PdfPTable table = new PdfPTable(3);
             table.setWidthPercentage(100);
//           
             java.sql.Date date = java.sql.Date.valueOf(java.time.LocalDate.now().toString());
      
            // String query = "select*from recevoir where matricule='"+getMat()+"'";
             String query="select * from recevoir where dateEntree=? and matricule='"+getMat()+"'";
             
            PreparedStatement st = con.prepareStatement(query);
            st.setDate(1,date);
            ResultSet rs =st.executeQuery();
     
            if (rs.next()) {
          
            String fileName = getMat() + ".pdf";

            Document doc =new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            com.itextpdf.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
          
             Chunk titleChunk = new Chunk("Fiche de demande pour le matricule: " + getMat(),  titleFont);
             titleChunk.setUnderline(0.1f, -1f);
               Paragraph title = new Paragraph(titleChunk);
                int qtt = rs.getInt("qttEntree");
                String refArt = rs.getString("refArt");
                Date dt = rs.getDate("dateEntree");
                table.addCell(refArt);
                table.addCell(String.valueOf(qtt));
                table.addCell(String.valueOf(dt));
               
                doc.add(table);
                 JOptionPane.showMessageDialog(this, "Imprime " ,"Dialog" ,JOptionPane.OK_OPTION);
            
                doc.close();
            }

 } catch (SQLException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatActionPerformed


    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed

        try {
            String url = "jdbc:mysql://localhost:3306/stock";
            String pwd = "";
            String user = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement st = con.createStatement();

            String ref = searchData.getText();
            String lib = searchData.getText();
            if (lib.equals("") || (ref.equals(""))) {
                JOptionPane.showMessageDialog(new JFrame(), "NomServices ou idServices obligatoire", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                String sql = "SELECT * FROM article WHERE libelle LIKE '%" + lib + "%' OR refArt LIKE '%" + ref + "%'";
                PreparedStatement pstmt = con.prepareStatement(sql);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String libelle = rs.getString("libelle");

                    String refArt = rs.getString("refArt");

                    if (lib.equalsIgnoreCase(libelle)) {
                        // model.addRow(new Object[]{refArt, lib});
                        txtCode.setText(rs.getString("CodeCat"));
                        txtRef.setText(rs.getString("refArt"));
                        txtFour.setText(rs.getString("fournisseur"));
                        txtRan.setText(rs.getString("rangement"));
                        txtSE.setText(String.valueOf(rs.getInt("stock_entree")));

                    } else if (ref.equalsIgnoreCase(refArt)) {
                        txtCode.setText(rs.getString("CodeCat"));
                        txtRef.setText(rs.getString("refArt"));
                        txtFour.setText(rs.getString("fournisseur"));
                        txtRan.setText(rs.getString("rangement"));
                        txtSE.setText(String.valueOf(rs.getInt("stock_entree")));

                    }

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aucun résultat trouvé", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed

    }//GEN-LAST:event_searchDataActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();
       menu art = new menu();
        art.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Magasin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsearch;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTextField searchData;
    private javax.swing.JTable table;
    public static javax.swing.JTextField txtCode;
    private com.toedter.calendar.JDateChooser txtDate;
    public static javax.swing.JTextField txtFour;
    public static javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtNumD;
    public static javax.swing.JTextField txtRan;
    public static javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtSE;
    public static javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
