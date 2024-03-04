package domain;

public enum Leg {
    CONNECTED(true),
    UN_CONNECTED(false);

    private final boolean isConnected;

    Leg(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
