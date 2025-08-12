package org.example;

import javafx.event.Event;
import javafx.event.EventDispatcher;
import javafx.event.EventTarget;
import javafx.event.EventType;

import java.util.ArrayList;
import java.util.List;

public class ServidorChat {
    private final List<EventTarget> suscriptores = new ArrayList<>();

    public void suscribir(EventTarget cliente) {
        suscriptores.add(cliente);
    }

    public void recibirMensaje(String mensaje) {
        NuevoMensaje evento = new NuevoMensaje(mensaje);
        for (EventTarget sub : suscriptores) {
            Event.fireEvent(sub, evento);
        }
    }
}