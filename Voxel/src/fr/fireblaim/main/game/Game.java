package fr.fireblaim.main.game;

import fr.fireblaim.main.engine.render.Camera;
import fr.fireblaim.main.maths.Vec3;

public class Game {

    private Camera cam;

    public Game() {
        cam = new Camera(new Vec3(0, 0, 0));
        cam.setPerspectiveProjection(70.0f, 0.1f, 150.0f);
    }

    public void render() {
        cam.getPerspectiveProjection();
        cam.update();
    }

    public void update() {
        cam.input();
    }

}