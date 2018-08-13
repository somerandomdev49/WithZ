package com.withZ;

import com.withZ.Meshes.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Camera cam = new Camera(new Vector3D(0, 0, -50)); // Creating Camera and setting it's position
        ArrayList<Object> objects = new ArrayList<>(); // ArrayList of all objects
        objects.add(new Box(new Vector3D(0, 0, 0), new Vector3D(10, 20, 10)).ToObject());
        //          ^^^^^^^  Making Box Geometry.
        World world = new World(cam, objects); // Creating new World and passing to it camera and objects list.
        WorldWindow window = new WorldWindow(world); // Creating WorldWindow. (You can use your own if you want to modify it.)
    }
}
