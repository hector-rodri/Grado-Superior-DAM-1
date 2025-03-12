package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class POong extends JPanel implements ActionListener {
    private int width = 800, height = 600;
    private int ballX = width / 2, ballY = height / 2, ballSize = 20;
    private int ballSpeedX = 3, ballSpeedY = 3;
    private int paddleWidth = 10, paddleHeight = 100;
    private int leftPaddleY = height / 2 - paddleHeight / 2, rightPaddleY = leftPaddleY;
    private int paddleSpeed = 10;
    private int leftScore = 0, rightScore = 0;
    private Timer timer;
    
    public POong() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        timer = new Timer(10, this);
        timer.start();
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> leftPaddleY = Math.max(leftPaddleY - paddleSpeed, 0);
                    case KeyEvent.VK_S -> leftPaddleY = Math.min(leftPaddleY + paddleSpeed, height - paddleHeight);
                    case KeyEvent.VK_UP -> rightPaddleY = Math.max(rightPaddleY - paddleSpeed, 0);
                    case KeyEvent.VK_DOWN -> rightPaddleY = Math.min(rightPaddleY + paddleSpeed, height - paddleHeight);
                }
                repaint();
            }
        });
        setFocusable(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        
        if (ballY <= 0 || ballY >= height - ballSize) {
            ballSpeedY *= -1;
        }
        
        if (ballX <= paddleWidth && ballY >= leftPaddleY && ballY <= leftPaddleY + paddleHeight ||
            ballX >= width - paddleWidth - ballSize && ballY >= rightPaddleY && ballY <= rightPaddleY + paddleHeight) {
            ballSpeedX *= -1;
        }
        
        if (ballX < 0) { 
            rightScore++; resetBall(); 
        } else if (ballX > width) { 
            leftScore++; resetBall(); 
        }
        
        repaint();
    }
    
    private void resetBall() {
        ballX = width / 2;
        ballY = height / 2;
        ballSpeedX = (Math.random() > 0.5 ? 3 : -3);
        ballSpeedY = (Math.random() > 0.5 ? 3 : -3);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillOval(ballX, ballY, ballSize, ballSize);
        g2d.fillRect(0, leftPaddleY, paddleWidth, paddleHeight);
        g2d.fillRect(width - paddleWidth, rightPaddleY, paddleWidth, paddleHeight);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString(leftScore + " - " + rightScore, width / 2 - 30, 50);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("POOng");
        POong game = new POong();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
