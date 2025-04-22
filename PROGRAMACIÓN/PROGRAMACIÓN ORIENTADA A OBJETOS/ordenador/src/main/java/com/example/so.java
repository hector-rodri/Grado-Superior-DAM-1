package com.example;

import java.util.ArrayList;

public class so {
    private String nombreSo;
    private String versionSo;
    private String arquitecturaSo;
    private boolean onlyCommandsSo;
    private double espacioRequeridoSo;
    private double memRamRequeridaSo;
    private ArrayList<programario> listaProgramario;

    public so(String nombreSoIndicado, String versionSoIndicado, String arquitecturaSoIndicado,
            Boolean onlyCommandsSoIndicado, double espacioRequeridoSoIndicado, double memRamRequeridaSoIndicado) {
        this.nombreSo = nombreSoIndicado;
        this.versionSo = versionSoIndicado;
        this.arquitecturaSo = arquitecturaSoIndicado;
        this.onlyCommandsSo = onlyCommandsSoIndicado;
        this.espacioRequeridoSo = espacioRequeridoSoIndicado;
        this.memRamRequeridaSo = memRamRequeridaSoIndicado;
        this.listaProgramario = new ArrayList<programario>();

    }

    public String getNombreSo() {
        return nombreSo;
    }

    public String getVersionSo() {
        return versionSo;
    }

    public String getArquitecturaSo() {
        return arquitecturaSo;
    }

    public boolean getOnlyCommandsSo() {
        return onlyCommandsSo;
    }

    public double getespacioRequeridoSo() {
        return espacioRequeridoSo;
    }

    public double getmemRamRequeridaSo() {
        return memRamRequeridaSo;
    }

    public void setNombreSo(String nombreSoIntro) {
        this.nombreSo = nombreSoIntro;
    }

    public void setVersionSo(String versionSoIntro) {
        this.versionSo = versionSoIntro;
    }

    public void setArquitecturaSo(String arquitecturaSoIntro) {
        this.arquitecturaSo = arquitecturaSoIntro;
    }

    public void setOnlyCommandsSo(boolean onlyCommandsSoIntro) {
        this.onlyCommandsSo = onlyCommandsSoIntro;
    }

    public void setespacioRequeridoSo(double espacioRequeridoSoIntro) {
        this.espacioRequeridoSo = espacioRequeridoSoIntro;
    }

    public void setmemRamRequeridaSo(double memRamRequeridaSoIntro) {
        this.memRamRequeridaSo = memRamRequeridaSoIntro;
    }

    public boolean instalarProgramario(ordenador pc, programario program) {
        if (pc.getHddOrdenador() > program.getEspacioProgramario() && pc.getMemoriaRamOrdenador() > program.getMemRamProgramario()) {
            listaProgramario.add(program);
            pc.actualizarRecursos(-program.getEspacioProgramario(), -program.getMemRamProgramario());
            System.out.println("Programa instalado con éxito");
            return true;
        } else {
            System.out.println("No hay suficiente espacio para instalar el programa");
            return false;
        }

    }

}
