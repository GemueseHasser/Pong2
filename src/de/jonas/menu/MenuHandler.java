package de.jonas.menu;

import de.jonas.GUI;
import de.jonas.Pong;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mithilfe des {@link MenuHandler MenuHandlers} wird geregelt, was beim über den {@link JButton Button} hovern
 * passieren soll, und was, je nach {@link Integer Action}, beim anklicken ausgeführt werden soll.
 */
public class MenuHandler implements MouseListener, ActionListener {

    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link JButton}, der angeklickt wird, bzw über den herüber gehovert wurde. */
    private final JButton button;
    /** Die auszuführende {@link Integer Aktion}. */
    private final int action;
    /** Das {@link GUI Graphical-User-Interface}, auf dem der {@link JButton} später platziert werden soll. */
    private final GUI gui;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue Instanz des {@link MenuHandler MenuHandlers}. Hiermit werden nur die einzelnen Variablen die
     * für die Listener benötigt werden, deklariert.
     *
     * @param button Der {@link JButton}, der angeklickt wird, bzw über den herüber gehovert wurde.
     * @param action Die auszuführende {@link Integer Aktion}, beim anklicken des {@link JButton}.
     * @param gui    Das {@link GUI Graphical-User-Interface}, auf dem der {@link JButton} später platziert werden
     *               soll.
     */
    public MenuHandler(
        final JButton button,
        final int action,
        final GUI gui
    ) {
        this.button = button;
        this.action = action;
        this.gui = gui;
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (action == 0) {
            Pong.startGame();
            gui.dispose();
        }
        if (action == 1) {
            System.exit(0);
        }
    }
    //</editor-fold>
}
