package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Exemple de JDialog");
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());

        JButton botoObrir = new JButton("Obrir diàleg");
        finestra.add(botoObrir);
        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialeg(finestra);
            }
        });

        finestra.setVisible(true);

    }

    private static void mostrarDialeg(JFrame parent) {
        JDialog dialeg = new JDialog(parent, "Diàleg", true);
        dialeg.setSize(300, 150);
        dialeg.setLayout(new BorderLayout());
        JLabel etiqueta = new JLabel("Aquest és un diàleg");
        dialeg.add(etiqueta, BorderLayout.CENTER);

        JButton botoTancar = new JButton("Tancar");
        botoTancar = new JButton("Tancar");
        botoTancar.addActionListener(e -> dialeg.dispose());
        dialeg.add(botoTancar, BorderLayout.SOUTH);

        dialeg.setLocationRelativeTo(parent);
        dialeg.setVisible(true);
    }
}
