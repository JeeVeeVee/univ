package prog2.dnd.shapes;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class ShapeDescription implements Serializable {

    private static final long serialVersionUID = -5164756040052797483L;

    private ShapeType type;

    // Onderstaande werkt niet omdat de klasse Color niet serialiseerbaar is
    //private Color color;

    // Dus gebruiken we in de plaats de drie  RGB-componenten
    private double red;
    private double green;
    private double blue;

    private double size;

    public Color getColor() {
        return Color.color(red, green, blue);
    }

    public void setColor(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    public ShapeDescription(ShapeType type, Color color, double size) {
        this.type = type;
        setColor(color);
        this.size = size;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
