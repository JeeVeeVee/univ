package Oefeningen.ContactsGUI;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ButtonCell<S, P> extends TableCell<S, ImageButton> {
    private ImageButton button;

    public ButtonCell(String picture){
        this.button = new ImageButton();
        try {
            this.button.updateImages(new Image(new FileInputStream(new File(picture))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setGraphic(button);
    }

    @Override
    public void updateItem(ImageButton item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(button);
        }
    }

    public ImageButton getButton(){
        return this.button;
    }
}
