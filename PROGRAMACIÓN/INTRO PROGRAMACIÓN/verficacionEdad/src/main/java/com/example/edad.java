package com.example;

import java.util.Scanner;

public class edad {

  static int anoActual = 2024;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce tu año de nacimiento");
    int anoNacimiento = sc.nextInt();

    int edad = anoActual - anoNacimiento;

    // Determinar si es mayor de edad
    if (edad >= 18) {
      System.out.println("Eres mayor de edad");
    }

    else if (anoNacimiento > 2024) {
      System.out.println("No existes");
    }

    else if (edad == 16) {
      System.out.println("Felices 16 años");
    }

    else {
      System.out.println("No eres mayor de edad.");
    }

  }

}
