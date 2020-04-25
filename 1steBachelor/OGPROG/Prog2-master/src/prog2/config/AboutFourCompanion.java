/* AboutOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.config;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public class AboutFourCompanion {
    
    public Label version;
    
    public Label email;

    public void initialize() throws IOException {
        Properties properties = new Properties();
        properties.load(AboutFourCompanion.class.getResourceAsStream("myapp.properties"));
        
        version.setText ("Versie " + properties.getProperty("version"));
        email.setText(properties.getProperty("sysadmin.email"));
    }

    public void doClose () {
        Stage stage = (Stage)version.getScene().getWindow();
        stage.close ();
    }
}
