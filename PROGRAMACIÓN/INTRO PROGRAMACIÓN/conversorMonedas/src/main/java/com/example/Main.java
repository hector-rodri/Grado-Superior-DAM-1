//Nom: Héctor Rodríguez Lozano
//DATA: 25/10/2024
//EXERCICI: PROU2EX03

package com.example;

import java.util.Scanner;//Importa la clase Scanner para recibir la respuesta del usuario

public class Main {
    //Utilizo constantes para las tasas de conversión de monedas
    // DÓLARES
    private static final double USD_EUR = 0.85;
    private static final double USD_MXN = 20;
    private static final double USD_GBP = 0.75;
    private static final double USD_JPY = 110.0;
    private static final double USD_DKK = 6.3;
    // PESOS MEXICANOS
    private static final double MXN_USD = 0.05;
    private static final double MXN_EUR = 0.042;
    private static final double MXN_GBP = 0.037;
    private static final double MXN_DKK = 0.32;
    private static final double MXN_JPY = 5.5;
    // EUROS
    private static final double EUR_GBP = 0.88;
    private static final double EUR_USD = 1.18;
    private static final double EUR_MXN = 23.50;
    private static final double EUR_JPY = 130.0;
    private static final double EUR_DKK = 7.45;

    // LIBRAS ESTERLINAS
    private static final double GBP_USD = 1.33;
    private static final double GBP_EUR = 1.14;
    private static final double GBP_MXN = 27.0;
    private static final double GBP_JPY = 150.0;
    private static final double GBP_DKK = 8.6;

    // YENES JAPONESES
    private static final double JPY_USD = 0.0091;
    private static final double JPY_EUR = 0.0077;
    private static final double JPY_MXN = 0.18;
    private static final double JPY_GBP = 0.0067;
    private static final double JPY_DKK = 0.057;

    // CORONAS DANESAS
    private static final double DKK_USD = 0.16;
    private static final double DKK_EUR = 0.13;
    private static final double DKK_MXN = 3.1;
    private static final double DKK_GBP = 0.12;
    private static final double DKK_JPY = 17.5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int respuesta = 0; //Creamos una variable para la respuesta seleccionada por el usuario, que es la conversión que quiere usar
        int opcion = 0; //Creamos una variable para controlar el ciclo del menú.
        int numero = 0;  //Creamos una variable para almacenar el valor del número que quiere convertir


