package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Appej5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear el área de texto
        TextArea textArea = new TextArea();
        textArea.setPrefSize(500, 300);
        textArea.setLayoutX(0);
        textArea.setLayoutY(0);

        // Crear la etiqueta para mostrar el evento
        Label label = new Label("Los eventos aparecerán aquí.");
        label.setLayoutX(0);
        label.setLayoutY(300);

        // Manejo de eventos de teclado
        textArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            label.setText("Tecla presionada: " + event.getCode());
        });

        // Crear el contenedor (Pane) y añadir los elementos
        Pane root = new Pane();
        root.getChildren().addAll(textArea, label);

        // Crear la escena y configurar la ventana
        Scene scene = new Scene(root, 500, 320);
        primaryStage.setTitle("Ejemplo de Evento de Teclado en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
