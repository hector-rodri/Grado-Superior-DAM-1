package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class DibujoInteractivo extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
    private Ellipse2D.Double pelota;
    private Color colorPelota = Color.RED;
    private int dx = 0, dy = 0;
    private JButton botonColor;

    public DibujoInteractivo() {
        pelota = new Ellipse2D.Double(100, 100, 50, 50);

        setFocusable(true);  // Para que reciba eventos del teclado
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        botonColor = new JButton("Cambiar color");
        botonColor.addActionListener(this);
        this.add(botonColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(colorPelota);
        g2.fill(pelota);
    }

    // MouseListener
    public void mouseClicked(MouseEvent e) {
        pelota.setFrame(e.getX(), e.getY(), 50, 50);
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // MouseMotionListener
    public void mouseDragged(MouseEvent e) {
        pelota.setFrame(e.getX(), e.getY(), 50, 50);
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}

    // KeyListener
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT) dx = -5;
        if (tecla == KeyEvent.VK_RIGHT) dx = 5;
        if (tecla == KeyEvent.VK_UP) dy = -5;
        if (tecla == KeyEvent.VK_DOWN) dy = 5;

        pelota.x += dx;
        pelota.y += dy;
        dx = dy = 0;
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // ActionListener
    public void actionPerformed(ActionEvent e) {
        colorPelota = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        repaint();
    }

    // MAIN
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Dibujo Interactivo");
        DibujoInteractivo panel = new DibujoInteractivo();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
