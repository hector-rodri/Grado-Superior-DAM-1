package com.example;

import java.util.Random;

abstract class Animal {
    protected String nom; 
    protected String tipus; 

    public Animal(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
    }

    public void mostrarInformacio() {
        System.out.println("Animal: " + nom + ", Tipus: " + tipus);
    }

    public String getTipus() {
        return tipus;
    }

    public abstract void emetreSo();
}

// Subclase Gos
class Gos extends Animal implements Terrestre {
    public Gos(String nom) {
        super(nom, "Terrestre");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + ": Bup bup.");
    }

    @Override
    public void caminar() {
        System.out.println(nom + ": Estic caminant!");
    }
}

// Subclase Àguila
class Àguila extends Animal implements Volador {
    public Àguila(String nom) {
        super(nom, "Volador");
    }

    @Override
    public void volar() {
        System.out.println(nom + ": Estic volant!");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + ": Screech!");
    }
}

// Subclase Peix
class Peix extends Animal implements Aquatic {
    public Peix(String nom) {
        super(nom, "Aquatic");
    }

    @Override
    public void nedar() {
        System.out.println(nom + ": Estic nedant!");
    }

    @Override
    public void emetreSo() {
        System.out.println(nom + ": Blub blub!");
    }
}

// Clase principal Zoologic
public class Zoologic {
    private static final int TAMANY_ZOOLOGIC = 10; // Tamaño del zoológico

    public static void main(String[] args) {
        Animal[] animals = new Animal[TAMANY_ZOOLOGIC];
        Random random = new Random();

        // Crear animales aleatorios y agregarlos al array
        for (int i = 0; i < TAMANY_ZOOLOGIC; i++) {
            int tipus = random.nextInt(3); // 0 = Gos, 1 = Àguila, 2 = Peix
            switch (tipus) {
                case 0:
                    animals[i] = new Gos("Gos " + (i + 1));
                    break;
                case 1:
                    animals[i] = new Àguila("Àguila " + (i + 1));
                    break;
                case 2:
                    animals[i] = new Peix("Peix " + (i + 1));
                    break;
            }
        }

        // Recorrer el array y hacer actuar a los animales
        for (int i = 0; i < TAMANY_ZOOLOGIC; i++) {
            Animal animal = animals[i];
            animal.mostrarInformacio();
            animal.emetreSo();

            // Determinar la acción basada en el tipo de animal
            switch (animal.getTipus()) {
                case "Volador":
                    ((Volador) animal).volar();
                    break;
                case "Aquatic":
                    ((Aquatic) animal).nedar();
                    break;
                case "Terrestre":
                    ((Terrestre) animal).caminar();
                    break;
                default:
                    System.out.println("Acció no definida per aquest tipus d'animal.");
            }

            System.out.println(); // Separador entre animales
        }
    }
}