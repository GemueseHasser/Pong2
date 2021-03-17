package de.jonas;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.KeyListener;

/**
 * Ein einfaches {@link JFrame Fenster}, mit dem später weitergearbeitet werden kann.
 */
public final class GUI {

    //<editor-fold desc="LOCAL FIELDS">
    /** Das Fenster, welches durch eine neue Instanz erstellt wird. */
    private final JFrame frame;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt ein neues und vollständig unabhängiges {@link GUI Graphical-User-Interface}. Dadurch wird ein einfaches
     * {@link JFrame Fenster} erzeugt, mit dem später weitergearbeitet werden kann.
     *
     * @param width       Die Breite des {@link JFrame Fensters}.
     * @param height      Die Höhe des {@link JFrame Fensters}.
     * @param title       Der Titel des {@link JFrame Fensters}.
     * @param undecorated Ist das {@link JFrame Fenster} undekoriert?
     */
    public GUI(
        final int width,
        final int height,
        final String title,
        final boolean undecorated
    ) {
        this.frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(undecorated);
        frame.setVisible(false);
    }
    //</editor-fold>


    /**
     * Macht das {@link GUI} sichtbar.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Schließt das {@link GUI}.
     */
    public void dispose() {
        frame.dispose();
    }

    /**
     * Fügt einen {@link KeyListener} zu dem {@link GUI} hinzu.
     *
     * @param keyListener Der {@link KeyListener}, der zu dem {@link GUI} hinzugefügt wird.
     */
    public void addKeyListener(final KeyListener keyListener) {
        frame.addKeyListener(keyListener);
    }

    /**
     * Fügt einen bestimmten {@link Component Komponenten} zu dem {@link GUI} hinzu.
     *
     * @param component Der {@link Component Komponent}, der zu dem {@link GUI} hinzugefügt wird.
     */
    public void add(final Component component) {
        frame.add(component);
    }

}
