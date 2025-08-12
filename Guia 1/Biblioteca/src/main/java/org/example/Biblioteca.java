package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Cliente> clientes;


    public Biblioteca(){
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public void quitarLibro(Libro libro){
        libros.remove(libro);
    }

    public int consultarStockTitulo(String titulo){
        int stock = 0;
        for (Libro libro:this.libros){
            if (libro.getTitulo().equals(titulo)){
                stock += libro.getStock();
            }
        }
        return stock;
    }

    public int consultarStockAutor(String autor){
        int stock = 0;
        for (Libro libro:this.libros){
            String[] autores = libro.getAutores();
            for(String a:autores) {
                if (a.equals(autor)) {
                    stock += libro.getStock();
                    break;
                }
            }
        }
        return stock;
    }


    public int consultarStockFecha(Date fecha){
        int stock = 0;
        for (Libro libro:this.libros){
            if (libro.getFecha().equals(fecha)){
                stock += libro.getStock();
            }
        }
        return stock;
    }


    public void prestarLibro(Libro libro, Cliente cliente){
        int stock = libro.getStock();
        if(stock > 0) {
            libro.setStock(stock - 1);
            cliente.prestarLibro(libro);
        }
    }

    public void devolverLibro(Libro libro, Cliente cliente){
        int stock = libro.getStock();
        libro.setStock(stock + 1);
        cliente.devolverLibro(libro);
    }

    public ArrayList<Libro> consultarPrestados(Cliente cliente){
        return cliente.getLibros_prestados();
    }
}
