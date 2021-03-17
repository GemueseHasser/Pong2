package de.jonas.plugins;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginManager {

    private static final List<PongPlugin> loadedPlugins = new ArrayList<>();

    public void start() {
        System.out.println("starting loading plugins.");
        File[] files = new File("plugins").listFiles();

        assert files != null;
        for (final File file : files) {
            loadPlugin(file);
            System.out.println("loaded plugin [" + file + "]");
        }
        for (PongPlugin plugin : loadedPlugins) {
            plugin.start();
        }
    }

    public void stop() {
        for (PongPlugin plugin : loadedPlugins) {
            plugin.stop();
        }
    }

    public void loadPlugin(final File file) {
        try {
            final JarFile jarFile = new JarFile(file);
            final Manifest manifest = jarFile.getManifest();
            final Attributes attributes = manifest.getMainAttributes();
            final String main = attributes.getValue(Attributes.Name.MAIN_CLASS);

            final Class cl = new URLClassLoader(new URL[]{file.toURL()}).loadClass(main);
            final Class[] interfaces = cl.getInterfaces();

            boolean isPlugin = false;

            for (int i = 0; i < interfaces.length && !isPlugin; i++) {
                if (interfaces[i].getName().equals("de.jonas.plugins.PongPlugin")) {
                    isPlugin = true;
                }
                if (isPlugin) {
                    PongPlugin plugin = (PongPlugin) cl.newInstance();
                    loadedPlugins.add(plugin);
                }
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
