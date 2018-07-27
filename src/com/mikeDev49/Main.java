package com.mikeDev49;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /* write your code here */
        Camera cam = new Camera(new Position(0, 0, -50));
        ArrayList<Vertex> obj_vertices = new ArrayList<Vertex>() {{
            add(new Vertex(new Position(100, 50, 150)));
            add(new Vertex(new Position(100, 80 ,150)));
            //add(new Vertex(new Position(130, 80 ,150)));
            //add(new Vertex(new Position(130, 50 ,150)));
        }};
        ArrayList<Vertex> obj_vertices1 = new ArrayList<Vertex>() {{
            add(new Vertex(new Position(100, 50, 200)));
            add(new Vertex(new Position(100, 80 ,200)));
            //add(new Vertex(new Position(130, 80 ,150)));
            //add(new Vertex(new Position(130, 50 ,150)));
        }};
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object(true, obj_vertices));
        objects.add(new Object(true, obj_vertices1));
        World world = new World(cam, objects);
        WorldWindow window = new WorldWindow(world);
        window.setVisible(true);
    }
}
