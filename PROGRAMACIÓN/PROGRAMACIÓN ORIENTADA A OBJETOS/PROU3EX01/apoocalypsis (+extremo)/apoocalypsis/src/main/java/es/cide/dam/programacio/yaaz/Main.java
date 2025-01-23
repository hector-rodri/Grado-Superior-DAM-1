//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Paquete donde se encuentra el archivo Main.java

import java.util.Scanner;//Importamos el scanner porque vamos a necesitar que el usuario nos introduzca respuestas, en este caso enteros o strings.

public class Main {//Clase Main que es la clase principal del programa

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//Instanciamos el scanner con la abreviatura sc que nos servirá para referirnos al scanner y darle uso
        
        //MENSAJES PARA EL USUARIO
        System.out.println("Hola! Benvingut a aquest joc!");
        System.out.println("Vull ajustar el joc al teu gust. Respon aquestes preguntes:");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Quin vols que sigui el nom de la teva ciutat?");
        String nomCiutatUsuari = sc.nextLine();//Variable de tipo string que va asociada al string que escriba el usuario
        System.out.println("Quin vols que sigui el nom del teu supervivient?");
        String nomSupervivientUsuari = sc.nextLine();//Variable de tipo string que va asociada al string que escriba el usuario
        System.out.println("Quin vols que sigui el tamany de la teva ciutat?");
        int tamanyCiutatUsuario = sc.nextInt();//Variable de tipo entero que va asociada al entero que escriba el usuario
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        //INDICE DE LOS OBJETOS Y VARIABLES INSTANCIADOS
        novaCiutat ciutatApoo = new novaCiutat(nomCiutatUsuari, tamanyCiutatUsuario);//Ciudad creada con el nombre y tamaño introducido por el usuario.
        supervivient supervivient1 = new supervivient(nomSupervivientUsuari);//Superviviente creado con el nombre introducido por el usuario.

        //MENSAJES DE BIENVENIDA
        System.out.println("Benvingut a " + ciutatApoo.getNom());//Imprimimos el nombre de la ciudad.
        System.out.println(
                "El nostre protagonista " + supervivient1.getNom() + " es troba en un univers destruit i apocaliptic.");//Durante todo el código usaré el nomSupervivient para que se imprima el nombre del superviviente
        System.out.println(
                "El nostre heroi recorrera la ciutat, ubicació per ubicació per tal de lluitar per la seva vida.");
        
        //COMIENZA EL JUEGO
        for (int i = 0; i < tamanyCiutatUsuario; i++) { //Bucle que recorre la ciudad

            zombie zombieActual= ciutatApoo.posicioRuta(i);//Zombie actual que se encuentra en la posición i de la ciudad

            if (i==1 && supervivient1.getSalut() >= 0) {//Un print con un mensaje que aparecerá si el superviviente esta vivo y cuando este en la posición 1
                System.out.println("Després d'aquest primer combat "+supervivient1.getNom()+" es conscient del perill de "+ciutatApoo.getNom()+ " la ciutat catastròfica.");
            }
            if (i==10 && supervivient1.getSalut() >= 0) {//Un print con un mensaje que aparecerá si el superviviente esta vivo y cuando este en la poición 10
                System.out.println("El nostre supervivent després de molts combats y de recorre molt la ciutat, decideix descansar perquè arriba la nit.");
                System.out.println("Comença un nou dia amb moltes adversitats...");
            }
            if (zombieActual instanceof superZombie) {//Si el zombie actual es un superzombie
                System.out.println("El zombie es un superzombie! Es més fort que un zombie normal!");
                
            }else{//Si el zombie actual no es un superzombie
                System.out.println(supervivient1.getNom()+" ha trobat un zombie!");
            }

            lucha.luchar(supervivient1, zombieActual, ciutatApoo, i);//Lucha entre el superviviente y el zombie actual

    
            
        }

        if (supervivient1.getSalut() <= 0) {//Si la salud del superviviente es menor o igual a 0
            System.out.println(supervivient1.getNom()+ " ha mort :(");
            System.out.println("-----------------------------YOU DEAD-----------------------------");
            System.out.println("Gràcies per jugar!");
        }else{//Si la salud del superviviente es mayor a 0
            System.out.println("-----------------------------YOU WIN-----------------------------");
            System.out.println("FELICITATS! Has sobreviscut a l'apocalipsi!");
            System.out.println("El teu supervivent ha acabat amb tots els zombies de la ciutat!");
            System.out.println("Gràcies per jugar!");

        }

        sc.close();//Cerramos el scanner

    }

}

