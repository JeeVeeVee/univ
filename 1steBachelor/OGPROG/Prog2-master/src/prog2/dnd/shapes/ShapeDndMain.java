package prog2.dnd.shapes;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShapeDndMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent pane = new CommandPanel();
        stage.setTitle("Opdrachten");
        stage.setScene(new Scene(pane));
        stage.setX(20);
        stage.setY(20);
        stage.show();

        Stage shapeWindow = new Stage();
        shapeWindow.setScene(new Scene(new ShapeLabel(3)));
        shapeWindow.initOwner(stage);
        shapeWindow.setTitle("Vorm");
        shapeWindow.setX(stage.getX() + stage.getWidth() + 60);
        shapeWindow.setY(stage.getY());
        shapeWindow.show();

        Stage overviewWindow = new Stage();
        overviewWindow.setScene(new Scene(new OverviewPanel()));
        overviewWindow.initOwner(stage);
        overviewWindow.setX(stage.getX());
        overviewWindow.setY(stage.getY() + 150.0);
        overviewWindow.setTitle("Overzicht");
        overviewWindow.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
