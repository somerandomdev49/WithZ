package com.mikeDev49;

public class Vertex {
    public Position position;
    public Vertex vertex;
    public Vertex renderedConnection;

    public Vertex(Position position, Vertex vertex) {
        this.position = position;
        this.vertex = vertex;
    }
    public Vertex(Position position) {
        this.position = position;
    }
}
