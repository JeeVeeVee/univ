package Oefeningen.VierOpEenRij;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

/**
 * The game "Vier-op-een-rij" in JavaFX.
 */
public class VierOpRij extends Application {

    /**
     * Create the GUI for the game
     * @param stage
     */
    @Override
    public void start(Stage stage) {

        // The model implements the game rules.
        Model model = new Model();

        // A board is a two-dimensional grid of cells.
        Board board = new Board(model);
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(board);
        Scene scene = new Scene(rootPane, Config.getSceneWidth(), Config.getSceneHeight());
        scene.getStylesheets().add("vieroprij/styles.css");
        scene.setFill(Color.BLACK);

        // Make everything visible on the screen.
        stage.setScene(scene);
        stage.setTitle(Config.GAME_TITLE);
        stage.setResizable(false);
        stage.show();

        // Wait for the game to end.
        // TODO
        model.addListener(winner -> gameOverHandler(winner, rootPane));
    }

    /**
     * Receive notifications for game-over
     */
    private void gameOverHandler(boolean winner, BorderPane rootPane) {
        // Present a nice message when the game has ended.
        Text text = new Text(winner ? " You won! Game over " : " There is no winner ?? ");
        rootPane.setBottom(text);
    }

    /**
     * Entrypoint to the application: start JavaFX.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
