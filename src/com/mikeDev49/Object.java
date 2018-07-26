package com.mikeDev49;

import java.util.ArrayList;
import java.util.List;

public class Object {
    public ArrayList<Vertex> vertices = new ArrayList<>();
    public Object(boolean connectToNext, ArrayList<Vertex> vertexList) {
        if (connectToNext) {
            for (int i = 0; i < vertexList.size(); i++) {
                Vertex vertex = vertexList.get(i);
                if (i != 0) {
                    vertex.vertex = vertices.get(i-1);
                }
                vertices.add(vertex);
            }
            vertices.get(0).vertex = vertices.get(vertices.size() - 1);
        } else {
            this.vertices = vertexList;
        }
    }
}
