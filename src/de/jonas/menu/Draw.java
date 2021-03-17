package de.jonas.menu;

import de.jonas.Pong;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Der Hintergrund und der Pong-Schriftzug werden hiermit auf das {@link Menu Menü} gezeichnet.
 */
public class Draw extends JLabel {

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // draw pong
        g.setColor(Color.WHITE);
        g.setFont(Pong.getInstance().getDefaultFont().deriveFont(115f));
        g.drawString("P O N G", 25, 100);

        repaint();
    }
}
