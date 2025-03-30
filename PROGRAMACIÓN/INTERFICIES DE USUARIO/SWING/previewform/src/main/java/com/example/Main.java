package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.add(new JTextField("Nombre:"));
        panel.add(new JTextArea("texto:"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GRAY);
        panel2.add(new JTextField("Género:"));
        panel2.add(new JCheckBox("hombre"));
        panel2.add(new JCheckBox("mujer"));
        panel2.add(new JCheckBox("otro"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GRAY);
        panel3.add(new JTextField("Edad:"));
        panel3.add(new JTextArea("texto:"));

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.GRAY);
        panel4.add(new JTextField("País"));
        String paises[] = { "España", "Italia", "Portugal", "Inglaterra", "Dinamarca" };
        JComboBox caja = new JComboBox<>(paises);
        panel4.add(caja);

        JPanel tocho = new JPanel();
        panel3.setBackground(Color.GRAY);
        tocho.setLayout(new GridLayout(0, 1));
        tocho.add(panel);
        tocho.add(panel2);
        tocho.add(panel3);
        tocho.add(panel4);
        ventana.add(tocho);

    }
}