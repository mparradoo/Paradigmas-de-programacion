package org.example;

import java.util.ArrayList;

public class ListaDuplicanteHerencia<T> extends ArrayList<T> {
    @Override
    public boolean add(T x){
        boolean a = super.add(x);
        boolean b =super.add(x);

        return a && b;
    }


}

//Ventajas:
//codigo mas limpio y corto
//acceso directo a los metodos de ArrayList

//Desventajas:
//Se heredan todos los metodos de ArrayList, incluyendo los que no son relevantes para ListaDuplicante