package com.example;

public class ordenador {

    private String nombreOrdenador;
    private double memoriaRamOrdenador;
    private double hddOrdenador;
    private so sistemaOperativo;

    public ordenador(double memoriaRamOrdenadorIndicada, double hddOrdenadorIndicado) {
        this.nombreOrdenador = "PC 1";
        this.memoriaRamOrdenador = memoriaRamOrdenadorIndicada;
        this.hddOrdenador = hddOrdenadorIndicado;
    }

    public String getNombreOrdenador() {
        return nombreOrdenador;
    }

    public double getMemoriaRamOrdenador() {
        return memoriaRamOrdenador;
    }

    public double getHddOrdenador() {
        return hddOrdenador;
    }

    public so getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setNombreOrdenador(String nombreOrdenadorIntro) {
        this.nombreOrdenador = nombreOrdenadorIntro;
    }

    public void setMemoriaRamOrdenador(double memoriaRamOrdenadorIntro) {
        this.memoriaRamOrdenador = memoriaRamOrdenadorIntro;
    }

    public void setHddOrdenador(double hddOrdenadorIntro) {
        this.hddOrdenador = hddOrdenadorIntro;
    }

    public void setSistemaOperativo(so sistemaOperativoIntro) {
        this.sistemaOperativo = sistemaOperativoIntro;
    }

    public boolean instalacionSistemaOperativo(so sistemaOperativo) {

        if (sistemaOperativo.getespacioRequeridoSo() < hddOrdenador
                && sistemaOperativo.getmemRamRequeridaSo() < memoriaRamOrdenador) {
            hddOrdenador = hddOrdenador - sistemaOperativo.getespacioRequeridoSo();
            memoriaRamOrdenador = memoriaRamOrdenador - sistemaOperativo.getmemRamRequeridaSo();
            this.sistemaOperativo = sistemaOperativo;
            System.out.println("Sistema operativo "+ sistemaOperativo.getNombreSo()+" instalado");
            return true;
        } else {
            return false;
        }
    }

    public void formatearOrdenador() {
        sistemaOperativo.desinstalarTodosLosProgramas(this);
        actualizarRecursos(sistemaOperativo.getespacioRequeridoSo(), sistemaOperativo.getmemRamRequeridaSo());
    }

    public void actualizarRecursos(double hdd, double ram) {
        hddOrdenador += hdd;
        memoriaRamOrdenador += ram;
    }

    public void infoOrdenador() {
        System.out.println("El pc " + nombreOrdenador + " tiene disponible:");
        System.out.println("RAM: " + memoriaRamOrdenador);
        System.out.println("HDD: " + hddOrdenador);
    }
}
