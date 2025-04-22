package com.example;

import java.util.ArrayList;

public class programario {
    private String nombreProgramario;
    private String versionProgramario;
    private double espacioProgramario;
    private double memRamProgramario;
    private ArrayList<programario> listaProgramarioSo;


    public programario(String nombreProgramarioIntroducido, String versionProgramarioIntroducida, double espacioProgramarioIntroducido, double memRamProgramarioIntroducida) {
        this.nombreProgramario = nombreProgramarioIntroducido;
        this.versionProgramario = versionProgramarioIntroducida;
        this.espacioProgramario = espacioProgramarioIntroducido;
        this.memRamProgramario = memRamProgramarioIntroducida;
    }

    public String getNombreProgramario() {
        return nombreProgramario;
    }

    public String getVersionProgramario() {
        return versionProgramario;
    }

    public double getEspacioProgramario() {
        return espacioProgramario;
    }

    public double getMemRamProgramario() {
        return memRamProgramario;
    }

    public ArrayList<programario> geListaProgramario(){
        return listaProgramarioSo;
    }

    public void setNombreProgramario(String nombreProgramarioIntroducido) {
        this.nombreProgramario = nombreProgramarioIntroducido;
    }

    public void setVersionProgramario(String versionProgramarioIntroducida) {
        this.versionProgramario = versionProgramarioIntroducida;
    }

    public void setEspacioProgramario(double espacioProgramarioIntroducido) {
        this.espacioProgramario = espacioProgramarioIntroducido;
    }

    public void setMemRamProgramario(double memRamProgramarioIntroducida) {
        this.memRamProgramario = memRamProgramarioIntroducida;
    }

    public void infoProgramario() {
        System.out.println("Nombre del programa: " + nombreProgramario);
        System.out.println("Espacio requerido: " + espacioProgramario);
        System.out.println("RAM requerida: " + memRamProgramario);
    }
}
