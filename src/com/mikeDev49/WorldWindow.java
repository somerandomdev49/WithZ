package com.mikeDev49;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
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
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z + 2);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_BACK) {
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z - 2);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_LEFT) {
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x + 2,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_RIGHT) {
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x - 2,
                            WorldWindow.this.world.cam.position.y, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_DOWN) {
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y + 2, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }
                if (e.getKeyCode() == GameKeys.KEY_UP) {
                    WorldWindow.this.world.cam.position = new Position(WorldWindow.this.world.cam.position.x,
                            WorldWindow.this.world.cam.position.y - 2, WorldWindow.this.world.cam.position.z);
                    WorldWindow.this.repaint();
                }

            }
        });
    }
    public void paint(Graphics g2) {
        //super.paintComponents(g2);
        Graphics2D g = (Graphics2D) g2;
        //System.out.print("paint");
        g.setColor(new Color(255, 90, 90));
        g.fillOval(this.world.cam.position.x, this.world.cam.position.y, 10, 10);
        g.setColor(new Color(0, 0, 0));
        ArrayList<ArrayList<Vertex>> renderedObjects = this.world.cam.Render();
        System.out.println("rendered vertices length: " + renderedObjects.size());
        this.console.setText("rendered vertices length: " + renderedObjects.size() + "\n");
        for (ArrayList<Vertex> renderedObject : renderedObjects) {
            for (Vertex vertex : renderedObject) {
                System.out.print("for rendered object loop: \n");
                this.console.setText("for rendered object loop: \n");
                System.out.println("vertex x position: " + vertex.position.x + ", vertex y position: " + vertex.position.y);
                this.console.setText("vertex x position: " + vertex.position.x + ", vertex y position: " + vertex.position.y+"\n");
                g.setStroke(new BasicStroke(5));
                try {
                    System.out.println("drawing line here");
                    this.console.setText("drawing line here \n");
                    g.drawLine(vertex.position.x, vertex.position.y,
                            vertex.renderedConnection.position.x, vertex.renderedConnection.position.y);
                } catch (NullPointerException exception) {
                    System.out.println("NullPointerException here");
                }
                /*vertex.renderedConnection.position.x, vertex.renderedConnection.position.y); */
            }
        }

    }
}
