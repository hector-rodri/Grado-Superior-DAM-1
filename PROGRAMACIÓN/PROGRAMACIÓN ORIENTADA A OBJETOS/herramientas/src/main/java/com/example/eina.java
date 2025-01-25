//HÉCTOR RODRIGUEZ LOZANO
package com.example;//Utilizamos el mismo package porque es la forma que tiene java de enlazar y permitir manipular los objetos que estan dentro de este package

public class eina {//Clase eina
    //Atributos privados de la clase eina
    private double pes;//Peso de la herramienta
    private String material;//Material de la herramienta
    private String nom;//Nombre de la herramienta

    public eina(double pesIndicat, String materialIndicat) { //Constructor de la clase eina donde al crear el objeto podemos indicar ya el peso y el material de nuestra herramienta
        this.pes = pesIndicat;//El peso será el peso introducido al crear la eina
        this.material = materialIndicat;//El material será el material introducido al crear la eina
        this.nom = "";//No tiene nombre por defecto
    }

    public void setPes(double pesIndicat) { //Método para establecer el peso de la herramienta, void porque no devuelve nada
        this.pes = pesIndicat;
    }

    public double getPes() {//Método para obtener el peso de la herramienta, double porque nos tiene que devolver un double que es el peso
        return this.pes;
    }

    public void setMaterial(String materialIndicat) { //Método para establecer el material de la herramienta, void porque no devuelve nada
        this.material = materialIndicat;
    }

    public String getMaterial() {//Método para obtener el material de la herramienta, String porque nos tiene que devolver un String que es el material
        return this.material;
    }

    public void setNom(String nomIndicat){ //Método para establecer el nombre de la herramienta, void porque no devuelve nada
        this.nom= nomIndicat;
    }

    public String getNom(){//Método para obtener el nombre de la herramienta, String porque tiene que devolver un String que es el nombre
        return this.nom;
    }

    public void utilitzar(){//Método que hace un print de que la herramienta se está usando
        System.out.println("Utilitzant una eina genèrica.");
    }

}
