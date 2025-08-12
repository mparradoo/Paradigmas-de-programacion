package org.example;

public class Mensaje {
    private Usuario remitente;
    private Usuario destinatario;
    private String texto;


    public Mensaje(Usuario remitente, Usuario destinatario, String texto){
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }


}
