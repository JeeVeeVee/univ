package prog2.contacts.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * Gemeenschappelijke bovenklasse voor de twee 'knop'cellen
 */
public abstract class ButtonCell<T> extends TableCell<T,Integer> implements EventHandler<ActionEvent> {

    protected Button button;

    public ButtonCell() {
        this.button = new Button ("");
        setText("");
        button.setOnAction(this);
    }

    @Override
    protected void updateItem(Integer id, boolean empty) {
        super.updateItem(id, empty);
        if (empty) {
            setGraphic (null);
        } else {
           setGraphic(button);
        }
    }
}
