package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private static Sistema instance;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    private Sistema() {
        usuarios = new ArrayList<>();
    }

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    } //Si instance es null, significa que todavía no existe una instancia de Sistema, por lo que se crea una nueva.


    public boolean autenticarUsuario(String nombreUsuario, String contraseña){
        for(Usuario usuario: usuarios){
            if(usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)){
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public List<Mensaje> obtenerMensajesEnviados() {
        if (usuarioActual == null) {
            System.out.println("No hay un usuario autenticado.");
        }
        return usuarioActual.getMensajesEnviados();
    }

    public List<Mensaje> obtenerMensajesRecibidos() {
        if (usuarioActual == null) {
            System.out.println("No hay un usuario autenticado.");
        }
        return usuarioActual.getMensajesRecibidos();
    }


    public void cerrarSesion{
        usuarioActual = null;
    }

    public Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void enviarMensaje(Mensaje mensaje){
        Usuario destinatario = buscarUsuarioPorNombre(mensaje.getDestinatario());
        Usuario remitente = buscarUsuarioPorNombre(mensaje.getRemitente());
        remitente.enviarMensaje(mensaje);
        destinatario.recibirMensaje(mensaje);
    }

    public void cerrarSistema(){
        if(usuarioActual == null){
            System.out.println("No hay un usuario autenticado.");
        }

        if(!usuarioActual.isEsPersonal()){
            System.out.println("Solo el personal puede cerrar el sistema.");
        }

        System.out.println("Cerrando sistema...");
        usuarios.clear();
        usuarioActual = null;
    }

    }
