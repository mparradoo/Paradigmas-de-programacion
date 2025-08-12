package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaChat extends Stage {
    private final TextArea chatArea = new TextArea();
    private final ServidorChat servidor;

    public VentanaChat(String nombreUsuario, ServidorChat servidor) {
        this.servidor = servidor;

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label usuarioLabel = new Label("Usuario: " + nombreUsuario);

        chatArea.setEditable(false);

        TextField input = new TextField();
        Button enviar = new Button("Enviar");

        enviar.setOnAction(e -> {
            String mensaje = nombreUsuario + ": " + input.getText();
            servidor.recibirMensaje(mensaje);
            input.clear();
        });

        root.getChildren().addAll(usuarioLabel, chatArea, input, enviar);
        setScene(new Scene(root, 400, 300));
        setTitle("Chat - " + nombreUsuario);
        show();

        // Suscribirse al servidor
        servidor.suscribir(this);

        // Escuchar eventos de tipo NuevoMensaje
        addEventHandler(NuevoMensaje.NUEVO_MENSAJE, event -> {
            chatArea.appendText(event.getMensaje() + "\n");
        });
    }
}