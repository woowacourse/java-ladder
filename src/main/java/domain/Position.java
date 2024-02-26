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
}
