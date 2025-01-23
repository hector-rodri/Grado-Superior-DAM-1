//Nom: Héctor Rodríguez Lozano
//DATA: 10/10/2024
//EXERCICI: 1

package com.example;

import java.util.Scanner;//Importamos el scanner para que el usuario nos de la información que queremos.
public class tarea1{
    public static void main(String[] args) {
       
        System.out.println("Hola, dime un número entero y positivo");//Pides al usuario que introduzca un número
        Scanner sc = new Scanner(System.in);
        
        int numero;//Creamos una variable int ya que necesitamos un número.
        numero = sc.nextInt();//Asociamos la variable al scanner para que el usuario introduzca un número.
     
        for(int i=1; i<=numero; i++) { //Utilizamos for para crear un bucle el cual al introducir un número, nos cuente desde el 1 hasta el número introducido.
               if (i%2==0) { //Utilizamos if porque si se cumple la condición se realizará la tarea, en este caso si el número es par, es decir, divisible entre 2 y de resto 0.
            System.out.println(i+" número par");
        }else { //Else nos garantiza que si la condición de if no se cumple, nos realizará la tarea de decirnos que el número es impar.
            System.out.println(i+" número impar");

        } //Al introducir if y else dentro de for, nos contará desde el número 1 hasta el introducido, además diciendonos si cada número de la cuenta es par o impar.
        }
        System.out.println("Gracias por jugar señor.");


    }
}