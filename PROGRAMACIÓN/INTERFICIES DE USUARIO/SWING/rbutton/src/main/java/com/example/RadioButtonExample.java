package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonExample {
    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("Ejemplo de JRadioButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Crear los JRadioButton
        JRadioButton opcion1 = new JRadioButton("Opción 1");
        JRadioButton opcion2 = new JRadioButton("Opción 2");
        JRadioButton opcion3 = new JRadioButton("Opción 3");

        // Agrupar los botones para que solo se pueda seleccionar uno
        ButtonGroup grupoOpciones = new ButtonGroup();
        grupoOpciones.add(opcion1);
        grupoOpciones.add(opcion2);
        grupoOpciones.add(opcion3);

        // Botón para mostrar selección
        JButton btnMostrar = new JButton("Mostrar Selección");

        // Etiqueta para mostrar el resultado
        JLabel resultadoLabel = new JLabel("Selecciona una opción.");

        // Acción del botón
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = "Ninguna opción seleccionada.";
                if (opcion1.isSelected()) {
                    seleccion = "Has seleccionado: Opción 1";
                } else if (opcion2.isSelected()) {
                    seleccion = "Has seleccionado: Opción 2";
                } else if (opcion3.isSelected()) {
                    seleccion = "Has seleccionado: Opción 3";
                }
                resultadoLabel.setText(seleccion);
            }
        });

        // Agregar componentes a la ventana
        frame.add(opcion1);
        frame.add(opcion2);
        frame.add(opcion3);
        frame.add(btnMostrar);
        frame.add(resultadoLabel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
