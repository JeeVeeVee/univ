/* BoundRectangleCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.bindings;

import javafx.beans.binding.Bindings;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;

/**
 * Partnerklasse voor {@code BoundRectangle.fxml}
 */
public class BoundRectangleCompanion {
    
    public Slider width;
    
    public Slider height;

    public CheckBox isSquare;
    
    public Rectangle rectangle;

    public void initialize() {
        rectangle.heightProperty().bind (height.valueProperty());
        rectangle.widthProperty().bind (width.valueProperty());

        isSquare.selectedProperty().bind (
                Bindings.equal(height.valueProperty(), width.valueProperty())
        );
    }    
}
