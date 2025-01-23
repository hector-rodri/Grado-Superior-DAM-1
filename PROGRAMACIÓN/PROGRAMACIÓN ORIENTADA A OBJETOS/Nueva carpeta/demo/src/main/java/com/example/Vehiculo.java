package com.example;

public class Vehiculo {

    private boolean enMarcha;
    private double gas;
    private boolean luces;
    private int orientado;
    private String nombre;

    public Vehiculo() {
        this.enMarcha = false;
        this.gas = 0;
        this.luces = false;
        this.orientado = 0;

    }

    public void encenderVehiculo() {
        this.enMarcha = true;
        System.out.println("VEHICULO EN MARCHA");

    }

    public void apagarVehiculo() {
        this.enMarcha = false;
        System.out.println("VEHICULO APAGADO");

    }

    public void acelerar() {

        gas++;
        if (gas >= 200) {
            gas = 200;

        }

    }

    public void frenar() {
        gas--;
        if (gas <= 0) {
            gas = 0;
        }

    }

    public void encenderLuz() {
        if (!luces) {
            luces = true;
            System.out.println("LUZ ACTIVADA");
        } else {
            System.out.println("LUCES YA ACTIVADAS");

        }

    }

    public void apagarLuz() {
        if (luces) {
            luces = true;
            System.out.println("LUZ DESACTIVADA");
        } else {
            System.out.println("LUCES YA ACTIVADAS");

        }

    }

    public double getGas() {

        return gas;

    }

    public void setGAS(double GAS) {
        if (GAS <= 0) {
            GAS = 0;
        } else if (GAS > 200) {
            GAS = 200;
        }

        this.gas = GAS;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String NOMBRE) {
        this.nombre = NOMBRE;
    }

}
