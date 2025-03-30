package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaSwing {
    private DefaultListModel<String> modeloLista;
    private JList<String> lista;

    public ListaSwing() {
        // Crear ventana
        JFrame frame = new JFrame("Lista de Elementos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new BorderLayout());

        // Panel superior para la entrada de texto y el botón "Agregar"
        JPanel panelSuperior = new JPanel();
        JTextField campoTexto = new JTextField(15);
        JButton btnAgregar = new JButton("Agregar");

        panelSuperior.add(campoTexto);
        panelSuperior.add(btnAgregar);

        // Modelo de la lista y JList
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(lista);

        // Botón para eliminar elementos seleccionados
        JButton btnEliminar = new JButton("Eliminar Seleccionado");

        // Acción para agregar elementos
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText().trim();
                if (!texto.isEmpty()) {
                    modeloLista.addElement(texto);
                    campoTexto.setText(""); // Limpiar campo de texto
                } else {
                    JOptionPane.showMessageDialog(frame, "Escribe algo antes de agregar.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Acción para eliminar elementos seleccionados
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lista.getSelectedIndex();
                if (selectedIndex != -1) {
                    modeloLista.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecciona un elemento para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Agregar componentes a la ventana
        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(btnEliminar, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListaSwing::new);
    }
}
