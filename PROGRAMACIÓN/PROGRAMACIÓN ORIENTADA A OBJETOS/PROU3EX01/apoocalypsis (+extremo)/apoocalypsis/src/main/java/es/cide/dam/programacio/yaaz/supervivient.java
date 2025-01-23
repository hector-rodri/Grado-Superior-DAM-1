//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Utilizamos el mismo package en todos los objetos porque es la manera que tiene java de enlazarlos entre si.
import java.util.Random;//Importamos la libreria random, que sirve para darnos un número aleatoriio.

public class supervivient { //Creamos una clase que tiene que ser pública para a través del main poder manipularla. Se tiene que llamar igual que el objeto.

    Random random = new Random();//Instanciamos el random para usarlo.

    private int salut; //Creamos una variable de tipo entero para la salud.
    private int atac; //Creamos una variable de tipo entero para el ataque.
    private int defensa; //Creamos una variable de tipo entero para la defensa.
    private String nom; //Creamos una variable de tipo String para el nombre.


    public supervivient(String nomUsuario) { //Creamos un constructor con un parámetro de tipo String.
        this.salut = 100;
        this.atac = 10;
        this.defensa = 10;
        this.nom = nomUsuario;//Establecemos los valores de la salud, ataque y defensa. Y el nombre lo establecemos con el parámetro que le pasamos.

    }

    public int getSalut() { //Método GET para que nos devuelva la salud.
        return salut; //El return para que nos devuelva.

    }

    public int getAtac() { //Método GET para que nos devuelva el ataque.
        return atac;//El return para que nos devuelva.
    }

    public int getDefensa() {//Método GET para que nos devuelva la defensa.
        return defensa;//El return para que nos devuelva.
    }

    public String getNom() { //Método GET para que nos devuelva el nombre.
        return nom;//El return para que nos devuelva.
    }

    public void setSalut(int salutSupervivient) { //Método para SET establecer la salud.
        this.salut = salutSupervivient;

    }

    public void setAtac(int atacSupervivient) { //Método para SET establecer el ataque.
        this.atac = atacSupervivient;
    }

    public void setDefensa(int defensaSupervivient) { //Método para SET establecer la defensa.
        this.defensa = defensaSupervivient;
    }

    public void setNom(String nomSupervivient) { //Método para SET establecer el nombre.
        this.nom = nomSupervivient;
    }

    public int ataca() { //Método para que el superviviente ataque.
        return (random.nextInt(atac) + 0); //Nos devolverá un número aleatorio desde el 0 hasta el 10 (porque hemos indicado antes que su ataque es 10).

    }

    public int defensat() { //Método para que el superviviente defienda.
        return (random.nextInt(defensa) + 0); //Nos devolverá un número aleatorio desde el 0 hasta el 10 (porque hemos indicado antes que su defensa es 10).

    }

}