        while (opcion <= 30) {//Bucle para mostrar el menú de opciones y si el número es mayor a 30 se sale del bucle

            System.out.println("\n■■■ MENÚ DE CONVERSIÓN DE MONEDAS ■■■");//Mostrar menú de conversión
            System.out.println("\nMENÚ DE OPCIONES:");
            System.out.println("Dólares a Euros = 1");
            System.out.println("Dólares a Pesos Mexicanos = 2");
            System.out.println("Dólares a Coronas Danesas = 3");
            System.out.println("Dólares a Libras Esterlinas = 4");
            System.out.println("Dólares a Yen Japonés = 5");
            System.out.println("Euros a Dólares = 6");
            System.out.println("Euros a Pesos Mexicanos = 7");
            System.out.println("Euros a Coronas Danesas = 8");
            System.out.println("Euros a Libras Esterlinas = 9 ");
            System.out.println("Euros a Yen Japonés = 10");
            System.out.println("Pesos Mexicanos a Dólares = 11");
            System.out.println("Pesos Mexicanos a Euros = 12");
            System.out.println("Pesos Mexicanos a  Coronas Danesas = 13");
            System.out.println("Pesos Mexicanos a Libras Esterlinas = 14");
            System.out.println("Pesos Mexicanos a Yenes Japoneses = 15");
            System.out.println("Coronas Danesas a Pesos Mexicanos = 16");
            System.out.println("Coronas Danesas a Euros = 17");
            System.out.println("Coronas Danesas a Dólares = 18");
            System.out.println("Coronas Danesas a Libras Esterlinas = 19");
            System.out.println("Coronas Danesas a Yen Japonés = 20");
            System.out.println("Libras Esterlinas a Pesos Mexicanos = 21");
            System.out.println("Libras Esterlinas a Euros = 22");
            System.out.println("Libras Esterlinas a Dólares = 23");
            System.out.println("Libras Esterlinas a Coronas Danesas = 24");
            System.out.println("Libras Esterlinas a Yen Japonés = 25");
            System.out.println("Yen Japonés a Pesos Mexicanos = 26 ");
            System.out.println("Yen Japonés a Euros = 27 ");
            System.out.println("Yen Japonés a Dólares = 28 ");
            System.out.println("Yen Japonés a Coronas Danesas = 29 ");
            System.out.println("Yen Japonés a Libras Esterlinas = 30 ");
            System.out.println("SALIR= 31 ");

            respuesta = sc.nextInt();

            switch (respuesta) {//Utilizamos un switch para manejar cada opción de conversión
                case 1:
                    System.out.print("Introduce el valor en Dólares: ");
                    numero = sc.nextInt();//Nos dice el valor que quiere convertir a la moneda de este caso
                    if (numero > 0) {//Ponemos un if para que la conversión que se realice sea siempre de un número mayor a 0 y que no sea negativo
                        System.out.println(numero + " USD son " + (numero * USD_EUR) + " EUR");//Imprimimos el número que queria convertir al convertido en la moneda que quiera el usuario (esto para cada caso)
                    } else {//Si el número no es válido, vuelve a introducir otro que sea válido
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 2:
                    System.out.print("Introduce el valor en Dólares: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " USD son " + (numero * USD_MXN) + " MXN");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 3:
                    System.out.print("Introduce el valor en Dólares: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " USD son " + (numero * USD_DKK) + " DKK");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 4:
                    System.out.print("Introduce el valor en Dólares: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " USD son " + (numero * USD_GBP) + " GBP");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 5:
                    System.out.print("Introduce el valor en Dólares: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " USD son " + (numero * USD_JPY) + " JPY");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 6:
                    System.out.print("Introduce el valor en Euros: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " EUR son " + (numero * EUR_USD) + " USD");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 7:
                    System.out.print("Introduce el valor en Euros: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " EUR son " + (numero * EUR_MXN) + " MXN");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 8:
                    System.out.print("Introduce el valor en Euros: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " EUR son " + (numero * EUR_DKK) + " DKK");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 9:
                    System.out.print("Introduce el valor en Euros: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " EUR son " + (numero * EUR_GBP) + " GBP");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 10:
                    System.out.print("Introduce el valor en Euros: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " EUR son " + (numero * EUR_JPY) + " JPY");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 11:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " MXN son " + (numero * MXN_USD) + " USD");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 12:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " MXN son " + (numero * MXN_EUR) + " EUR");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 13:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " MXN son " + (numero * MXN_DKK) + " DKK");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 14:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " MXN son " + (numero * MXN_GBP) + " GBP");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 15:
                    System.out.print("Introduce el valor en Pesos Mexicanos: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " MXN son " + (numero * MXN_JPY) + " JPY");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 16:
                    System.out.print("Introduce el valor en Coronas Danesas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " DKK son " + (numero * DKK_MXN) + " MXN");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 17:
                    System.out.print("Introduce el valor en Coronas Danesas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " DKK son " + (numero * DKK_EUR) + " EUR");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 18:
                    System.out.print("Introduce el valor en Coronas Danesas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " DKK son " + (numero * DKK_USD) + " USD");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 19:
                    System.out.print("Introduce el valor en Coronas Danesas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " DKK son " + (numero * DKK_GBP) + " GBP");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 20:
                    System.out.print("Introduce el valor en Coronas Danesas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " DKK son " + (numero * DKK_JPY) + " JPY");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 21:
                    System.out.print("Introduce el valor en Libras Esterlinas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " GBP son " + (numero * GBP_MXN) + " MXN");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 22:
                    System.out.print("Introduce el valor en Libras Esterlinas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " GBP son " + (numero * GBP_EUR) + " EUR");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 23:
                    System.out.print("Introduce el valor en Libras Esterlinas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " GBP son " + (numero * GBP_USD) + " USD");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 24:
                    System.out.print("Introduce el valor en Libras Esterlinas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " GBP son " + (numero * GBP_DKK) + " DKK");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 25:
                    System.out.print("Introduce el valor en Libras Esterlinas: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " GBP son " + (numero * GBP_JPY) + " JPY");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 26:
                    System.out.print("Introduce el valor en Yenes Japoneses: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " JPY son " + (numero * JPY_MXN) + " MXN");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 27:
                    System.out.print("Introduce el valor en Yenes Japoneses: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " JPY son " + (numero * JPY_EUR) + " EUR");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 28:
                    System.out.print("Introduce el valor en Yenes Japoneses: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " JPY son " + (numero * JPY_USD) + " USD");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 29:
                    System.out.print("Introduce el valor en Yenes Japoneses: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " JPY son " + (numero * JPY_DKK) + " DKK");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 30:
                    System.out.print("Introduce el valor en Yenes Japoneses: ");
                    numero = sc.nextInt();
                    if (numero > 0) {
                        System.out.println(numero + " JPY son " + (numero * JPY_GBP) + " GBP");
                    } else {
                        System.out.println("No válido, prueba de nuevo");
                    }

                    break;

                case 31:
                    System.out.println("HAS SALIDO DEL PROGRAMA");//Para salir del programa hacemos que opción valga mas de 30, porque hemos puesto que la condición sea que sea menor o igual a 30.
                    opcion = 33;

                    break;

                default:
                    System.out.println("La opción no és valida, has salido del programa :(");//Cuando escriba un número que no pertenece saldrá del programa
                    opcion=33;
                    break; 
            }

        }

    }
}
