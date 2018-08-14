# WithZ
This is 3D game engine.
For now you can only move the camera using WASD and Q to go up and E to go down.
### how to use:
(example in file main.java)
```java
import com.lib.withZ.*;
import com.lib.withZ.Meshes.*;
import java.util.ArrayList;

class YourFirstGameWithZ {
    Camera cam = new Camera(new Vector3D(0, 0, -50)); // Creating Camera and setting it's position
    ArrayList<Object> objects = new ArrayList<>(); // ArrayList of all objects
    objects.add(new Box(new Vector3D(0, 0, 0), new Vector3D(1, 1, 1))); // Creating Box Mesh.
    World world = new World(cam, objects); // Creating new World and passing to it camera and objects list.
    WorldWindow window = new WorldWindow(world);
//  ^^^^ Creating WorldWindow. 
// (You can use your own if you want to modify how objects are drawn.)
}
```
