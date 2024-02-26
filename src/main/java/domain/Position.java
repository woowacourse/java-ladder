package domain;

public class Position {
    private int verticalLocation;
    private int horizontalLocation;


    public Position(final int horizontalLocation, final int verticalLocation) {
        this.horizontalLocation = horizontalLocation;
        this.verticalLocation = verticalLocation;
    }


    public int getVerticalLocation() {
        return verticalLocation;
    }

    public int getHorizontalLocation() {
        return horizontalLocation;
    }

    public void next() {
        verticalLocation = verticalLocation + 1;
    }
}
