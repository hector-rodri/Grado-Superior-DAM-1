//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Utilizamos el mismo package en todos los objetos porque es la manera que tiene java de enlazarlos entre si.
import java.util.Random;//Importamos la libreria random, que sirve para darnos un número aleatoriio.

public class zombie {//Creamos una clase que tiene que ser pública para a través del main poder manipularla. Se tiene que llamar igual que el objeto.

    Random random = new Random();//Instanciamos el random para usarlo.

    private int salut;//Creamos una variable de tipo entero para la salud.
    private int atac;//Creamos una variable de tipo entero para el ataque.
    private int defensa;//Creamos una variable de tipo entero para la defensa.

    public zombie(int salut, int atac, int defensa) {//Este es el constructor con parámetros, que nos servirá para instanciar el objeto en el main. y para la herencia
        this.salut =salut;
        this.atac = atac;
        this.defensa = defensa;
    }

    public zombie() {//Este es el constructor vacío, que nos servirá para instanciar el objeto en el main.
        this.salut = 20;//Aquí le damos un valor inicial a la salud.
        this.atac = 5;//Aquí le damos un valor inicial al ataque.
        this.defensa = 5;//Aquí le damos un valor inicial a la defensa.
    }

    public int getSalut() {//Método GET para que nos devuelva la salud.
        return salut;//El return para que nos devuelva.

    }

    public int getAtac() { //Método GET para que nos devuelva el ataque.
        return atac;//El return para que nos devuelva.
    }

    public int getDefensa() { //Método GET para que nos devuelva la defensa.
        return defensa;//El return para que nos devuelva.
    }

    public void setSalut(int salutZombie) {//Método para SET establecer la salud.
        this.salut = salutZombie;

    }

    public void setAtac(int atacZombie) {//Método para SET establecer el ataque.
        this.atac = atacZombie;
    }

    public void setDefensa(int defensaZombie) {//Método para SET establecer la defensa.
        this.defensa = defensaZombie;
    }

    public int ataca() {//Método para que el superviviente ataque.

        return (random.nextInt(atac) + 0); //Nos devolverá un número aleatorio desde el 0 hasta el 5 (porque hemos indicado antes que su ataque es 5).

    }

    public int defensat() {//Método para que el superviviente defienda.
        return (random.nextInt(defensa) + 0);//Nos devolverá un número aleatorio desde el 0 hasta el 5 (porque hemos indicado antes que su defensa es 5).
    
    }

}
