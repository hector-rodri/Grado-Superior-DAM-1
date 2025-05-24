package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class palindromo extends JFrame {

    private JTextField inputField;
    private JTextArea palindromosArea;
    private JTextArea noPalindromosArea;
    private JButton verificarBtn;

    public palindromo() {
        // LOOK AND FEEL
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        setTitle("PALÍNDROMOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 250));

        // PANEL SUPERIOR
        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSuperior.setBackground(new Color(230, 230, 250));

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        verificarBtn = new JButton("Verificar");
        verificarBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        verificarBtn.setBackground(new Color(100, 149, 237));
        verificarBtn.setForeground(Color.WHITE);
        verificarBtn.setFocusPainted(false);

        JLabel textoIntroduce = new JLabel("Introduce una frase: ");
        textoIntroduce.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panelSuperior.add(textoIntroduce, BorderLayout.WEST);
        panelSuperior.add(inputField, BorderLayout.CENTER);
        panelSuperior.add(verificarBtn, BorderLayout.EAST);

        // PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(new Color(245, 245, 250));

        JLabel palindromoTexto = new JLabel("PALÍNDROMO");
        palindromoTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        palindromoTexto.setHorizontalAlignment(SwingConstants.CENTER);

        palindromosArea = new JTextArea();
        palindromosArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        palindromosArea.setEditable(false);
        palindromosArea.setBackground(new Color(235, 255, 235));
        palindromosArea.setBorder(BorderFactory.createLineBorder(new Color(144, 238, 144), 2));
        JScrollPane scrollPalindromos = new JScrollPane(palindromosArea);

        JLabel noPalindromoTexto = new JLabel("NO PALÍNDROMO");
        noPalindromoTexto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        noPalindromoTexto.setHorizontalAlignment(SwingConstants.CENTER);

        noPalindromosArea = new JTextArea();
        noPalindromosArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        noPalindromosArea.setEditable(false);
        noPalindromosArea.setBackground(new Color(255, 235, 235));
        noPalindromosArea.setBorder(BorderFactory.createLineBorder(new Color(255, 182, 193), 2));
        JScrollPane scrollNoPalindromos = new JScrollPane(noPalindromosArea);

        panelPrincipal.add(palindromoTexto);
        panelPrincipal.add(noPalindromoTexto);
        panelPrincipal.add(scrollPalindromos);
        panelPrincipal.add(scrollNoPalindromos);

        // AÑADIR PANELES
        add(panelSuperior, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);

        // BOTÓN VERIFICAR
        verificarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarFrase();
            }
        });
    }

    private void verificarFrase() {
        String frase = inputField.getText();
        if (frase.isEmpty())
            return;

        String procesada = frase.toLowerCase().replaceAll("[^a-záéíóúüñ0-9]", "");
        String invertida = new StringBuilder(procesada).reverse().toString();

        if (procesada.equals(invertida)) {
            palindromosArea.append(frase + "\n");
        } else {
            noPalindromosArea.append(frase + "\n");
        }

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new palindromo().setVisible(true);
        });
    }
}
