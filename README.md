# WithZ
This is 3D game engine.
For now you can only move the camera using WASD.
### how to use:
(example in file main.java)
```java
Camera cam = new Camera(new Position(0, 0, -50)); // Creating Camera and setting it's position
ArrayList<Vertex> obj_vertices = new ArrayList<Vertex>() {{ // points for 1st object.
    add(new Vertex(new Position(100, 50, 150))); // setting vertex positions
    add(new Vertex(new Position(100, 80 ,150)));
}};
ArrayList<Vertex> obj_vertices1 = new ArrayList<Vertex>() {{ // points for 2nd object.
    add(new Vertex(new Position(100, 50, 200))); // setting vertex positions
    add(new Vertex(new Position(100, 80 ,200)));
}};
ArrayList<Object> objects = new ArrayList<>(); // ArrayList of all objects
objects.add(new Object(true, obj_vertices)); // Adding Object to list of objects.
objects.add(new Object(true, obj_vertices1));
World world = new World(cam, objects); // Creating new World and passing to it camera and objects list.
WorldWindow window = new WorldWindow(world); // Creating WorldWindow. (You can use your own if you want to modify it.)
window.setVisible(true); // WorldWindow extends JFrame, so you need to make it visible. (Can be removed in newer versions.)
```
