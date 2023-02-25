package laddergame.domain;

public class PointImpl implements Point {

    private final boolean isConnected;

    public PointImpl(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
