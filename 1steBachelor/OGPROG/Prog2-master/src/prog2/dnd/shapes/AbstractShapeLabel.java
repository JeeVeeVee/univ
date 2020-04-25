package prog2.dnd.shapes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Label waarmee een vorm kan worden getoond. Gemeenschappelijke bovenklasse van
 * {@link ShapeLabel} en {@link OverviewLabel}
 */
public abstract class AbstractShapeLabel extends Label {

    private double scale;

    protected ShapeDescription description;

    public static DataFormat CUSTOM_DESCRIPTION = new DataFormat("custom/description");

    protected void doDragDetected(MouseEvent event) {
        if (description != null) {
            Dragboard db = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.put(CUSTOM_DESCRIPTION, description);
            db.setContent(content);
            event.consume();
        }
    }

    public AbstractShapeLabel(double scale) {
        this.scale = scale;
        this.description = null;
        setGraphic(null);

        setMinWidth(scale * 60 + 15);
        setMinHeight(scale * 60 + 15);
        setAlignment(Pos.CENTER);
        setText(null);

        setOnDragDetected(this::doDragDetected);
        setOnDragDropped(this::doDragDropped);
        // Opmerking: on drag over is verschillend bij ShapeLabel en OverviewLabel
    }

    public void setShape(ShapeDescription description) {
        Shape node;
        double size = 60 * scale * description.getSize();
        switch (description.getType()) {
            case CIRCLE:
                node = new Circle(size/2);
                break;
            case SQUARE:
                node = new Rectangle(size, size);
                break;
            case TRIANGLE:
                node = new Polygon(
                    0.5*size, 0,
                        -0.25*size, Math.sqrt(0.1875)*size,
                        -0.25*size, -Math.sqrt(0.1875)*size
                );
                break;
            default:
                // this should not happen
                throw new IllegalArgumentException("Unknown shape type");

        }
        node.setFill(description.getColor());
        node.setStroke(Color.BLACK);
        node.setStrokeWidth(2.0*scale);
        setGraphic(node);
        setText(null);
    }


    private void doDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasContent(CommandLabel.CUSTOM_COMMAND)) {
            Command command = (Command) db.getContent(CommandLabel.CUSTOM_COMMAND);
            command.updateDescription(description);
            setShape(description);
            event.setDropCompleted(true);
        } else if (db.hasContent(CUSTOM_DESCRIPTION)) {
            this.description = (ShapeDescription) db.getContent(CUSTOM_DESCRIPTION);
            setShape(description);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }
}
