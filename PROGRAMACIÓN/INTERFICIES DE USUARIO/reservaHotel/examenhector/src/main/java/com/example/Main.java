//HÉCTOR RODRÍGUEZ LOZANO
//PROGRAMACIÓN

package com.example;//Nombre del paquete donde se encuentra el archivo

import java.awt.*;//Importamos las librerias necesarias, para interfaza gráfica, diseño, eventos y validaciones
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {//Clase principal
    public static void main(String[] args) {

        try {//Cambiamos el diseño de la interfaz gráfica
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {//En caso de error, se imprime un mensaje
            System.out.println("ERROR");
        }

        //VENTANA
        JFrame ventana = new JFrame("Reserves d'Hotel");//Creamos la ventana
        ventana.setSize(500, 400);//Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Indicamos que al cerrar la ventana, se cierre el programa

        //PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();//Creamos un panel principal
        panelPrincipal.setLayout(new GridLayout(7, 1));//Le damos un diseño GridLayout
        ventana.add(panelPrincipal);//Agregamos el panel a la ventana
        
        //NOM
        JPanel panelNom = new JPanel();//Panel para la fila nombre
        panelNom.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout
        panelPrincipal.add(panelNom);//Agregamos al panel principal

        JLabel nom = new JLabel("Nom:");//Etiqueta para indicar el nombre
        panelNom.add(nom);//Agregamos al panel 
        JTextField respuestaNom = new JTextField();//Campo de texto donde el usuario ingresa el nombre
        panelNom.add(respuestaNom);//Agregamos al panel 

        //DNI
        JPanel panelDni = new JPanel();//Panel para la fila DNI
        panelDni.setLayout(new GridLayout(1, 3));//Le damos un diseño GridLayout
        panelPrincipal.add(panelDni);//Agregamos al panel principal

        JLabel dni = new JLabel("DNI:");//Etiqueta para indicar el DNI
        panelDni.add(dni);//Agregamos al panel 
        JTextField respuestaDni = new JTextField();//Campo de texto donde el usuario ingresa el DNI
        panelDni.add(respuestaDni);//Agregamos al panel 

        JLabel okKo = new JLabel("-");//Etiqueta para indicar el si el dni es válido
        panelDni.add(okKo);//Agregamos al panel 

        respuestaDni.addKeyListener(new KeyAdapter() {//Añadimos un action listener al campo de texto para saber los digitos que se entran introduciendo
            @Override
            public void keyReleased(KeyEvent e){

                if (validarDNI(respuestaDni.getText()) == true) {//Si al añadir el cotenido que se va actualizando cada vez que se pone un nuevo digito, la función de validación del dni da TRUE el texto cambiará a OK
                    okKo.setText("OK");
                }else{
                    okKo.setText("KO");//Si el booleano devuelto es false, seguirá siendo KO
                }
            }
        });

        //FECHA
        JPanel panelData = new JPanel();//Panel para la fila feha
        panelData.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout
        panelPrincipal.add(panelData);//Agregamos al panel principal

        JLabel data = new JLabel("Data Ckeck in: (dd/MM/yyyy)");//Etiqueta para indicar la fecha
        panelData.add(data);//Agregamos al panel 
        JTextField respuestaData = new JTextField();//Campo de texto donde el usuario ingresa la fecha
        panelData.add(respuestaData);//Agregamos al panel 
        
        respuestaData.addFocusListener(new FocusAdapter() {//Le añadimos a respuestaData un listener para que cuando pierda el foco, actue
            @Override
            public void focusLost(FocusEvent e){
                esDataValida(respuestaData.getText());//Ejecutamos el método fecha válida con la fecha del usuario
                if (respuestaData.getText().trim().isEmpty()) {//Si el campo de texto está vacío al perder el foco aparece un optionpane
                    JOptionPane.showMessageDialog(ventana, "\u00a1Texto vacio!", "Advertencia", 2);
                }
                if(esDataValida(respuestaData.getText())==false){//Si el campo de texto está incorrecto al perder el foco aparece un optionpane
                    JOptionPane.showMessageDialog(ventana, "\u00a1La fecha no es correcta!", "Advertencia", 2);
                }
                

            }
        });

        //HOTEL
        JPanel paneHotel = new JPanel();//Panel para la fila hotel
        paneHotel.setLayout(new GridLayout(1, 2));//Le damos un diseño GridLayout
        panelPrincipal.add(paneHotel);//Agregamos al panel principal

        JLabel hotel = new JLabel("Hotel:");//Etiqueta para indicar el hotel
        paneHotel.add(hotel);//Agregamos al panel 
        String hoteles[] = { "Hotel Mar", "Hotel Illa", "Hotel Muntanya" };//Opciones de hotel
        JComboBox hotelBox = new JComboBox<>(hoteles); //Menú desplegable con los hoteles
        paneHotel.add(hotelBox);//Agregamos al panel 

        //SLIDER
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 7, 1);//Slider con valores
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);//Mostrar marcas en el slider
        slider.setPaintLabels(true);//Mostrar números en las marcas
        panelPrincipal.add(slider);//Agregamos al panel principal


        hotelBox.addActionListener(new ActionListener() {//Añadimos al menú de opciones un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { //Método que se ejecuta cuando el usuario hace click
                
                if (hotelBox.getSelectedItem() == "Hotel Mar") {//Si el hotel seleccionado es Mar cambia el valor máximo del slider
                    
                    slider.setMaximum(7);

                }
                if (hotelBox.getSelectedItem() == "Hotel Illa") {//Si el hotel seleccionado es Illa cambia el valor máximo del slider
                    
                    slider.setMaximum(15);

                }
                if (hotelBox.getSelectedItem() == "Hotel Muntanya") {//Si el hotel seleccionado es Muntanya cambia el valor máximo del slider
                    
                    slider.setMaximum(30);

                }

            }
        });

        slider.addChangeListener(new ChangeListener() {//Añadimos al slider un listener que cuando se seleccione el valor máximo salte un JOptionPane
            @Override
            public void stateChanged(ChangeEvent e) {
                if (slider.getValue() == slider.getMaximum()) {//Si el valor del slider es el máximo da un aviso
                    JOptionPane.showMessageDialog(ventana, "\u00a1Estada máxima a aquest hotel!", "Advertencia", 3);
                }
            }
        });

        //BOTÓN MOSTRAR
        JButton boton = new JButton("Guardar reserva");//Botón para mostrar la reserva
        panelPrincipal.add(boton);//Agregamos al panel principal

        JLabel reserva = new JLabel();//Información de la reserva
        panelPrincipal.add(reserva);//Agregamos al panel principal
        
        boton.addActionListener(new ActionListener() {//Añadimos al botón un Action Listener
            @Override
            public void actionPerformed(ActionEvent e) { //Método que se ejecuta cuando el usuario hace click
                String uno = respuestaNom.getText();//Obtener nombre
                String dos = respuestaDni.getText();//Obtener dni
                String tres = respuestaData.getText();//Obtener fecha
                String cuatro = String.valueOf(hotelBox.getSelectedItem());//Obtener el hotel
                String cinco = String.valueOf(slider.getValue());//Obtener el valor del slider
                reserva.setText(uno+", "+dos+", "+tres+", "+cuatro+", "+cinco);//Hacer un setter en JLabel para indicar los detalles de la reserva


            }
        });

        
        ventana.setVisible(true);//Ventana visible

    }

    public static boolean validarDNI(String dni) {//Método validación DNI
        // Verifica que el format sigui correcte (8 dígits + 1 lletra)
        return dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
                // Calcula la lletra esperada i la compara amb la lletra proporcionada
                "TRWAGMYFPDXBNJZSQVHLCKE"
                        .charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character.toUpperCase(dni.charAt(8));
    }


    public static boolean esDataValida(String dataString) {//Método validación fecha
        try {
            // Defineix el format esperat de la data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
            // Converteix la cadena de text en un objecte LocalDate
            LocalDate dataEntrada = LocalDate.parse(dataString, formatter);
    
            // Comprova si la data no és anterior a la data actual
            return !dataEntrada.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            // Captura l'excepció si la cadena no té el format correcte i retorna false
            return false;
        }
    }
}



