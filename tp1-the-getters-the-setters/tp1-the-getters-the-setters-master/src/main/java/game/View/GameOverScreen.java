package game.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class GameOverScreen extends VBox {
    public GameOverScreen(Runnable onRestart) {
        setStyle("-fx-background-color: black;");

        // Centrado y expansión
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPrefSize(500, 550);

        Label label = new Label("💀 GAME OVER 💀");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 36;");

        Button restartButton = new Button("Reiniciar");
        restartButton.setStyle("-fx-font-size: 18;");
        restartButton.setOnAction(e -> onRestart.run());

        getChildren().addAll(label, restartButton);
    }
}


