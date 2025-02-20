package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame("MI VENTANA DE TRABAJO");
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        JPanel panelPrincipal  =new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        ventana.add(panelPrincipal);

        JLabel textoFinal = new JLabel("ESTO ES UNA PRUEBA");
        panelPrincipal.add(textoFinal);

        JTextField textoUsuario  =new JTextField();
        panelPrincipal.add(textoUsuario);

        JButton boton = new JButton("PULSAME");
        panelPrincipal.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                if (textoUsuario.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "\u00a1Texto vacio!", "Advertencia", 2);
                }
                textoFinal.setText(textoUsuario.getText());
            }
        });
        ventana.setVisible(true);

        
    }
}