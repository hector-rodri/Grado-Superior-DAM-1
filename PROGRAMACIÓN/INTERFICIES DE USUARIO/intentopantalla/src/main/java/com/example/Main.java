package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("CHAVRA Example");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0,1));
        ventana.add(panelPrincipal);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(0,3));
        panelSuperior.add(new Button("File"));
        panelSuperior.add(new Button("Options"));
        panelSuperior.add(new Button("Help"));
        panelPrincipal.add(panelSuperior);

        JPanel panelCentroAlto = new JPanel();
        panelCentroAlto.setLayout(new GridLayout(0,1));
        panelPrincipal.add(panelCentroAlto);

        JPanel panelCentroAltoOptions = new JPanel();
        panelCentroAltoOptions.setLayout(new GridLayout(0,3));
        panelCentroAltoOptions.add(new Button("Proxy"));
        panelCentroAltoOptions.add(new Button("Cookies"));
        panelCentroAltoOptions.add(new Button("Accounts"));
        panelCentroAlto.add(panelCentroAltoOptions);
        
        JPanel panelCentroAltoNewUser = new JPanel();
        panelCentroAltoNewUser.setLayout(new BorderLayout());
        panelCentroAltoNewUser.add(new JLabel("New User"), BorderLayout.WEST);
        panelCentroAlto.add(panelCentroAltoNewUser);

        JPanel panelCentroAltoRellenar = new JPanel();
        panelCentroAltoRellenar.setLayout(new BorderLayout());
        panelCentroAlto.add(panelCentroAltoRellenar);
        JPanel panelCentroAltoRellenarComplejo = new JPanel();
        panelCentroAltoRellenarComplejo.setLayout(new GridLayout(0,2));
        panelCentroAltoRellenarComplejo.add(new JLabel("Account name:"));
        panelCentroAltoRellenarComplejo.add(new JTextField("leonid"));
        panelCentroAltoRellenarComplejo.add(new JLabel("Full name:"));
        panelCentroAltoRellenarComplejo.add(new JTextField("Leonid Brezhnev"));
        panelCentroAltoRellenarComplejo.add(new JLabel("Password:"));
        panelCentroAltoRellenarComplejo.add(new JTextField("********"));
        panelCentroAltoRellenarComplejo.add(new JLabel("Repeat Password"));
        panelCentroAltoRellenarComplejo.add(new JTextField("********"));
        panelCentroAltoRellenarComplejo.add(new Button("Add"));
        panelCentroAltoRellenar.add(panelCentroAltoRellenarComplejo);

        JPanel panelCentroBajo = new JPanel();
        panelCentroBajo.setLayout(new GridLayout(0,1));
        panelPrincipal.add(panelCentroBajo);

        JPanel panelCentroBajoNewUser = new JPanel();
        panelCentroBajoNewUser.setLayout(new BorderLayout());
        panelCentroBajoNewUser.add(new JLabel("New User"), BorderLayout.WEST);
        panelCentroBajo.add(panelCentroBajoNewUser);

        JPanel panelCentroBajoDatos = new JPanel();
        panelCentroBajoDatos.setLayout(new BorderLayout());
        panelCentroBajo.add(panelCentroBajoDatos, BorderLayout.CENTER);
        

        
        ventana.setVisible(true);







    }
}