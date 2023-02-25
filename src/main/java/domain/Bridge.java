package domain;

public enum Bridge {
    CONNECTED(true), UNCONNECTED(false);

    private final boolean isConnected;

    Bridge(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Bridge from(boolean generate) {
        if (generate) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
