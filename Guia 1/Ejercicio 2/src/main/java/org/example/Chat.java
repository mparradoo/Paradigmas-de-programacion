package org.example;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<Usuario> usuarios;

    public Chat(){
        this.usuarios = new ArrayList<>();
    }


    public agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public obtenerHistorial(Usuario usuario1, Usuario usuario2){
        List<Mensaje> historial = new ArrayList<>();
        for(Mensaje mensaje : usuario1.getMensajesEnviados()){ //for each mensaje in mensajesEnviados
            if (mensaje.getDestinatario() == usuario2){
                historial.add(mensaje);
            }
        }

        for(Mensaje mensaje : usuario2.getMensajesEnviados()){ //for each mensaje in mensajesEnviados
            if (mensaje.getDestinatario() == usuario1){
                historial.add(mensaje);
            }
        }

        return historial;
    }
}
