package de.jonas.pong;

/**
 * Ein {@link PlayerType} wird für jeden Spieler des Pong Spiels erzeugt. Bisher gibt es nur den {@code USER} und den
 * {@code COMPUTER}. Für beide Spieler wird hier dessen Punktestand gespeichert.
 */
public enum PlayerType {
    /** Der Spieler "User" in dem Pong-Spiel. */
    USER(),
    /** Der Spieler "Computer" in dem Pong-Spiel. */
    COMPUTER();

    /** Der Punktestand des jeweiligen {@link PlayerType}. */
    private int points;

    /**
     * Der Punktestand des jeweiligen {@link PlayerType} wird um 1 erhöht.
     */
    public void incrementPoints() {
        points += 1;
    }

    /**
     * Der Punktestand des jeweiligen {@link PlayerType PlayerTypes}.
     *
     * @return Der Punktestand des jeweiligen {@link PlayerType PlayerTypes}.
     */
    public int getPoints() {
        return this.points;
    }
}
