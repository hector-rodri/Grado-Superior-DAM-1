package com.example;

import java.util.Scanner;

public class practica4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un número entero positivo");

        int numero;
        numero = sc.nextInt();

        int sumaNp = 0;
        int contadorNp = 0;

        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sumaNp += i;
                contadorNp++;
            }
        }
        if (numero <= 0) {
            System.out.println("El número no se puede utilizar ya que no es entero positivo.");
        } else {
            System.out.println("Suma de pares: " + sumaNp);
            System.out.println("Total: " + contadorNp);
        }

    }
}
