package org.example;

public class MensajeTexto extends Mensaje {
    private String texto;

    public MensajeTexto(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public String mostrarContenido() {
        return "Mensaje de texto: " + texto;
    }
}