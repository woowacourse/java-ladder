package domain;

public class Position {

    public int value;

    public Position(final int value) {
        this.value = value;
    }

    public boolean isFirst() {
        return value == 0;
    }

    public boolean isLast(int lineSize) {
        return value == lineSize;
    }

    public int findLeft() {
        return --value;
    }

    public int findRight() {
        return ++value;
    }
}
