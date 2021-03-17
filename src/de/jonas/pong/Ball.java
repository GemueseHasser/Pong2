package de.jonas.pong;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

import de.jonas.Pong;

/**
 * Der Ball, der sich über das Spielfeld bewegt.
 */
public final class Ball {

    //<editor-fold desc="CONSTANTS">
    /** Die Geschwindigkeit, in dem der {@link Timer} für die Berechnung der Bewegung des {@link Ball Balls} läuft. */
    private static final int TIMER_PERIOD = 10;
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Die Breite des {@link Ball Balls}. */
    private final int width;
    /** Die Höhe des {@link Ball Balls}. */
    private final int height;

    /** Der {@link Racket Schläger} des Nutzers. */
    private final Racket player;
    /** Der {@link Racket Schläger} des Computers ({@link Bot Bots}). */
    private final Racket computer;

    /** Die X-Koordinate des {@link Ball Balls}. */
    private int x;
    /** Die Y-Koordinate des {@link Ball Balls}. */
    private int y;

    /** Die Anzahl, um die der Wert der X-Koordinate des {@link Ball Balls} erhöht wird. */
    private int xIncrementation;
    /** Die Anzahl, um die der Wert der Y-Koordinate des {@link Ball Balls} erhöht wird. */
    private int yIncrementation;

    /** Eine Liste mit allen hinzugefügten {@link BallListener BallListenern}. */
    private final List<BallListener> listeners = new ArrayList<>();
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz eines {@link Ball Balls}. Ein {@link Ball} zeichnet sich
     * aus, durch seine Maße und seine Koordinaten.
     *
     * @param width    Die Breite des {@link Ball Balls}.
     * @param height   Die Höhe des {@link Ball Balls}.
     * @param player   Der {@link Racket Schläger} des Nutzers.
     * @param computer Der {@link Racket Schläger} des Computers ({@link Bot Bots}).
     */
    public Ball(
        final int width,
        final int height,
        final Racket player,
        final Racket computer
    ) {
        xIncrementation = -1;
        yIncrementation = 1;
        this.width = width;
        this.height = height;
        this.player = player;
        this.computer = computer;
    }
    //</editor-fold>


    /**
     * Setzt die X-Koordinate des {@link Ball Balls} neu.
     *
     * @param x Der neue X-Wert.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Setzt die Y-Koordinate des {@link Ball Balls} neu.
     *
     * @param y Der neue Y-Wert.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Gibt den aktuellen X-Wert des {@link Ball Balls} zurück.
     *
     * @return Der aktuelle X-Wert des {@link Ball Balls}.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gibt den aktuellen Y-Wert des {@link Ball Balls} zurück.
     *
     * @return Der aktuelle Y-Wert des {@link Ball Balls}.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gibt die Breite des {@link Ball Balls} zurück.
     *
     * @return Die Breite des {@link Ball Balls}.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gibt die Höhe des {@link Ball Balls} zurück.
     *
     * @return Die Höhe des {@link Ball Balls}.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Lässt den {@link Ball} anfangen sich gezielt über den Bildschirm zu bewegen.
     */
    public void startMoving() {
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                incrementX();
                incrementY();
            }
        }, 10, TIMER_PERIOD);
    }

    /**
     * Fügt einen neuen {@link BallListener} zu dem {@link Ball} hinzu.
     *
     * @param ballListener Ein neuer {@link BallListener}, der zu dem {@link Ball} hinzugefügt wird.
     */
    public void addBallListener(final BallListener ballListener) {
        listeners.add(ballListener);
    }

    /**
     * Verändert den X-Wert passend.
     */
    private void incrementX() {
        if (x < 1) {
            xIncrementation = 1;
            win(PlayerType.COMPUTER);
        }

        if (x > Pong.FRAME_WIDTH - width) {
            xIncrementation = -1;
            win(PlayerType.USER);
        }

        if (isOnRacket(player)) {
            xIncrementation = 1;
            collision(PlayerType.USER);
        }

        if (isOnRacket(computer)) {
            xIncrementation = -1;
            collision(PlayerType.COMPUTER);
        }

        x += xIncrementation;
    }

    /**
     * Verändert den Y-Wert passend.
     */
    private void incrementY() {
        if (y < 1) {
            yIncrementation = 1;
        }

        if (y > Pong.FRAME_HEIGHT - height * 3) {
            yIncrementation = -1;
        }

        y += yIncrementation;
    }

    /**
     * Ein bestimmter {@link PlayerType} hat gewonnen!
     *
     * @param type Der {@link PlayerType Gewinner}.
     */
    private void win(final PlayerType type) {
        for (BallListener listener : listeners) {
            listener.win(type, this);
        }
    }

    /**
     * Der {@link Ball} hat den {@link Racket Schläger} eines bestimmten {@link PlayerType} berührt.
     *
     * @param type Der {@link PlayerType}, dessen {@link Racket Schläger} berührt wurde.
     */
    private void collision(final PlayerType type) {
        for (BallListener listener : listeners) {
            listener.collisionWithRacket(type);
        }
    }

    /**
     * Prüft, ob der {@link Ball} einen bestimmten {@link Racket Schläger} berührt.
     *
     * @param racket Der {@link Racket Schläger}, der auf Kollision geprüft wird.
     *
     * @return Ob der {@link Ball} den {@link Racket Schläger} berührt hat.
     */
    private boolean isOnRacket(final Racket racket) {
        if (racket.equals(player)) {
            return (y > racket.getY() && y < racket.getY() + racket.getHeight())
                && x <= racket.getX() + racket.getWidth();
        }
        if (racket.equals(computer)) {
            return (y > racket.getY() && y < racket.getY() + racket.getHeight())
                && x >= racket.getX() - 10;
        }
        return false;
    }
}
