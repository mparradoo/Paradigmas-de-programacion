package org.example;

import java.util.ArrayList;

public class ListaDuplicanteComposicion<T> {

    private ArrayList<T> lista;

    public ListaDuplicanteComposicion(){
        this.lista = new ArrayList<T>();
    }


    public boolean add(T x){
        return lista.add(x) && lista.add(x);
    }//que agrega el elemento x al final de la lista dos veces.


    public T get(int i){
        return lista.get(i);
    }


}



//Ventajas:
// mayor flexibilidad ya que tiene control total sobre como interactua con ArrayList<T>
// evita herencia inecesaria

//Desventajas:
//El codigo es mas largo
//Las llamadas no son tan directas