package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appej2 extends Application {

    @Override
    public void start(Stage stage) {
        // Crear Label
        Label etiqueta = new Label("Texto de ejemplo");
        etiqueta.setStyle("-fx-font-size: 18px;");

        // Crear ChoiceBox con colores
        ChoiceBox<String> selectorColores = new ChoiceBox<>();
        selectorColores.getItems().addAll("Rojo", "Verde", "Azul", "Negro", "Morado");

        // Acción al seleccionar un color
        selectorColores.getSelectionModel().selectedItemProperty().addListener((obs, valorViejo, valorNuevo) -> {
            switch (valorNuevo) {
                case "Rojo":
                    etiqueta.setTextFill(Color.RED);
                    break;
                case "Verde":
                    etiqueta.setTextFill(Color.GREEN);
                    break;
                case "Azul":
                    etiqueta.setTextFill(Color.BLUE);
                    break;
                case "Negro":
                    etiqueta.setTextFill(Color.BLACK);
                    break;
                case "Morado":
                    etiqueta.setTextFill(Color.PURPLE);
                    break;
            }
        });

        // Layout
        VBox layout = new VBox(15, selectorColores, etiqueta);
        layout.setPadding(new javafx.geometry.Insets(20));

        // Escena y ventana
        Scene scene = new Scene(layout, 300, 150);
        stage.setTitle("Selector de Color");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


//ChoiceBox<String>: Lista desplegable con opciones de texto.
//
//addListener(...): Detecta cuando el usuario selecciona un nuevo color.
//
//Label.setTextFill(Color.X): Cambia el color del texto del Label.
//
//VBox(...): Ordena verticalmente los elementos con espacio entre ellos.