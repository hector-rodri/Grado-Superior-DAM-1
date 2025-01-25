package com.example;

public class perro extends animal{
    
    public perro (double peso){
        super(peso);
    }

    @Override
    public void hazRuido(){
        System.out.println("Guau Guau");
    }
}
