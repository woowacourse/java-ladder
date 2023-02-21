package domain;

public class Position {

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position of(final int position) {
        return new Position(position);
    }

    public void swapPosition(final Position positionTwo) {
        int temp = this.position;
        this.position = positionTwo.position;
        positionTwo.position = temp;
    }
}
