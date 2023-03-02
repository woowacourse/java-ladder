package domain;

public class Position {
    private int index;

    public Position(int index) {
        this.index = index;
    }

    public void moveLeft() {
        --index;
    }

    public void moveRight() {
        ++index;
    }

    public int getIndex() {
        return index;
    }

}
