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
        panelPrincipal.setLayout(new GridLayout(3,1));
        ventana.add(panelPrincipal);

        JTextField introduce = new JTextField(30);
        panelPrincipal.add(introduce);

        JPanel panelBotones = new JPanel();
        panelPrincipal.add(panelBotones);

        JButton boton = new JButton("CONTAR VOCALES");
        panelPrincipal.add(boton);

        JLabel letrasA= new JLabel("LETRA A: ");
        panelBotones.add(letrasA);
        
        JLabel letrasE = new JLabel("LETRA E: ");
        panelBotones.add(letrasE);

        JLabel letrasI = new JLabel("LETRA I: ");
        panelBotones.add(letrasI);

        JLabel letrasO = new JLabel("LETRA O: ");
        panelBotones.add(letrasO);

        JLabel letrasU = new JLabel("LETRA U: ");
        panelBotones.add(letrasU);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = introduce.getText();

                int contadorA = 0;
                int contadorE = 0;
                int contadorI = 0;
                int contadorO = 0;
                int contadorU = 0;
                
                for (int i = 0; i < texto.length(); i++) {
                    char letra = texto.charAt(i);

                    if (letra == 'a' || letra == 'A') {
                        contadorA++;
                    }
                    if (letra == 'e' || letra == 'E') {
                        contadorE++;
                    }
                    if (letra == 'i' || letra == 'I') {
                        contadorI++;
                    }
                    if (letra == 'o' || letra == 'O') {
                        contadorO++;
                    }
                    if (letra == 'u' || letra == 'U') {
                        contadorU++;
                    }

                }

                letrasA.setText("LETRA A: "+contadorA+" veces");
                letrasE.setText("LETRA E: "+contadorE+" veces");
                letrasI.setText("LETRA I: "+contadorI+" veces");
                letrasO.setText("LETRA O: "+contadorO+" veces");
                letrasU.setText("LETRA U: "+contadorU+" veces");
            }
        });

    

        ventana.setVisible(true);

    }
}