package prog2.dnd.shapes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.*;

public class CommandLabel extends Label {

    private Command command;

    public static DataFormat CUSTOM_COMMAND = new DataFormat("custom/command");

    private void doDragDetected(MouseEvent event) {
        Dragboard db = startDragAndDrop(TransferMode.COPY_OR_MOVE);
        ClipboardContent content = new ClipboardContent();
        // om te testen:
        // content.putString(command.toString());
        content.put(CUSTOM_COMMAND, command);
        db.setContent(content);
        event.consume();
    }

    public CommandLabel(String text, Node graphic, Command command) {
        super(text, graphic);
        this.command = command;
        setAlignment(Pos.BOTTOM_CENTER);
        setContentDisplay(ContentDisplay.TOP);
        setMinHeight(100);
        setMinWidth(70);

        setOnDragDetected(this::doDragDetected);

    }
}
