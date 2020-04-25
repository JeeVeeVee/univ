package prog2.ifless.correct;

/**
 * Opsomtype dat gebruikt wordt in {@link Richtingen}
 */
public enum Windrichting {

    OOST (1, 0), ZUID(0, -1), WEST(-1, 0), NOORD(0, 1);

    private int dx;
    private int dy;

    Windrichting(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}


