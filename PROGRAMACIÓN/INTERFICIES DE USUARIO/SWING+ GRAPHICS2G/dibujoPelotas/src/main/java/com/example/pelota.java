package com.example;

public class pelota {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int radi;

    public pelota() {
        this.x = 50;
        this.y = 50;
        this.dx = 2;
        this.dy = 2;
        this.radi = 20;
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public int getRadi() {
        return radi;
    }

    public void setX(int valorX) {
        this.x = valorX;
    }

    public void setY(int valorY) {
        this.y = valorY;  
    }

    public void setDX(int valorDX) {
        this.dx = valorDX;  
    }

    public void setDY(int valorDY) {
        this.dy = valorDY;  
    }

    public void setRadi(int valorRadi) {
        this.radi = valorRadi;  
    }

    
}
