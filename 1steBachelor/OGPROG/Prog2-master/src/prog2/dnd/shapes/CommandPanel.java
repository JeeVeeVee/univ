package prog2.dnd.shapes;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class CommandPanel extends GridPane {

    public CommandPanel() {

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);

        Shape graphic = new Rectangle(60, 60);
        adjustGraphic(graphic);
        add(new CommandLabel ("Vierkant", graphic, new ShapeCommand(ShapeType.SQUARE)), 0, 0);

        graphic = new Circle(30);
        adjustGraphic(graphic);
        add(new CommandLabel ("Cirkel", graphic, new ShapeCommand(ShapeType.CIRCLE)), 1, 0);

        graphic = new Polygon(30,0,-15,26.6,-15,-26.6);
        adjustGraphic(graphic);
        add(new CommandLabel ("Drieh.", graphic, new ShapeCommand(ShapeType.TRIANGLE)), 2, 0);

        graphic = new Rectangle(60, 60);
        adjustGraphic(graphic);
        add(new CommandLabel ("Groot", graphic, new SizeCommand(1.0)), 3, 0);

        graphic = new Rectangle(30, 30);
        adjustGraphic(graphic);
        add(new CommandLabel ("Klein", graphic, new SizeCommand(0.5)), 4, 0);

        graphic = new Rectangle(60, 60);
        graphic.setFill(Color.PINK);
        add(new CommandLabel ("Roze", graphic, new ColorCommand(Color.PINK)), 5, 0);

        graphic = new Rectangle(60, 60);
        graphic.setFill(Color.ORANGE);
        add(new CommandLabel ("Oranje", graphic, new ColorCommand(Color.ORANGE)), 6, 0);

        graphic = new Rectangle(60, 60);
        graphic.setFill(Color.MEDIUMPURPLE);
        add(new CommandLabel ("Paars", graphic, new ColorCommand(Color.MEDIUMPURPLE)), 7, 0);
    }

    private void adjustGraphic(Shape graphic) {
        graphic.setStrokeWidth(2.0);
        graphic.setStroke(Color.BLACK);
        graphic.setFill(Color.TRANSPARENT);
    }
}
