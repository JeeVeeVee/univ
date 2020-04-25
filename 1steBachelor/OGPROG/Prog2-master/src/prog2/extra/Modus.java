/* Modus.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */
package prog2.extra;

import java.util.List;

/**
 * Voorbeeld van een opsomtype waarin de elementen een verschillend gedrag
 * vertonen.
 */
public enum Modus {

    INVOEGEN {
        public void aanpassen(List<Persoon> lijst, int index, Persoon persoon) {
            lijst.add(index, persoon);
        }
    },

    OVERSCHRIJVEN {
        public void aanpassen(List<Persoon> lijst, int index, Persoon persoon) {
            lijst.set(index, persoon);
        }
    };

    public abstract void aanpassen(List<Persoon> lijst, int index, Persoon persoon);
}
