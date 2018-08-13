package com.withZ;

import java.util.ArrayList;

public class World {
    public ArrayList<Object> objects;
    public Camera cam;

    public World(Camera cam, ArrayList<Object> objects) {
        this.cam = cam;
        this.objects = objects;
        this.cam.world = this;
    }
}
