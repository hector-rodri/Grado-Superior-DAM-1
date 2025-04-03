package com.example;

import javax.swing.*;
import java.awt.*;

public class Animacion extends JPanel {
    private int x = 0; // Posición inicial del círculo

    public Animacion() {
        Timer timer = new Timer(50, e -> { // Cada 50ms se ejecuta el código
            x += 5; // Mueve el círculo hacia la derecha
            if (x > getWidth()) x = 0; // Resetea la posición
            repaint(); // Vuelve a dibujar la pantalla
        });
        timer.start(); // Inicia la animación
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, 50, 30, 30); // Dibuja el círculo
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Animación con Timer");
        Animacion panel = new Animacion();
        ventana.add(panel);
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
