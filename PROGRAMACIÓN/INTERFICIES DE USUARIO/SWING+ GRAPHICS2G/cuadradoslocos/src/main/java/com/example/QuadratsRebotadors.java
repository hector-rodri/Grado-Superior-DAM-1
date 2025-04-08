package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class Quadrat {
    int x, y, mida;
    int dx, dy;
    Color color;

    public Quadrat(int x, int y, int mida) {
        this.x = x;
        this.y = y;
        this.mida = mida;
        Random r = new Random();
        this.dx = r.nextInt(5) + 1;
        this.dy = r.nextInt(5) + 1;
        this.color = getColorRandom();
    }

    public void moure(int ample, int alt) {
        x += dx;
        y += dy;
        if (x <= 0 || x + mida >= ample) dx = -dx;
        if (y <= 0 || y + mida >= alt) dy = -dy;
    }

    public void canviarColor() {
        this.color = getColorRandom();
    }

    private Color getColorRandom() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, mida, mida);
    }

    public void dibuixar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, mida, mida);
    }
}

class PanellQuadrats extends JPanel implements ActionListener {
    ArrayList<Quadrat> quadrats = new ArrayList<>();
    Timer timer;

    public PanellQuadrats() {
        setBackground(Color.WHITE);
        timer = new Timer(20, this);
        timer.start();

        for (int i = 0; i < 8; i++) {
            quadrats.add(new Quadrat(new Random().nextInt(500), new Random().nextInt(300), 40));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Quadrat q : quadrats) {
            q.dibuixar(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Quadrat q : quadrats) {
            q.moure(getWidth(), getHeight());
        }

        // Comprovar col·lisions
        for (int i = 0; i < quadrats.size(); i++) {
            for (int j = i + 1; j < quadrats.size(); j++) {
                if (quadrats.get(i).getRectangle().intersects(quadrats.get(j).getRectangle())) {
                    quadrats.get(i).canviarColor();
                    quadrats.get(j).canviarColor();
                }
            }
        }

        repaint();
    }
}

public class QuadratsRebotadors {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🟥 Quadrats Bojos!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(new PanellQuadrats());
            frame.setVisible(true);
        });
    }
}
