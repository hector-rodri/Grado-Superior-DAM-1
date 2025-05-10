package com.example;

import javax.swing.*;//Importamos las librerias necesarias, para interfaza gráfica, diseño y eventos
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class editorDeArchivos extends JFrame {

    private JTextField inputUsuario;
    private JTextField escaparate;

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
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        //PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();//Creamos un panel principal
        panelPrincipal.setLayout(new BorderLayout());//Le damos un diseño GridLayout de 4 filas y 1 columna
        ventana.add(panelPrincipal);//Agregamos el panel a la ventana
        //PANEL DE TEXTO
        JPanel panelTexto = new JPanel();//Creamos un panel para el texto
        panelTexto.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout de 1 fila y 2 columnas
        panelPrincipal.add(panelTexto,BorderLayout.NORTH);//Agregamos el panel de texto al panel principal
        JLabel texto1 = new JLabel("NOMBRE DEL ARCHIVO");// Creamos un texto
        panelTexto.add(texto1);//Agregamos el texto al panel de texto
        inputUsuario = new JTextField();// Creamos zonas de texto
        panelTexto.add(inputUsuario);
        //TEXTO 
        escaparate = new JTextField();
        panelPrincipal.add(escaparate);
        //PANEL DE BOTONES Y CHECKBOX
        JPanel panelBotones = new JPanel();
        panelPrincipal.add(panelBotones,BorderLayout.SOUTH);
        JButton leer = new JButton("LEER");
        leer.addActionListener(e -> leerArchivo());
        JButton escribir = new JButton("ESCRIBIR");
        escribir.addActionListener(e -> {
            try {
                escribirArchivo();
            } catch (IOException io) {
                io.printStackTrace();
            }
        });
        
        JCheckBox implementar = new JCheckBox("AÑADIR");
        panelBotones.add(leer);
        panelBotones.add(escribir);
        panelBotones.add(implementar);
        ventana.setVisible(true);

    }

    public static void main(String[] args) {
        new editorDeArchivos();//Creamos una nueva ventana
        
    }

    private void escribirArchivo() throws IOException{
        FileOutputStream fileEscribir = null;
        char caracter;
        String nombreArchivo = inputUsuario.getText();
        String texto = escaparate.getText();
        try {
            fileEscribir = new FileOutputStream(nombreArchivo);
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

    private void leerArchivo() {
        JOptionPane.showMessageDialog(rootPane, "EN DESARROLLO...", "Advertencia", 2);  
    }  
}