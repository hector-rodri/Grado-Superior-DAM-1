package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class poong extends JPanel implements ActionListener {

    private int x = 50;
    private int y = 50;
    private int velocidadX = 2;
    private int velocidadY = 2;
    private Timer timer;

    public poong() {
        timer = new Timer(10, this);
        timer.start();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Poong");
        poong juego = new poong();
        ventana.add(juego);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (y < 0 || y > getHeight() - 20) {
            velocidadY = -velocidadY;
        }

        x += velocidadX;
        y += velocidadY;

        repaint();
    }
}