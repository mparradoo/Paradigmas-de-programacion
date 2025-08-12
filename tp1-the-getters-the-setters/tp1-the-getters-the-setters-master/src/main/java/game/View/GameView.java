package game.View;

import game.Model.Direction;
import game.Model.Game;
import game.Model.Position;
import game.Model.TeleportType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameView {
    private static final KeyCode MOVE_UP = KeyCode.W;
    private static final KeyCode MOVE_LEFT = KeyCode.A;
    private static final KeyCode MOVE_DOWN = KeyCode.S;
    private static final KeyCode MOVE_RIGHT = KeyCode.D;
    private static final KeyCode MOVE_UP_LEFT = KeyCode.Q;
    private static final KeyCode MOVE_UP_RIGHT = KeyCode.E;
    private static final KeyCode MOVE_DOWN_LEFT = KeyCode.Z;
    private static final KeyCode MOVE_DOWN_RIGHT = KeyCode.X;
    private static final Map<KeyCode, Direction> movementMap = new HashMap<>();
    private static final double GAME_UPDATE_DELAY = 1.0;
    private final Stage stage;
    private final VBox root;
    private final int rows;
    private final int cols;
    private final Set<KeyCode> activeKeys = new HashSet<>();
    private Game game;
    private BoardView boardView;
    private boolean showingGameOver = false;
    private VBox topBar;
    private HBox bottomBar;
    private Label scoreLabel;

    public GameView(Stage stage, int cols, int rows) {
        this.stage = stage;
        this.root = new VBox();
        this.cols = cols;
        this.rows = rows;
        this.stage.setResizable(false);
        this.stage.setResizable(false);

        Scene scene = new Scene(root, 500, 650);
        this.stage.setScene(scene);
        this.stage.setTitle("Juego");
        this.stage.show();

        this.game = new Game();
        game.startLevel(cols, rows, 4, 4);

        initializeMovementMap();
        setupKeyboard(scene);
        buildUI();
        startGameLoop();
    }

    private void setupKeyboard(Scene scene) {
        scene.setOnKeyPressed(event -> {
            activeKeys.add(event.getCode());
            handleMovement();
        });

        scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode()));
    }

    public void show() {
        buildUI();
    }

    private void updateScoreLabel() {
        int resources = game.getTotalScore();
        int level = game.getLevel();
        scoreLabel.setText("Score: " + resources + " | Nivel: " + level);
    }

    private void buildTopBar() {
        Label title = new Label("Robots");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        scoreLabel = new Label();
        scoreLabel.setStyle("-fx-font-size: 16px;");
        updateScoreLabel(); // Mostrar puntaje inicial

        topBar = new VBox(5, title, scoreLabel);
        topBar.setStyle("-fx-alignment: center; -fx-padding: 10;");
    }

    private Button createTeleportButton(String text, Runnable action) {
        Button btn = new Button(text);
        String style =
                "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-color: linear-gradient(to bottom, #61a2b1, #2A5058);" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-cursor: hand;";
        btn.setStyle(style);
        btn.setOnAction(e -> {
            action.run();
        });
        return btn;
    }

    private void showInfoAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void buildBottomBar() {
        Button tpRandomButton = createTeleportButton("TP-RANDOM", () -> {
            game.queuePlayerTeleport(TeleportType.RANDOM_TELEPORT);
            game.nextTurn();
            updateScoreLabel();
            checkGameOver();
        });

        Button tpSafeButton = createTeleportButton("TP-SAFE", () -> {
            if (game.getBoard().getPlayer().getSafeTeleports() > 0) {
                openTeleportSelection();
            } else {
                showInfoAlert("Teletransporte seguro", "No hay teletransportes seguros disponibles.");
            }
        });

        HBox bottomBar = new HBox(10, tpRandomButton, tpSafeButton);
        bottomBar.setStyle("-fx-alignment: center; -fx-padding: 10;");

        this.bottomBar = bottomBar;
    }

    private void buildUI() {
        refreshGameBoard();

        buildTopBar();
        buildBottomBar();

        root.getChildren().clear();
        root.getChildren().addAll(topBar, boardView, bottomBar);
    }

    private void openTeleportSelection() {
        boardView.setOnMouseClicked(event -> {
            int cols = (int) (event.getX() / boardView.getCellSize());
            int rows = (int) (event.getY() / boardView.getCellSize());

            Position targetPos = new Position(cols, rows);

            game.getBoard().getPlayer().teleportToPosition(game.getBoard(), targetPos);
            game.nextTurn();
            updateScoreLabel();
            checkGameOver();

            boardView.setOnMouseClicked(null);
        });
    }

    private void initializeMovementMap() {
        movementMap.put(MOVE_UP, Direction.UP);
        movementMap.put(MOVE_LEFT, Direction.LEFT);
        movementMap.put(MOVE_DOWN, Direction.DOWN);
        movementMap.put(MOVE_RIGHT, Direction.RIGHT);
        movementMap.put(MOVE_UP_LEFT, Direction.UP_LEFT);
        movementMap.put(MOVE_UP_RIGHT, Direction.UP_RIGHT);
        movementMap.put(MOVE_DOWN_LEFT, Direction.DOWN_LEFT);
        movementMap.put(MOVE_DOWN_RIGHT, Direction.DOWN_RIGHT);
    }

    private void handleMovement() {
        Direction direction = null;

        for (KeyCode keyCode : activeKeys) {
            direction = movementMap.get(keyCode);
            if (direction != null) break;
        }

        if (direction != null) {
            game.queuePlayerMove(direction);
            game.nextTurn();
            updateScoreLabel();
            checkGameOver();
        }
    }

    private void checkGameOver() {
        if (game.getState() == Game.State.GAME_OVER) {
            showGameOverScreen();
        } else if (game.getState() == Game.State.LEVEL_COMPLETED) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nivel completado");
            alert.setHeaderText(null);
            alert.setContentText("¡Ganaste el nivel!");
            alert.showAndWait();

            game.nextLevel(cols, rows, 4, 4);

            activeKeys.clear();

            refreshGameBoard();
            buildUI();
        }
    }

    private void showGameOverScreen() {
        if (showingGameOver) return;

        showingGameOver = true;

        GameOverScreen gameOverScreen = new GameOverScreen(() -> {
            game = new Game();
            game.startLevel(cols, rows, 4, 4);
            updateScoreLabel();
            showingGameOver = false;
            buildUI();
        });

        root.getChildren().clear();
        root.getChildren().add(gameOverScreen);

        VBox.setVgrow(gameOverScreen, javafx.scene.layout.Priority.ALWAYS);
    }

    private void refreshGameBoard() {
        if (boardView != null) {
            root.getChildren().remove(boardView);
        }

        BoardView newBoardView = new BoardView(game.getBoard());
        newBoardView.setWidth(500);
        newBoardView.setHeight(500);

        game.addObserver(newBoardView);
        boardView = newBoardView;

        if (root.getChildren().size() >= 2) {
            root.getChildren().add(1, boardView);
        } else {
            root.getChildren().add(boardView);
        }
    }

    private void startGameLoop() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(GAME_UPDATE_DELAY), event -> {
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}