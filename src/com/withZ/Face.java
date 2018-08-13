package com.withZ;

import java.awt.*;
import java.util.ArrayList;

public class Face {
    public Color color = Color.GRAY;
    public ArrayList<Vertex> vertices;
    public ArrayList<Vertex> rendered_verticest;
    public Face(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }
    public Face(ArrayList<Vertex> vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }
}
