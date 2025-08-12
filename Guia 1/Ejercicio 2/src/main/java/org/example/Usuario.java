package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private final String nombre;
    private final List<Mensaje> mensajesEnviados;
    private final List<Mensaje> mensajesRecibidos;


    public Usuario(String nombre){
        this.nombre = nombre;
        this.mensajesEnviados = new arrayList<>();
        this.mensajesRecibidos = new arrayList<>();
    }

    public getNombre(){
        return nombre;
    }


    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void enviarMensaje(Usuario destinatario, String texto){
        Mensaje mensaje = new Mensaje(this, destinatario, texto);
        mensajesEnviados.add(mensaje);
        destinatario.recibirMensaje(mensaje);
    }

    public void recibirMensaje(Mensaje mensaje) {
        mensajesRecibidos.add(mensaje);
    }
}
