package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Integrante> integrantes;


    public Sistema(){
        this.integrantes = new ArrayList<>();
    }

    public void agregarIntegrante(Integrante integrante){
        for(Integrante i: integrantes){
            if(i.getDni() == integrante.getDni()){
                System.out.println("DNI ya registrado");
            }
        }
        integrantes.add(integrante);
    }

    public void listarAlumnos(){
        for(Integrante integrante: integrantes){
            if(integrante instanceof Alumno){
                integrante.mostrarDatos();
            }
        }
    }

    public void listarDocentes(){
        for(Integrante integrante: integrantes){
            if(integrante instanceof Docente){
                integrante.mostrarDatos();
            }
        }
    }
}

