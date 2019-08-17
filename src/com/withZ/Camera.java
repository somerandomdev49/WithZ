package com.withZ;

import java.util.ArrayList;

public class Camera {
    public Vector3D position = new Vector3D();
    public int screenDistance = 100;
    public World world;
    public  Camera() {}
    public Camera(Vector3D position) {
        this.position = position;
    }
    public Camera(Vector3D position, int screenDistance) {
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
        System.out.println("RenderObject method:");
        ArrayList<Vertex> vertices = new ArrayList<>();
        System.out.println("How many vertices in object: " + obj.vertices.size());
        for (int v=0;v<obj.vertices.size();v++) {
            Vertex vertex = obj.vertices.get(v);
            int x = vertex.position.x / vertex.position.z;
            int y = vertex.position.y / vertex.position.z;
            System.out.println("Generated rendered x and y for vertex");
            Vertex i = new Vertex(new Vector3D(x, y), vertex.vertices, true);
            vertex.Render = i;
            vertices.add(i);


        }
        System.out.println("Ended RenderObject method:");
        return vertices;

    }
}
