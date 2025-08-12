package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private final ServidorChat servidor = new ServidorChat();
    private int contadorUsuarios = 1;

    @Override
    public void start(Stage primaryStage) {
        Button nuevoUsuario = new Button("Conectar nuevo usuario");
        nuevoUsuario.setOnAction(e -> {
            new VentanaChat("Usuario" + contadorUsuarios++, servidor);
        });

        VBox root = new VBox(10, nuevoUsuario);
        root.setPadding(new javafx.geometry.Insets(20));
        primaryStage.setScene(new Scene(root, 300, 100));
        primaryStage.setTitle("Servidor de Chat");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}