package game.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScreen {
    private final Stage stage;

    public MenuScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Title
        Label title = new Label("Bienvenido a Robots");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: darkblue; -fx-font-family: 'Noto Color Emoji';");


        // Subtitle
        Label subtitle = new Label("Elija la cantidad de filas y columnas del tablero");
        subtitle.setStyle("-fx-font-size: 14px; -fx-padding: 0 0 10 0;");

        // Spinners for cols and rows
        Spinner<Integer> filasSpinner = new Spinner<>();
        filasSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 25, 16));
        filasSpinner.setPrefWidth(80);

        Spinner<Integer> columnasSpinner = new Spinner<>();
        columnasSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 25, 16));
        columnasSpinner.setPrefWidth(80);

        // Container for config
        HBox boardConfig = new HBox(20,
                new VBox(new Label("Filas:"), filasSpinner),
                new VBox(new Label("Columnas:"), columnasSpinner)
        );
        boardConfig.setAlignment(Pos.CENTER);

        // Button to start playing
        Button jugarButton = new Button("¡Jugar!");
        jugarButton.setStyle("-fx-font-size: 16px; -fx-background-color: darkgreen; -fx-text-fill: white;");
        jugarButton.setOnAction(e -> {
            int filas = filasSpinner.getValue();
            int columnas = columnasSpinner.getValue();
            GameView gameView = new GameView(stage, columnas, filas);
            gameView.show();
        });

        // Game rules
        Label reglas = new Label(
                "🕹️ Reglas del juego:\n" +
                        "- Muevete con W A S D (o diagonales: Q, E, Z, X)\n" +
                        "- Recoge recursos antes de que los robots te atrapen\n" +
                        "- Usa TP-RANDOM o TP-SAFE para teletransportarte\n" +
                        "- TP-SAFE: toca el boton y selecciona una celda\n" +
                        "- Sobrevive y completa todos los niveles!"
        );
        reglas.setStyle("-fx-font-size: 12px; -fx-text-fill: #444;");
        reglas.setWrapText(true);
        reglas.setMaxWidth(300);

        VBox layout = new VBox(20, title, subtitle, boardConfig, jugarButton, reglas);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #f0f8ff;");

        Scene scene = new Scene(layout, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
}