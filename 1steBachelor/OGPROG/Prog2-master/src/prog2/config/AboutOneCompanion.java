/* AboutOneCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.config;

import java.io.IOException;
import java.util.Properties;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AboutOneCompanion  {
    
    public Label version;
    
    public Label email;

    public void initialize() throws IOException {
        Properties properties = new Properties();
        properties.load(AboutOneCompanion.class.getResourceAsStream("myapp.properties"));
        
        version.setText ("Versie " + properties.getProperty("version"));
        email.setText(properties.getProperty("sysadmin.email"));
    }
    
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void doClose () {
        stage.close();
    }
}
