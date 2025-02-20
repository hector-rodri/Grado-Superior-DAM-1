package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FichaVideojuego {
    public static void main(String[] args) {
        // VENTANA PRINCIPAL
        JFrame frame = new JFrame("Ficha de Videojuego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // TÍTULO DEL VIDEOJUEGO
        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField(20);

        // PLATAFORMA (ComboBox)
        JLabel plataformaLabel = new JLabel("Plataforma:");
        String[] plataformas = {"PC", "PlayStation", "Xbox", "Nintendo Switch", "Móvil"};
        JComboBox<String> plataformaBox = new JComboBox<>(plataformas);

        // GÉNERO (ComboBox)
        JLabel generoLabel = new JLabel("Género:");
        String[] generos = {"Acción", "Aventura", "RPG", "Shooter", "Deportes"};
        JComboBox<String> generoBox = new JComboBox<>(generos);

        // AÑO DE LANZAMIENTO (Slider)
        JLabel añoLabel = new JLabel("Año de lanzamiento:");
        JSlider añoSlider = new JSlider(1980, 2025, 2000);
        añoSlider.setMajorTickSpacing(10);
        añoSlider.setMinorTickSpacing(5);
        añoSlider.setPaintTicks(true);
        añoSlider.setPaintLabels(true);
        JLabel añoSeleccionadoLabel = new JLabel("2000");

        // ACTUALIZAR AÑO SELECCIONADO
        añoSlider.addChangeListener(e -> añoSeleccionadoLabel.setText(String.valueOf(añoSlider.getValue())));

        // CALIFICACIÓN POR EDAD (Radio Buttons)
        JLabel calificacionLabel = new JLabel("Calificación:");
        JRadioButton eButton = new JRadioButton("E (Todos)");
        JRadioButton tButton = new JRadioButton("T (Adolescentes)");
        JRadioButton mButton = new JRadioButton("M (Adultos)");
        ButtonGroup grupoCalificacion = new ButtonGroup();
        grupoCalificacion.add(eButton);
        grupoCalificacion.add(tButton);
        grupoCalificacion.add(mButton);
        JPanel panelCalificacion = new JPanel();
        panelCalificacion.add(eButton);
        panelCalificacion.add(tButton);
        panelCalificacion.add(mButton);

        // CARACTERÍSTICAS ADICIONALES (CheckBoxes)
        JLabel caracteristicasLabel = new JLabel("Características:");
        JCheckBox multiplayerCheck = new JCheckBox("Multijugador");
        JCheckBox vrCheck = new JCheckBox("Soporte VR");
        JCheckBox dlcCheck = new JCheckBox("DLCs disponibles");
        JPanel panelCaracteristicas = new JPanel();
        panelCaracteristicas.add(multiplayerCheck);
        panelCaracteristicas.add(vrCheck);
        panelCaracteristicas.add(dlcCheck);

        // BOTÓN PARA MOSTRAR FICHA
        JButton mostrarButton = new JButton("Mostrar Ficha");
        JLabel resultadoLabel = new JLabel("Aquí se mostrará la información.");

        // ACCIÓN DEL BOTÓN MOSTRAR
        mostrarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String plataforma = (String) plataformaBox.getSelectedItem();
            String genero = (String) generoBox.getSelectedItem();
            int año = añoSlider.getValue();
            String calificacion = eButton.isSelected() ? "E" :
                                  tButton.isSelected() ? "T" :
                                  mButton.isSelected() ? "M" : "No seleccionada";

            StringBuilder caracteristicas = new StringBuilder();
            if (multiplayerCheck.isSelected()) caracteristicas.append("Multijugador, ");
            if (vrCheck.isSelected()) caracteristicas.append("VR, ");
            if (dlcCheck.isSelected()) caracteristicas.append("DLCs, ");
            if (caracteristicas.length() > 0) {
                caracteristicas.setLength(caracteristicas.length() - 2);
            } else {
                caracteristicas.append("Ninguna");
            }

            resultadoLabel.setText("<html>Videojuego: " + titulo +
                    "<br>Plataforma: " + plataforma +
                    "<br>Género: " + genero +
                    "<br>Año: " + año +
                    "<br>Calificación: " + calificacion +
                    "<br>Características: " + caracteristicas + "</html>");
        });

        // SELECCIONAR UNA VOCAL PARA CONTAR EN EL TÍTULO
        JLabel vocalLabel = new JLabel("Selecciona una vocal:");
        String[] vocales = {"A", "E", "I", "O", "U"};
        JComboBox<String> vocalBox = new JComboBox<>(vocales);
        JButton contarVocalesButton = new JButton("Contar Vocales");
        JLabel resultadoVocalesLabel = new JLabel("Número de vocales: 0");

        // ACCIÓN DEL BOTÓN CONTAR VOCALES
        contarVocalesButton.addActionListener(e -> {
            String titulo = tituloField.getText().toLowerCase();
            String vocalSeleccionada = ((String) vocalBox.getSelectedItem()).toLowerCase();
            long count = titulo.chars().filter(ch -> ch == vocalSeleccionada.charAt(0)).count();
            resultadoVocalesLabel.setText("Número de vocales: " + count);
        });

        // COLOCAR COMPONENTES EN LA VENTANA (GridBagLayout)
        gbc.gridx = 0; gbc.gridy = 0; frame.add(tituloLabel, gbc);
        gbc.gridx = 1; frame.add(tituloField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; frame.add(plataformaLabel, gbc);
        gbc.gridx = 1; frame.add(plataformaBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2; frame.add(generoLabel, gbc);
        gbc.gridx = 1; frame.add(generoBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3; frame.add(añoLabel, gbc);
        gbc.gridx = 1; frame.add(añoSlider, gbc);
        gbc.gridx = 2; frame.add(añoSeleccionadoLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 4; frame.add(calificacionLabel, gbc);
        gbc.gridx = 1; frame.add(panelCalificacion, gbc);

        gbc.gridx = 0; gbc.gridy = 5; frame.add(caracteristicasLabel, gbc);
        gbc.gridx = 1; frame.add(panelCaracteristicas, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; frame.add(mostrarButton, gbc);
        gbc.gridy = 7; frame.add(resultadoLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 1; frame.add(vocalLabel, gbc);
        gbc.gridx = 1; frame.add(vocalBox, gbc);

        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2; frame.add(contarVocalesButton, gbc);
        gbc.gridy = 10; frame.add(resultadoVocalesLabel, gbc);

        // HACER VISIBLE LA VENTANA
        frame.setVisible(true);
    }
}
