package com.example;

public class TV {
    //atributos
    private boolean isOn;
    private int volumen;
    private int canal;

    public TV() {

        this.isOn = false;
        this.volumen = 10;
        this.canal = 1;
    }

    public void encender(){
        if (!isOn) {
            isOn=true;
            System.out.println("ENCENDIDO");
        }else{
            System.out.println("YA ENCENDIDO");
        }
    }
    public void apagar() {
        if (isOn) {
            isOn= false;
            System.out.println("APAGADO");

        }else{
            System.out.println("YA APAGADO");
        }
    }

    public void subirV() {
        volumen++;
        
        if (volumen > 100) {
            volumen=100;
            System.out.println(" MAX VOLUMEN ");
        }
        System.out.println("+1 volumen "+ volumen );

    }

    public void bajarV() {
        volumen--;
        if (volumen < 0) {
            volumen=0;
            System.out.println(" MIN VOLUMEN (MUTE)");
        }
        System.out.println("-1 volumen " + volumen);
        

    }

    public void subirC() {
        canal++;
        

    }

    public void bajarC() {
        canal--;
        if (canal < 1) {
            canal=1;
        }



        System.out.println(" -1 canal");
        

    }
    
    public int getCANAL(){
        return canal;

    }

    public void setCANAL(int EPA){
        
        if (EPA<=0) {
            EPA=1;
        }
        this.canal = EPA;

    }

    //metodos
    
}
