package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class Estrella {
    int x, y, dx, dy;
    final int mida = 10;
    ArrayList<Point> trajectoria = new ArrayList<>();

    public Estrella(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        dx = rand.nextInt(5) + 1;
        dy = rand.nextInt(5) + 1;
    }

    public void moure(int ample, int alt) {
        x += dx;
        y += dy;

        if (x <= 0 || x >= ample - mida) dx = -dx;
        if (y <= 0 || y >= alt - mida) dy = -dy;

        trajectoria.add(new Point(x, y));
        if (trajectoria.size() > 20) { // Limitem la llargària de la traça
            trajectoria.remove(0);
        }
    }

    public void dibuixar(Graphics2D g2) {
        // Dibuixar la traça
        for (int i = 1; i < trajectoria.size(); i++) {
            Point p1 = trajectoria.get(i - 1);
            Point p2 = trajectoria.get(i);
            g2.setColor(new Color(0, 0, 255, 100));
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // Dibuixar l'estrella
        g2.setColor(Color.YELLOW);
        g2.fillOval(x, y, mida, mida);
    }
}

class PanellEstrelles extends JPanel implements ActionListener {
    ArrayList<Estrella> estrelles = new ArrayList<>();
    Timer timer;

    public PanellEstrelles() {
        setBackground(Color.BLACK);
        timer = new Timer(20, this);
        timer.start();
    }

    public void afegirEstrella() {
        int x = new Random().nextInt(getWidth() - 10);
        int y = new Random().nextInt(getHeight() - 10);
        estrelles.add(new Estrella(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Estrella e : estrelles) {
            e.dibuixar(g2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Estrella estrella : estrelles) {
            estrella.moure(getWidth(), getHeight());
        }
        repaint();
    }
}

public class EstrellesRebotants {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Estrelles rebotants amb traça");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            PanellEstrelles panell = new PanellEstrelles();

            JButton boto = new JButton("Afegir Estrella");
            boto.addActionListener(e -> panell.afegirEstrella());

            frame.setLayout(new BorderLayout());
            frame.add(panell, BorderLayout.CENTER);
            frame.add(boto, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
