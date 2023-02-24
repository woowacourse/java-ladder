package domain.model;

public class Location {

    private int horizon;
    private int vertical;

    public Location(final int horizon, final int vertical) {
        this.horizon = horizon;
        this.vertical = vertical;
    }

    public void goLeft() {
        horizon--;
    }

    public void goRight() {
        horizon++;
    }

    public void goDown() {
        vertical++;
    }

    public int getHorizon() {
        return horizon;
    }

    public int getVertical() {
        return vertical;
    }
}
