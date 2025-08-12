package org.example;

abstract class Integrante {
    protected String nombre;
    protected int dni;

    public Integrante(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public abstract void mostrarDatos();
}
