package de.jonas;

import de.jonas.menu.Menu;
import de.jonas.plugins.PluginManager;
import de.jonas.pong.Ball;
import de.jonas.pong.BallHandler;
import de.jonas.pong.Bot;
import de.jonas.pong.PongGui;
import de.jonas.pong.Racket;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;

/**
 * Die Haupt- und Main-Klasse des Pong-Spiels.
 */
public final class Pong {

    //<editor-fold desc="CONSTANTS">
    /** Die Breite, des hauptsächlichen Spiels. */
    public static final int FRAME_WIDTH = 650;
    /** Die Höhe, des hauptsächlichen Spiels. */
    public static final int FRAME_HEIGHT = 450;
    /** Der {@link PluginManager}, der das Aktivieren und Deaktivieren von Plugins regelt. */
    private static final PluginManager manager = new PluginManager();
    //</editor-fold>


    //<editor-fold desc="STATIC FIELDS">
    /** Die Instanz des {@link Pong}. */
    private static Pong instance;
    //</editor-fold>

    //<editor-fold desc="LOCAL FIELDS">
    /** Die {@link Font Schriftart}, die hauptsächlich in diesem Spiel verwendet wird. */
    private Font defaultFont;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz des {@link Pong}. Hiermit wird lediglich die
     * Instanz-Variable deklariert.
     */
    public Pong() {
        instance = this;
    }
    //</editor-fold>


    //<editor-fold desc="setup and start">
    /**
     * Die Main-Methode, die vor allen anderen Methoden dieser Anwendung aufgerufen wird.
     *
     * @param args .
     */
    public static void main(String[] args) {
        final Pong pong = new Pong();
        pong.loadFont();
        new Menu();
        pong.loadPlugins();
    }
    //</editor-fold>

    /**
     * Startet das hauptsächliche Spiel.
     */
    public static void startGame() {
        // declare player
        final Racket player = new Racket(30, 150);
        player.setX(10);
        player.setY(FRAME_HEIGHT / 2 - player.getHeight() / 2);

        // declare computer
        final Racket computer = new Racket(30, 150);
        computer.setX(FRAME_WIDTH - (computer.getWidth() + 20));
        computer.setY(FRAME_HEIGHT / 2 - computer.getHeight() / 2);

        // declare ball
        final Ball ball = new Ball(15, 15, player, computer);
        ball.setX(FRAME_WIDTH / 2 - ball.getWidth());
        ball.setY(FRAME_HEIGHT / 2 - ball.getHeight());
        ball.addBallListener(new BallHandler());

        // start bot
        new Bot(ball, computer);

        // open interface
        new PongGui(ball, player, computer);
    }

    /**
     * Lädt die standardmäßige {@link Font Schriftart}.
     */
    private void loadFont() {
        final URL url = getClass().getResource("/de/jonas/res/coders_crux.ttf");
        try {
            defaultFont = Font.createFont(Font.TRUETYPE_FONT, url.openStream()).deriveFont(40f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt alle Plugins in dem 'plugins' Ordner, der sich in demselben Verzeichnis wie die Anwendung befindet.
     */
    private void loadPlugins() {
        manager.start();
    }

    /**
     * Stoppt alle Plugins, die beim Start aktiviert bzw geladen wurden.
     */
    public void unloadPlugins() {
        manager.stop();
    }

    /**
     * Gibt die Instanz-Variable dieser {@link Pong Klasse} zurück.
     *
     * @return Die Instanz-Variable dieser {@link Pong Klasse}.
     */
    public static Pong getInstance() {
        return instance;
    }

    /**
     * Gibt die standardmäßige Schriftart {@link Font Schriftart} zurück.
     *
     * @return Die standardmäßige Schriftart {@link Font Schriftart}.
     */
    public Font getDefaultFont() {
        return defaultFont;
    }

}
