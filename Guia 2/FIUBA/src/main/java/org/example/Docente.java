package org.example;

public class Docente extends Integrante {
    private int padron;

    public Docente(String nombre, int dni, int padron) {
        super(nombre, dni);
        this.padron = padron;
    }

    public int getPadron() {
        return padron;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Docente: " + nombre + ", DNI: " + dni + ", Número de padrón: " + padron);
    }

}