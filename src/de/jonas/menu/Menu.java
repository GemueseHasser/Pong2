package de.jonas.menu;

import de.jonas.GUI;
import de.jonas.Pong;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;

/**
 * Das {@link Menu Menü} öffnet sich unmittelbar nachdem man die Anwendung gestartet hat und in diesem kann man dann
 * auswählen, ob man das Spiel nun starten möchte, oder doch wieder beenden möchte.
 */
public class Menu {

    //<editor-fold desc="CONSTANTS">
    /** Die Breite des {@link GUI Graphical-User-Interface} des {@link Menu Menü}. */
    private static final int WIDTH = 350;
    /** Die Höhe des {@link GUI Graphical-User-Interface} des {@link Menu Menü}. */
    private static final int HEIGHT = 450;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz des {@link Menu}. Ein {@link Menu Menü} wird unmittelbar
     * nachdem man die Anwendung gestartet hat geöffent und man kann in diesem dann auswählen, ob man das Spiel nun
     * starten, oder doch lieber wieder beenden möchte.
     */
    public Menu() {
        final GUI gui = new GUI(WIDTH, HEIGHT, null, true);

        final Draw draw = new Draw();
        draw.setBounds(0, 0, WIDTH, HEIGHT);
        draw.setVisible(true);

        final JButton play = new JButton("Spielen");
        play.setBounds(50, 200, WIDTH - 100, 50);
        prepareButton(play, 0, gui);

        final JButton exit = new JButton("Beenden");
        exit.setBounds(50, 300, WIDTH - 100, 50);
        prepareButton(exit, 1, gui);

        gui.add(play);
        gui.add(exit);
        gui.add(draw);
        gui.show();
    }
    //</editor-fold>


    /**
     * Verleiht einem {@link JButton} die gewünschten Eigenschaften, um stylisch gut in das {@link Menu Menü} zu
     * passen.
     *
     * @param button Der {@link JButton} der bearbeitet wird.
     * @param action Die {@link Integer Action} die ausgeführt werden soll, beim anklicken des {@link JButton}.
     * @param gui    Das {@link GUI Graphical-User-Interface}, auf dem der Button später platziert wird.
     */
    private void prepareButton(
        final JButton button,
        final int action,
        final GUI gui
    ) {
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setOpaque(true);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(Pong.getInstance().getDefaultFont());
        button.addMouseListener(new MenuHandler(button, action, gui));
        button.addActionListener(new MenuHandler(button, action, gui));
    }

}
