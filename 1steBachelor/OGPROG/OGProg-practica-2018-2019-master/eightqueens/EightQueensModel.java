package eightqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Model voor deze toepassing. Bevat alle gegevens die nodig zijn om het bord te kunnen afbeelden.
 */
public class EightQueensModel {

    /*
     * Intern bijgehouden gegevens
     */

    // keeps track of where the queens are placed
    private boolean[][] hasQueen = new boolean[8][8];

    // keeps track of the number of times a field i threatened
    private int[][] threatened = new int[8][8];


    /*
     * Onderstaande methoden worden gebruikt door luisteraars om te weten  hoe het bord eruit ziet
     */

    /**
     * Staat er een dame op de gegeven positie?
     */
    public boolean hasQueen (int row, int column) {
        return hasQueen[row][column];
    }

    /**
     * Wordt de gegeven positie bedreigd?
     */
    public boolean isThreatened (int row, int column) {
        return threatened[row][column] != 0;
    }

    /*
     * Onderstaande methoden worden gebruik om het bord te veranderen
     */


    /**
     * Als er een dame staat op de gegeven positie, verwijder ze dan,
     * anders, als er nog geen dame staat en de plaats is niet bedreigd,
     * plaats een dame
     */
    public void toggleQueen(int row, int column) {
        if (hasQueen[row][column]) {
            hasQueen[row][column] = false;
            for (int i = 0; i < 8; i++) {
                threatened[i][column] --;
                threatened[row][i] --;
                if (row+column >= i && row + column < i+ 8) {
                    threatened[i][row + column - i]--;
                }
                if (column + i >= row && column + i < row+ 8) {
                    threatened[i][column - row + i]--;
                }
            }
            fireModelChanged();
        } else if (threatened[row][column] == 0){
            hasQueen[row][column] = true;
            for (int i = 0; i < 8; i++) {
                threatened[i][column] ++;
                threatened[row][i] ++;
                if (row+column >= i && row + column < i+ 8) {
                    threatened[i][row + column - i]++;
                }
                if (column + i >= row && column + i < row+ 8) {
                    threatened[i][column - row + i]++;
                }
            }
            fireModelChanged();
        }
    }


    public void cleanAll () {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                threatened[i][j] = 0;
                hasQueen[i][j] = false;
            }
        }
        fireModelChanged();
    }

    /*
     * Listeners
     */

    //
    private List<EightQueensListener> listeners = new ArrayList<>(64);

    public void registerListener(EightQueensListener listener) {
        listeners.add(listener);
    }

    private void fireModelChanged() {
        for (EightQueensListener listener : listeners) {
            listener.modelHasChanged();
        }
    }
}
