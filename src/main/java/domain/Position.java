package domain;

public class Position {
    private int verticalLocation;
    private int horizontalLocation;


    public Position(final int horizontalLocation, final int verticalLocation) {
        this.horizontalLocation = horizontalLocation;
        this.verticalLocation = verticalLocation;
    }

    public int moveDown() {
        verticalLocation = verticalLocation + 1;
        return verticalLocation;
    }

    public void moveLeft(final boolean condition) {
        if (condition) {
            horizontalLocation = horizontalLocation - 1;
        }
    }

    public void moveRight(final boolean condition) {
        if (condition) {
            horizontalLocation = horizontalLocation + 1;
        }
    }

    public int getVerticalLocation() {
        return verticalLocation;
    }

    public int getHorizontalLocation() {
        return horizontalLocation;
    }
}
