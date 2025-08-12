package game;

import game.View.MenuScreen;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        new MenuScreen(primaryStage).show();
    }

}