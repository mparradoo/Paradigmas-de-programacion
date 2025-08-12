package org.example;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private ArrayList<Libro> libros_prestados;


    public Cliente(String nombre){
        this.nombre = nombre;
        this.libros_prestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getLibros_prestados() {
        return libros_prestados;
    }

    public void prestarLibro(Libro libro){
        libros_prestados.add(libro);
    }
    public void devolverLibro(Libro libro){
        libros_prestados.remove(libro);
    }
}

