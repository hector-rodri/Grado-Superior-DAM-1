package com.example;

import java.net.SocketTimeoutException;

public class Main {
    public static void main(String[] args) {

        int suma = 0;
        int media = 0;
        int[][] matriu = {
                { 3, 6, 3 },
                { 8, 0, 1 },
                { 7, 7, 3 }

        };
        int filasMatriu;
        filasMatriu = matriu.length;
        int columnasMatriu;
        int max = 0;
        int min = 1000;

        for (int i = 0; i < filasMatriu; i++) {

            columnasMatriu = matriu[i].length;

            for (int e = 0; e < columnasMatriu; e++) {
                System.out.println(matriu[i][e]);
                suma += matriu[i][e];

                media = suma / (filasMatriu * columnasMatriu);

                if (matriu[i][e] > max) {
                    max = matriu[i][e];

                }
                if (matriu[i][e] < min) {
                    min = matriu[i][e];

                }

            }

        }

        System.out.println("La suma es " + suma);
        System.out.println("La media es " + media);
        System.out.println("El valor máximo es " + max);
        System.out.println("El valor mínimo es " + min);

    }
}