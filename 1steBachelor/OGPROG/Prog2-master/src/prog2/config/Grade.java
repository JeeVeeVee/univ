/* Grade.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.config;

/**
 * Bevat informatie over één graad.
 */
public class Grade {

    public Grade(String name, int points, String code) {
        this.name = name;
        this.points = points;
        this.code = code;
    }

    private String name;

    public String getName() {
        return name;
    }

    private int points;

    public int getPoints() {
        return points;
    }

    private String code;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Grade [" + name + ',' + points + ',' + code + ']';
    }
}
