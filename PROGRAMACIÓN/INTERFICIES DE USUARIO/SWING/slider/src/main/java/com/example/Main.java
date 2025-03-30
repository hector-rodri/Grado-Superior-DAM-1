package com.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame ventana = new JFrame("SLIDER");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        ventana.add(panelPrincipal);

        JPanel centrar = new JPanel();
        centrar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPrincipal.add(centrar);
        JLabel valorSlider = new JLabel("20");
        valorSlider.setFont(new Font("Arial", Font.BOLD, 24));
        centrar.add(valorSlider);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
        panelPrincipal.add(slider);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valorSlider.setText(String.valueOf(slider.getValue()));
            }
        });

        ventana.setVisible(true);

    }
}