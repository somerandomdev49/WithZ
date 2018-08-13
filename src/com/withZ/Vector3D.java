package com.withZ;

public class Vector3D {
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    public Vector3D() {this.x = 0; this.y = 0; this.z = 0;}
    public Vector3D Centralize(int width, int height) {
        return new Vector3D(this.x + (width /2), this.y + (height /2), this.z);
    }
}
