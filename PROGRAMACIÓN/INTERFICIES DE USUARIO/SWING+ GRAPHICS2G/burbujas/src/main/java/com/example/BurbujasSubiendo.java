package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Bombolla {
    int x, y, mida;
    int velocitat;
    Color color;

    public Bombolla(int x, int y) {
        Random r = new Random();
        this.x = x;
        this.y = y;
        this.mida = r.nextInt(20) + 10;
        this.velocitat = r.nextInt(2) + 1;
        int rColor = r.nextInt(256);
        int gColor = r.nextInt(256);
        int bColor = r.nextInt(256);
        this.color = new Color(rColor, gColor, bColor, 100); // Color amb transparència
    }

    public void pujar() {
        y -= velocitat;
    }

    public boolean haSortit() {
        return y + mida < 0;
    }

    public void dibuixar(Graphics2D g2) {
        g2.setColor(color);
        g2.fillOval(x, y, mida, mida);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.drawOval(x, y, mida, mida); // contorn suau
    }
}

class PanellBombolles extends JPanel implements ActionListener {
    ArrayList<Bombolla> bombolles = new ArrayList<>();
    Timer timer;

    public PanellBombolles() {
        setBackground(Color.BLACK);
        timer = new Timer(30, this);
        timer.start();
    }

    public void afegirBombolla() {
        int x = new Random().nextInt(getWidth() - 20);
        int y = getHeight();
        bombolles.add(new Bombolla(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Bombolla b : bombolles) {
            b.dibuixar(g2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Iterator<Bombolla> it = bombolles.iterator();
        while (it.hasNext()) {
            Bombolla b = it.next();
            b.pujar();
            if (b.haSortit()) {
                it.remove(); // Elimina la bombolla si surt per dalt
            }
        }
        repaint();
    }
}

public class BurbujasSubiendo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🎈 Bombolles que pugen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            PanellBombolles panell = new PanellBombolles();

            JButton boto = new JButton("Afegir Bombolla");
            boto.addActionListener(e -> panell.afegirBombolla());

            frame.setLayout(new BorderLayout());
            frame.add(panell, BorderLayout.CENTER);
            frame.add(boto, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
