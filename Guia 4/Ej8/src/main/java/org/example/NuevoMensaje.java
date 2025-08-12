package org.example;
import javafx.event.Event;
import javafx.event.EventType;

public class NuevoMensaje extends Event {
    public static final EventType<NuevoMensaje> NUEVO_MENSAJE = new EventType<>(Event.ANY, "NUEVO_MENSAJE");

    private final String mensaje;

    public NuevoMensaje(String mensaje) {
        super(NUEVO_MENSAJE);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
