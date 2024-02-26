package model.bridge;

public enum Bridge {
    CONNECTED,
    UNCONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public boolean isUnconnected() {
        return this == UNCONNECTED;
    }
}
