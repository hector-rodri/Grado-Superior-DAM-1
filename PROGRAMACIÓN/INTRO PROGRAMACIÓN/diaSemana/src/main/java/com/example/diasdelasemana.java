package com.example;

import java.util.Scanner;

public class diasdelasemana {
    public static void main(String[] args) {
        System.out.println("Hola!!! Dame un número del 1 al 7.");
        Scanner sc = new Scanner(System.in);
        int dia;
        dia= sc.nextInt();
        System.out.println(dia);

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
            System.out.println("Martes");
            break;
            case 3:
            System.out.println("Miercoles");
            break;
            case 4:
            System.out.println("Jueves");
            break;
            case 5:
            System.out.println("Viernes");
            break;
            case 6:
            System.out.println("Sabado");
            break;
            case 7:
            System.out.println("Domingo");
            break;
            default:
            System.out.println("Esto no es un dia de la semana");
                break;
        }
        if (dia<5) {
            System.out.println("Este dia es entresemana.");
        } else 
        System.out.println("Este dia es del fin de semana.");
    }
}