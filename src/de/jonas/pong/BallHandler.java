package de.jonas.pong;

import de.jonas.Pong;

/**
 * Die Aktionen, die ausgeführt werden, sobald ein {@link BallListener} ausgelöst wird.
 */
public final class BallHandler implements BallListener {

    //<editor-fold desc="implementation">
    @Override
    public void win(final PlayerType type, final Ball ball) {
        type.incrementPoints();
        System.out.println("Player " + type.name() + " gets a point! (" + type.getPoints() + ")");
        ball.setX(Pong.FRAME_WIDTH / 2 - ball.getWidth());
        ball.setY(Pong.FRAME_HEIGHT / 2 - ball.getHeight());
    }

    @Override
    public void collisionWithRacket(final PlayerType type) {
        System.out.println("Collision with racket (" + type.name() + ")");
    }
    //</editor-fold>

}
