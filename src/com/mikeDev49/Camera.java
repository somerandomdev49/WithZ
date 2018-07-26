package com.mikeDev49;

import java.util.ArrayList;

public class Camera {
    public Position position = new Position();
    public int screenDistance = 100;
    public World world;
    public  Camera() {}
    public Camera(Position position) {
        this.position = position;
    }
    public Camera(Position position, int screenDistance) {
        this.position = position;
        this.screenDistance = screenDistance;
    }
    public ArrayList<ArrayList<Vertex>> Render() {
        //System.out.print("Render");

        // Render method.
        ArrayList<ArrayList<Vertex>> outer = new ArrayList<>();
        for (Object obj : world.objects) {
            outer.add(RenderObject(obj));
        }
        System.out.println("How many objects in world: " + world.objects.size());
        return outer;
    }
    private ArrayList<Vertex> RenderObject(Object obj) {
        //System.out.print("ObjectRender");
        ArrayList<Vertex> vertices = new ArrayList<>();
        System.out.println("How many vertices in object: " + obj.vertices.size());
        for (int v=0;v<obj.vertices.size();v++) {
            Vertex vertex = obj.vertices.get(v);
            int x = this.position.x - (this.screenDistance *
                    (this.position.x - vertex.position.x)) / (vertex.position.z - this.position.z);
            int y = this.position.y - (this.screenDistance *
                    (this.position.y - vertex.position.y)) / (vertex.position.z - this.position.z);
            System.out.println("Rendered x and y for vertex");
            Vertex i = new Vertex(new Position(x, y), vertex.vertex);
            if (v != 0) {
                vertex.renderedConnection = vertices.get(v-1);
            }
            vertices.add(i);

        }
        vertices.get(0).renderedConnection = vertices.get(vertices.size() - 1);
        return vertices;
    }
}
