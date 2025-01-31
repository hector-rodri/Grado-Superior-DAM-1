package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Demo");
        finestra.setSize(500,300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());

        JPanel panellSuperior = new JPanel();
        panellSuperior.setLayout(new FlowLayout());
        panellSuperior.add(new JButton("BOTÓN 1:"));
        panellSuperior.add(new JButton("BOTÓN 2:"));
        panellSuperior.add(new JButton("BOTÓN 3:"));

        JPanel panellCentral = new JPanel();
        panellCentral.setLayout(new GridLayout(2,2));
        panellCentral.add(new JLabel("etiqueta 1:"));
        panellCentral.add(new JTextField("texto 1"));
        panellCentral.add(new JLabel("etiqueta 2:"));
        panellCentral.add(new JTextField("texto 2"));

        finestra.add(panellSuperior, BorderLayout.NORTH);
        finestra.add(panellCentral, BorderLayout.CENTER);

        finestra.setVisible(true);
    }
}