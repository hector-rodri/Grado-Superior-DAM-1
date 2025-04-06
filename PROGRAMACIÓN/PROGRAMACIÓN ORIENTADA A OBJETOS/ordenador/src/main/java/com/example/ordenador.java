package com.example;

public class ordenador {
    
    private String nombreOrdenador;
    private double memoriaRamOrdenador;
    private double hddOrdenador;
    
    public ordenador(double memoriaRamOrdenadorIndicada, double hddOrdenadorIndicado){
        this.nombreOrdenador = "PC 1";
        this.memoriaRamOrdenador = memoriaRamOrdenadorIndicada;
        this.hddOrdenador = hddOrdenadorIndicado;
    }

    public String getNombreOrdenador(){
        return nombreOrdenador;
    }

    public double getMemoriaRamOrdenador(){
        return memoriaRamOrdenador;
    }

    public double getHddOrdenador(){
        return hddOrdenador;
    }

    public void setNombreOrdenador(String nombreOrdenadorIntro){
        this.nombreOrdenador = nombreOrdenadorIntro;
    }

    public void setMemoriaRamOrdenador(double memoriaRamOrdenadorIntro){
        this.memoriaRamOrdenador = memoriaRamOrdenadorIntro;
    }

    public void setHddOrdenador(double hddOrdenadorIntro){
        this.hddOrdenador = hddOrdenadorIntro;
    }
}
