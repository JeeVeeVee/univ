package Oefeningen.NietZo;

import java.util.ArrayList;

/**
 * Deze klasse bevat een aantal methoden waarvan
 * de implementatie hier en daar toch nog te wensen overlaat.
 *
 * Herschrijf deze methoden zodat ze nog steeds werken, maar dan
 * op een 'mooiere' manier.
 */
public class NietZo {

    /**
     * Is een getal even of niet?
     */
    public boolean isEven(int getal){
        return getal % 2 == 0;
    }

    /**
     * Drukt de rij 1 2 3 4 5 6 7 8 9 10 9 8 7 6 5 4 3 2 1 af
     */
    public void opEnAf(){
       for(int i = 0; i < 10; i++){
           System.out.print(i + 1);
           System.out.print(" ");
       }
        System.out.print(10);
       for(int i = 10; i > 0; i--){
           System.out.print(i);
       }
    }

    /**
     * Druk de cijfers van een getal af, in leesbare vorm, van achter naar voor
     */
    public void cijfers (int getal) {
        if (getal < 0) {
            getal = - getal;
        }
        for (int i=0; i < 100; i++) {
            int cijfer = getal % 10;
            if (getal == 0 && i > 0) {
                i = 100; // we mogen stoppen, maar we moeten wel minstens
                // één cijfer afdrukken - ons startgetal kan nul zijn!
            }
            if (getal != 0 || i <= 0) {
                getal /= 10;
                if (cijfer == 0) {
                    System.out.println ("nul");
                } else if (cijfer == 1) {
                    System.out.println ("één");
                } else if (cijfer == 2) {
                    System.out.println ("twee");
                } else if (cijfer == 3) {
                    System.out.println ("drie");
                } else if (cijfer == 4) {
                    System.out.println ("vier");
                } else if (cijfer == 5) {
                    System.out.println ("vijf");
                } else if (cijfer == 6) {
                    System.out.println ("zes");
                } else if (cijfer == 7) {
                    System.out.println ("zeven");
                } else if (cijfer == 8) {
                    System.out.println ("acht");
                } else if (cijfer == 9) {
                    System.out.println ("negen");
                }
            }
        }
    }

    /**
     * Bepaal de positie van een gegeven waarde in een gegeven tabel. Geef
     * -1 terug als de waarde zich niet in de tabel bevindt.
     */
    public int indexOf(double tabel[],double waarde) {
        for(int m=1;m<=tabel.length;m++) {
            if(waarde==tabel[m-1]) {
                return m-1;
            }
        }
        return -1;
    }

    /**
     * Druk een lijst van strings af, gescheiden door komma's
     */
    public void printLijst(ArrayList<String> lijst) {
        for(int m=0;m<lijst.size();m++) {
            System.out.print(lijst.get(m));
            if(m+1<lijst.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Ga na hoever je een tabel van getallen moet overlopen vooraleer
     * de cumulatieve som van de absolute waarden een bepaalde drempel
     * overschrijdt.
     */
    public int maxAbsSomLengte(double[] tabel, double drempel) {
        double som=0.0;
        for(int m=0;m<tabel.length;m++)
        {
            if(tabel[m]>0) {
                som+=tabel[m];
            } else if(tabel[m]<0) {
                som-=tabel[m];
            } else { //element is nul, draagt niets bij aan som dus controleer niet
                continue; // gaat direct verder met de volgende stap van de lus - mag in dit vak niet gebruikt worden!
            }
            if(som>drempel) {
                return m;
            }
        }
        return tabel.length;
    }

    /**
     * Zoek het eerste negatieve getal in de tabel en geef dit terug.
     * Geef anders 0 terug.
     */
    public int eersteNegatief (int[] tab) {
        for (int getal: tab) {
            if (getal < 0) {
                return getal;
            }
        }
        return 0;
    }

    /**
     * Kijkt of het gegeven jaartal een schrikkeljaar voorstelt.
     */
    public void schrikkeljaar(int jaar) {
        if (jaar % 400 == 0) {
            System.out.println("Schrikkeljaar");
        } else {
            if (jaar % 100 == 0) {
                System.out.println("Geen schrikkeljaar");
            } else {
                if (jaar % 4 == 0) {
                    System.out.println("Schrikkeljaar");
                } else {
                    System.out.println("Geen schrikkeljaar");
                }
            }
        }
    }

    /**
     * Drukt af hoeveel keer 'stuk' voorkomt in 'tekst' zonder te overlappen.
     * Bijvoorbeeld: "gtg" komt "cgtcattcgtgtgtgagtg" drie keer voor, zonder overlappen.
     */
    public void herhalingen(String stuk, String tekst){
        int aantal = 0;

        for(int p = tekst.indexOf(stuk); p!=-1; p = tekst.indexOf(stuk, p)){
            aantal++;
            p += stuk.length();
        }

        System.out.println(stuk + " komt (zonder overlappingen) " + Integer.toString(aantal) + " keer voor in " + tekst);
    }


}
