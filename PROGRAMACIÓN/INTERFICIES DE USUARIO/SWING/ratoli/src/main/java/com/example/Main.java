package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        /* try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        } */

        JFrame ventana = new JFrame("MOUSEOVER");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        ventana.add(panelPrincipal);

        JLabel miTexto = new JLabel("Fuera");
        miTexto.setForeground(Color.darkGray);
        miTexto.setFont(new Font("Arial", Font.BOLD, 50));
        panelPrincipal.add(miTexto);

        miTexto.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                miTexto.setText("Dentro");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                miTexto.setText("Fuera");
            }
        });

        ventana.setVisible(true);

    }
}