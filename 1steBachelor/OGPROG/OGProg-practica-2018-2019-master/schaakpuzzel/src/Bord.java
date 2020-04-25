/**
 * Schaakbord met stukken.
 */
public class Bord {

    /** De 64 stukken. */
    private final Stuk[][] stukken = new Stuk[8][8];

    /**
     * De overeenkomstige letter voor het gegeven stuk.
     */
    public char letterVoorStuk (Stuk stuk) {
        int code = stuk.getCode();
        if (code == 0) {
            return 'D';
        } else if (code == 1) {
            return 'T';
        } else if (code == 2) {
            return 'L';
        } else { // code == 3
            return 'P';
        }
    }

    /**
     * String-representatie van een bord.
     */
    public String toString () {
        String str = "\n";
        for (int rij = 7; rij >= 0; rij--) {
            str += rij + 1 + " ";
            for (int kol = 0; kol < 8; kol++) {
                str += " ";
                if (stukken[rij][kol] != null)
                    str += letterVoorStuk (stukken[rij][kol]);
                else if ((rij + kol) % 2 == 0)
                    str += " ";
                else
                    str += ".";
            }
            str += "\n";
        }
        str += "   a b c d e f g h\n";
        return str;
    }

    /**
     * Plaats het gegeven stuk op de gegeven plaats op het bord.
     */
    public void zet (Stuk stuk) {
        stukken[stuk.getRij ()][stuk.getKolom ()] = stuk;
    }
    
    /**
     * Kijkt of het gegeven stuk de gegeven positie bedreigt
     */
    private boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom) {
        int code = stuk.getCode();
        if (code == 0) {  // dame
           return
               stuk.getRij() == rij || stuk.getKolom() == kolom || 
               stuk.getRij() + stuk.getKolom() == rij + kolom || 
               stuk.getRij() + kolom == rij + stuk.getKolom();            
        } else if (code == 1) { // toren
           return 
               stuk.getRij() == rij || stuk.getKolom() == kolom;            
        } else if (code == 2) { // loper
           return
               stuk.getRij() + stuk.getKolom() == rij + kolom || 
               stuk.getRij() + kolom == rij + stuk.getKolom();                
        } else { // paard
            int dr = stuk.getRij() - rij;
            int dk = stuk.getKolom() - kolom;
            return dr * dr + dk * dk == 5;  // [!] wiskundig truukje
        }        
    }

    /**
     * Is dit een geldige plaats voor het gegeven stuk? M.a.w., wordt het 
     * niet door een ander stuk op het bord bedreigd of bedreigt het niet
     * zelf een ander stuk?
     */
    public boolean geldigePlaatsVoor (Stuk stuk) {
        int rij = stuk.getRij ();
        int kol = stuk.getKolom ();
        if (stukken[rij][kol] != null) {
            return false;  // plaats reeds bezet
	}
        for (int r = 0; r < 8; r++) {
            for (int k = 0; k < 8; k++) {
                if (stukken[r][k] != null) {
                    if (stukBedreigtPositie (stukken[r][k], rij, kol) || 
			stukBedreigtPositie (stuk, r, k)) {
                        return false;
		    }
		}
	    }
	}
        return true;
    }
}
