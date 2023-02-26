package domain.model;

public class Location {

    private int location;

    public Location(final int location) {
        this.location = location;
    }

    public void goLeft() {
        location--;
    }

    public void goRight() {
        location++;
    }

    public int getHorizon() {
        return location;
    }
}
