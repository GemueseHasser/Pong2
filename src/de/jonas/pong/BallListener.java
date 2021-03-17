package de.jonas.pong;

/**
 * Ein {@link BallListener} wird ausgelöst, sobald ein Spieler gewonnen hat, oder sobald der {@link Ball} einen {@link
 * Racket Schläger} berührt.
 */
public interface BallListener {
    /**
     * Diese Methode wird bei einem Sieg aufgerufen (wenn jemand den Ball nicht mehr bekommt).
     *
     * @param type Der {@link PlayerType}, der gewonnen hat.
     * @param ball Der {@link Ball}, der den Spieler hat gewinnen lassen.
     */
    void win(PlayerType type, Ball ball);

    /**
     * Diese Methode wird bei einer Berührung durch den {@link Ball} mit einem {@link Racket Schläger} aufgerufen.
     *
     * @param type Der {@link PlayerType}, dessen Schläger berührt wurde.
     */
    void collisionWithRacket(PlayerType type);
}
