package domain;

public enum Point {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean isConnected;

    Point(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public static Point from(boolean value) {
        if (value) return Point.CONNECTED;
        return Point.DISCONNECTED;
    }
}
