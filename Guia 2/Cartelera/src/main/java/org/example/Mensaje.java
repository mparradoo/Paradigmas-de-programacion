package org.example;


public abstract Mensaje {
    private String remitente;
    private String destinatario;

    public Mensaje(String remitente, String destinatario, String texto) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public abstract String mostrarContenido();
}