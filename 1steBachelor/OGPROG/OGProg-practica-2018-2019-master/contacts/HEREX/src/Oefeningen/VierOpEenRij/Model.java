package Oefeningen.VierOpEenRij;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulate the game rules and the current game state.
 * Allow clients to subscribe to important model changes.
 * Notify listeners when changes to the model occur.
 */
public class Model {

    private int[] aantallen;
    private boolean[][] geel;
    private boolean[][] rood;
    private boolean gameOver;

    //true voor geel, false voor rood
    private boolean beurt;

    public Model(){
        this.aantallen = new int[7];
        this.geel = new boolean[7][6];
        this.rood = new boolean[7][6];
        this.gameOver = false;
    }

    /*
     * If a new move causes the game to end then all listeners should be notified of this fact. You can use
     * {@link #notifyListeners} for this.
     */
    private void checkGameOver() {
        // TODO (step 3): implement this.
    }

    /**
     * Check if a new disc can be inserted in the current column. Note that this is only
     * a check and the disc should not yet be played. See also {@link #playMove}
     * @param column
     * @return true if and only if a move in this column is allowed.
     */
    public boolean isPlayableMove(int column) {
        // TODO: Check if this move is playable.
        assert this.gameOver == false;
        // TODO (step 3) No moves are allowed when the game is over.
        return this.aantallen[column] < 6;
    }

    /**
     * Compute the final destination row of a candidate move.
     * @param column The column in which a disc is going to be played.
     * @return The row where the disc will eventually be stored.
     */
    public int moveDestination(int column) {
        // TODO: implement this method properly.
        return 5 - this.aantallen[column];

    }

    /**
     * A new move is committed to the model when the move animation has ended.
     * Commit the insertion of a new disc in a given column and update game state.
     * @param column The column in which a new disc has been inserted.
     */
    public void playMove(int column) {
        // TODO: Verify the following preconditions:
        // assert (isGameOver() == false);
        // assert (isPlayableMove(column) == true);

        // TODO: Update the model to reflect the new move.
        this.aantallen[column]++;
        if (beurt){
            this.geel[this.aantallen[column] - 1][column] = true;
            System.out.print(this.aantallen[column] - 1);
            System.out.print(", ");
            System.out.println(column);
        } else {
            this.rood[this.aantallen[column] - 1][column] = true;
            System.out.print(this.aantallen[column] - 1);
            System.out.print(", ");
            System.out.println(column);
        }
        // TODO (step 3): Also check for termination conditions.

        // TODO (step 3): Maybe notify listeners about important model changes.
        notifyListeners(false);
    }


    // The code below manages listeners. You can use these methods, but do not
    // modify the code
    //

    // List of all registered listeners
    List<GameOverListener> listeners = new ArrayList<>();

    /**
     * Registers a listener which should be notified whenever the game is finished
     */
    public void addListener (GameOverListener listener) {
        listeners.add(listener);
    }

    /**
     * Notify all registered listeners that the game is finished
     * @param winner indicates whether there was a winner (if true) or the game simply ended
     *               because the board is full
     */
    public void notifyListeners (boolean winner) {
        for (GameOverListener listener : listeners) {
            listener.gameOver(winner);
        }
    }

}
