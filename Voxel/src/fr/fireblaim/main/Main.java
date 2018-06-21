package fr.fireblaim.main;

import fr.fireblaim.main.engine.Window;
import org.lwjgl.opengl.Display;

public class Main {

    public Main() {

    }

    public void update() {

    }

    public void render() {

    }

    public void renderGUI() {

    }

    public static void main(String[] args) {
        Window.createWindow(1280, 720, "Voxel Minecraft");

        Main main = new Main();

        long before = System.nanoTime();
        double ns = 1000000000.0 / 60.0;
        long timer = System.currentTimeMillis();

        int frames = 0;
        int ticks = 0;

        while(!Display.isCloseRequested()) {
            long now = System.nanoTime();

            double elapsed = now - before;

            if(elapsed > ns) {
                main.update();
                ticks++;
                before += ns;
            } else {
                main.render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                System.out.println(frames + " fps, " + ticks + " ticks");
                frames = 0;
                ticks = 0;
                timer += 1000;
            }

            Display.update();
        }

        Display.destroy();
        System.exit(0);
    }

}
