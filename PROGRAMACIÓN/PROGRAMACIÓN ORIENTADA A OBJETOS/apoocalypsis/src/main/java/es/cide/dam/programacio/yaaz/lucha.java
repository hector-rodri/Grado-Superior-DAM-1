//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Paquete donde se encuentra el archivo lucha.java

public class lucha {//Clase lucha que se encarga de la lucha entre el superviviente y el zombie
    public static void luchar(supervivient supervivient, zombie zombieActual, novaCiutat ciutat1, int posicioRuta) {//Método luchar que recibe el superviviente, el zombie actual, la ciudad y la posición de la ruta

        while (supervivient.getSalut() > 0 && zombieActual.getSalut() > 0) {//Mientras la salud del superviviente sea mayor que 0 y la salud del zombie actual sea mayor que 0
            // TURNO 1
            System.out.println("-----------------------------ROUND " + (posicioRuta + 1) + "-----------------------------");
            int atacaSupervivent = supervivient.ataca();//Variable que almacena el ataque del superviviente
            int defensaZombie = zombieActual.defensat();//Variable que almacena la defensa del zombie
            System.out.println(supervivient.getNom() + " ataca amb " + atacaSupervivent + " punts de atac.");//Imprimimos el ataque del superviviente
            if (atacaSupervivent == 0) {//Si el ataque del superviviente es 0
                System.out.println(supervivient.getNom() + " crida  f**ck he fallat el meu atac!");
            }
            System.out.println("El zombie es defensa amb " + defensaZombie + " punts de defensa.");//Imprimimos la defensa del zombie

            // CÁLCULO PUNTOS
            int puntsPerdutsZombie = atacaSupervivent - defensaZombie;//Variable que almacena los puntos perdidos por el zombie
            if (puntsPerdutsZombie > 0) {//Si los puntos perdidos por el zombie son mayores que 0
                zombieActual.setSalut(zombieActual.getSalut() - puntsPerdutsZombie);//La salud del zombie actual disminuye
                System.out.println("·El zombie te " + zombieActual.getSalut() + " punts de salut.");
            }

            if (zombieActual.getSalut() > 0) {//Si la salud del zombie actual es mayor que 0
                // TURNO 2
                int atacaZombie = zombieActual.ataca();//Variable que almacena el ataque del zombie
                int defensaSupervivient = supervivient.defensat();//Variable que almacena la defensa del superviviente
                System.out.println("El zombie ataca amb " + atacaZombie + " punts de atac!");//Imprimimos el ataque del zombie
                if (atacaZombie == 0) {//Si el ataque del zombie es 0
                    System.out.println(supervivient.getNom() + " celebra que no li ha donat el atac del zombie!");
                }
                System.out.println(//Imprimimos la defensa del superviviente
                        supervivient.getNom() + " es defensa amb " + defensaSupervivient + " punts de defensa.");

                // CÁLCULO PUNTOS
                int puntsPerdutsSupervivient = atacaZombie - defensaSupervivient;//Variable que almacena los puntos perdidos por el superviviente
                if (puntsPerdutsSupervivient > 0) {//Si los puntos perdidos por el superviviente son mayores que 0
                    supervivient.setSalut(supervivient.getSalut() - puntsPerdutsSupervivient);//La salud del superviviente disminuye
                    System.out.println("·El supervivient te " + supervivient.getSalut() + " punts de salut.");
                }
            }
            
            
            if (zombieActual.getSalut() <= 0) {//Si la salud del zombie actual es menor o igual a 0
                System.out.println(supervivient.getNom() + " ha destrozat al zombie!!!");
                System.out.println(
                        "-----------------------------ZOMBIE IS DEAD-----------------------------");

            }

            if (zombieActual.getSalut() <= 0) {//Si la salud del zombie actual es menor o igual a 0
                System.out.println("Has guanyat el combat! El zombie ha mort!");
                ciutat1.generadorArtefactos();//Generador de artefactos
                artefacte artefacteGuanyat = ciutat1.posicioArtefacte(posicioRuta);//Artefacto ganado y su posición
                if (artefacteGuanyat != null) {//Si el artefacto ganado no es nulo
                    String nomArtefacte = artefacteGuanyat.getNom();//Nombre del artefacto ganado
                    double valorArtefacte = artefacteGuanyat.getValorArtefacte();//Valor del artefacto ganado
                    System.out.println("Has guanyat un artefacte: " + nomArtefacte );

                    switch (nomArtefacte) {//Switch que dependiendo del nombre del artefacto ganado
                        case "armaAcer"://Si el artefacto ganado es un arma de acero
                            supervivient.setAtac((int) (supervivient.getAtac() + valorArtefacte));//El ataque del superviviente aumenta
                            System.out.println("El atac del supervivient ha incrementat a: " + supervivient.getAtac());

                            break;
                        case "escud"://Si el artefacto ganado es un escudo
                            supervivient.setDefensa((int) (supervivient.getDefensa() + valorArtefacte));//La defensa del superviviente aumenta
                            System.out.println("La defensa del supervivient ha incrementat a: " + supervivient.getDefensa());

                            break;

                        case "armaDeFoc"://Si el artefacto ganado es un arma de fuego
                            supervivient.setAtac((int) (supervivient.getAtac() * valorArtefacte));//El ataque del superviviente aumenta
                            System.out.println("El atac del supervivient ha incrementat a: " + supervivient.getAtac());

                            break;

                        case "farmaciola"://Si el artefacto ganado es una farmacia
                            supervivient.setSalut((int) (supervivient.getSalut() + valorArtefacte));//La salud del superviviente aumenta
                            System.out.println("La salut del supervivient ha incrementat a: " + supervivient.getSalut());

                            break;

                        default:

                            break;
                    }
                } else {//Si el artefacto ganado es nulo
                    System.out.println("No has guanyat cap artefacte en aquesta ronda.");
                }
            }

        }

    }

}
