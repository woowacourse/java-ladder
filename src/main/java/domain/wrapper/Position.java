package domain.wrapper;

public class Position {
    private int x;
    private int y;

    private Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Position from(final int x) {
        return new Position(x, 0);
    }

    public static Position from(final int x, final int y) {
        return new Position(x, y);
    }

    public void addX() {
        x = x + 1;
    }

    public void subX() {
        x = x - 1;
    }

    public void addY() {
        y = y + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
