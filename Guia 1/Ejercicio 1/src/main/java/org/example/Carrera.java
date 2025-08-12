package org.example;

public class Carrera {
    private final String nombre;
    private final Materia[] materias;
    private final int creditos_minimos;
    private final String codigo;


    public Carrera(String nombre, String codigo, Materia[] materias, int creditos_minimos){
        this.nombre = nombre;
        this.codigo = codigo;
        this.materias = materias;
        this.creditos_minimos = creditos_minimos;
    }


    public void printCarrera(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Materias: ");
        for (int i = 0; i < materias.length; i ++){
            materias[i].printMateria();
        }

        System.out.println("Creditos necesarios: " + creditos_minimos);
    }

    public int getCreditos_minimos(){
        return creditos_minimos;
    }

    public String getCodigo() {
        return codigo;
    }
}
