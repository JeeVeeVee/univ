/* Copyright © 2016 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.inner;

import java.util.List;

/**
 * Versie van {@link MijnKlasse1} met een DTO-klasse met publieke velden.
 */
public class MijnKlasse2 {

    public static class Resultaat {
        public double som;
        public int aantal;
    }

    public Resultaat mijnFunctie(List<Double> lijst) {
        Resultaat r = new Resultaat();
        for (double element : lijst) {
            if (element >= 0.0) {
                r.som += Math.sqrt(element);
            } else {
                r.aantal++;
            }
        }
        return r;
    }

}

