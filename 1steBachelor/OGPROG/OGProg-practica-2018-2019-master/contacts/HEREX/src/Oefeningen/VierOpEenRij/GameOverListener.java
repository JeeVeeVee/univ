package Oefeningen.VierOpEenRij;

/**
 * This interface is implemented by all objects that would like to know when the game is over.
 */
public interface GameOverListener {

    /**
     * Called by the game to indicate that the game is over.
     * @param winner true when there is a winner, false if the game stopped because the board is full
     */
    void gameOver(boolean winner);

}