package es.cide.programacio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class FichaPelicula {
   public FichaPelicula() {
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Ficha de Pel\u00edcula");
      frame.setDefaultCloseOperation(3);
      frame.setSize(400, 400);
      JPanel panel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.fill = 2;
      JLabel tituloLabel = new JLabel("T\u00edtulo de la pel\u00edcula:");
      JTextField tituloField = new JTextField(20);
      JLabel generoLabel = new JLabel("G\u00e9nero:");
      String[] generos = new String[]{"Acci\u00f3n", "Comedia", "Drama", "Terror", "Ciencia Ficci\u00f3n"};
      JComboBox<String> generoBox = new JComboBox(generos);
      JLabel añoLabel = new JLabel("A\u00f1o de estreno:");
      JSlider añoSlider = new JSlider(1900, 2025, 2000);
      añoSlider.setMajorTickSpacing(25);
      añoSlider.setMinorTickSpacing(5);
      añoSlider.setPaintTicks(true);
      añoSlider.setPaintLabels(true);
      JLabel añoSeleccionadoLabel = new JLabel("2000");
      JButton mostrarButton = new JButton("Mostrar Ficha");
      JLabel resultadoLabel = new JLabel("Aqu\u00ed se mostrar\u00e1 la informaci\u00f3n.");
      JLabel vocalLabel = new JLabel("Selecciona una vocal:");
      String[] vocales = new String[]{"A", "E", "I", "O", "U"};
      JComboBox<String> vocalBox = new JComboBox(vocales);
      JButton contarVocalesButton = new JButton("Contar Vocales");
      JLabel resultadoVocalesLabel = new JLabel("N\u00famero de vocales: 0");
      añoSlider.addChangeListener((e) -> {
         añoSeleccionadoLabel.setText(String.valueOf(añoSlider.getValue()));
      });
      generoBox.addActionListener((e) -> {
         String generoSeleccionado = (String)generoBox.getSelectedItem();
         if ("Terror".equals(generoSeleccionado)) {
            JOptionPane.showMessageDialog(frame, "\u00a1Asustando al usuario! \ud83d\udc7b", "Advertencia", 2);
         }

      });
      mostrarButton.addActionListener((e) -> {
         String titulo = tituloField.getText();
         String genero = (String)generoBox.getSelectedItem();
         int año = añoSlider.getValue();
         resultadoLabel.setText("Pel\u00edcula: " + titulo + " | G\u00e9nero: " + genero + " | A\u00f1o: " + año);
      });
      contarVocalesButton.addActionListener((e) -> {
         String titulo = tituloField.getText().toLowerCase();
         String vocalSeleccionada = ((String)vocalBox.getSelectedItem()).toLowerCase();
         long count = titulo.chars().filter((ch) -> {
            return ch == vocalSeleccionada.charAt(0);
         }).count();
         resultadoVocalesLabel.setText("N\u00famero de vocales: " + count);
      });
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(tituloLabel, gbc);
      gbc.gridx = 1;
      panel.add(tituloField, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(generoLabel, gbc);
      gbc.gridx = 1;
      panel.add(generoBox, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel.add(añoLabel, gbc);
      gbc.gridx = 1;
      panel.add(añoSlider, gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      panel.add(new JLabel("A\u00f1o seleccionado:"), gbc);
      gbc.gridx = 1;
      panel.add(añoSeleccionadoLabel, gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      panel.add(mostrarButton, gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 2;
      panel.add(resultadoLabel, gbc);
      gbc.gridx = 0;
      gbc.gridy = 6;
      panel.add(vocalLabel, gbc);
      gbc.gridx = 1;
      panel.add(vocalBox, gbc);
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 2;
      panel.add(contarVocalesButton, gbc);
      gbc.gridx = 0;
      gbc.gridy = 8;
      gbc.gridwidth = 2;
      panel.add(resultadoVocalesLabel, gbc);
      frame.add(panel);
      frame.setVisible(true);
   }
}
