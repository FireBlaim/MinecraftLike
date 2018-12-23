package fr.fireblaim.main.engine.render;

import fr.fireblaim.main.maths.Mathf;
import fr.fireblaim.main.maths.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Camera {

    private float fov, zNear, zFar;

    private Vec3 position;
    private Vec3 rotation = new Vec3();

    private float mouseSpeed = 0.3f;
    private float movementSpeed = 0.05f;

    public Camera(Vec3 position) {
        this.position = position;
    }

    public Camera setPerspectiveProjection(float fov, float zNear, float zFar) {
        this.fov = fov;
        this.zNear = zNear;
        this.zFar = zFar;

        return this;
    }

    public void getPerspectiveProjection() {
        glEnable(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(fov, Window.getAspect(), zNear, zFar);
        glEnable(GL_MODELVIEW);
    }

    public void update() {
        glPushAttrib(GL_TRANSFORM_BIT);
            glRotatef(position.x, 1, 0, 0);
            glRotatef(position.y, 0, 1, 0);
            glRotatef(position.z, 0, 0, 1);
            glTranslatef(-rotation.x, -rotation.y, -rotation.z);
        glPopMatrix();
    }

    public void input() {
        rotation.addX(-Mouse.getDY() * mouseSpeed);
        rotation.addY(Mouse.getDX() * mouseSpeed);

        if(rotation.x > 90) rotation .setX(90);
        if(rotation.x < -90) rotation .setX(-90);

        if(Keyboard.isKeyDown(Keyboard.KEY_Z) | Keyboard.isKeyDown(Keyboard.KEY_W)) {
            position.add(getForward().mul(movementSpeed));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q) | Keyboard.isKeyDown(Keyboard.KEY_A)) {
            position.add(getLeft().mul(movementSpeed));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
            position.add(getBack().mul(movementSpeed));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            position.add(getRight().mul(movementSpeed));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            position.add(new Vec3(0, -1, 0));
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            position.add(new Vec3(0, 1, 0));
        }
    }

    private Vec3 getForward() {
        Vec3 r = new Vec3();
        Vec3 rot = new Vec3(rotation);

        float cosY = (float) Math.cos(Math.toRadians(rot.y - 90));
        float sinY = (float) Math.sin(Math.toRadians(rot.y - 90));
        float cosP = (float) Math.cos(Math.toRadians(-rot.x));
        float sinP = (float) Math.sin(Math.toRadians(-rot.y));

        r.setX(cosY * cosP);
        r.setY(sinP);
        r.setZ(sinY * cosP);
        r.normalize();

        return new Vec3(r);
    }

    private Vec3 getBack() {
        return new Vec3(getForward().mul(-1));
    }

    private Vec3 getRight() {
        Vec3 r = new Vec3();
        Vec3 rot = new Vec3(rotation);

        r.setX((float) Math.cos(Math.toRadians(rot.y)));
        r.setZ((float) Math.sin(Math.toRadians(rot.y)));

        return new Vec3(r);
    }

    private Vec3 getLeft() {
        return new Vec3(getRight().mul(-1));
    }
}