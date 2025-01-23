//Nom: Héctor Rodríguez Lozano
//DATA: 23/10/2024
//EXERCICI: PROU2EX02

package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Importo el scanner para que el usuario pueda darnos respuesta.

        int calculo = 0; //Declaro la variable calculo, en este caso int porque queremos que nos responda con un número para elegir la opción del menú.
        double r1 = 0;
        double r2 = 0;
        char respuesta;

    

        for (int i = 0; i <= 4; i++) {//Creo un bucle for del 0 hasta que sea igual o menor que 4 con contador, para que itere 5 veces.
            System.out.println("Menú de opciones");//El menú que muestra las diferentes operaciones.
            System.out.println("Sumar=1");
            System.out.println("Restar=2");
            System.out.println("Multiplicar=3");
            System.out.println("Dividir=4");
            System.out.println("Salir=5");
            System.out.println("Elige una opción:");
            calculo = sc.nextInt();//Para que la opción se refleeje en el scanner y nos de información para saber hacia que caso del switch ir (o ir al default).
            
            switch (calculo) { //Un switch que nos dirija a la opción escogida, en caso de suma, resta, salir...
                case 1:
                    System.out.println("Introduce el primer número:");//Creamos dos variables double una para que vaya asociada a la primera respuesta, otra que vaya asociada a la segunda y que se reflejen en el scanner.
                    r1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    r2 = sc.nextDouble();
                    double rf = r1 + r2;//Creamos una variable que sea la respuesta final, esta variable ira cambiando según el caso, en este caso es la suma de la r1 y la r2.
                    System.out.println("El resultado es: " + (rf));
                    break;
                case 2:
                    System.out.println("Introduce el primer número:");
                    r1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    r2 = sc.nextDouble();
                    rf = r1 - r2;
                    System.out.println("El resultado es: " + (rf));//Lo mismo que el caso 1 pero en este caso haciendo la operación de resta.
                    break;
                case 3:
                    System.out.println("Introduce el primer número:");
                    r1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    r2 = sc.nextDouble();
                    rf = r1 * r2;
                    System.out.println("El resultado es: " + (rf));//Lo mismo que el caso 1 pero en este caso haciendo la operación de multiplicación.
                    break;
                case 4:
                    System.out.println("Introduce el primer número:");
                    r1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    r2 = sc.nextDouble();
                    if (r2 == 0) {
                        System.out.println("ERROR, NO ES POSIBLE");
                        break;
                    }
                    rf = r1 / r2;
                    System.out.println("El resultado es: " + (rf));//Lo mismo que el caso 1 pero en este caso haciendo la operación de división. Pero además añadiendo un if para que si la respuesta dos es 0, no podamos dividir entre 0 y de Error.
                    break;
                case 5:
                    System.out.println("Has salido del programa");
                    i=5;
                    break;//En este caso el usuario al escoger la opción de salir así que hacemos que la variable i valga mas que 4, para que salga del bucle y cierre el programa.

                default:
                    System.out.println("Has elegido una opción que no está en el programa");
                    i=5;
                    break;//Esto significa que si el usuario elige una opción que no está dentro del menú, se salga del programa, conseguimos que salga poniendole un valor a la variable i superior a 4.
            } 
            if (calculo<=4) {
                System.out.println("¿Deseas realizar otra operación? (SI/NO)");//Se declara la variable char respuesta.
                respuesta=sc.next().charAt(0); //Fuera del switch pero dentro del for creamos un if, si la respuesta del menú es menor o igual a 4, nos permitirá realizar otra operación a cambio de una respuesta.

                if (respuesta=='N'|| respuesta=='n') {
                    System.out.println("Has salido del programa");
                    i=50; //Si elige la respuesta No, el programa se cierra. Conseguimos esto con el charAt(0) ya que el 0 recoge la primera letra de la respuesta y nuestra condición es que si coge 'N' o 'n' se cierre el programa.
                }
                
            }

        }

    }
}