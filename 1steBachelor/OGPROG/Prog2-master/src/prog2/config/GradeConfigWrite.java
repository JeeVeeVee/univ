/* GradeConfigWrite.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.config;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Demonstreert hoe een XML-bestand kan worden uitgeschreven met behulp van JDOM.
 */
public class GradeConfigWrite {

    public static void main(String[] args) {

        try (Writer writer = Files.newBufferedWriter(Paths.get("out/gradesOut.xml"))) {
            // maak het JDOM-document
            Element root = new Element("grades");
            for (Grade grade : Grades.getAllGrades()) {
                Element element = new Element("grade")
                        .addContent(new Element("name").setText(grade.getName()))
                        .addContent(new Element("points").setText("" + grade.getPoints()))
                        .setAttribute("code", grade.getCode());
                root.addContent(element);
            }
            Document document = new Document(root);

            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat()); // maakt resultaat 'human readable'
            outputter.output(document, writer);

        } catch (IOException ex) {
            System.err.println("Kon het uitvoerbestand niet aanmaken");
        }

    }
}
