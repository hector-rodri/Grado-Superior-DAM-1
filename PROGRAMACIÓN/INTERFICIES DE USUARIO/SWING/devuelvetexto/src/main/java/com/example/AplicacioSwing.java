package com.example;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 

public class AplicacioSwing {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Exemple Swing");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(300, 150); 

        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(3, 1)); 

        JTextField campText = new JTextField(15);
        panel.add(campText); 

        JLabel etiqueta = new JLabel("Aquí irà el text..."); 
        panel.add(etiqueta); 

        JButton boto = new JButton("Mostrar text"); 
        panel.add(boto); 

        boto.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText(campText.getText()); 
            }
        });

        finestra.add(panel); 
        finestra.setVisible(true); 
    }
}
