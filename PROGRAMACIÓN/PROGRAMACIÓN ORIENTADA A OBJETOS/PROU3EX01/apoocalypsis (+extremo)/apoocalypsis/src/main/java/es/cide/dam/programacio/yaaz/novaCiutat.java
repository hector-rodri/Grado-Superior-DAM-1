//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Paquete de la clase

import java.util.Random;//Importación de la clase Random

public class novaCiutat extends ciutat {//Clase hija de ciutat

    private static final double PROBABILITAT_ARMA_FOC = 1;//Constante de tipo double
    private static final double PROBABILITAT_ARMA_ACER= 3;//Constante de tipo double
    private static final double PROBABILIAT_FARMACIOLA = 5;//Constante de tipo double
    private static final double PROBABILITAT_ESCUD= 10;//Constante de tipo double

    Random random = new Random();//Creación de un objeto de la clase Random

    private artefacte[] obrirEnCasDeEmergencia;//Array de artefactes

    public novaCiutat(String nom, int tamany) {//Constructor de la clase
        super(nom, tamany);//Llamada al constructor de la clase padre
        this.obrirEnCasDeEmergencia = new artefacte[tamany];//Creación de un array de artefactes
     

    }

    public void generadorArtefactos() {//Método para generar artefactos

        for (int i = 0; i < getTamany(); i++) {//Bucle para recorrer el array
            boolean conseguido = false;//Variable de tipo boolean

            if (PROBABILITAT_ARMA_FOC >= random.nextInt(100)+1 && !conseguido) {//Condición para comprobar si se ha conseguido un artefacto
                obrirEnCasDeEmergencia[i] = new armaDeFoc();//Creación de un objeto de la clase armaDeFoc
                conseguido = true;//Asignación de un valor a la variable

            } else if (PROBABILITAT_ARMA_ACER >= random.nextInt(100)+1) {//Condición para comprobar si se ha conseguido un artefacto
                obrirEnCasDeEmergencia[i] = new armaAcer();//Creación de un objeto de la clase armaAcer

            } else if (PROBABILIAT_FARMACIOLA >= random.nextInt(100)+1) {//Condición para comprobar si se ha conseguido un artefacto
                obrirEnCasDeEmergencia[i] = new farmaciola();//Creación de un objeto de la clase farmaciola

            } else if (PROBABILITAT_ESCUD >= random.nextInt(100)+1) {//Condición para comprobar si se ha conseguido un artefacto
                obrirEnCasDeEmergencia[i] = new escud();//Creación de un objeto de la clase escud

            }

        }

    }

    public artefacte posicioArtefacte(int posicioRuta) {//Método para obtener la posición de un artefacto
        return obrirEnCasDeEmergencia[posicioRuta];//Devolución de un artefacto

    }


}
