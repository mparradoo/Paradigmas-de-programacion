package org.example;

public class Materia {
    private final String codigo;
    private final String nombre;
    private final int creditos;
    private final boolean obligatoria;

    public Materia(String codigo, String nombre, int creditos, boolean obligatoria){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.obligatoria = obligatoria;
    }


    public void printMateria(){
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Creditos: " + this.creditos);
        System.out.println("Obligatoria: " + this.obligatoria);
    }

    public int getCreditos(){return creditos;}

    public String getCodigo() {
        return codigo;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }
}


