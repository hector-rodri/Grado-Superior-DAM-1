package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Triangle {
    double x, y;
    int mida = 30;
    Color color = Color.MAGENTA;

    public Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void seguir(int destX, int destY) {
        double velocitat = 0.05;
        x += (destX - x) * velocitat;
        y += (destY - y) * velocitat;
    }

    public void dibuixar(Graphics g) {
        int[] xs = {(int)x, (int)(x - mida / 2), (int)(x + mida / 2)};
        int[] ys = {(int)y, (int)(y + mida), (int)(y + mida)};
        g.setColor(color);
        g.fillPolygon(xs, ys, 3);
    }
}

class PanellTriangles extends JPanel implements MouseMotionListener, ActionListener {
    ArrayList<Triangle> triangles = new ArrayList<>();
    int mouseX = 300, mouseY = 200;
    Timer timer;

    public PanellTriangles() {
        setBackground(Color.WHITE);
        addMouseMotionListener(this);
        timer = new Timer(20, this);
        timer.start();

        for (int i = 0; i < 10; i++) {
            triangles.add(new Triangle(100 + i * 20, 100));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Triangle t : triangles) {
            t.dibuixar(g);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Triangle t : triangles) {
            t.seguir(mouseX, mouseY);
        }
        repaint();
    }

    @Override public void mouseDragged(MouseEvent e) {}
}

public class TrianglesPerseguidors {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🔺 Triangles perseguidors");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(new PanellTriangles());
            frame.setVisible(true);
        });
    }
}
