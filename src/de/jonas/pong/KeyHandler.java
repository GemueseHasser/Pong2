package de.jonas.pong;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Es wird ein Tastendruck gehandhabt. In diesem Fall, wird nur auf die hoch- und runter-Pfeiltasten reagiert. Mit jenen
 * wird der {@link Racket Schläger} des {@link PlayerType Spielers} entweder hoch oder runter bewegt.
 */
public final class KeyHandler implements KeyListener {

    //<editor-fold desc="CONSTANTS">
    /** Die Geschwindigkeit, mit der sich der {@link Racket Schläger} beim Tastendruck bewegt. */
    private static final int SPEED = 7;
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link Racket Schläger}, der sich je nach Tastendruck hoch oder herunter bewegen soll. */
    private final Racket player;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue Instanz des {@link KeyHandler KeyHandlers}. Hiermit wird der {@link KeyHandler} initialisiert.
     *
     * @param player Der {@link Racket Schläger} der, bewegt werden soll.
     */
    public KeyHandler(final Racket player) {
        this.player = player;
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // move up
            player.subY(SPEED);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // move down
            player.addY(SPEED);
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }
    //</editor-fold>

}
