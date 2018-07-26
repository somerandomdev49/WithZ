package com.mikeDev49;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {

    public static void main(String[] args) {
        /* write your code here */
        Camera cam = new Camera(new Position(0, 0, -50));
        ArrayList<Vertex> obj_vertices = new ArrayList<Vertex>() {{
            add(new Vertex(new Position(100, 50, 150)));
            add(new Vertex(new Position(100, 80 ,150)));
            add(new Vertex(new Position(130, 80 ,150)));
            //add(new Vertex(new Position(130, 50 ,150)));
        }};
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object(true, obj_vertices));
        World world = new World(cam, objects);
        WorldWindow window = new WorldWindow(world);
        window.setVisible(true);
    }
}
