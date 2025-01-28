//HÉCTOR RODRÍGUEZ LOZANO

package com.example;

import java.util.Random;

interface Graella {
    // Mètode per posar carn a la graella
    void posarCarnAGraella();

    // Mètode per llevar carn de la graella
    void llevarCarnDeGraella();

    // Mètode per verificar si el menjar està fet
    boolean estaFet();
}

// Interfície Menjar
interface Menjar {
    // Mètode per assaborir el menjar
    void assaborir();

    // Mètode que retorna si el menjar crema (50% probabilitat)
    default boolean crema() {
        Random random = new Random();
        return random.nextBoolean();
    }
}



