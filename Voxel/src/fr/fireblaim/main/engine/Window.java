package fr.fireblaim.main.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

    public static void createWindow(int width, int height, String title) {
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.out.print("Erreur : LWJGL non present ou non trouve");
        }
    }

}