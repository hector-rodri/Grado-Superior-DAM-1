package com.example;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Random random = new Random();
        boolean quieresjugar = true;
        Scanner scanner = new Scanner(System.in);

        while (quieresjugar) {

            int numeroAleatorio = random.nextInt(100) + 1;
            
            int intento = 0;
            int contadorIntentos = 0;
            String sino = "n";

            System.out.println("Bienvenido, adivina el número que estoy pensando. Dime un número entre el 1 y 100.");

            while (intento != numeroAleatorio) {
                System.out.print("Introduce tu intento: ");
                intento = scanner.nextInt();
                contadorIntentos++;

                if (intento < numeroAleatorio) {
                    System.out.println("Demasiado bajo. Intenta otra vez.");
                } else if (intento > numeroAleatorio) {
                    System.out.println("Demasiado alto. Intenta otra vez.");
                } else {
                    System.out
                            .println("¡Felicidades! :) has adivinado el numero en " + contadorIntentos + " intentos.");
                    intento = numeroAleatorio;
                }
            }
            System.out.println("Juegas otra?");
            sino = scanner.next();
            if (sino == "n") {
                quieresjugar = false;
            }
        }
    }
}
