package org.exampleAbstract;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura, String color){
        super(color);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area(){
        return base*altura;
    }
}
