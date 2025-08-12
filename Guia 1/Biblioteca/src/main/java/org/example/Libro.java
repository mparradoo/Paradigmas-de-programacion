package org.example;

import java.util.Date;

public class Libro {

    private String codigo;
    private String titulo;
    private Date fecha;
    private String[] autores;
    private int stock;



    public Libro(String codigo, String titulo, Date fecha, String[] autores, int stock){
        this.codigo = codigo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.autores = autores;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public Date getFecha() {
        return fecha;
    }
}



//Cada libro tiene un código único (ISBN), un título, una fecha de publicación y uno o más autores.{
