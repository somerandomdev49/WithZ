package com.mikeDev49;

public class Position {
    public int x = 0;
    public int y = 0;
    public int z = 0;
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    public Position() {this.x = 0; this.y = 0; this.z = 0;}
}
