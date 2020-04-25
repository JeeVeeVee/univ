/* FruitPane.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.memory.v7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 */
public class FruitPane extends GridPane {

    public static final Image UNKNOWN_IMAGE = new Image("/prog2/memory/images/unknown.png");

    private static final String[] IMAGE_NAMES = {
        "aardbei",
//        "ajuin",
//        "ananas",
        "appel",
//        "asperge",
        "banaan",
//        "broccoli",
        "druiven",
        "framboos",
        "kiwi",
//        "mais",
//        "meloen",
        "peer",
//        "peper",
//        "perzik",
//        "pickle",
        "pompelmoes",
//        "tomaat",
//        "watermeloen",
//        "wortel",
    };
    
    private final MemoryHandler memoryHandler = new MemoryHandler ();

    class ButtonHandler implements EventHandler<ActionEvent> {
        
        private final ImageView selectedGraphic;

        public ButtonHandler(Image fruitImage) {
            this.selectedGraphic = new ImageView (fruitImage);
        }

        @Override
        public void handle(ActionEvent t) {
            Button button = (Button) t.getSource();
            if (memoryHandler.clickEnabled()) {
                button.setGraphic(selectedGraphic);
                memoryHandler.buttonClicked(button);
            }
        }

    }

    public FruitPane() {
        
        assert IMAGE_NAMES.length == 8;
        
        List<Image> buttonImages = new ArrayList<> ();
        for (int i = 0; i < 8; i++) {
            Image image = new Image("/prog2/memory/images/" + IMAGE_NAMES[i] + ".png");
            buttonImages.add(image);
            buttonImages.add(image);
        }
        
        Collections.shuffle(buttonImages);
        
        for (int row = 0, count = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++, count++) {
                Button button = new Button(null, new ImageView(UNKNOWN_IMAGE));
                button.setOnAction(new ButtonHandler(buttonImages.get(count)));
                add(button, column, row);
            }
        }
    }

}
