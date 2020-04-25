/* FruitButton.java
 * ============================================================
 * Copyright (C) 2013-2014 Universiteit Gent
 * 
 * Opgeloste oefeningen bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.memory.v9;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 */
public class FruitButton extends Button implements EventHandler<ActionEvent> {

    private final ImageView selectedGraphic;

    private final ImageView unselectedGraphic;

    private final MemoryHandler memoryHandler;

    public FruitButton(ImageView selectedGraphic, ImageView unselectedGraphic, MemoryHandler memoryHandler) {
        super(null, unselectedGraphic);
        this.selectedGraphic = selectedGraphic;
        this.unselectedGraphic = unselectedGraphic;
        this.memoryHandler = memoryHandler;
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent t) {
        if (memoryHandler.clickEnabled()) {
            setGraphic(selectedGraphic);
            memoryHandler.buttonClicked(this);
        }
    }
    
    public Image getImage () {
        return selectedGraphic.getImage();
    }
    
    public void reset () {
        setGraphic(unselectedGraphic);
    }
    
    public void freeze () {
        setOnAction(null);
    }

}
