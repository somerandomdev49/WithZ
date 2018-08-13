package com.withZ;

import java.util.ArrayList;

public class Vertex {
    public Vector3D position;
    public ArrayList<Vertex> vertices = new ArrayList<>(100);
    public Vertex renderedConnection;
    public Vertex Render;
    public boolean isRendered = true;

    public Vertex(Vector3D position, ArrayList<Vertex> vertices, boolean isRendered) {
        this.position = position;
        this.vertices = vertices;

    }
    public Vertex(Vector3D position, boolean isRendered) {
        this.position = position;
        this.isRendered = isRendered;
    }

}
