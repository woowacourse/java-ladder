package domain.player;

public class Position {

    private int x;
    private int y;

    public Position(int order) {
        this.x = order;
        this.y = 0;
    }

    public void moveLeft() {
        x--;
        y++;
    }

    public void moveRight() {
        x++;
        y++;
    }

    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLeft() {
        return x - 1;
    }

    public int getRight() {
        return x;
    }
}
