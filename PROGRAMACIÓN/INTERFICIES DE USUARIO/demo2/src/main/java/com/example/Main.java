package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setSize(200,100);
        panel.setBackground(Color.RED);

        JButton button = new JButton("Click");
        panel.add(button);

        frame.add(panel);

        frame.setVisible(true);





    }
}