//HÉCTOR RODRÍGUEZ LOZANO

package com.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvingut a la torrada de Sant Sebastià 2025.");
        Botifarro botifarro = new Botifarro("Sant Sebastià", "2025", true);
        Sobrassada sobrassada = new Sobrassada("Sant Sebastià", "2025");
        // Posar a la graella
        botifarro.posarCarnAGraella();
        sobrassada.posarCarnAGraella();
        // Esperar fins que tots dos estiguin fets
        boolean botifarroFet, sobrassadaFeta;
        do {
            System.out.println("Vaig a mirar si estan fets:");
            botifarroFet = botifarro.estaFet();
            sobrassadaFeta = sobrassada.estaFet();

            if (!botifarroFet || !sobrassadaFeta) {
                System.out.println("El botifarró està " + (botifarroFet ? "fet" : "cru") +
                        " i la sobrassada està " + (sobrassadaFeta ? "feta" : "crua") + ". He d’esperar.");
            }
        } while (!botifarroFet || !sobrassadaFeta);
        // Quan tots dos estan fets
        System.out.println("El botifarró està fet i la sobrassada està feta. Ja puc anar a sopar.");
        // Assaborir els aliments
        botifarro.assaborir();
        sobrassada.assaborir();
        // Final del programa
        System.out.println("Au, ja està tot fet! Visca Sant Sebastià!");
    }

    // Classe base Torrada
    static abstract class Torrada {
        private String festivitat; // Nom de la festivitat
        private String any; // Any de celebració

        // Constructor per inicialitzar els atributs
        public Torrada(String festivitat, String any) {
            this.festivitat = festivitat;
            this.any = any;
            System.out.println("S'ha creat una torrada per a la festivitat de " + festivitat + " l'any " + any + ".");
        }

        // Getter per obtenir la festivitat
        public String getFestivitat() {
            return festivitat;
        }

        // Setter per actualitzar la festivitat
        public void setFestivitat(String festivitat) {
            this.festivitat = festivitat;
        }

        // Getter per obtenir l'any
        public String getAny() {
            return any;
        }

        // Setter per actualitzar l'any
        public void setAny(String any) {
            this.any = any;
        }
    }

    // Subclasse Botifarro (herència de Torrada, implementa Graella i Menjar)
    static class Botifarro extends Torrada implements Graella, Menjar {
        private boolean coent; // Indica si el botifarró és coent

        // Constructor que inicialitza els atributs
        public Botifarro(String festivitat, String any, boolean coent) {
            super(festivitat, any);
            this.coent = coent;
            System.out.println("He comprat un botifarró.");
        }

        // Getter per saber si el botifarró és coent
        public boolean isCoent() {
            return coent;
        }

        // Setter per modificar si el botifarró és coent
        public void setCoent(boolean coent) {
            this.coent = coent;
        }

        // Implementació del mètode per posar el botifarró a la graella
        @Override
        public void posarCarnAGraella() {
            System.out.println("He posat el botifarró a la graella.");
        }

        // Implementació del mètode per llevar el botifarró de la graella
        @Override
        public void llevarCarnDeGraella() {
            System.out.println("He llevat el botifarró de la graella.");
        }

        // Implementació del mètode per comprovar si el botifarró està fet
        @Override
        public boolean estaFet() {
            Random random = new Random();
            // 70% de les vegades retorna false (no està fet)
            return random.nextInt(10) < 3;
        }

        // Implementació del mètode per assaborir el botifarró
        @Override
        public void assaborir() {
            System.out.println("Estic assaborint un botifarró i és " + (coent ? "coent." : "no coent."));
        }
    }

    // Subclasse Sobrassada (herència de Torrada, implementa Graella i Menjar)
    static class Sobrassada extends Torrada implements Graella, Menjar {

        // Constructor que inicialitza els atributs
        public Sobrassada(String festivitat, String any) {
            super(festivitat, any);
            System.out.println("He comprat una sobrassada.");
        }

        // Implementació del mètode per posar la sobrassada a la graella
        @Override
        public void posarCarnAGraella() {
            System.out.println("He posat la sobrassada a la graella.");
        }

        // Implementació del mètode per llevar la sobrassada de la graella
        @Override
        public void llevarCarnDeGraella() {
            System.out.println("He llevat la sobrassada de la graella.");
        }

        // Implementació del mètode per comprovar si la sobrassada està feta
        @Override
        public boolean estaFet() {
            Random random = new Random();
            // 50% de probabilitat de retornar true o false
            return random.nextBoolean();
        }

        // Implementació del mètode per assaborir la sobrassada
        @Override
        public void assaborir() {
            System.out.println("Estic assaborint la sobrassada.");
        }
    }

}
