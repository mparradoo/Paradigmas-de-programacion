package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<CajaAhorro> cuentas;


    public Usuario(String nombre){
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCuenta(CajaAhorro cuenta){
        cuentas.add(cuenta);
    }

    public CajaAhorro obtenerCuenta(String nombre_cuenta) {
        for (CajaAhorro cuenta : cuentas) {
            if (cuenta.getNombre().equals(nombre_cuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}

