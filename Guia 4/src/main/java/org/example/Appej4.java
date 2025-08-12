package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Appej4 extends Application {

    @Override
    public void start(Stage stage) {
        // Crear un Label para mostrar las coordenadas
        Label coordenadasLabel = new Label("Mueve el mouse por la ventana");

        // Crear el layout
        StackPane root = new StackPane(coordenadasLabel);
        //StackPane: un contenedor que centra automáticamente su contenido.
        //Scene: representa el “contenido” de la ventana, con un tamaño de 400x200.
        Scene scene = new Scene(root, 400, 200);

        // Manejar movimiento del mouse
        //setOnMouseMoved(...) le dice a la escena:
        //"Cada vez que el mouse se mueva, ejecutá este código..."
        scene.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            coordenadasLabel.setText("X: " + x + "  |  Y: " + y);
        });

        // Mostrar ventana
        stage.setTitle("Coordenadas del Mouse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}