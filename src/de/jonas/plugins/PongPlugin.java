package de.jonas.plugins;

public interface PongPlugin {

    boolean start();

    boolean stop();

    void setPluginManager(final PongPluginManager manager);

}
