package domain;

public enum Point {

    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean status;

    Point(final boolean status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status;
    }
}
