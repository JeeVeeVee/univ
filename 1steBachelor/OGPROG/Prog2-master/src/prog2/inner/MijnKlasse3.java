package prog2.inner;

import java.util.List;

/**
 * Biedt dezelfde functionaliteit als {@link MijnKlasse1} maar zonder binnenklasse. Gebruikt
 * een set/compute/get-cyclus
 */
public class MijnKlasse3 {

    private List<Double> lijst;

    public MijnKlasse3 () {
        lijst = null;
    }

    private double som;
    private int aantal;

    public void setLijst(List<Double> lijst) {
        this.lijst = lijst;
        this.som = 0.0;
        this.aantal = -1; // geeft aan dat compute nog niet werd opgeroepen
    }

    public double getSom() {
        if (aantal < 0) {
            throw new IllegalStateException("Roep compute of vóór getSomVanWortels");
        }
        return som;
    }

    public int getAantalNegatief() {
        if (aantal < 0) {
            throw new IllegalStateException("Roep compute of vóór getAantalNegatief");
        }
        return aantal;
    }

    public void compute () {
        if (lijst == null) {
            throw new IllegalStateException("Roep setLijst op vóór compute");
        }

        aantal = 0;
        som = 0.0;
        for (double element : lijst) {
            if (element >= 0.0) {
                som += Math.sqrt(element);
            } else {
                aantal++;
            }
        }

    }
}
