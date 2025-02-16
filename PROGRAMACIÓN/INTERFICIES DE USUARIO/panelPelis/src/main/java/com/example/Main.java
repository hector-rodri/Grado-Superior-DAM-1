package com.example;//Paquete donde se encuentra la clase

import javax.swing.*;//Importamos las clases necesarias para la interfaz gráfica, eventos y diseño
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        //LOOK AND FEEL
        try {//Cambiamos el diseño de la interfaz gráfica
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {//En caso de error, se imprime un mensaje
            System.out.println("ERROR");
        }

        //VENTANA
        JFrame ventana = new JFrame("FICHA DE PELÍCULA");//Creamos la ventana
        ventana.setSize(400, 400);//Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Indicamos que al cerrar la ventana, se cierre el programa

        //PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();// Creamos un panel principal
        panelPrincipal.setLayout(new GridLayout(10, 1));//Le damos un diseño GridLayout de 10 filas y 1 columna
        ventana.add(panelPrincipal);//Agregamos el panel a la ventana
        
        //SECCIÓN: TÍTULO DE LA PELÍCULA
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelTitulo);

        JLabel titulo = new JLabel("Título de la película:");//Etiqueta para indicar el título
        panelTitulo.add(titulo);
        JTextField respuestaTitulo = new JTextField();//Campo de texto donde el usuario ingresa el título
        panelTitulo.add(respuestaTitulo);

        //SECCIÓN: SELECCIÓN DE GÉNERO
        JPanel panelGenero = new JPanel();
        panelGenero.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelGenero);

        JLabel genero = new JLabel("Género:");//Etiqueta para indicar el género
        panelGenero.add(genero);
        String generosPeliculas[] = { "Acción", "Comedia", "Drama", "Terror", "Ciencia ficción" };//Opciones de géneros
        JComboBox generoBox = new JComboBox<>(generosPeliculas); //Menú desplegable con los géneros
        panelGenero.add(generoBox);

        //EVENTO: Mensaje de advertencia si el usuario elige "Terror"
        generoBox.addActionListener(new ActionListener() {//Añadimos al menú de opciones un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { //Método que se ejecuta cuando el usuario hace click
                if (generoBox.getSelectedItem() == "Terror") {//Si el género seleccionado es "Terror" salta un JOptionPane
                    JOptionPane.showMessageDialog(ventana, "\u00a1Asustando al usuario! \ud83d\udc7b", "Advertencia", 2);

                }

            }
        });

        //SECCIÓN: SLIDER PARA SELECCIONAR EL AÑO DE ESTRENO
        JPanel panelSlider = new JPanel();
        panelSlider.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelSlider);
        
        JLabel anoEstreno = new JLabel("Año de estreno:");//Etiqueta para el año de estreno
        panelSlider.add(anoEstreno);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1900, 2025, 2000);//Slider con valores
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);//Mostrar marcas en el slider
        slider.setPaintLabels(true);//Mostrar números en las marcas
        panelSlider.add(slider);

        //SECCIÓN: MUESTRA EL AÑO SELECCIONADO 
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelSeleccion);

        JLabel anoSeleccion = new JLabel("Año de estreno:");//Etiqueta que muestra el año de estreno seleccionado
        panelSeleccion.add(anoSeleccion);

        JLabel anoValor = new JLabel("2000"); //Etiqueta con el valor inicial del slider
        panelSeleccion.add(anoValor);

        //EVENTO: Actualizar el valor del año conforme se mueve el slider
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                anoValor.setText(String.valueOf(slider.getValue()));//Cambia el texto con el valor del slider
            }
        });

        //SECCIÓN: BOTÓN PARA MOSTRAR INFORMACIÓN DE LA PELÍCULA
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new GridLayout(1, 1));
        panelPrincipal.add(panelBoton);

        JButton boton = new JButton("MOSTRAR FICHA");//Botón para mostrar la ficha
        panelBoton.add(boton);

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelInfo);

        JLabel peliculaInfo = new JLabel("Película:");//Etiqueta película
        panelInfo.add(peliculaInfo);
        JLabel info = new JLabel("-----|-----|-----" );//Etiqueta para mostrar la información seleccionada
        panelInfo.add(info);

        //EVENTO: Mostrar la información de la película al presionar el botón
        boton.addActionListener(new ActionListener() {//Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { //Método que se ejecuta cuando el usuario hace click
                String uno = respuestaTitulo.getText();//Obtener título
                String dos = String.valueOf(generoBox.getSelectedItem());//Obtener género
                String tres = anoValor.getText();//Obtener año
                info.setText(uno + "|" + dos + "|" + tres);//Mostrar

            }
        });

        //SECCIÓN: ELEGIR LA VOCAL QUE SE VA A CONTAR
        JPanel panelVocales = new JPanel();
        panelVocales.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelVocales);

        JLabel seleccionaVocal = new JLabel("Selecciona una vocal:");//Etiqueta selecciona vocal
        panelVocales.add(seleccionaVocal);

        String vocales[] = { "A", "E", "I", "O", "U" };//Vocales
        JComboBox vocalesBox = new JComboBox<>(vocales);//Menú desplegable para escoger la vocal
        panelVocales.add(vocalesBox);

        //SECCIÓN: BOTÓN PARA CONTAR VOCALES DEL TÍTULO DE LA PELÍCULA
        JButton botonContador = new JButton("CONTAR VOCALES");//Botón para contar vocales
        panelPrincipal.add(botonContador);

        JPanel panelResultadoVocales = new JPanel();
        panelResultadoVocales.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(panelResultadoVocales);

        JLabel resultadoVocales = new JLabel("Número de vocales:");//Etiqueta 
        panelResultadoVocales.add(resultadoVocales);

        JLabel total = new JLabel();//Etiqueta resultado de vocales
        panelResultadoVocales.add(total);

        //EVENTO: Contar la vocal seleccionada del título de la película al hacer click en el botón
        botonContador.addActionListener(new ActionListener() {// Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Método que se ejecuta cuando el usuario hace click

                String tituloFinal = respuestaTitulo.getText();//Obtener título
                String vocalSelect = String.valueOf(vocalesBox.getSelectedItem());//Obtener vocal escogida para contar
                char vocalFinal = vocalSelect.charAt(0);//Vocal escogida pasada a char

                int contadorA = 0;//Contadores de vocales
                int contadorE = 0;
                int contadorI = 0;
                int contadorO = 0;
                int contadorU = 0;

                for (int i = 0; i < tituloFinal.length(); i++) {//Bucle que va recorriendo el título letra a letra
                    char letra = tituloFinal.charAt(i);

                    switch (Character.toLowerCase(letra)) {//Dependiendo de las vocales que haya en el título, va aumentando el contador de cada vocal
                        case 'a':
                            contadorA++;
                            break;
                        case 'e':
                            contadorE++;
                            break;
                        case 'i':
                            contadorI++;
                            break;
                        case 'o':
                            contadorO++;
                            break;
                        case 'u':
                            contadorU++;
                            break;
                    }
                    
                }

                switch (vocalFinal) {//Dependiendo de la vocal escogida se hace visible en el total(JLabel) el número de esa vocal que tiene el título
                    case 'A':
                         total.setText(String.valueOf(contadorA));
                        break;
                    
                    case 'E':
                        total.setText(String.valueOf(contadorE));
                        break;
                    
                    case 'I':
                        total.setText(String.valueOf(contadorI));
                        break;

                    case 'O':
                        total.setText(String.valueOf(contadorO));
                        break;

                    case 'U':
                        total.setText(String.valueOf(contadorU));
                        break;
                    default:
                        break;
                }
            };

        });

        ventana.setVisible(true);//Ventana visible

    }
}