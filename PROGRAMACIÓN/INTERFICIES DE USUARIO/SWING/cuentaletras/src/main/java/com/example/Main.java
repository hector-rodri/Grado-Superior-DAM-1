package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame ventana = new JFrame("CONTADOR DE LETRAS");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        ventana.add(panelPrincipal);

        JTextField introduce = new JTextField(30);
        panelPrincipal.add(introduce);

        JLabel contador = new JLabel("0");
        panelPrincipal.add(contador);
        
        introduce.addKeyListener(new KeyAdapter() {
            int veces = 0;
            @Override
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                if (letra == 'a' || letra == 'A') {
                    veces++;
                    contador.setText(String.valueOf(veces));
                }
            }
        });;

        ventana.setVisible(true);

    }
}