package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSwing extends JFrame {

    public FormularioSwing() {
        setTitle("Formulario con Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5)); // Filas x Columnas con espaciado

        // Etiquetas y Campos de Texto
        add(new JLabel("Nombre:"));
        JTextField txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Edad:"));
        JTextField txtEdad = new JTextField();
        add(txtEdad);

        // Radio Buttons (Género)
        add(new JLabel("Género:"));
        JPanel panelGenero = new JPanel();
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        JRadioButton rbFemenino = new JRadioButton("Femenino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);
        panelGenero.add(rbMasculino);
        panelGenero.add(rbFemenino);
        add(panelGenero);

        // ComboBox (Lista de países)
        add(new JLabel("País:"));
        String[] paises = {"México", "España", "Argentina", "Colombia", "Chile"};
        JComboBox<String> comboPais = new JComboBox<>(paises);
        add(comboPais);

        // Botón de Envío
        JButton btnEnviar = new JButton("Enviar");
        add(new JLabel()); // Espacio vacío
        add(btnEnviar);

        // Acción del Botón
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String edad = txtEdad.getText();
                String genero = rbMasculino.isSelected() ? "Masculino" : (rbFemenino.isSelected() ? "Femenino" : "No seleccionado");
                String pais = (String) comboPais.getSelectedItem();

                JOptionPane.showMessageDialog(null, "Nombre: " + nombre + 
                                                    "\nEdad: " + edad + 
                                                    "\nGénero: " + genero + 
                                                    "\nPaís: " + pais, 
                                                    "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioSwing();
    }
}
