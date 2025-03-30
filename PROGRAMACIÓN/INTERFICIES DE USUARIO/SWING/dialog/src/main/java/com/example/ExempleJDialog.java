package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExempleJDialog {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Creem el JFrame principal
        JFrame finestra = new JFrame("Exemple de JDialog");
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());

        // Botó per obrir el JDialog
        JButton botoObrir = new JButton("Obrir diàleg");
        finestra.add(botoObrir);

        // Afegim un listener per obrir el JDialog quan es premi
        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialog(finestra);
            }
        });

        // Fem visible la finestra principal
        finestra.setVisible(true);
    }

    // Mètode per crear i mostrar un JDialog
    private static void mostrarDialog(JFrame parent) {
        // Creem el diàleg modal (bloqueja la finestra principal fins que es tanqui)
        JDialog dialog = new JDialog(parent, "Missatge Important", true);
        dialog.setSize(300, 150);
        dialog.setLayout(new BorderLayout());

        // Afegim un missatge
        JLabel etiqueta = new JLabel("Això és un diàleg!", JLabel.CENTER);
        dialog.add(etiqueta, BorderLayout.CENTER);

        // Botó per tancar el diàleg
        JButton botoTancar = new JButton("D'acord");
        botoTancar.addActionListener(e -> dialog.dispose()); // Tanca el diàleg
        dialog.add(botoTancar, BorderLayout.SOUTH);

        // Fem visible el diàleg
        dialog.setLocationRelativeTo(parent); // Centra el diàleg respecte a la finestra principal
        dialog.setVisible(true);
    }
}
