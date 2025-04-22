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

    public boolean instalarProgramario(ordenador pc, programario program) {//Método que instala un programa
        if (pc.getHddOrdenador() > program.getEspacioProgramario() && pc.getMemoriaRamOrdenador() > program.getMemRamProgramario()) {//Si el espacio del hdd y la ram es suficiente, añade el programa al arraylist y le quita el espacio requerido al pc
            listaProgramario.add(program);
            pc.actualizarRecursos(-program.getEspacioProgramario(), -program.getMemRamProgramario());
            System.out.println("Programa instalado con éxito "+ program.getNombreProgramario());
            return true;
        } else {
            System.out.println("No hay suficiente espacio para instalar el programa "+program.getNombreProgramario());
            return false;
        }

    }

    public boolean desinstalarProgramario(ordenador pc, programario program) {//Método que desisntala un programa en especifico
        if (listaProgramario.contains(program)) {//Si el programa está en el arraylist lo borra y le devuelve el espacio ocupado al pc
            listaProgramario.remove(program);
            pc.actualizarRecursos(program.getEspacioProgramario(), program.getMemRamProgramario());
            System.out.println("Programa desinstalado correctamente " + program.getNombreProgramario());
            return true;
        } else {
            System.out.println("El programa no está instalado");
            return false;
        }
    }
    

    public void desinstalarTodosLosProgramas(ordenador pc) {//Método que desinstala todos los programas
        for (programario p : listaProgramario) {//Itera sobr el arraylist con un bucle for, mostrando el nombre de los programas desinstalados y devuelve el espacio que ocupaba al pc
            pc.actualizarRecursos(p.getEspacioProgramario(), p.getMemRamProgramario());
            System.out.println("Desinstalado: " + p.getNombreProgramario());
        }
        listaProgramario.clear();//Borra todos los programas del arraylist
        System.out.println("Todos los programas están desinstalados");
    }
    
    public void mostrarProgramasInstalados() {//Método que muestra todos los programas instalados
        if (listaProgramario.isEmpty()) {//Si el arraylist está vacío
            System.out.println("No hay programas instalados");
        } else {//Si contiene programas muestra su nombre, uno por uno iterando con un bucle for sobre el arraylist
            System.out.println("Programas instalados en el sistema operativo:");
            for (programario p : listaProgramario) {
                System.out.println(p.getNombreProgramario());
            }
        }
    }

}
