//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Utilizamos el mismo package porque es la forma que tiene java de enlazar y permitir manipular los objetos que estan dentro de este package

import java.util.Scanner;//Importamos el scanner porque vamos a necesitar que el usuario nos introduzca respuestas, en este caso enteros o strings.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Instanciamos el scanner con la abreviatura sc que nos servirá para referirnos al scanner y darle uso

        //Este proyecto consiste en crear un superviviente que recorre una ciudad y va acabando con los zombies
        
        System.out.println("HOLA! BENVINGUT A AQUEST JOC.");//Estos son unos prints introductorios para el usuario, donde este deberá introducirnos un entero o una cadena
        System.out.println("ABANS DE COMENÇAR OMPLE AIXÒ:");
        System.out.println("QUIN VOLS QUE SIGUI EL NOM DE LA CIUTAT?");
        String nomCiutatUsuari = sc.nextLine();//Variable de tipo string que va asociada al string que escriba el usuario
        System.out.println("QUIN VOLS QUE SIGUI EL NOM DEL SUPERVIVENT?");
        String nomSupervivientUsuari = sc.nextLine();//Variable de tipo string que va asociada al string que escriba el usuario
        System.out.println("QUIN TAMANY VOLS QUE TENGUI LA CIUTAT? (10 o 20 aconsejable)");
        int tamanyCiutatUsuario = sc.nextInt();//Variable de tipo entero que va asociada al entero que escriba el usuario

        System.out.println(
                "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        //INDICE DE LOS OBJETOS Y VARIABLES INSTANCIADOS
        ciutat ciutat1 = new ciutat(nomCiutatUsuari, tamanyCiutatUsuario);//Ciudad creada con el nombre y tamaño introducido por el usuario.
        supervivient supervivient1 = new supervivient(nomSupervivientUsuari);//Superviviente creado con el nombre introducido por el usuario.
        zombie zombie1 = new zombie();//Zombie creado.
        String nomCiutat = ciutat1.getNom();//Método para saber el nombre de la ciudad.
        String nomSupervivient = supervivient1.getNom();//Método para saber el nombre del superviviente.
        int salutSupervivient = supervivient1.getSalut();//Método para saber la salud del superviviente.
        int salutZombie = zombie1.getSalut();//Método para saber la salud del zombie.
        int atacaSupervivient = supervivient1.ataca();//Método para atacar y saber el valor del ataque realizado por el superviviente.
        int defensaZombie = zombie1.defensat();//Método para defender y saber el valor de la defensa realizada por el zombie.
        int atacaZombie = zombie1.ataca();//Método para atacar y saber el valor del ataque realizado por el zombie.
        int defensaSupervivient = supervivient1.defensat();//Método para defender y saber el valor de la defensa realizada por el superviviente.
        int puntsPerdutsZombie = atacaSupervivient - defensaZombie;//Variable para recoger los puntos perdidos del zombie en el combate.
        int puntsPerdutsSupervivient = atacaZombie - defensaSupervivient;//Variable para recoger los puntos perdidos del superviviente en el combate.

        ciutat1.getNom();//Usamos el método get para saber cuál es el nombre de la ciudad.
        System.out.println("Benvingut a " + nomCiutat);
        supervivient1.getNom();//Usamos el método get para saber cuál es el nombre del superviviente.
        System.out.println(
                "El nostre protagonista " + nomSupervivient + " es troba en un univers destruit i apocaliptic.");//Durante todo el código usaré el nomSupervivient para que se imprima el nombre del superviviente
        System.out.println(
                "El nostre heroi recorrera la ciutat, ubicació per ubicació per tal de lluitar per la seva vida.");
        

        for (int i = 0; i < tamanyCiutatUsuario; i++) { //Un bucle for que recorre desde el 0 hasta el tamaño de la ciudad el cual es el introducido por el usuario, este bucle irá incrementando recorriendo el código de dentro hasta llegar al tamaño (su máximo)

            zombie1 = ciutat1.posicioRuta(i);//Con esto conseguimos que se cree un zombie en cada posición de la ruta, entonces si el tamaño de la ciudad es 20 habrá 20 zombies y el superviviente irá combatiéndolos uno a uno
            salutZombie = zombie1.getSalut();//Un combate acaba cuando el zombie muere o el superviviente muere, con este getSalut conseguimos que el zombie que esta a 0 de vida (muerto), se le reinicie su vida a 20 (la vida por defecto instanciada en el constructor del zombie), así el bucle se volverá a iniciar y el superviviente volverá a combatir con otro zombie.
            
            if (i==1 && salutSupervivient >= 0) {//Un print con un mensaje que aparecerá si el superviviente esta vivo y cuando este en la posición 1
                System.out.println("Després d'aquest primer combat "+nomSupervivient+" es conscient del perill d'aquesta ciutat catastròfica.");
            }

            if (i==10 && salutSupervivient >= 0) {//Un print con un mensaje que aparecerá si el superviviente esta vivo y cuando este en la poición 10
                System.out.println("El nostre supervivent després de molts combats y de recorre molt la ciutat, decideix descansar perquè arriba la nit.");
                System.out.println("Comença un nou dia amb moltes adversitats...");
            }
            
            System.out.println(nomSupervivient + " ha trobat un zombie!");

            while (salutSupervivient > 0 && salutZombie > 0) {//Un while que funcionará siempre que el superviviente y el zombie esten vivos, es decir a más de 0 de salud

                atacaSupervivient = supervivient1.ataca();//Usamos el método ataca para que el superviviente haga un ataque aleatorio de entre 0 y 10 de daño
                System.out.println(nomSupervivient+" ataca amb " + atacaSupervivient + " punts de atac.");
                if (atacaSupervivient == 0) {//Si el ataque del superviviente es 0, se imprimirá este print
                    System.out.println(nomSupervivient + " f**ck he fallado mi ataque!");
                }

                defensaZombie = zombie1.defensat();//Usamos el método defensa para que el zombie haga una defensa aleatoria de entre 0 y 5 de daño
                System.out.println("El zombie es defensa amb " + defensaZombie + " punts de defensa.");

                atacaZombie = zombie1.ataca();//Usamos el método ataca para que el zombie haga un ataque aleatorio de entre 0 y 5 de daño
                System.out.println("El zombie ataca amb " + atacaZombie + " punts de atac!");
                if (atacaZombie == 0) {//Si el ataque del zombie es 0, saldrá este print
                    System.out.println(nomSupervivient + " celebra que no li ha donat el atac del zombie!");

                }

                defensaSupervivient = supervivient1.defensat();//Usamos el método defensa para que el superviviente haga una defensa aleatoria de entre 0 y 10 de daño
                System.out.println(nomSupervivient+" es defensa amb " + defensaSupervivient + " punts de defensa.");

                puntsPerdutsZombie = atacaSupervivient - defensaZombie;//Usamos la variable puntsPerdutsZombie que le resta la defensa del zombie al ataque del superviviente.
                if (puntsPerdutsZombie > 0) {//Si los puntos perdidos son mayores a 0 se restan a la salud.
                    zombie1.setSalut(salutZombie = salutZombie - puntsPerdutsZombie);//En este setSalut, obligamos a que la salud valga, la salud restandole los puntos perdidos del zombie, así el zombie irá perdiendo salud si le hacen daño
                    System.out.println("·El zombie te " + salutZombie + " punts de salut.");
                }

                puntsPerdutsSupervivient = atacaZombie - defensaSupervivient;//Usamos la variable puntsPerdutsSupervivent que le resta la defensa del supervivent al ataque del zombie.
                if (puntsPerdutsSupervivient > 0) {//Si los puntos perdidos son mayores a 0 se restan a la salud.
                    supervivient1.setSalut(salutSupervivient = salutSupervivient - puntsPerdutsSupervivient);//En este setSalut, obligamos a que la salud valga, la salud restandole los puntos perdidos del superviviente, así el superviviente irá perdiendo salud si le hacen daño
                    System.out.println("·El supervivient te " + salutSupervivient + " punts de salut.");
                }

                if (salutSupervivient > 0 && salutZombie > 0) {//Un print que aparecerá si al haber acabado un combate siguen vivos
                    System.out.println(
                            "----------------------------------------------------NEXT ROUND----------------------------------------------------");
                }

                if (salutZombie <= 0) {//Si la salud del zombie es igual o menor a 0, saldrá este print
                    System.out.println(nomSupervivient + " ha destrozat al zombie!!!");
                    System.out.println(
                            "-----------------------------ZOMBIE " + (i + 1) + " IS DEAD-----------------------------");// i+1, porque el zombie 1 esta en la posición 0

                }

                if (salutSupervivient <= 0) {//Si la salud del superviviente es igual o menor a 0, salrá el print
                    System.out.println(nomSupervivient + " ha mort pel zombie "+(i+1)+" :(.");
                    System.out.println("-----------------------------YOU DEAD-----------------------------");
                }

            }

        }

        System.out.println("GRACIÈS PER JUGAR AL MEU JOC."); //Un print que al finalizar el bucle aparezca

       

    }

}
