package org.exampleAbstract;

public abstract class Figura {
    //Clase abstracta --> atributos y metodos

    private String color;
    public Figura(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double area();
}
