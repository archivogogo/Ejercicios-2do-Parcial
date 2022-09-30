package com.example.ejercicios2doparcial.poo;

public class Bicicleta {

    String nombre;
    String color;

    public Bicicleta (String name, String color){
        this.nombre = nombre;
        this.color = color;
    }


    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }


}
