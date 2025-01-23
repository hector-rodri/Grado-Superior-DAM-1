package com.example;

public class Main {
    public static void main(String[] args) {
       
        // TV tele =new TV();
        // TV tele2 =new TV();
        
        // tele.encender();
        // tele.apagar();
        // tele.bajarV();
        // tele.bajarV();
        // tele.setCANAL(10);
        // int canal = tele.getCANAL();
        // System.out.println( "Estas en el canal " + canal);


        Vehiculo miVehiculo = new Vehiculo();
        Vehiculo miVehiculo2 = new Vehiculo();

        miVehiculo.encenderVehiculo();
        
        
    
        miVehiculo.setGAS(0);
        double gas = miVehiculo.getGas();
        miVehiculo.acelerar();
        miVehiculo2.acelerar();
        
        
        miVehiculo.setNombre("miVehiculo2");
        String nombre = miVehiculo.getNombre();
        System.out.println("Tu velocidad es "+ gas + " km/h." );

        







    }
}