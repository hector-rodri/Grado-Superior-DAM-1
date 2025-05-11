package com.example;

import javax.swing.*;//Importamos las librerias necesarias, para interfaza gráfica, diseño y eventos
import java.awt.*;
import java.io.*;

public class editorDeArchivos extends JFrame {

    private JTextField archivoUsuario;
    private JTextArea escaparate;
    private JCheckBox implementar;

    public editorDeArchivos(){
        //LOOK AND FEEL
        try {//Cambiamos el diseño de la interfaz gráfica
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {//En caso de error, se imprime un mensaje
            System.out.println("ERROR");
        }
        //VENTANA
        JFrame ventana = new JFrame("EDITOR DE ARCHIVOS DE TEXTO");//Creamos la ventana
        ventana.setSize(600, 500);//Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Indicamos que al cerrar la ventana, se cierre el programa
        ventana.setLocationRelativeTo(null);//Colocamos la ventana en el centro de la pantalla
        ventana.setResizable(false);//No se puede cambiar el tamaño de la ventana
        //PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();//Creamos un panel principal
        panelPrincipal.setLayout(new BorderLayout());//Le damos un diseño BorderLayout
        ventana.add(panelPrincipal);
        //PANEL DE TEXTO
        JPanel panelTexto = new JPanel();//Creamos un panel para guardar el JLabel y el JTextField
        panelTexto.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout de 1 fila y 2 columnas
        panelPrincipal.add(panelTexto,BorderLayout.NORTH);//Agregamos el panel de texto al panel principal con direección norte
        JLabel texto1 = new JLabel("NOMBRE DEL ARCHIVO");//Creamos un JLabel
        panelTexto.add(texto1);
        archivoUsuario = new JTextField();//Creamos un JTextField donde el usuario escribirá el nombre del archivo
        panelTexto.add(archivoUsuario);
        //TEXTO 
        escaparate = new JTextArea();//Creamos un JTextArea donde se leera y escribirá el texto
        panelPrincipal.add(escaparate);
        //PANEL DE BOTONES Y CHECKBOX
        JPanel panelBotones = new JPanel();//Creamos un panel para los botones y el checkbox
        panelPrincipal.add(panelBotones,BorderLayout.SOUTH);//Agregamos el panel de botones al panel principal con dirección sur
        JButton leer = new JButton("LEER");//Creamos un botón para leer el archivo
        leer.addActionListener(e ->{//Agregamos un evento al botón para leer el archivo
            try {
                leerArchivo();
            } catch (IOException io) {
                io.printStackTrace();
            }
        });
        JButton escribir = new JButton("ESCRIBIR");//Creamos un botón para escribir el archivo
        escribir.addActionListener(e -> {//Agregamos un evento al botón para escribir el archivo
            try {
                escribirArchivo();
            } catch (IOException io) {
                io.printStackTrace();
            }
        });
        implementar = new JCheckBox("AÑADIR");//Creamos un checkbox para añadir texto al archivo
        panelBotones.add(leer);
        panelBotones.add(escribir);
        panelBotones.add(implementar);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new editorDeArchivos();//Creamos una nueva ventana de editor de archivos
    }

    private void escribirArchivo() throws IOException{
        FileOutputStream fileEscribir = null;
        char caracter;
        String nombreArchivo = archivoUsuario.getText();
        String texto = escaparate.getText();
        Boolean masTexto = false;

        if (implementar.isSelected()){
            masTexto = true;
        }

        if (nombreArchivo.isEmpty() || texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de archivo y contenido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            fileEscribir = new FileOutputStream(nombreArchivo,masTexto);
            for (int i = 0; i < texto.length(); i++) {
                caracter = texto.charAt(i);
                fileEscribir.write((byte)caracter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fileEscribir.close();
        }
    }

    private void leerArchivo() throws IOException{
        FileInputStream file = null;
        String nombreArchivo = archivoUsuario.getText();
        String texto = "";
        char caracter;

        try {
            file = new FileInputStream(nombreArchivo);
            int tamano = file.available();
            for (int i = 0; i < tamano; i++) {
                caracter = (char) file.read();
                texto += caracter;
            }
            escaparate.setText(texto);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}