package Oefeningen.ContactsGUI;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageButton extends Button {
    public void updateImages(Image selected) {
        ImageView iv = new ImageView(selected);
        super.setGraphic(iv);
    }
}
