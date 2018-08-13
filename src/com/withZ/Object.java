package com.withZ;

import java.util.ArrayList;

public class Object {
    public Face face;
    public ArrayList<Vertex> vertices = new ArrayList<>();
    public Object(ArrayList<Vertex> vertexList) {
        this.vertices = vertexList;
    }
}
