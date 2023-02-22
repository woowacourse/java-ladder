package domain;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveDown() {
        ++y;
    }

    public void moveLeft() {
        --x;
    }

    public void moveRight() {
        ++x;
    }
}
