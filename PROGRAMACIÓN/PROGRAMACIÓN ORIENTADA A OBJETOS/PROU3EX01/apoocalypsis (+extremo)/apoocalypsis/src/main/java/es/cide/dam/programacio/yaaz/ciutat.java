//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Utilizamos el mismo package en todos los objetos porque es la manera que tiene java de enlazarlos entre si.

import java.util.Random;//Importamos la clase Random para poder utilizarla en la clase.

public class ciutat {//Creamos una clase que tiene que ser pública para a través del main poder manipularla. Se tiene que llamar igual que el objeto.
    Random random= new Random();//Creamos un objeto de tipo Random para poder utilizarlo en la clase.
    private String nom;//Creamos una variable de tipo String para el nombre.
    private int tamany;//Creamos una variable de tipo entero para el tamaño.
    private zombie[] ruta;//Creamos un array de variable zombie para la ruta del zombie.

    public ciutat( String nom, int tamany) {//Esto es el constructor el cual se tiene que llamar igual que la clase, aquí encontraremos los varoles iniciales de nuestras variables.
        
        this.nom = nom;
        this.tamany = tamany;
        this.ruta= new zombie[tamany]; //La ruta crea zombies nuevos, el número de zombies que crea son sgún el tamaño de la ciudad.

        for (int i = 0; i < tamany; i++) { //Creamos un bucle for que recorre desde la posición 0 hasta el valor del tamaño.
            int superZombieProbabilidad = random.nextInt(1,10);//Creamos una variable de tipo entero que genera un número aleatorio entre 1 y 10.
            if (superZombieProbabilidad == 1) {//Si la probabilidad de que salga un superzombie es 1, entonces en esa posición de la ruta se creará un superzombie.
                this.ruta[i] = new superZombie();//Para saber que en cada posición según el tamaño hay un superzombie.
                
            }else{
                this.ruta[i] = new zombie();//Para saber que en cada posición según el tamaño hay un zombie.
            }
            

        }

    }

    public String getNom() { //Método GET para que nos devuelva el nombre.
        return nom;//El return para que nos devuelva.
    }

    public int getTamany() {  //Método GET para que nos devuelva el tamaño;
        return tamany;//El return para que nos devuelva.
    }

    public void setNom (String nomCiutat) { //Método para SET establecer el nombre.
        this.nom = nomCiutat;

    }

    public void setTamany(int tamanyCiutat) {//Método para SET establecer el tamaño.
        this.tamany = tamanyCiutat;
    }

    public zombie posicioRuta(int posicioRuta) { //Método zombie para saber si en la posición de la ruta se crean el número de zombies que se indican.
       return ruta[posicioRuta]; //Nos devuelve la posición de la ruta.

    }



    
}
