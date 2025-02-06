//HÉCTOR RODRÍGUEZ LOZANO
//PROGRAMACIÓN

package com.example;//Nombre del paquete donde se encuentra el archivo

import javax.swing.*;//Importamos las librerias necesarias, para interfaza gráfica, diseño y eventos
import java.awt.*;
import java.awt.event.*;

public class Main {//Clase principal
    public static void main(String[] args) {

        try {//Cambiamos el diseño de la interfaz gráfica
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {//En caso de error, se imprime un mensaje
            System.out.println("ERROR");
        }

        //VENTANA
        JFrame ventana = new JFrame("CALCULADORA DE HECTOR");//Creamos la ventana
        ventana.setSize(500, 300);//Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Indicamos que al cerrar la ventana, se cierre el programa

        //PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();//Creamos un panel principal
        panelPrincipal.setLayout(new GridLayout(4, 1));//Le damos un diseño GridLayout de 4 filas y 1 columna
        ventana.add(panelPrincipal);//Agregamos el panel a la ventana

        //PANEL DE TEXTO
        JPanel panelTexto = new JPanel();//Creamos un panel para el texto
        panelTexto.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout de 1 fila y 2 columnas
        panelPrincipal.add(panelTexto);//Agregamos el panel de texto al panel principal

        JLabel texto1 = new JLabel("NUMERO 1:");// Creamos un texto
        panelTexto.add(texto1);//Agregamos el texto al panel de texto

        JLabel texto2 = new JLabel("NÚMERO 2:");// Creamos un texto
        panelTexto.add(texto2);//Agregamos el texto al panel de texto

        //PANEL DE NÚMEROS
        JPanel panelNumeros = new JPanel();//Creamos un panel para los números
        panelNumeros.setLayout(new GridLayout(1, 2));// Le damos un diseño GridLayout de 1 fila y 2 columnas
        panelPrincipal.add(panelNumeros);// Agregamos el panel de números al panel principal

        JTextField numero1 = new JTextField();// Creamos zonas de texto
        JTextField numero2 = new JTextField();
        panelNumeros.add(numero1);// Agregamos las zonas de texto al panel de números
        panelNumeros.add(numero2);

        //PANEL DE RESULTADO
        JPanel panelResultado = new JPanel();//Creamos un panel para el resultado
        panelResultado.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout de 1 fila y 2 columnas
        panelPrincipal.add(panelResultado);//Agregamos el panel de resultado al panel principal

        JLabel resultado = new JLabel("RESULTADO:   ");//Creamos un texto
        panelResultado.add(resultado);//Agregamos el texto al panel de resultado

        JLabel resultadoOperacion = new JLabel();//Creamos un texto
        panelResultado.add(resultadoOperacion);//Agregamos el texto al panel de resultado, en este se verá el resultado de la operación

        //PANEL DE BOTONES
        JPanel panelBotones = new JPanel();//Creamos un panel para los botones
        panelBotones.setLayout(new GridLayout(1, 4));//Le damos un diseño GridLayout de 1 fila y 4 columnas
        panelPrincipal.add(panelBotones);//Agregamos el panel de botones al panel principal

        JButton suma = new JButton("+");//Creamos botón de suma
        panelBotones.add(suma);//Agregamos el botón al panel de botones
        JButton resta = new JButton("-");//Creamos botón de resta
        panelBotones.add(resta);//Agregamos el botón al panel de botones
        JButton multiplicacion = new JButton("x");//Creamos botón de multiplicación
        panelBotones.add(multiplicacion);//Agregamos el botón al panel de botones
        JButton division = new JButton("÷");//Creamos botón de división
        panelBotones.add(division);//Agregamos el botón al panel de botones

        //EVENTOS

        suma.addActionListener(new ActionListener() {//Añadimos al botón suma un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { //Método que se ejecuta cuando el usuario hace clic en el botón de suma
                try {
                    double num1 = Double.parseDouble(numero1.getText());//Convertimos el texto a números
                    double num2 = Double.parseDouble(numero2.getText());
                    double suma = num1 + num2;//Operación
                    resultadoOperacion.setText(String.valueOf(suma));//Mostramos el resultado en la etiqueta
                } catch (Exception exception) {//Si ocurre algún error como por ejemplo el que en este caso esperamos, que el usuario introduzca en la etiqueta un valor no númerico, se ejecuta el cathc
                    resultadoOperacion.setText(String.valueOf("ERROR EXCEPTION"));//Set en la etiqueta que ha habido un error
                }

            }
        });

        resta.addActionListener(new ActionListener() {//Añadimos al botón resta un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) {//Método que se ejecuta cuando el usuario hace clic en el botón de resta
                try {
                    double num1 = Double.parseDouble(numero1.getText());//Convertimos el texto a números
                    double num2 = Double.parseDouble(numero2.getText());
                    double resta = num1 - num2;//Operación
                    resultadoOperacion.setText(String.valueOf(resta));//Mostramos el resultado en la etiqueta
                } catch (Exception exception) {//Si ocurre algún error como por ejemplo el que en este caso esperamos, que el usuario introduzca en la etiqueta un valor no númerico, se ejecuta el cathc
                    resultadoOperacion.setText(String.valueOf("ERROR EXCEPTION"));//Set en la etiqueta que ha habido un error
                }

            }
        });

        multiplicacion.addActionListener(new ActionListener() {//Añadimos al botón multiplica un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) {//Método que se ejecuta cuando el usuario hace clic en el botón de multiplicar
                try {
                    double num1 = Double.parseDouble(numero1.getText());//Convertimos el texto a números
                    double num2 = Double.parseDouble(numero2.getText());
                    double multiplicacion = num1 * num2;//Operación
                    resultadoOperacion.setText(String.valueOf(multiplicacion));//Mostramos el resultado en la etiqueta
                } catch (Exception exception) {//Si ocurre algún error como por ejemplo el que en este caso esperamos, que el usuario introduzca en la etiqueta un valor no númerico, se ejecuta el cathc
                    resultadoOperacion.setText(String.valueOf("ERROR EXCEPTION"));//Set en la etiqueta que ha habido un error
                }

            }
        });

        division.addActionListener(new ActionListener() {//Añadimos al botón divide un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) {//Método que se ejecuta cuando el usuario hace clic en el botón de dividir
                try {
                    double num1 = Double.parseDouble(numero1.getText());//Convertimos el texto a números
                    double num2 = Double.parseDouble(numero2.getText());
                    double division = num1 / num2;//Operación
                    if (num2 == 0) {//Si el número es intentado dividir entre 0, hace un set en la etiqueta de ERROR, antes de que explote
                        resultadoOperacion.setText("ERROR ");

                    } else {
                        resultadoOperacion.setText(String.valueOf(division));//Mostramos el resultado en la etiqueta
                    }
                } catch (Exception exception) {//Si ocurre algún error como por ejemplo el que en este caso esperamos, que el usuario introduzca en la etiqueta un valor no númerico, se ejecuta el cathc
                    resultadoOperacion.setText(String.valueOf("ERROR EXCEPTION"));//Set en la etiqueta que ha habido un error
                }

            }
        });

        ventana.setVisible(true);//Hacemos visible la ventana de la calculadora

    }
}