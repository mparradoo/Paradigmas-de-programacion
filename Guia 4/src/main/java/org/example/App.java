package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Cuadro de texto para ingresar el nombre
        TextField nombreField = new TextField();
        nombreField.setPromptText("Ingresá tu nombre");

        // Botón para saludar
        Button botonSaludar = new Button("Saludar");

        // Acción al hacer clic en el botón
        botonSaludar.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            if (!nombre.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saludo");
                alert.setHeaderText(null);
                alert.setContentText("¡Hola, " + nombre + "!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Advertencia");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, ingresá un nombre.");
                alert.showAndWait();
            }
        });

        // Layout
        VBox layout = new VBox(10, nombreField, botonSaludar);
        layout.setPadding(new javafx.geometry.Insets(20));

        // Escena y stage
        Scene scene = new Scene(layout, 300, 150);
        stage.setTitle("Aplicación de Saludo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
