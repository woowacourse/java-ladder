package domain.vo;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Location location = (Location) o;
        return getHorizon() == location.getHorizon() && getVertical() == location.getVertical();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorizon(), getVertical());
    }

    public int getHorizon() {
        return horizon;
    }

    public int getVertical() {
        return vertical;
    }
}
