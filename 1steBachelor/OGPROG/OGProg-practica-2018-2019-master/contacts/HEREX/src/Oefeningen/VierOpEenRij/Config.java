package Oefeningen.VierOpEenRij;

import javafx.scene.paint.Color;
import javafx.stage.Screen;

/**
 * Configurable global settings.
 */
public class Config {
    // Configurable strings

    public static final String GAME_TITLE = "Vier op een rij";

    // Board dimensions in cells.
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    // Dimension in pixels of a single board square.
    public static final int CELL_SIZE = 100;

    // Cell color
    public static final Color CELL_COLOR = Color.BLUE;

    // The time for one animation in milliseconds

    public static final int ANIMATION_TIME = 1000;

    public static int getDiskRadius() {
        return CELL_SIZE / 2 - 3;
    }

    public static int getSceneWidth() {
        return (NUM_COLUMNS + 2) * CELL_SIZE;
    }

    public static int getSceneHeight() {
        return (NUM_ROWS + 2) * CELL_SIZE;
    }
}