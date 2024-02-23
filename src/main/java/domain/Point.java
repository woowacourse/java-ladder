package domain;

public enum Point {

    CONNECTED(true),
    DISCONNECTED(false);

    private final Boolean isConnected;

    Point(Boolean isConnected) {
        this.isConnected = isConnected;
    }
}
