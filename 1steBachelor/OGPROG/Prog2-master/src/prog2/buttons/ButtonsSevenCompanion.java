/* ButtonsSevenCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.buttons;

/**
 * Partnerklasse van {@code ButtonsSeven.fxml}
 */
public class ButtonsSevenCompanion {

    public PageButton minus1;

    public PageButton minus10;

    public PageButton plus1;

    public PageButton plus10;

    public PageLabel pageLabel;

    public PageModel model;

    public void initialize() {
        model = new PageModel();

        pageLabel.setModel(model);

        minus1.setModel(model);
        minus1.setIncrement(-1);
        minus10.setModel(model);
        minus10.setIncrement(-10);
        plus1.setModel(model);
        plus1.setIncrement(1);
        plus10.setModel(model);
        plus10.setIncrement(10);

        model.setNumber(1); // zorgt meteen voor het disablen/enablen van de juiste knoppen
    }
}
