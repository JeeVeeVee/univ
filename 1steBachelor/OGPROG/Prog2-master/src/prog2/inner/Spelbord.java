/* Copyright © 2016 Universiteit Gent
 *
 * Bijlage bij het vak 'Programmeren 2'.
 *
 * Auteur: Kris Coolsaet
 */

package prog2.inner;

/**
 * Voorbeeld van een klasse met een (niet-statische) binnenklasse.
 */
public class Spelbord {

    // om echt bruikbaar te zijn, moeten er nog wel enkele velden en methodes aan de klasse worden
    // toegevoegd (en aan de binnenklasse)

    private int aantalRijen;

    private int aantalKolommen;

    public int getAantalRijen() {
        return aantalRijen;
    }

    public int getAantalKolommen() {
        return aantalKolommen;
    }

    public Spelbord(int aantalRijen, int aantalKolommen) {
        this.aantalRijen = aantalRijen;
        this.aantalKolommen = aantalKolommen;
    }

    public class Stuk {

        private int rij;

        private int kolom;

        public Stuk(int rij, int kolom) {
            this.rij = rij;
            this.kolom = kolom;
        }

        public void naarOnder () {
            if (rij + 1 < aantalRijen) {
                rij ++;
            }
        }

        public void naarRechts () {
            if (kolom + 1 < aantalKolommen) {
                kolom ++;
            }
        }
    }

    // voorbeeld van objectcreatie
    public void vulDiagonaal() {
        for (int i = 0; i < aantalKolommen && i < aantalRijen; i++) {
            new Stuk (i, i);
        }
    }

    // voorbeeld van objectreatie buiten de context van de buitenklasse
    public static void main(String[] args) {
        Spelbord spelbord = new Spelbord(8, 12);
        Stuk stuk = spelbord.new Stuk (3, 5);
    }

}

