package Oefeningen.VierOpEenRij;

import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * A cell is a blue square with an empty inner circle where a disc can be played to.
 */
public class Cell {

    /**
     * Create a new cell.
     * @param row the destination row
     * @return the new empty cell
     */
    public static Node create(int row) {

        // A circle is a hole which fits a played disc.
        Circle circ = new Circle(Config.getDiskRadius());
        circ.centerXProperty().set(Config.CELL_SIZE / 2);
        circ.centerYProperty().set(Config.CELL_SIZE / 2);
        circ.setFill(Color.TRANSPARENT);

        // A cell is a square minus the circle.
        Shape cell = Path.subtract(new Rectangle(Config.CELL_SIZE, Config.CELL_SIZE), circ);

        // Give the cell a blue plastic look.
        cell.setFill(Config.CELL_COLOR);
        cell.setOpacity(.8);

        // Create a bit of a shadow to suggest 3D.
        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(3.0);
        shadow.setOffsetX(3.0);
        shadow.setColor(Config.CELL_COLOR);
        cell.setEffect(shadow);
        cell.setCache(true);

        return cell;
    }
}