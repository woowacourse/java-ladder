package domain;

public class Position {

    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position increase() {
        return new Position(index + 1);
    }

    public Position decrease() {
        return new Position(index - 1);
    }

    public int getIndex() {
        return index;
    }
}
