package de.jonas.pong;

import de.jonas.Pong;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Zeichnet das gesamte Pong-Spiel. Das Spiel wird hiermit durchgehend neu gezeichnet, wodurch dann die Bewegung
 * entsteht.
 */
public final class Draw extends JLabel {

    //<editor-fold desc="CONSTANTS">
    /** Die Anzahl an Kästchen, aus denen das Netz besteht. */
    private static final int GRID_RECT_AMOUND = 16;
    /** Die Größe, aus denen ein Kästchen des Netzes besteht. */
    private static final int GRID_RECT_SIZE = 15;

    /** Die X-Koordinate, an der der Punktestand des Nutzers angezeigt wird. */
    private static final int USER_POINTS_X = 220;
    /** Die Y-Koordinate, an der der Punktestand des Nutzers angezeigt wird. */
    private static final int USER_POINTS_Y = 75;

    /** Die X-Koordinate, an der der Punktestand des Computers angezeigt wird. */
    private static final int COMPUTER_POINTS_X = 395;
    /** Die Y-Koordinate, an der der Punktestand des Computers angezeigt wird. */
    private static final int COMPUTER_POINTS_Y = 75;
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link Ball}, der über den Bildschirm läuft, bzw ständig auf den Bildschirm gezeichnet wird. */
    private final Ball ball;
    /** Der {@link Racket Schläger} des {@link PlayerType Nutzers}, der ständig auf den Bildschirm gezeichnet wird. */
    private final Racket user;
    /** Der {@link Racket Computer} des {@link PlayerType Spielers}, der ständig auf den Bildschirm gezeichnet wird. */
    private final Racket computer;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue Instanz der {@link Draw Draw-Klasse}. Das Spiel wird hiermit durchgehend neu gezeichnet,
     * wodurch dann die Bewegung entsteht.
     *
     * @param ball     Der {@link Ball}, der ständig neu gezeichnet wird.
     * @param user   Der {@link Racket Schläger} des {@link PlayerType Nutzers}, der ständig neu gezeichnet wird.
     * @param computer Der {@link Racket Schläger} des {@link PlayerType Computers}, der ständig neu gezeichnet wird.
     */
    public Draw(
        final Ball ball,
        final Racket user,
        final Racket computer
    ) {
        this.ball = ball;
        this.user = user;
        this.computer = computer;
    }
    //</editor-fold>


    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // draw grid
        g.setColor(Color.WHITE);

        final int x = this.getWidth() / 2 - GRID_RECT_SIZE / 2;
        int y = 13;

        for (int i = 0; i < GRID_RECT_AMOUND; i++) {
            g.fillRect(x, y, GRID_RECT_SIZE, GRID_RECT_SIZE);
            y += GRID_RECT_SIZE + 10;
        }

        // draw player racket
        g.fillRect(user.getX(), user.getY(), user.getWidth(), user.getHeight());

        // draw computer racket
        g.fillRect(computer.getX(), computer.getY(), computer.getWidth(), computer.getHeight());

        // draw points
        g.setFont(Pong.getInstance().getDefaultFont().deriveFont(95f));

        g.drawString(PlayerType.USER.getPoints() + "", USER_POINTS_X, USER_POINTS_Y);
        g.drawString(PlayerType.COMPUTER.getPoints() + "", COMPUTER_POINTS_X, COMPUTER_POINTS_Y);

        // draw ball
        g.setColor(Color.GREEN);
        g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

        repaint();
    }

}
