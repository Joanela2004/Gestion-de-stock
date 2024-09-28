package com.raven.swing.scrollbar;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {

    // Taille du curseur (thumb)
    private final int TAILLE_CURSEUR = 80;

    @Override
    protected Dimension getMaximumThumbSize() {
        // Définir la taille maximale du curseur en fonction de l'orientation
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, TAILLE_CURSEUR);
        } else {
            return new Dimension(TAILLE_CURSEUR, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        // Définir la taille minimale du curseur en fonction de l'orientation
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, TAILLE_CURSEUR);
        } else {
            return new Dimension(TAILLE_CURSEUR, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        // Créer un bouton personnalisé pour augmenter la valeur
        return new BoutonScrollBar();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        // Créer un bouton personnalisé pour diminuer la valeur
        return new BoutonScrollBar();
    }

    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // Méthode pour dessiner la piste de défilement (non utilisée ici)
    }

    @Override
    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // Dessiner le curseur (thumb) avec un rendu anti-aliasé
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rctngl.x;
        int y = rctngl.y;
        int width = rctngl.width;
        int height = rctngl.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 1, 1);
    }

    // Classe interne pour le bouton de la barre de défilement
    private class BoutonScrollBar extends JButton {

        public BoutonScrollBar() {
            // Supprimer la bordure par défaut
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
            // Ne pas dessiner le bouton (le rendre transparent)
        }
    }
}
