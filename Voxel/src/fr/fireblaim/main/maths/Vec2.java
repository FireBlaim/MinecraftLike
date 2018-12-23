package fr.fireblaim.main.maths;

public class Vec2 {

    public float x, y;

    public Vec2() {
        this(0, 0);
    }

    public Vec2(Vec2 vec) {
        this(vec.x, vec.y);
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float magnitude() {
        return Mathf.sqrt(x * x + y * y);
    }

    public Vec2 normalize() {
        float mag = magnitude();

        x /= mag;
        y /= mag;

        return this;
    }

    public float dot(Vec2 r) {
        return x * r.x + y * r.y;
    }

    public float max() {
        return Mathf.max(x, y);
    }

    public float min() {
        return Mathf.min(x, y);
    }

    public static Vec2 lerp(Vec2 a, Vec2 b, float t) {
        float x = Mathf.lerp(a.x, b.x, t);
        float y = Mathf.lerp(a.y, b.y, t);

        return new Vec2(x, y);
    }

    public Vec2 negate() {
        x = -x;
        y = -y;

        return this;
    }

    public Vec2 add(Vec2 vec) {
        x += vec.x;
        y += vec.y;

        return this;
    }

    public Vec2 sub(Vec2 vec) {
        x -= vec.x;
        y -= vec.y;

        return this;
    }

    public Vec2 mul(Vec2 vec) {
        x *= vec.x;
        y *= vec.y;

        return this;
    }

    public Vec2 div(Vec2 vec) {
        x /= vec.x;
        y /= vec.y;

        return this;
    }

    public Vec2 add(float x, float y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Vec2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;

        return this;
    }

    public Vec2 mul(float x, float y) {
        this.x *= x;
        this.y *= y;

        return this;
    }

    public Vec2 div(float x, float y) {
        this.x /= x;
        this.y /= y;

        return this;
    }

    public Vec2 add(float v) {
        x += v;
        y += v;

        return this;
    }

    public Vec2 sub(float v) {
        x -= v;
        y -= v;

        return this;
    }

    public Vec2 mul(float v) {
        x *= v;
        y *= v;

        return this;
    }

    public Vec2 div(float v) {
        x /= v;
        y /= v;

        return this;
    }

    public Vec2 copy() {
        return new Vec2(x, y);
    }

    public String toString() {
        return x + " " + y;
    }

    public boolean equals(Vec2 v) {
        return x == v.x && y == v.y;
    }

    //-----------X
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Vec2 addX(float v) {
        x += v;
        return this;
    }

    public Vec2 subX(float v) {
        x -= v;
        return this;
    }

    //-----------Y
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vec2 addY(float v) {
        y += v;
        return this;
    }

    public Vec2 subY(float v) {
        y -= v;
        return this;
    }


}
