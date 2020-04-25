/* LottoGenerator.java
 * ============================================================
 * Copyright (C) 2012-2013 Universiteit Gent
 * 
 * Bijlage bij het vak 'Programmeren 2'.
 * 
 * Auteur: Kris Coolsaet
 */

package prog2.quickpick;

import java.util.Arrays;
import java.util.Random;

/**
 * Kan gebruikt worden om willekeurige lottocijfers te genereren.
 */
public class LottoGenerator {
    
    private Random randomGenerator;
    
    private int[] base;

    public LottoGenerator() {
        randomGenerator = new Random();
        base = new int[45];
        for (int i = 0; i < base.length; i++) {
            base[i] = i+1;
        }
    }
    
    /**
     * This is the Fisher-Yate shuffle
     */
    private void shuffle () {
        for (int i = 44; i >= 0; i--) {
            int j = randomGenerator.nextInt(i+1);
            int tmp = base[i];
            base[i] = base[j];
            base[j] = tmp;
        }
    }
    
    
    
    /**
     * Genereert 6 verschillende lottocijfers tuseen 1 en 45, in numerieke volgorde.
     */
    public int[] generateNumbers () {
        shuffle ();
        int[] result = Arrays.copyOf (base, 6);
        Arrays.sort (result);
        return result;
    }
    
}
