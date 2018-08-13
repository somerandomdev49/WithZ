package com.withZ.Meshes;

import com.withZ.*;

import java.util.ArrayList;

public class Box {
    public ArrayList<Vertex> vertices = new ArrayList<>(12);
    public ArrayList<Face> faces;

    /**
     * Creates Box.
     * @param pos
     * @param size
     */
    public Box(Vector3D pos, Vector3D size) {
        for (int i = 0; i < 8; i++) { // Just for no errors
            vertices.add(new Vertex(new Vector3D(0, 0, 0), new ArrayList<>(100), true));
        }
        this.vertices.get(0).position =  pos; // MASTER POINT 1
        this.vertices.get(2).position =  new Vector3D(pos.x - size.x, pos.y, pos.z + size.z); // MASTER POINT 2
        this.vertices.get(3).position =  new Vector3D(pos.x - size.x, pos.y + size.y, pos.z); // MASTER POINT 3
        this.vertices.get(6).position =  new Vector3D(pos.x , pos.y + size.y, pos.z + size.z); // MASTER POINT 4
        this.vertices.get(1).position =  new Vector3D(pos.x - size.x, pos.y, pos.z); // 1; 2;
        this.vertices.get(4).position =  new Vector3D(pos.x - size.x, pos.y + size.y, pos.z + size.z); // 2;
        this.vertices.get(5).position =  new Vector3D(pos.x , pos.y + size.y, pos.z); // 1;
        this.vertices.get(7).position =  new Vector3D(pos.x , pos.y, pos.z + size.z); // 1; 2;

        for (int i = 0; i < 8; i++) { // Just for no errors
            for (int j = 0; j < 100 /* How may connections vertex can have */; j++) { // Just for no errors
                this.vertices.get(i).vertices.add(new Vertex(new Vector3D(), true));
            }
        }

        Vertex MP1V0 = this.vertices.get(0).vertices.get(0);
        Vertex MP1V1 = this.vertices.get(0).vertices.get(1);
        Vertex MP1V2 = this.vertices.get(0).vertices.get(2);
        MP1V0 = this.vertices.get(1);
        MP1V1 = this.vertices.get(5);
        MP1V2 = this.vertices.get(7);

        Vertex MP2V0 = this.vertices.get(2).vertices.get(0);
        Vertex MP2V1 = this.vertices.get(2).vertices.get(1);
        Vertex MP2V2 = this.vertices.get(2).vertices.get(2);
        MP2V0 = this.vertices.get(1);
        MP2V1 = this.vertices.get(5);
        MP2V2 = this.vertices.get(7);


        Vertex MP3V0 = this.vertices.get(3).vertices.get(0);
        Vertex MP3V1 = this.vertices.get(3).vertices.get(1);
        Vertex MP3V2 = this.vertices.get(3).vertices.get(2);
        MP3V0 = this.vertices.get(1);
        MP3V1 = this.vertices.get(5);
        MP3V2 = this.vertices.get(7);

        Vertex MP4V0 = this.vertices.get(6).vertices.get(0);
        Vertex MP4V1 = this.vertices.get(6).vertices.get(1);
        Vertex MP4V2 = this.vertices.get(6).vertices.get(2);
        MP4V0 = this.vertices.get(1);
        MP4V1 = this.vertices.get(5);
        MP4V2 = this.vertices.get(7);
    }
    public com.withZ.Object ToObject() {
        return new com.withZ.Object( this.vertices);
    }
}
