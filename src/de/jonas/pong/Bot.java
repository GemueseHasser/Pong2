package de.jonas.pong;

import de.jonas.Pong;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Der {@link Bot} sorgt dafür, dass der {@link Racket Computer}, den Ball so gut es geht bekommt.
 */
public final class Bot {

    //<editor-fold desc="CONSTANTS">
    /**
     * Die Geschwindiǵkeit, mit der der {@link Timer} zum berechnen der besten Position des {@link Racket Computers}
     * läuft.
     */
    private static final int TIMER_PERIOD = 100;
    /** Die Geschwindigkeit des {@link Racket Schläger} des Computers. */
    private static final int SPEED = 8;
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link Ball}, womit die best-mögliche Position des {@link Racket Computer} berechnet wird. */
    private final Ball ball;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz des {@link Bot}. Mit diesem wird dann die best-mögliche
     * Position des {@link Ball Balls} berechnet.
     *
     * @param ball     Der {@link Ball}, womit die best-mögliche Position des {@link Racket Computer} berechnet wird.
     * @param computer Der {@link Racket Computer}, für den die bestmögliche Position berechnet werden soll.
     */
    public Bot(
        final Ball ball,
        final Racket computer
    ) {
        this.ball = ball;
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isOnSide()) {
                    return;
                }
                if (ball.getY() < computer.getY() + 50) {
                    computer.subY(SPEED);
                } else {
                    computer.addY(SPEED);
                }
            }
        }, 0, TIMER_PERIOD);
    }
    //</editor-fold>


    /**
     * Überprüft, ob der {@link Ball} auf der Seite des {@link Racket Computer} ist.
     *
     * @return Ob der {@link Ball} auf der Seite des {@link Racket Computer} ist.
     */
    private boolean isOnSide() {
        return ball.getX() > Pong.FRAME_WIDTH / 2;
    }

}
