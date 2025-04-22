package com.example;

public class Main {
    public static void main(String[] args) {

        //ORDENADOR
        ordenador pcHector = new ordenador(4, 100);
        pcHector.setNombreOrdenador("c1");

        //SISTEMA OPERATIVO
        so soHector = new so("OS1", "5", "CISC", false, 50, 2);
        pcHector.instalacionSistemaOperativo(soHector);

        //PROGRAMAS
        programario java = new programario("s1", "last-version", 10, 1);
        programario python = new programario("s2","last-version",5,0.5);
        programario oracle = new programario("s3","last-version",40,0.3);
        soHector.instalarProgramario(pcHector, java);
        soHector.instalarProgramario(pcHector, python);
        soHector.instalarProgramario(pcHector, oracle);

        soHector.desinstalarProgramario(pcHector, python);//Desinstalación s2
        pcHector.formatearOrdenador();//Formateo

        pcHector.infoOrdenador();
    }
}