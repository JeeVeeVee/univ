package vieroprij;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Manage a playing board with a grid of cells.
 */
public class Board extends GridPane {

    // Player colors
    private static final Color[] COLORS = {Color.YELLOW, Color.RED};

    private int currentPlayer;

    // The disc being played.
    private final DiscFactory discFactory;

    // Game state and rules.
    private final Model model;

    // The column in which the mouse currently is positioned.
    private int mouseColumn;

    /**
     * Create the playing board.
     */
    public Board(Model model) {
        this.model = model;

        // Place board 120 pixels down from the top border.
        setTranslateY(Config.CELL_SIZE * 6 / 5);
        setAlignment(Pos.TOP_CENTER);

        // Configure grid for a 7 by 6 layout.
        for (int column = 0; column < Config.NUM_COLUMNS; ++column) {
            getColumnConstraints().add(
                    new ColumnConstraints(Config.CELL_SIZE, Config.CELL_SIZE, Double.MAX_VALUE));
        }
        for (int row = 0; row < Config.NUM_ROWS; ++row) {
            getRowConstraints().add(
                    new RowConstraints(Config.CELL_SIZE, Config.CELL_SIZE, Double.MAX_VALUE));
        }

        // For 3D effects reflect the board downwards. Used on bottom cells.
        Reflection reflection = new Reflection();
        reflection.setFraction(0.9);
        reflection.setTopOpacity(0.9);
        reflection.setTopOffset(10);

        // For each cell on the 7 by 6 board create one cell.
        for (int column = 0; column < Config.NUM_COLUMNS; column++) {
            // all but the last row
            for (int row = 0; row < Config.NUM_ROWS - 1; row++) {
                // Materialize a cell in the current grid location.
                add(Cell.create(row), column, row);
            }
            // Last row also has a reflection
            Node node = Cell.create(Config.NUM_ROWS - 1);
            node.setEffect(reflection);
            add(node, column, Config.NUM_ROWS - 1);

            // Create a transparent column to receive events.
            add(createColumn(column), column, 0, 1, Config.NUM_ROWS);
        }

        // initialize remainder of user interface (e.g., candidate disc)
        this.discFactory = new DiscFactory();
        this.mouseColumn = -1;  // < 0 means: invisible
        this.moveInProgress = false;

        this.currentPlayer = 0;

        // react appropriately when the game is finished
    }

    private Rectangle createColumn(int column) {
        // Create a rectangle which receives mouse events.
        Rectangle rect = new Rectangle(Config.CELL_SIZE, Config.NUM_ROWS * Config.CELL_SIZE);

        // Make it invisible
        rect.setFill(Color.TRANSPARENT);

        // Listen to mouse
        rect.setOnMouseEntered(mouseEvent -> mouseEntered(column));
        rect.setOnMouseExited(mouseEvent -> mouseExited(column));
        rect.setOnMouseClicked(mouseEvent -> mouseClicked(column));

        return rect;
    }

    /**
     * The mouse entered a cell, which may trigger a disc-drop suggestion.
     */
    private void mouseEntered(int column) {
        this.mouseColumn = column;
        // Check if player can position a disc in the current column.
        if (!moveInProgress && model.isPlayableMove(column)) {

            // Ask for the row where a falling disc will find its destination.
            int dest = model.moveDestination(column);

            // Ask for a candidate disc, which may already exist.
            Circle circle = discFactory.getDisc();
            if (circle == null) {
                circle = discFactory.Disc(COLORS[currentPlayer]);
            } else {
                getChildren().remove(circle);
            }

            // Position disc above the playing board.
            circle.setTranslateY(-Config.CELL_SIZE * (dest + 1));

            // Attach disc to grid, but behind all the cells.
            getChildren().add(0, circle);
            GridPane.setConstraints(circle, column, dest);
        }
    }

    /**
     * The mouse pointer left a grid cell.
     * Check if we have to undo the 'mouseEntered()' action.
     */
    private void mouseExited(int column) {
        this.mouseColumn = -1; // invisible
        if (!moveInProgress && model.isPlayableMove(column)) {
            // We may need to hide a candidate disc.
            Circle circle = discFactory.getDisc();
            if (circle != null) {
                getChildren().remove(circle);
            }
        }
    }

    /**
     * The mouse has clicked on a square:
     * check if a move can be played.
     */
    private void mouseClicked(int column) {
        if (!moveInProgress && model.isPlayableMove(column)) {

            // Convert the candidate disc into a played disc.
            Circle circle = discFactory.takeDisc();
            if (circle == null) {
                // If no candidate yet, then simulate a mouse enter event.
                mouseEntered(column);
                circle = discFactory.takeDisc();
            }
            if (circle != null) {
                // Drop the disc.
                animateDisc(circle, column);
            }
        }
    }


    private boolean moveInProgress;

    /**
     * Start a new animation to move a disc from its candidate position
     * to its final destination cell.
     *
     * @param disc The yellow/red disc which should be falling down.
     */
    private void animateDisc(Node disc, int column) {
        // Prohibit further moves
        moveInProgress = true;

        // Create a new animation
        final TranslateTransition transition
                = new TranslateTransition(Duration.millis(Config.ANIMATION_TIME), disc);

        // Receive a notification when the animation ends.
        transition.setOnFinished(actionEvent -> animationFinished(column));

        // Convert linear time [0..1] to falling distance.
        transition.setInterpolator(FALLING_DISC_INTERPOLATOR);

        // Set animation destination to the center of the cell.
        transition.setToY(0);

        // Animate our disc towards its destination cell.
        transition.play();
    }

    /**
     * A falling disc animation has ended: update the game state.
     *
     * @param column the column in which the disc fell.
     */
    private void animationFinished(int column) {
        // Enable new moves
        moveInProgress = false;

        // Tell the model that this move has been played
        model.playMove(column);

        // Change colors for the next move
        currentPlayer = 1 - currentPlayer;

        // Is the mouse inside a column?
        if (this.mouseColumn >= 0) {
            // Show a new candidate by simulating a mouse event
            mouseEntered(this.mouseColumn);
        }
    }

    /**
     * An interpolator converts linear time in the range 0.0 to 1.0 seconds
     * by a 'curve' function. In this case we wish to simulate physically
     * realistic falling according to Newtons gravity laws.
     * A small remaining fraction is used for a little bounce.
     */
    private final static Interpolator FALLING_DISC_INTERPOLATOR = new Interpolator() {
        @Override
        protected double curve(double time) {
            final double most = 0.90;
            if (time <= most) {
                double distance = time / most;
                return distance * distance;
            } else /* 0.90 < time <= 1.0 */ {
                double half = (most + 1.0) / 2.0;
                double bounce = (time - half) / (1.0 - half);
                return half + bounce * bounce * (1.0 - half);
            }
        }
    };
}
