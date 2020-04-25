package prog2.proglangs;

import java.util.Collection;

/**
 * Data access object waarmee programmertaalvoorkeuren van en naar de databank
 * kunnen worden getransfereerd
 */
public interface DAO {

    /**
     * Haalt de huidige voorkeuren op
     */
    Collection<Preference> getAllPreferences ();

    /**
     * Past de huidige voorkeuren aan
     */
    void updateAllPreferences (Iterable<Preference> prefs);

    /**
     * DTO met voorkeuren
     */
    class Preference {
        public String name;
        public boolean checked;
    }


}
