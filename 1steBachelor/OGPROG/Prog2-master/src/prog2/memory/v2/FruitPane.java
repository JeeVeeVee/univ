/* FruitPane.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.memory.v2;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 */
public class FruitPane extends GridPane {

    public FruitPane() {
        Image unknownImage = new Image("/prog2/memory/images/unknown.png");
        Image fruitImage = new Image("/prog2/memory/images/aardbei.png");

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                Button button = new Button(null, new ImageView(unknownImage));
                button.setOnAction(t -> button.setGraphic(new ImageView(fruitImage)));
                add(button, column, row);
            }
        }
    }

}
