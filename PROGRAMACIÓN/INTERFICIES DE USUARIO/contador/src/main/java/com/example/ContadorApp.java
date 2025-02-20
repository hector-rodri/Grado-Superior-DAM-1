package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApp {
    private int contador = 0; // Variable para almacenar el número

    public ContadorApp() {
        // Crear la ventana
        JFrame frame = new JFrame("Contador con Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());

        // Crear componentes
        JLabel contadorLabel = new JLabel("Contador: " + contador);
        JButton btnIncrementar = new JButton("Incrementar");
        JButton btnDecrementar = new JButton("Decrementar");
        JButton btnReset = new JButton("Restablecer");

        // Configurar layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        frame.add(contadorLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(btnIncrementar, gbc);

        gbc.gridx = 1;
        frame.add(btnDecrementar, gbc);

        gbc.gridx = 2;
        frame.add(btnReset, gbc);

        // Agregar ActionListeners a los botones
        btnIncrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                contadorLabel.setText("Contador: " + contador);
            }
        });

        btnDecrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador--;
                contadorLabel.setText("Contador: " + contador);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                contadorLabel.setText("Contador: " + contador);
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContadorApp::new);
    }
}
