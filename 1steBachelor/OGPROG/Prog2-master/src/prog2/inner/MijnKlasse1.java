/* Copyright © 2016 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */
package prog2.inner;

import java.util.List;

/**
 * Voorbeeld van een statische binnenklasse die een data transfer object voorstelt
 */
public class MijnKlasse1 {

    public static class Resultaat {

        private double som;

        private int aantal;

        public Resultaat(double som, int aantal) {
            this.som = som;
            this.aantal = aantal;
        }

        public double getSom() {
            return this.som;
        }

        public int getAantal() {
            return this.aantal;
        }
    }

    public Resultaat mijnFunctie(List<Double> lijst) {
        int aantal = 0;
        double som = 0.0;
        for (double element : lijst) {
            if (element >= 0.0) {
                som += Math.sqrt(element);
            } else {
                aantal++;
            }
        }
        return new Resultaat(som, aantal);
    }

}

