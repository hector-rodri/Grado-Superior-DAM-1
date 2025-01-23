//HÉCTOR RODRÍGUEZ LOZANO
package es.cide.dam.programacio.yaaz;//Paquete de la clase

public abstract class artefacte {//Clase abstracta

    private double pes;//Atributo de tipo double
    private double valorArtefacte;//Atributo de tipo double
    private String nom;//Atributo de tipo String

    public artefacte() {//Constructor de la clase
        this.pes = 1;
        this.valorArtefacte = 1;
        this.nom = "artefacte";
        

    }

    public double getPes() {//Método para obtener el peso
        return pes;//Devolución del peso
    }

    public double getValorArtefacte() {//Método para obtener el valor del artefacto
        return valorArtefacte;//Devolución del valor del artefacto
    }
    
    public String getNom() {//Método para obtener el nombre
        return nom;//Devolución del nombre
    }	

    public void setValorArtefacte(double valorIntroducido) {//Método para asignar un valor al artefacto
        this.valorArtefacte = valorIntroducido;//Asignación de un valor al artefacto
    }
    
    public void setPes(double pesoIntroducido) {//Método para asignar un peso al artefacto
        this.pes = pesoIntroducido;//Asignación de un peso al artefacto
    }

    public void setNom(String nomIntroducido) {//Método para asignar un nombre al artefacto
        this.nom = nomIntroducido;//Asignación de un nombre al artefacto
    }

}
