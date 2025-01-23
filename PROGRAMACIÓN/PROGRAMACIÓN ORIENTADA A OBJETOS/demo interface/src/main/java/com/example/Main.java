package com.example;

interface interficieConduir {
    void conduir();

    int getVelocitatMaxima();

}

interface interficieHabitabilitat {
    void albergarPersonas(int numPersonas);

    int getCapacitat();

}

abstract class vehicle {
    protected String nom;

    public vehicle(String nom) {
        this.nom = nom;
    }

    public void descripcio() {
        System.out.println("Sóc un vehicle");
    }
}

class cotxe extends vehicle implements interficieConduir, interficieHabitabilitat {
    private int capacitat;

    public cotxe(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 4 ? capacitat : 4;
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint el cotxe");
    }

    @Override
    public int getVelocitatMaxima() {
        return 200;
    }

    @Override
    public void albergarPersonas(int numPersonas) {
        System.out.println("El cotxe alberga " + numPersonas + " persones");
    }

    @Override
    public int getCapacitat() {
        return capacitat;
    }
}

class moto extends vehicle implements interficieConduir, interficieHabitabilitat {
    private int capacitat;

    public moto(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 2 ? capacitat : 2;
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint mi moto BRUM BRUM BRUM"); 
    }

    @Override
    public int getVelocitatMaxima() {
        return 120;
    }

    @Override
    public void albergarPersonas(int numPersonas) {
        System.out.println("La moto alberga " + numPersonas + " persones");
    }

    @Override
    public int getCapacitat() {
        return capacitat;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        cotxe miCotxe = new cotxe("Seat", 5);
        miCotxe.descripcio();
        miCotxe.conduir();
        miCotxe.albergarPersonas(4);

        moto miMoto = new moto("Yamaha", 2);
        miMoto.descripcio();
        miMoto.conduir();
        miMoto.albergarPersonas(2);



    }
    
}

