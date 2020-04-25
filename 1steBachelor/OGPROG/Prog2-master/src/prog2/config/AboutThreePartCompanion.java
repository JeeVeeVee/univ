/* AboutTwoCompanion.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.config;

import javafx.scene.control.Label;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;

public class AboutThreePartCompanion {

    public Label version;
    public Label email;

    public void initialize() throws JDOMException, IOException {

        Document document = new SAXBuilder().build(AboutTwoCompanion.class.getResourceAsStream("applicationConfig.xml"));
        Element element = document.getRootElement();

        version.setText("Versie " + element.getAttributeValue("version"));
        email.setText(element.getChild("sysAdminEmail").getText());
    }

}
