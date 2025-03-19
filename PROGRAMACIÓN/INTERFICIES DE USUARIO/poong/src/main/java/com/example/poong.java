package com.example;//El paquete donde se encuentra la clase

import javax.swing.*;//Importamos las librerias necesarias
import java.awt.*;
import java.awt.event.*;

public class poong extends JPanel implements ActionListener {

    private int x = 50;// Posicion inicial X de la bola
    private int y = 50;// Posicion inicial Y de la bola
    private int velocidadX = 2;// Velocidad de la bola en X
    private int velocidadY = 2;// Velocidad de la bola en Y
    private Timer timer;
    private int barraAncho = 20;// Ancho de las barras
    private int barraLargo = 100;// Largo de las barras
    private int barraIzquierdaY = 600 / 2 - barraLargo / 2;
    private int barraDerechaY = 600 / 2 - barraLargo / 2;
    private int velocidadPala = 10;// Velocidad de las barras
    private int puntuaciónIzquierda = 0;// Puntuación del jugador de la izquierda
    private int puntuacionDerecha = 0;// Puntuación del jugador de la derecha

    public poong() {// Constructor de la clase
        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> barraIzquierdaY = Math.max(barraIzquierdaY - velocidadPala, 0);
                    case KeyEvent.VK_S -> barraIzquierdaY = Math.min(barraIzquierdaY + velocidadPala, 600 - barraLargo);
                    case KeyEvent.VK_UP -> barraDerechaY = Math.max(barraDerechaY - velocidadPala, 0);
                    case KeyEvent.VK_DOWN -> barraDerechaY = Math.min(barraDerechaY + velocidadPala, 600 - barraLargo);
                }
                repaint();
            }
        });

        setFocusable(true);
    }

    public static void main(String[] args) {// Método principal para iniciar la aplicación
        JFrame ventana = new JFrame("Poong");// Crear una nueva ventana
        poong juego = new poong();
        ventana.add(juego);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configurar la operación de cierre
        ventana.setSize(800, 600);// Establecer el tamaño de la ventana
        ventana.setResizable(false);// Hacer que la ventana no sea ajustable por el usuario
        ventana.setLocationRelativeTo(null);// Centrar la ventana en la pantalla
        ventana.setVisible(true);// Hacer visible la ventana
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Convertir a Graphics2D para mejorar el dibujo

        // ELEMENTOS DEL JUEGO
        g2d.setColor(new Color(240, 51, 255)); // Establecer el color
        g2d.fillOval(x, y, 40, 40); // Dibujar la bola

        // Dibujar las barras utilizando las variables de posición
        g2d.fillRect(10, barraIzquierdaY, barraAncho, barraLargo); // Barra izquierda
        g2d.fillRect(755, barraDerechaY, barraAncho, barraLargo); // Barra derecha

        // PUNTUACIÓN
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString(String.valueOf(puntuaciónIzquierda), 350, 50); // Puntuación izquierda
        g2d.drawString(String.valueOf(puntuacionDerecha), 420, 50); // Puntuación derecha
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Verificar si la pelota toca el borde izquierdo
        if (x < 0) {
            puntuacionDerecha++; // Aumentar la puntuación del jugador de la derecha
            x = 400; // Reiniciar la posición de la pelota
            y = 300;
            velocidadX = 2; // Reiniciar la velocidad
            velocidadY = 2;
        }
        // Verificar si la pelota toca el borde derecho
        else if (x > getWidth() - 40) {
            puntuaciónIzquierda++;
            x = 400;
            y = 300;
            velocidadX = -2; // Reiniciar la velocidad
            velocidadY = 2;
        }

        // Verificar si la pelota toca el borde superior o inferior
        if (y < 0 || y > getHeight() - 40) {
            velocidadY = -velocidadY; // Invertir la dirección en Y
        }

        // Verificar colisión con la pala izquierda
        if (x <= 30 && y + 40 >= barraIzquierdaY && y <= barraIzquierdaY + barraLargo) {
            velocidadX = -velocidadX; // Invertir la dirección en X
            x = 30; // Ajustar la posición para evitar que se quede pegada
        }

        // Verificar colisión con la pala derecha
        if (x + 40 >= 755 && y + 40 >= barraDerechaY && y <= barraDerechaY + barraLargo) {
            velocidadX = -velocidadX; // Invertir la dirección en X
            x = 755 - 40; // Ajustar la posición para evitar que se quede pegada
        }

        // Mover la pelota
        x += velocidadX;
        y += velocidadY;

        repaint(); // Volver a dibujar
    }
}