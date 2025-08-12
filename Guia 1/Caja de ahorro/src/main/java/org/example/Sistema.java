package org.example;

import java.util.HashMap;
import java.util.Map;

public class Sistema {

    private Map<String, Usuario> usuarios;

    public Sistema() {
        usuarios = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
    }

    public Usuario obtenerUsuario(String nombre) {
        return usuarios.get(nombre);
    }

    public boolean transferir(String usuarioOrigen, String usuarioDestino,String nombre_origen, String nombre_destino, double cantidad) {
        Usuario origen = obtenerUsuario(usuarioOrigen);
        Usuario destino = obtenerUsuario(usuarioDestino);

        if (origen != null && destino != null) {
            CajaAhorro cuentaOrigenObj = origen.obtenerCuenta(nombre_origen);
            CajaAhorro cuentaDestinoObj = destino.obtenerCuenta(nombre_destino);

            if (cuentaOrigenObj != null && cuentaDestinoObj != null) {
                if (cuentaOrigenObj.retirarDinero(cantidad)) {
                    cuentaDestinoObj.depositarDinero(cantidad);
                    return true;
                }
            }
        }
        return false;
    }
}


