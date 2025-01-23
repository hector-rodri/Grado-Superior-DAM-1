package com.example;

public class Main {
    public static void main(String[] args) {

        int[] numero = { 10, 20, 30, 40, 50, 2 };
        int valorMax = 0;
        double valorMin = 100000000;
        int suma = 0;
        int media = 0;
        int reves = 0;

        for (int i = 0; i < numero.length; i++) {
            System.out.println(numero[i]);
            if (numero[i] > valorMax) {
                valorMax = numero[i];
            } else if (numero[i] < valorMin) {
                valorMin = numero[i];

            }
            suma = suma + numero[i];
            media = suma / numero.length;

        }

        for (int i = numero.length - 1; i >= 0; i--) {
            reves = numero[i];
            System.out.print(reves + ",");
        }
        System.out.println("\nValor maximo " + valorMax);
        System.out.println("Valor minimo " + valorMin);
        System.out.println("Suma total " + suma);
        System.out.println("Media " + media);

    }
}
