package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Classe per a les pilotes que cauen
class PilotaQueCau {
    int x, y, mida, velocitat;

    public PilotaQueCau(int x, int mida, int velocitat) {
        this.x = x;
        this.y = 0;
        this.mida = mida;
        this.velocitat = velocitat;
    }

    public void moure() {
        y += velocitat;
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, mida, mida);
    }

    public boolean colisionaAmbJugador(Rectangle jugador) {
        Rectangle r = new Rectangle(x, y, mida, mida);
        return r.intersects(jugador);
    }

    public boolean haSortit(int alturaPanel) {
        return y > alturaPanel;
    }
}

// Panell principal del joc
class PanellJoc extends JPanel implements ActionListener, KeyListener {
    int jugadorX = 250;
    final int jugadorY = 350;
    final int ampladaJugador = 50;
    final int alturaJugador = 20;
    int velocitatJugador = 20;

    ArrayList<PilotaQueCau> pilotes = new ArrayList<>();
    Timer timer;
    boolean gameOver = false;

    public PanellJoc() {
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.WHITE);
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuixar jugador
        g.setColor(Color.BLUE);
        g.fillRect(jugadorX, jugadorY, ampladaJugador, alturaJugador);

        // Dibuixar pilotes
        for (PilotaQueCau p : pilotes) {
            p.dibuixar(g);
        }

        if (gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("GAME OVER", 200, 200);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        // Afegir pilotes aleatòriament
        if (new Random().nextInt(20) == 0) {
            int mida = new Random().nextInt(20) + 10;
            int x = new Random().nextInt(getWidth() - mida);
            int velocitat = new Random().nextInt(3) + 2;
            pilotes.add(new PilotaQueCau(x, mida, velocitat));
        }

        // Moure pilotes
        Iterator<PilotaQueCau> it = pilotes.iterator();
        while (it.hasNext()) {
            PilotaQueCau p = it.next();
            p.moure();
            if (p.colisionaAmbJugador(getRectangleJugador())) {
                gameOver = true;
                timer.stop();
            }
            if (p.haSortit(getHeight())) {
                it.remove();
            }
        }

        repaint();
    }

    private Rectangle getRectangleJugador() {
        return new Rectangle(jugadorX, jugadorY, ampladaJugador, alturaJugador);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) return;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jugadorX -= velocitatJugador;
            if (jugadorX < 0) jugadorX = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jugadorX += velocitatJugador;
            if (jugadorX > getWidth() - ampladaJugador)
                jugadorX = getWidth() - ampladaJugador;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}

public class JocEsquivarPilotes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🧍 Evita les pilotes!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            PanellJoc panell = new PanellJoc();
            frame.add(panell);

            frame.setVisible(true);
        });
    }
}
