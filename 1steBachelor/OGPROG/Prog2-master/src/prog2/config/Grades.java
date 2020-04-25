/* Grades.java
 * ============================================================
 * Copyright (C) 2015 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Demonstreert hoe objecten van het type {@link Grade} kunnen worden ingelezen
 */
public final class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    Grades {

    /**
     * Leest de inhoud van het bestand grades.properties en zet dit om in een
     * lijst van graden
     */
    public static List<Grade> getAllGrades() {

        List<Grade> result = new ArrayList<>();
        try {
            Properties properties = new Properties();
            properties.load(Grades.class.getResourceAsStream("grades.properties"));

            int count = 1;
            String prefix = "grade." + count + ".";
            String code = properties.getProperty(prefix + "code");
            while (code != null) {
                Grade grade = new Grade(
                        properties.getProperty(prefix + "name"),
                        Integer.parseInt(properties.getProperty(prefix + "points")),
                        code);
                result.add(grade);
                count++;
                prefix = "grade." + count + ".";
                code = properties.getProperty(prefix + "code");
            }

        } catch (IOException e) {
            // negeer de uitzondering en geef dus terug wat er tot nog toe
            // in de lijst zit
        }
        return result;
    }

    /**
     * Leest het properties-bestand in en schrijft de inhoud op het scherm.
     */
    public static void main(String[] args) {
        for (Grade grade : getAllGrades()) {
            System.out.println(grade);
        }
    }
}
