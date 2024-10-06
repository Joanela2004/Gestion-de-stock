package com.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.model.AccueilForm;
import com.model.menu;
import com.model.Employe;
import com.model.Magasin;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
    }
 private int m;
    
public menu(int m){
    
this.m = m;

initComponents();

}
public int getMat(){
return m;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        perso = new javax.swing.JButton();
        categorie = new javax.swing.JButton();
        article = new javax.swing.JButton();
        comm = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(240, 240));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1246, 400));

        perso.setBackground(new java.awt.Color(0, 153, 255));
        perso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        perso.setForeground(new java.awt.Color(255, 255, 255));
        perso.setText("PERSONNEL");
        perso.setBorder(null);
        perso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persoActionPerformed(evt);
            }
        });

        categorie.setBackground(new java.awt.Color(0, 153, 255));
        categorie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        categorie.setForeground(new java.awt.Color(255, 255, 255));
        categorie.setText("CATEGORIES");
        categorie.setBorder(null);
        categorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorieActionPerformed(evt);
            }
        });

        article.setBackground(new java.awt.Color(0, 153, 255));
        article.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        article.setForeground(new java.awt.Color(255, 255, 255));
        article.setText("ARTICLES");
        article.setBorder(null);
        article.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleActionPerformed(evt);
            }
        });

        comm.setBackground(new java.awt.Color(0, 153, 255));
        comm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comm.setForeground(new java.awt.Color(255, 255, 255));
        comm.setText("COMMANDE");
        comm.setBorder(null);
        comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU PRINCIPALE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("      QUITTER");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(perso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perso, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorieActionPerformed
         
        try {
            setVisible(false);
            new categ().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_categorieActionPerformed

    private void articleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleActionPerformed
        try {
            setVisible(false);
            new article().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_articleActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       int a = JOptionPane.showConfirmDialog(null, "Voulez-vous vous déconnecter de l'application?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new AccueilForm().setVisible(true);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void persoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persoActionPerformed
             
       Employe emp=new Employe();
       emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_persoActionPerformed

    private void commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commActionPerformed
   

        Magasin mag= new Magasin((int)m);
        
        mag.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_commActionPerformed
   public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton article;
    private javax.swing.JButton categorie;
    private javax.swing.JButton comm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton perso;
    // End of variables declaration//GEN-END:variables
}
