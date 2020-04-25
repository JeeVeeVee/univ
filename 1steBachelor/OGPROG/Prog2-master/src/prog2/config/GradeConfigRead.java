/* GradeConfigRead.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.config;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstreert hoe het bestand {@code gradeConfig.xml} wordt ingelezen en verwerkt door
 * JDOM.
 */
public class GradeConfigRead {

    /**
     * Leest het XML-bestand in, zet het om naar een lijst van {@link Grade}-objecten en drukt
     * deze lijst af.
     */
    public static void main(String[] args) throws IOException, JDOMException {

        Element grades = new SAXBuilder().build(GradeConfigRead.class.getResource("gradeConfig.xml")).getRootElement();
        List<Grade> list = grades.getChildren("grade").stream().map(element ->
                new Grade(
                        element.getChild("name").getTextNormalize(), //
                        // Integer.parseInt(element.getChild("points").getTextNormalize()),
                        Integer.parseInt(element.getChildTextNormalize("points")),
                        element.getAttributeValue("code")
                )).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
