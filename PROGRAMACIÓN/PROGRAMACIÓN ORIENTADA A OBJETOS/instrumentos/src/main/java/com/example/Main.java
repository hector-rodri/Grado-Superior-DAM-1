package com.example;

public class Main {
    public static void main(String[] args) {
        
        flauta miFlauta = new flauta("laFlautadeOro");
        miFlauta.mostrarInformacio();
        miFlauta.afinarVent();
        miFlauta.ferSonar();
        miFlauta.interpretar();
        System.out.println("------------------------------------");
        tambor miTambor = new tambor("señorTambor");
        miTambor.mostrarInformacio();
        miTambor.afinarTambor();
        miTambor.colpejarTambor();
        miTambor.interpretar();
        System.out.println("------------------------------------");
        guitarra miGuitarra = new guitarra("laViejaGuitarra");
        miGuitarra.mostrarInformacio();
        miGuitarra.afinarCordes();
        miGuitarra.tocarArpegis();
        miGuitarra.interpretar();
        System.out.println("------------------------------------");



    }
}

abstract class instrumento{
    private String nom;
    private String tipus;
    
    public instrumento(String nom, String tipus){
        this.nom = nom;
        this.tipus = tipus;
    }

    public String getNom(){
        return nom;
    }

    public String getTipus(){
        return tipus;
    }

    public void mostrarInformacio(){
        System.out.println("Soy " + getNom() + " y soy de tipo " +getTipus());
    }

    public abstract void interpretar();
}

class guitarra extends instrumento implements cordes{
    public guitarra(String nom){
        super(nom, "cordes");
    }

    @Override
    public void interpretar(){
        System.out.println("Soy una guitarra española!");
    }

    @Override
    public void afinarCordes(){
        System.out.println("La guitarra está siendo afinada...");
    }

    @Override
    public void tocarArpegis(){
        System.out.println("La guitarra está siendo tocada...");
    }
}

class tambor extends instrumento implements percussio{
    public tambor(String nom){
        super(nom, "percussio");
    }

    @Override
    public void interpretar(){
        System.out.println("Soy un tambor POROMPOMPON!");
    }

    @Override
    public void afinarTambor(){
        System.out.println("El tambor se está afinando...");
    }

    @Override
    public void colpejarTambor(){
        System.out.println("El tambor está siendo golpeado");
    }
}

class flauta extends instrumento implements vent{
    public flauta(String nom){
        super(nom, "vent");
    }

    @Override
    public void interpretar(){
        System.out.println("Soy una flauta");
    }

    @Override
    public void afinarVent(){
        System.out.println("Flauta flautosa esta siendo afinada");
    }

    @Override
    public void ferSonar(){
        System.out.println("tururuturututururu");
    }
}