package prog2.contacts;

import prog2.contacts.gui.ErrorAlert;

/**
 * Gemeenschappelijke bovenklasse van de partnerklassen. Bevat een methode om een foutboodschap
 * te tonen aan de gebruiker.
 */
public class DatabaseCompanion {

    protected void signalError () {
        new ErrorAlert("database.error").showAndWait();
    }
}
