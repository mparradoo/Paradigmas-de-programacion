package org.example;

public class Circulo implements Figura{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }
    @Override
    public double area(){
        return Math.PI * radio *radio;
    }
}
