package com.withZ;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class WorldWindow extends JFrame {
    public World world;
    public JPanel panel;
    public JTextArea console;
    public WorldWindow(World world) {
        super("3D Graphics.");
        this.world = world;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
        this.panel = new JPanel();
        this.console = new JTextArea();
        this.console.setColumns(80);
        this.panel.add(console);
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                //This is where you want to implement your key!
                if (e.getKeyCode() == GameKeys.KEY_FORWARD) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z + 2);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_BACK) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z - 2);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_LEFT) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x + 2,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_RIGHT) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x - 2,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_DOWN) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y + 2, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_UP) {
                    WorldWindow.this.world.cam.position = new Vector3D(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y - 2, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_RESET) {
                    WorldWindow.this.world.cam.position = new Vector3D(0, 0, -50);
                    WorldWindow.this.repaint();
                }

            }
        });
        setVisible(true);
    }
    public void paint(Graphics g2) {
        //super.paintComponents(g2);
        Graphics2D g3 = (Graphics2D) g2;
        //System.out.print("paint");
        BufferedImage graphics = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = graphics.createGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(10, 10, 800, 800);

        //g.fillOval(this.world.cam.position.x, this.world.cam.position.y, 10, 10);
        g.setColor(new Color(0, 255, 0));
        ArrayList<ArrayList<Vertex>> renderedObjects = this.world.cam.Render();
        System.out.println("rendered vertices length: " + renderedObjects.size());
        this.console.setText("rendered vertices length: " + renderedObjects.size() + "\n");
        for (ArrayList<Vertex> renderedObject : renderedObjects) {
            for (Vertex vertex : renderedObject) {
                System.out.print("for vertex in rendered object vertices loop: \n");
                System.out.println("vertex x position: " + String.valueOf(vertex.position.x + 400) + ", vertex y position: " + String.valueOf(vertex.position.y + 400));
                g.setStroke(new BasicStroke(3));
                System.out.println("drawing line here");
                //g.drawRect(400, 400, 10, 10);
                if (vertex.isRendered) {
                    try {

//                    g.drawLine(vertex.position.Centralize(800, 800).x, vertex.position.Centralize(800, 800).y,
//                            vertex.renderedConnection.position.Centralize(800, 800).x, vertex.renderedConnection.position.Centralize(800, 800).y);
                        for (Vertex connection : vertex.vertices) {
                            //g.drawLine(vertex.Render.position.x, vertex.Render.position.y,
                            //        connection.Render.position.x, connection.Render.position.y);
                            System.out.println(connection.Render.position.x);
                            //g.drawRect(20, 20, 80, 80);

                        }
                            //System.out.println(vertex.position.Centralize(800, 800).y);
                    } catch (NullPointerException exception) {
                        System.out.println("NullPointerException here");
                    }
                    /*vertex.renderedConnection.position.x, vertex.renderedConnection.position.y); */
                }
            }
            g.drawString("X: " + String.valueOf(this.world.cam.position.x), 400, 50);
            g.drawString("Y: " + String.valueOf(this.world.cam.position.y), 400, 60);
            g.drawString("Z: " + String.valueOf(this.world.cam.position.z), 400, 70);
        }
        g3.drawImage(graphics.getScaledInstance(800, 800, 0), 0, 0, this);
        //g3.draw
    }

}
