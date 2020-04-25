
/**
 * Schaakstuk
 */
public class Stuk {

    /** Code die aangeeft over welk type schaakstuk het gaat:
     *  0: dame, 1: toren, 2: loper, 3: paard
     */
    private final int code;

    /**
     * De overeenkomstige code van dit stuk
     *  0: dame, 1: toren, 2: loper, 3: paard
     */
    public int getCode () {
        return code;
    }

    /**
     * Maak een stuk met een gegeven code.
     */
    public Stuk (int code) {
        this.code = code;
    }

    /** Rijpositie. */
    private int rij;

    /**
     * Rijpositie van dit stuk.
     */
    public int getRij () {
        return rij;
    }

    /**
     * Stel de rijpositie van dit stuk in.
     */
    public void setRij (int rij) {
        this.rij = rij;
    }

    /** Kolompositie. */
    protected int kolom;

    /**
     * Kolompositie van dit stuk.
     */
    public int getKolom () {
        return kolom;
    }

    /**
     * Stel de kolompositie van dit stuk in.
     */
    public void setKolom (int kolom) {
        this.kolom = kolom;
    }
}