package com.example;//El paquete donde se encuentra la clase

import javax.swing.*;//Importamos las librerias necesarias
import java.awt.*;
import java.awt.event.*;

public class poong extends JPanel implements ActionListener {

    private int x = 50;//Posicion inicial X de la bola
    private int y = 50;//Posicion inicial Y de la bola
    private int velocidadX = 2;//Velocidad de la bola en X
    private int velocidadY = 2;//Velocidad de la bola en Y
    private Timer timer;
    private int barraAncho = 20;//Ancho de las barras
    private int barraLargo = 100;//Largo de las barras
    private int puntuaciónIzquierda = 0;//Puntuación del jugador de la izquierda
    private int puntuacionDerecha = 0;//Puntuación del jugador de la derecha

    public poong() {//Constructor de la clase
        timer = new Timer(10, this);
        timer.start();
    }

    
    public static void main(String[] args) {// Método principal para iniciar la aplicación
        JFrame ventana = new JFrame("Poong");//Crear una nueva ventana
        poong juego = new poong(); 
        ventana.add(juego); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Configurar la operación de cierre
        ventana.setSize(800, 600);//Establecer el tamaño de la ventana
        ventana.setResizable(false);//Hacer que la ventana no sea ajustable por el usuario
        ventana.setLocationRelativeTo(null);//Centrar la ventana en la pantalla
        ventana.setVisible(true);//Hacer visible la ventana
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;//Convertir a Graphics2D para mejorar el dibujo
        //ELEMENTOS DEL JUEGO
        g2d.setColor(new Color(240, 51, 255));//Establecer el color
        g2d.fillOval(x, y, 40, 40);//Dibujar la bola
        g2d.fillRect(10, 230, barraAncho, barraLargo);//Dibujar la barra izquierda
        g2d.fillRect(755, 230, barraAncho, barraLargo);//Dibujar la barra derecha
        
        //PUNTUACIÓN
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));//
        g2d.drawString(String.valueOf(puntuaciónIzquierda), 350, 50);//La puntuación del jugador de la izquierda
        g2d.drawString(String.valueOf(puntuacionDerecha), 420, 50);//La puntuación del jugador de la derecha
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (x < 0) {//Si la bola toca el borde izquierdo
            puntuacionDerecha++;//Aumentar la puntuación del jugador de la derecha
            x = 400;//Reiniciar la posición de la bola
            y = 300;
        } else if (x > getWidth() - 20) {//Si la bola toca el borde derecho
            puntuaciónIzquierda++;
            x = 400;
            y = 300;
        }

        if (y < 0 || y > getHeight() - 20) {//Si la bola toca el borde superior o inferior
            velocidadY = -velocidadY;//Invertir la dirección
        }

        x += velocidadX;//Mover la bola
        y += velocidadY;

        repaint();//Volver a dibujar 
    }
}