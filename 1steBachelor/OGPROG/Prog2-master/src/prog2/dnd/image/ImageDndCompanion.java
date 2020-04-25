package prog2.dnd.image;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageDndCompanion {

    public Label label;

    public Parent parent;

    private void fileToImage(File file) {
        try (InputStream is = new FileInputStream(file)) {
            Image image = new Image(is);
            label.setGraphic(new ImageView(image));
            label.setText(null);
        } catch (Exception ex) {
            // this should not happen
        }
    }

    public void initialize() {

        parent.setOnDragOver(event -> {
            if (event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
                event.consume();
            }
        });

        parent.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                fileToImage(db.getFiles().get(0));
            }
            event.setDropCompleted(true);
            event.consume();
        });

    }
}
