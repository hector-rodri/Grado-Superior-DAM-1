package com.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        try {// Cambiamos el diseño de la interfaz gráfica
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {// En caso de error, se imprime un mensaje
            System.out.println("ERROR");
        }

        // VENTANA
        JFrame ventana = new JFrame("FICHA DE PELÍCULA");// Creamos la ventana
        ventana.setSize(400, 400);// Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Indicamos que al cerrar la ventana, se cierre el
                                                               // programa

        // PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();// Creamos un panel principal
        panelPrincipal.setLayout(new GridLayout(10, 1));// Le damos un diseño GridBagLayout de 4 filas y 1 columna
        ventana.add(panelPrincipal);// Agregamos el panel a la ventana
        // titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelTitulo);

        JLabel titulo = new JLabel("Título de la película:");
        panelTitulo.add(titulo);
        JTextField respuestaTitulo = new JTextField();
        panelTitulo.add(respuestaTitulo);

        // genero
        JPanel panelGenero = new JPanel();
        panelGenero.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelGenero);

        JLabel genero = new JLabel("Género:");
        panelGenero.add(genero);
        String generosPeliculas[] = { "Acción", "Comedia", "Drama", "Terror", "Ciencia ficción" };
        JComboBox generoBox = new JComboBox<>(generosPeliculas);
        panelGenero.add(generoBox);

        generoBox.addActionListener(generoBox);

        generoBox.addActionListener(new ActionListener() {// Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Método que se ejecuta cuando el usuario hace clic en el
                                                         // botón
                if (generoBox.getSelectedItem() == "Terror") {
                    JOptionPane panelTerror = new JOptionPane("CUIDADO LA PELICULA DA MUCHO MIEDO");
                    panelPrincipal.add(panelTerror);

                }

            }
        });

        // slider
        JPanel panelSlider = new JPanel();
        panelSlider.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelSlider);
        

        JLabel anoEstreno = new JLabel("Año de estreno:");
        panelSlider.add(anoEstreno);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1900, 2025, 2000);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panelSlider.add(slider);

        // valor slider
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelSeleccion);

        JLabel anoSeleccion = new JLabel("Año de estreno:");
        panelSeleccion.add(anoSeleccion);

        JLabel anoValor = new JLabel("2000");
        panelSeleccion.add(anoValor);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                anoValor.setText(String.valueOf(slider.getValue()));
            }
        });

        // boton mostrar info

        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new GridLayout(1, 1));
        panelPrincipal.add(panelBoton);

        JButton boton = new JButton("MOSTRAR FICHA");
        panelBoton.add(boton);

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelInfo);
        JLabel peliculaInfo = new JLabel("Película:");
        panelInfo.add(peliculaInfo);
        JLabel info = new JLabel();
        panelInfo.add(info);

        boton.addActionListener(new ActionListener() {// Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Método que se ejecuta cuando el usuario hace clic en el
                                                         // botón
                String uno = respuestaTitulo.getText();
                String dos = String.valueOf(generoBox.getSelectedItem());
                String tres = anoValor.getText();
                info.setText(uno + "|" + dos + "|" + tres);

            }
        });

        // vocal

        JPanel panelVocales = new JPanel();
        panelVocales.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelVocales);

        JLabel seleccionaVocal = new JLabel("Selecciona una vocal:");
        panelVocales.add(seleccionaVocal);

        String vocales[] = { "A", "E", "I", "O", "U" };
        JComboBox vocalesBox = new JComboBox<>(vocales);
        panelVocales.add(vocalesBox);

        // contador boton

        JButton botonContador = new JButton("CONTAR VOCALES");
        panelPrincipal.add(botonContador);

        // numero vocales

        JPanel panelResultadoVocales = new JPanel();
        panelResultadoVocales.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelResultadoVocales);

        JLabel resultadoVocales = new JLabel("Número de vocales:");
        panelResultadoVocales.add(resultadoVocales);

        JLabel total = new JLabel();
        panelResultadoVocales.add(total);

        botonContador.addActionListener(new ActionListener() {// Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Método que se ejecuta cuando el usuario hace clic en el
                                                         // botón

                String tituloFinal = respuestaTitulo.getText();
                String vocalSelect = String.valueOf(vocalesBox.getSelectedItem());
                char vocalFinal = vocalSelect.charAt(0);

                int contadorA = 0;
                int contadorE = 0;
                int contadorI = 0;
                int contadorO = 0;
                int contadorU = 0;

                for (int i = 0; i < tituloFinal.length(); i++) {
                    char letra = tituloFinal.charAt(i);

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

                if (vocalFinal == 'A') {
                    total.setText(String.valueOf(contadorA));
                }

                if (vocalFinal == 'E') {
                    total.setText(String.valueOf(contadorE));
                }

                if (vocalFinal == 'I') {
                    total.setText(String.valueOf(contadorI));
                }

                if (vocalFinal == 'O') {
                    total.setText(String.valueOf(contadorO));
                }

                if (vocalFinal == 'U') {
                    total.setText(String.valueOf(contadorU));
                }
            };

        });

        ventana.setVisible(true);

    }
}