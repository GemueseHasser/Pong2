package de.jonas.pong;

import de.jonas.GUI;
import de.jonas.Pong;

import static de.jonas.Pong.FRAME_HEIGHT;
import static de.jonas.Pong.FRAME_WIDTH;

/**
 * Das {@link GUI Graphical-User-Interface} für das Pong-Spiel.
 */
public final class PongGui {

    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt ein neues und vollständig unabhängiges {@link PongGui}. In diesem {@link GUI Graphical-User-Interface}
     * wird das Spiel dargestellt.
     *
     * @param ball     Der {@link Ball}, der in dem {@link PongGui} dargstellt wird.
     * @param player   Der {@link Racket Schläger} des {@link PlayerType Nutzers}, der in dem {@link PongGui}
     *                 dargestellt wird.
     * @param computer Der {@link Racket Schläger} des {@link PlayerType Computers}, der in dem {@link PongGui}
     *                 dargestellt wird.
     */
    public PongGui(
        final Ball ball,
        final Racket player,
        final Racket computer
    ) {
        // launch ball
        ball.startMoving();
        // open frame
        final GUI gui = new GUI(FRAME_WIDTH, FRAME_HEIGHT, "Pong - by Jonas -", false);
        gui.addKeyListener(new KeyHandler(player));

        final Draw draw = new Draw(ball, player, computer);
        draw.setBounds(0, 0, FRAME_WIDTH, Pong.FRAME_HEIGHT);
        draw.setVisible(true);

        gui.add(draw);
        gui.show();
    }
    //</editor-fold>

}
