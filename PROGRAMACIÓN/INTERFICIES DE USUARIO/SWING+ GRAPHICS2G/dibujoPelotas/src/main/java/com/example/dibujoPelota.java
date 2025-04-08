package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dibujoPelota extends JPanel implements ActionListener {

    private static final int MAX_PELOTAS = 10;
    private final pelota[] pelotas = new pelota[MAX_PELOTAS];
    private int numeroPelotas = 0;
    

    private final int DELAY = 10;
    private final Timer timer;

    public dibujoPelota() {
        setBackground(Color.WHITE);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void afegirPelota() {//Metodo para añadir pelotas
        if (numeroPelotas < MAX_PELOTAS) {//Compruebo si el array de pelotas no está lleno
            pelotas[numeroPelotas] = new pelota();//Creo una nueva pelota dentro del array
            
            pelotas[numeroPelotas].setX((int)(Math.random() * (getWidth() - 40)));//La pelota se añade en una posición aleatoria
            pelotas[numeroPelotas].setY((int)(Math.random() * (getHeight() - 40)));
            numeroPelotas++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {//Metodo para dibujar las pelotas
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < numeroPelotas; i++) {//Recorro el array de pelotas
            g2d.setColor(Color.BLUE);
            g2d.fillOval(pelotas[i].getX(), pelotas[i].getY(), pelotas[i].getRadi() * 2, pelotas[i].getRadi() * 2);//Dibujo la pelota
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numeroPelotas; i++) {
            pelota p = pelotas[i];

            
            if (p.getX() + 2 * p.getRadi() >= getWidth() || p.getX() <= 0) {//Compruebo si la pelota choca con el borde vertical
                p.setDX(-p.getDX());
            }
            if (p.getY() + 2 * p.getRadi() >= getHeight() || p.getY() <= 0) {//Compruebo si la pelota choca con el borde horizontal
                p.setDY(-p.getDY());
            }

            p.setX(p.getX() + p.getDX());
            p.setY(p.getY() + p.getDY());
        }

        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pilotes que reboten!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            dibujoPelota panel = new dibujoPelota();

            JButton botonAfegir = new JButton("Afegir Pilota");

            botonAfegir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.afegirPelota();
                }
            });

            JPanel controls = new JPanel();
            controls.add(botonAfegir);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(controls, BorderLayout.NORTH);
            frame.setVisible(true);
        });
    }
}
