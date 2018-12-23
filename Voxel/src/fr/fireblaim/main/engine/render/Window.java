package fr.fireblaim.main.engine.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class Window {

    public static void createWindow(int width, int height, String title, boolean resizable, boolean fullscreen) {
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);
            Display.setResizable(resizable);
            Display.setFullscreen(fullscreen);
            Display.create();

            initGL();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.out.println("Erreur : LWJGL non present ou non trouve");
        }
    }

    public static void clearBuffers() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    private static void initGL() {
        glEnable(GL_DEPTH_TEST);
    }

    public static float getAspect() {
        return (float) Display.getWidth() / (float) Display.getHeight();
    }

}