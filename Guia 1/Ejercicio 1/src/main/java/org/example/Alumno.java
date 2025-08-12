package org.example;

import java.util.ArrayList;

public class Alumno {
    private final int padron;
    private final ArrayList<Carrera> carrerasActivas;
    private  final ArrayList<Materia> materiasAprobadas;


    public Alumno(int padron){
        this.padron = padron;
        this.carrerasActivas = new ArrayList<Carrera>();
        this.materiasAprobadas = new ArrayList<Materia>();

    }

    public boolean inscribirCarrera(Carrera carrera_nueva){
        if(carrerasActivas.contains(carrera_nueva)){
            return false;
        }
        carrerasActivas.add(carrera_nueva);
        return true;

    }

    public boolean aprobarMateria(Materia materia_aprobada){
        if(materiasAprobadas.contains(materia_aprobada)){
            return false;
        }
        materiasAprobadas.add(materia_aprobada);
        return true;
    }


    public String creditosTotales(){
        int creditos = 0;
        for(int i = 0; i < materiasAprobadas.size(); i++){
            creditos += materiasAprobadas.get(i).getCreditos();
        }
        return "Tenes %d creditos".formatted(creditos);
    }
}
