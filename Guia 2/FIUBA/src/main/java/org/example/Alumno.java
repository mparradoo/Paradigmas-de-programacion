package org.example;

public class Alumno extends Integrante{
    private int padron;

    public Alumno(String nombre, int dni, int padron){
        super(nombre, dni);
        this.padron = padron;
    }

    public int getPadron() {
        return padron;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Alumno: " + nombre + ", DNI: " + dni + ", Número de padrón: " + padron);
    }

}
