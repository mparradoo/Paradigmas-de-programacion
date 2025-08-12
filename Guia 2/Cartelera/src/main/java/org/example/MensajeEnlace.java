package org.example;

public class MensajeEnlace extends Mensaje {
    private String url;

    public MensajeEnlace(String remitente, String destinatario, String url) {
        super(remitente, destinatario);
        this.url = url;
    }

    @Override
    public String mostrarContenido() {
        return "Enlace: " + url;
    }
}


//Todos los enlaces en este, sino hacer enlaceImagen y enlaceVideo aparte.