//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Paquete de la clase
import java.util.Random;//Importación de la clase Random

public class armaDeFoc extends artefacte {//Clase hija de artefacte
    Random random  = new Random();//Creación de un objeto de la clase Random
    

    public armaDeFoc(){//Constructor de la clase
        super();//Llamada al constructor de la clase padre
        setValorArtefacte(random.nextDouble(0.9, 1.5));//Asignación de un valor al artefacto
        setNom("armaDeFoc");//Asignación de un nombre al artefacto
    
    }


    
}
