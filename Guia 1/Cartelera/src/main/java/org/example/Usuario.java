package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String contraseña;
    private String nombre;
    private boolean esPersonal;
    private final List<Mensaje> mensajesEnviados;
    private final List<Mensaje> mensajesRecibidos;

    public Usuario(String nombre, String contraseña, boolean esPersonal){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esPersonal = esPersonal;
        this.mensajesEnviados = new ArrayList<>();
        this.mensajesRecibidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isEsPersonal() {
        return esPersonal;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void enviarMensaje(Mensaje mensaje){
        mensajesEnviados.add(mensaje);
    }

    public void recibirMensaje(Mensaje mensaje){
        mensajesRecibidos.add(mensaje);
    }
}
