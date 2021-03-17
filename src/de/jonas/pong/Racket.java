package de.jonas.pong;

import de.jonas.Pong;

/**
 * Ein {@link Racket Schläger}, mit dem jeder Spieler am Pong-Spiel teilnimmt.
 */
public final class Racket {

    //<editor-fold desc="LOCAL FIELDS">
    /** Die maximale Y-Koordinate, die ein {@link Racket Schläger} haben darf. */
    private final int maxBottom;
    /** Die minimale Y-Koordinate, die ein {@link Racket Schläger} haben darf. */
    private final int maxTop;

    /** Die Breite des {@link Racket Schlägers}. */
    private final int width;
    /** Die Höhe des {@link Racket Schlägers}. */
    private final int height;

    /** Die aktuelle X-Koordinate des {@link Racket Schlägers}. */
    private int x;
    /** Die aktuelle Y-Koordinate des {@link Racket Schlägers}. */
    private int y;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt einen neuen und vollständig unabhängigen {@link Racket Schläger}. Ein Schläger hat die Eigenschaften Maße
     * und Koordinaten.
     *
     * @param width  Die Breite des {@link Racket Schlägers}.
     * @param height Die Höhe des {@link Racket Schlägers}.
     */
    public Racket(
        final int width,
        final int height
    ) {
        this.width = width;
        this.height = height;
        this.maxBottom = Pong.FRAME_HEIGHT - this.getHeight() - 40;
        this.maxTop = 5;
    }
    //</editor-fold>


    /**
     * Setzt die X-Koordinate des {@link Racket Schlägers} neu.
     *
     * @param x Der neue X-Wert des {@link Racket Schlägers}.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Setzt die Y-Koordinate des {@link Racket Schlägers} neu.
     *
     * @param y Der neue Y-Wert des {@link Racket Schlägers}.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Fügt einen gewissen Wert zu der aktuellen Y-Koordinate des {@link Racket Schlägers} hinzu.
     *
     * @param add Der Wert, der zu der Y-Koordinate des {@link Racket Schlägers} hinzugefügt wird.
     */
    public void addY(final int add) {
        if (this.y >= maxBottom) {
            return;
        }
        this.y += add;
    }

    /**
     * Zieht einen gewissen Wert von der aktuellen Y-Koordinate des {@link Racket Schlägers} ab.
     *
     * @param sub Der Wert, der von der Y-Koordinate des {@link Racket Schlägers} abgezogen wird.
     */
    public void subY(final int sub) {
        if (this.y <= maxTop) {
            return;
        }
        this.y -= sub;
    }

    /**
     * Gibt die aktuelle X-Koordinate des {@link Racket Schlägers} zurück.
     *
     * @return Die aktuelle X-Koordinate des {@link Racket Schlägers}.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gibt die aktuelle Y-Koordinate des {@link Racket Schlägers} zurück.
     *
     * @return Die aktuelle Y-Koordinate des {@link Racket Schlägers}.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gibt die Breite des {@link Racket Schlägers} zurück.
     *
     * @return Die Breite des {@link Racket Schlägers}.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gibt die Höhe des {@link Racket Schlägers} zurück.
     *
     * @return Die Höhe des {@link Racket Schlägers}.
     */
    public int getHeight() {
        return this.height;
    }

}
