package domain;

public class Position {
    private int position;

    public Position(final int position) {
        this.position = position;
    }

    public void swapPosition(final Position positionTwo) {
        int temp = this.position;
        this.position = positionTwo.position;
        positionTwo.position = temp;
    }
}
