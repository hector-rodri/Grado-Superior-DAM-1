//HÉCTOR RODRIGUEZ LOZANO
package com.example;//Utilizamos el mismo package porque es la forma que tiene java de enlazar y permitir manipular los objetos que estan dentro de este package

public class Main {
    
    public static void mostrarEina(eina unaEina) {//Método estático para mostrar la información de una herramienta
        unaEina.utilitzar();//Recibe un objeto del tipo eina y llama a sus métodos para mostrar su información
        System.out.println("Eina: " +unaEina.getNom() + ", Pes: " + unaEina.getPes() + " kg, Material: "+unaEina.getMaterial());
    }

    public static void main(String[] args) {//Método principal
        System.out.println("Bon dia!! Aquestes són les meves einas!!");

        eina martell = new martell(2.5, "ferro");  //Creación de objetos de tipo eina, que heredan de eina sus métodos, en este caso creamos un martillo
        eina serra = new serra(3.25, "fusta");//Creación de objetos de tipo eina, que heredan de eina sus métodos, en este caso creamos un serra
        eina destornillador = new destornillador(0.87, "ferro");//Creación de objetos de tipo eina, que heredan de eina sus métodos, en este caso creamos un destornillador
        
        mostrarEina(martell); //Llamamos al método "mostrarEina" para mostrar la información de cada herramienta en este caso martell
        mostrarEina(destornillador); //Llamamos al método "mostrarEina" para mostrar la información de cada herramienta en este caso destornillador
        mostrarEina(serra);//Llamamos al método "mostrarEina" para mostrar la información de cada herramienta en este caso serra
        

    }

}
