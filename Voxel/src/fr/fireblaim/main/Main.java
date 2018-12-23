package fr.fireblaim.main;

import fr.fireblaim.main.engine.render.Window;
import fr.fireblaim.main.game.Game;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Main {

    private static Main instance;

    private int frames = 0;
    private int ticks = 0;

    private Game game;

    public Main() {
        Window.createWindow(1280, 720, "Voxel Minecraft", false, false);
        game = new Game();
    }

    public void update() {
        if(Mouse.isGrabbed() && Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Mouse.setGrabbed(false);
        if(!Mouse.isGrabbed() && Mouse.isButtonDown(0)) Mouse.setGrabbed(true);
        if(!Mouse.isGrabbed()) return;

        game.update();
    }

    public void render() {
        Window.clearBuffers();

        game.render();
        renderGUI();
    }

    public void renderGUI() {

    }

    public void start() {
        instance = this;
        loop();
    }

    public void loop() {
        long before = System.nanoTime();
        double ns = 1000000000.0 / 60.0;
        long timer = System.currentTimeMillis();

        while(!Display.isCloseRequested()) {
            long now = System.nanoTime();
            double elapsed = now - before;

            if(elapsed > ns) {
                update();
                ticks++;
                before += ns;
            } else {
                render();
                Display.update();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }

        stop();
    }

    public void stop() {
        instance = null;
        Display.destroy();
        System.exit(0);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public static Main getInstance() {
        return instance;
    }
}
