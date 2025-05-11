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

    private void escribirArchivo() throws IOException{//Método para escribir en el archivo
        FileOutputStream fileEscribir = null;//Creamos un FileOutputStream para escribir el archivo
        char caracter;//caracter para guardar el texto
        String nombreArchivo = archivoUsuario.getText();//Nombre del archivo
        String texto = escaparate.getText();//Texto que se va a escribir en el archivo
        Boolean masTexto = false;//Variable para saber si se va a añadir texto o no

        if (implementar.isSelected()){//Si el checkbox está seleccionado, se añade texto al archivo
            masTexto = true;
        }

        if (nombreArchivo.isEmpty() || texto.isEmpty()) {//Si el nombre del archivo o el texto están vacíos, se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor escribe un nombre de archivo y el texto que deseas escribir", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            fileEscribir = new FileOutputStream(nombreArchivo,masTexto);//Creamos un FileOutputStream para escribir el archivo
            for (int i = 0; i < texto.length(); i++) {//Recorremos el texto
                caracter = texto.charAt(i);//El caracter se guarda en una variable
                fileEscribir.write((byte)caracter);//Escribimos el caracter en el archivo
            }
        } catch (Exception e) {//Si hay un error al escribir el archivo, se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Error al escribir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }finally{
            fileEscribir.close();
        }
    }

    private void leerArchivo() throws IOException{//Método para leer el archivo
        FileInputStream file = null;//Creamos un FileInputStream para leer el archivo
        String nombreArchivo = archivoUsuario.getText();//Nombre del archivo
        String texto = "";//Guardamos un texto vacío que nos servirá para guardar el texto del archivo
        char caracter;//Caracter para guardar el texto

        if (nombreArchivo.isEmpty()) {//Si el nombre del archivo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor escribe un nombre de archivo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            file = new FileInputStream(nombreArchivo);//Creamos un FileInputStream para leer el archivo
            int tamano = file.available();//Guardamos el tamaño del archivo en una variable
            for (int i = 0; i < tamano; i++) {//Recorremos el archivo
                caracter = (char) file.read();//Leemos el caracter del archivo
                texto += caracter;//Guardamos el caracter en la variable texto
            }
            escaparate.setText(texto);//Escribimos el texto en el JTextArea
        } catch (IOException e) {//Si hay un error al leer el archivo, se muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}