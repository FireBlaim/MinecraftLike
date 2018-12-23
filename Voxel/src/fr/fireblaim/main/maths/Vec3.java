package fr.fireblaim.main.maths;

public class Vec3 {

    public float x, y, z;

    public Vec3() {
        this(0, 0, 0);
    }

    public Vec3(Vec3 vec) {
        this(vec.x, vec.y, vec.z);
    }

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float magnitude() {
        return Mathf.sqrt(x * x + y * y + z * z);
    }

    public Vec3 normalize() {
        float mag = magnitude();

        x /= mag;
        y /= mag;
        z /= mag;

        return this;
    }

    public Vec3 cross(Vec3 r) {
        float nx = y * r.z - z * r.y;
        float ny = z * r.x - x * r.z;
        float nz = x * r.y - y * r.x;

        return new Vec3(nx, ny, nz);
    }

    public float dot(Vec3 r) {
        return x * r.x + y * r.y + z * r.z;
    }

    public float max() {
        return Mathf.max(x, Mathf.max(y, z));
    }

    public float min() {
        return Mathf.min(x, Mathf.min(y, z));
    }

    public static Vec3 lerp(Vec3 a, Vec3 b, float t) {
        float x = Mathf.lerp(a.x, b.x, t);
        float y = Mathf.lerp(a.y, b.y, t);
        float z = Mathf.lerp(a.z, b.z, t);

        return new Vec3(x, y, z);
    }

    public Vec3 negate() {
        x = -x;
        y = -y;
        z = -z;

        return this;
    }

    public Vec3 add(Vec3 vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;

        return this;
    }

    public Vec3 sub(Vec3 vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;

        return this;
    }

    public Vec3 mul(Vec3 vec) {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;

        return this;
    }

    public Vec3 div(Vec3 vec) {
        x /= vec.x;
        y /= vec.y;
        z /= vec.z;

        return this;
    }

    public Vec3 add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;

        return this;
    }

    public Vec3 sub(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;

        return this;
    }

    public Vec3 mul(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;

        return this;
    }

    public Vec3 div(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;

        return this;
    }

    public Vec3 add(float v) {
        x += v;
        y += v;
        z += v;

        return this;
    }

    public Vec3 sub(float v) {
        x -= v;
        y -= v;
        z -= v;

        return this;
    }

    public Vec3 mul(float v) {
        x *= v;
        y *= v;
        z *= v;

        return this;
    }

    public Vec3 div(float v) {
        x /= v;
        y /= v;
        z /= v;

        return this;
    }

    public Vec3 copy() {
        return new Vec3(x, y, z);
    }

    public String toString() {
        return x + " " + y + " " + z;
    }

    public boolean equals(Vec3 v) {
        return x == v.x && y == v.y && z == v.z;
    }

    //-----------X
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Vec3 addX(float v) {
        x += v;
        return this;
    }

    public Vec3 subX(float v) {
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

    public Vec3 addY(float v) {
        y += v;
        return this;
    }

    public Vec3 subY(float v) {
        y -= v;
        return this;
    }

    //-----------Z
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Vec3 addZ(float v) {
        z += v;
        return this;
    }

    public Vec3 subZ(float v) {
        z -= v;
        return this;
    }

}
