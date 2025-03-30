package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame ventana = new JFrame("CHECKBOX");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        ventana.add(panelPrincipal);

        JCheckBox box = new JCheckBox();
        panelPrincipal.add(box);

        JLabel mensaje =new JLabel("NO DAS TU CONSENTIMIENTO");
        panelPrincipal.add(mensaje);

        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mensaje.setText("HAS FIRMADO TU CONSETIMIENTO");
                } else {
                    mensaje.setText("NO DAS TU CONSENTIMIENTO");
                }
            }
        });

        ventana.setVisible(true);

    }
}