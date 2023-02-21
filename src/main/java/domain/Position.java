package domain;

public class Position {

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public void swap(final Position positionTwo) {
        final int temp = this.position;
        this.position = positionTwo.position;
        positionTwo.position = temp;
    }
}
