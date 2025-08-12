package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appej3 extends Application {

    @Override
    public void start(Stage stage) {
        // Campos de entrada
        TextField campoNumero1 = new TextField();
        campoNumero1.setPromptText("Primer número");

        TextField campoNumero2 = new TextField();
        campoNumero2.setPromptText("Segundo número");

        // ChoiceBox de operaciones
        ChoiceBox<String> operaciones = new ChoiceBox<>();
        operaciones.getItems().addAll("Sumar", "Restar", "Multiplicar", "Dividir");
        operaciones.setValue("Sumar"); // valor por defecto

        // Botón de calcular
        Button botonCalcular = new Button("Calcular");

        // Etiqueta para mostrar el resultado
        Label resultadoLabel = new Label();

        // Acción al hacer clic en el botón
        botonCalcular.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(campoNumero1.getText());
                double num2 = Double.parseDouble(campoNumero2.getText());
                double resultado = 0;
                String operacion = operaciones.getValue();

                switch (operacion) {
                    case "Sumar":
                        resultado = num1 + num2;
                        break;
                    case "Restar":
                        resultado = num1 - num2;
                        break;
                    case "Multiplicar":
                        resultado = num1 * num2;
                        break;
                    case "Dividir":
                        if (num2 == 0) {
                            resultadoLabel.setText("Error: División por cero");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }

                resultadoLabel.setText("Resultado: " + resultado);

            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Por favor, ingresá números válidos.");
            }
        });

        // Layout
        VBox layout = new VBox(10, campoNumero1, campoNumero2, operaciones, botonCalcular, resultadoLabel);
        layout.setPadding(new javafx.geometry.Insets(20));

        // Escena y stage
        Scene scene = new Scene(layout, 300, 250);
        stage.setTitle("Calculadora Básica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}