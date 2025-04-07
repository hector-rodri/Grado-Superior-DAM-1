package com.example;

import java.util.ArrayList;

public class so {
    private String nombreSo;
    private String versionSo;
    private String arquitecturaSo;
    private boolean onlyCommandsSo;
    private double espacioRequeridoSo;
    private double memRamRequeridaSo;
    

    public so(String nombreSoIndicado, String versionSoIndicado, String arquitecturaSoIndicado, Boolean onlyCommandsSoIndicado, double espacioRequeridoSoIndicado, double memRamRequeridaSoIndicado){
        this.nombreSo = nombreSoIndicado;
        this.versionSo = versionSoIndicado;
        this.arquitecturaSo = arquitecturaSoIndicado;
        this.onlyCommandsSo = onlyCommandsSoIndicado;
        this.espacioRequeridoSo = espacioRequeridoSoIndicado;
        this.memRamRequeridaSo = memRamRequeridaSoIndicado;
        
    }

    public String getNombreSo(){
        return nombreSo;
    }

    public String getVersionSo(){
        return versionSo;
    }

    public String getArquitecturaSo(){
        return arquitecturaSo;
    }

    public boolean getOnlyCommandsSo(){
        return onlyCommandsSo;
    }

    public double getespacioRequeridoSo(){
        return espacioRequeridoSo;
    }

    public double getmemRamRequeridaSo(){
        return memRamRequeridaSo;
    }

    public void setNombreSo(String nombreSoIntro){
        this.nombreSo = nombreSoIntro;
    }

    public void setVersionSo(String versionSoIntro){
        this.versionSo = versionSoIntro;
    }

    public void setArquitecturaSo(String arquitecturaSoIntro){
        this.arquitecturaSo = arquitecturaSoIntro;
    }

    public void setOnlyCommandsSo(boolean onlyCommandsSoIntro){
        this.onlyCommandsSo = onlyCommandsSoIntro;
    }

    public void setespacioRequeridoSo(double espacioRequeridoSoIntro){
        this.espacioRequeridoSo = espacioRequeridoSoIntro;
    }

    public void setmemRamRequeridaSo(double memRamRequeridaSoIntro){
        this.memRamRequeridaSo = memRamRequeridaSoIntro;
    }

    


}
